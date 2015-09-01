package com.zh.web.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.WarehouseService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.IDataObject;
import com.zh.core.model.Pager;
import com.zh.core.util.JSONUtil;
import com.zh.web.model.PurchaseOrderModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.ProcurementDemandDetail;
import com.zh.web.model.bean.PurchaseOrderDetail;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.model.template.ProductModel;
import com.zh.web.service.CustomerService;
import com.zh.web.service.ProcurementDemandDetailService;
import com.zh.web.service.PurchaseOrderDetailService;
import com.zh.web.service.PurchaseOrderPrimaryService;
import com.zh.web.util.UtilService;

import freemarker.template.Template;

/**
 * @Title: PurchaseOrderAction.java
 * @Package com.zh.web.action
 * @Description: 采购订单
 * @date 2015年5月4日 上午11:45:26
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class PurchaseOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2055529417633768596L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(PurchaseOrderAction.class);

	private PurchaseOrderModel purchaseOrderModel = new PurchaseOrderModel();

	@Autowired
	private PurchaseOrderPrimaryService purchaseOrderPrimaryService;

	@Autowired
	private PurchaseOrderDetailService purchaseOrderDetailService;

	@Autowired
	private WarehouseService warehouseService;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProcurementDemandDetailService procurementDemandDetailService;

	private FileInputStream fis;
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return purchaseOrderModel;
	}

	@Override
	public String execute() throws Exception {
		PurchaseOrderPrimary purchaseOrderPrimary = this.purchaseOrderModel
				.getPurchaseOrderPrimary();
		Integer count = purchaseOrderPrimaryService.count(purchaseOrderPrimary);
		Pager page = this.purchaseOrderModel.getPageInfo();
		page.setTotalRow(count);
		List<PurchaseOrderPrimary> purchaseOrderPrimaryList = purchaseOrderPrimaryService
				.queryList(purchaseOrderPrimary, page);
		this.purchaseOrderModel
				.setPurchaseOrderPrimaryList(purchaseOrderPrimaryList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.purchaseOrderModel.getId();

		// 供应商信息
		Customer customer = new Customer();
		customer.setType(UtilService.CUSTOMER_TYPE_SUPPLIER);
		customer.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Customer> customerList = customerService.queryList(customer);
		this.purchaseOrderModel.setCustomerList(customerList);

		// 获取仓库信息
		Warehouse warehouse = new Warehouse();
		warehouse.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Warehouse> warehouseList = warehouseService.queryList(warehouse);
		this.purchaseOrderModel.setWarehouseList(warehouseList);

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			PurchaseOrderPrimary purchaseOrderPrimary = this.purchaseOrderModel
					.getPurchaseOrderPrimary();
			purchaseOrderPrimary.setId(Integer.valueOf(id));
			PurchaseOrderPrimary reult = purchaseOrderPrimaryService
					.query(purchaseOrderPrimary);
			this.purchaseOrderModel.setPurchaseOrderPrimary(reult);

			// 销售明细列表
			PurchaseOrderDetail purchaseOrderDetail = this.purchaseOrderModel
					.getPurchaseOrderDetail();
			purchaseOrderDetail.setPurchaseOrderID(id);
			Pager page = this.purchaseOrderModel.getPageInfo();
			Integer count = purchaseOrderDetailService
					.count(purchaseOrderDetail);
			page.setTotalRow(count);
			List<PurchaseOrderDetail> list = purchaseOrderDetailService
					.queryList(purchaseOrderDetail, page);
			this.purchaseOrderModel.setPurchaseOrderDetailList(list);

			// 判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.purchaseOrderModel.getView();
			if (status != 0 || "view".equals(view)) {
				return Action.VIEW;
			}
		} else {
			Integer userID = this.queryUser().getId();
			this.purchaseOrderModel.getPurchaseOrderPrimary().setUserID(userID);
		}
		return Action.EDITOR;
	}
	
	public String popList()
	{
		ProcurementDemandDetail procurementDemandDetail = new ProcurementDemandDetail();
		procurementDemandDetail.setNotPlaceOrderNumber(0);
		procurementDemandDetail.setApprovalStatus(UtilService.PROCUREMENTDEMAND_STATUS_APPROVAL);
		List<ProcurementDemandDetail> list = procurementDemandDetailService.queryList(procurementDemandDetail);
		this.purchaseOrderModel.setProcurementDemandDetailList(list);
		return "popListJson";
	}

	/**
	 * 
	 * @Title: examineSalesOrder
	 * @Description: 审核（修改订单状态）
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 * @author taozhaoping 26078
	 * @author mail taozhaoping@gmail.com
	 * @throws ParameterException
	 */
	public String examineSalesOrder() throws ParameterException {
		LOGGER.debug("examine SalesOrder ()");
		Integer id = this.purchaseOrderModel.getId();
		if (null == id || "".equals(id)) {
			throw new ParameterException("审核的单据号不允许为空!");
		}

		// 计算销售订单的采购需求清单和修改头表状态 已下代码需要跟采购需求单计算放在一个事物里面，防止失败
		PurchaseOrderPrimary purchaseOrderPrimary = this.purchaseOrderModel
				.getPurchaseOrderPrimary();
		purchaseOrderPrimary.setId(id);
		purchaseOrderPrimary.setStatus(1);
		purchaseOrderPrimaryService.update(purchaseOrderPrimary);
		// ============结束==================
		this.purchaseOrderModel.setFormId(String.valueOf(id));
		return Action.EDITOR_SAVE;
	}
	
	public void export() {
		HttpServletResponse response = getResponse();
		HttpServletRequest request = getRequest();
		OutputStream os = null;
		
//		String templatePath = request.getSession().getServletContext()
//				.getRealPath("templates");
//		Configuration configuration = new Configuration();
//		configuration.setDefaultEncoding("utf-8");
//		configuration.setClassForTemplateLoading(this.getClass(), "/template");
//		configuration.setObjectWrapper(new DefaultObjectWrapper());
		try {
			
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate("purchaseContract.xml");
			
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("contractNo", "20150901");
			rootMap.put("supplierName", "浙江大华");
			rootMap.put("supplierFax", "0571-110");
			
			rootMap.put("supplierAddress", "浙江省杭州市");
			rootMap.put("supplierTel", "0571-25895689");
			rootMap.put("supplierBankName", "招商银行");
			rootMap.put("supplierCardNo", "123456789101");
			rootMap.put("year", "2015");
			rootMap.put("month", "09");
			rootMap.put("day", "01");
			rootMap.put("total", "120000");
			rootMap.put("totalChinese", "十二万");
			
			ProductModel product = new ProductModel();
			product.setNumber("p001");
			rootMap.put("product", product);
			
//			String templatePath = request.getSession().getServletContext()
//					.getRealPath("templates");
//			String templateFullPath = templatePath + File.separator
//					+ "purchaseContract.doc";

			String purchaseOrderId = this.purchaseOrderModel
					.getPurchaseOrderPrimary().getPurchaseOrderID();

			// InputStream is = new FileInputStream(templateFullPath);
//			File file = new File(templateFullPath);

			String fileName = purchaseOrderId + ".doc";
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", new String(
					("filename=" + fileName).getBytes("GBK"), "ISO-8859-1"));
			os = response.getOutputStream();
//			fis = new FileInputStream(file);
//			byte[] buf = new byte[1024];
//			int length = 0;
//			while ((fis != null) && ((length = fis.read(buf)) != -1)) {
//				os.write(buf, 0, length);
//			}
			Writer out = new OutputStreamWriter(os);
			template.process(rootMap, out);
			out.flush();
		} catch (Exception e) {
			LOGGER.error("Exception, cause:{}, message:{}",e.getCause(), e.getLocalizedMessage());
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	* @Title: servSalesOrderDetailList 
	* @Description: 保存采购明细列表（获取的是采购需求单） 
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public String savePurchaseOrderDetailList()
	{
		LOGGER.debug("save SalesOrderDetail List!");
		String jsonList = this.purchaseOrderModel.getJsonList();
		System.out.println( "需要保存的列表清单：" + jsonList);
		List<IDataObject> list = JSONUtil.jsonArrToListObject(jsonList, PurchaseOrderDetail.class);
		if(list.size() > 0 )
		{
			purchaseOrderDetailService.insertList(list);
		}
		return Action.EDITOR_SAVE;
	}

	public String savePurchaseOrderDetail() {
		LOGGER.debug("save StorageDetail ()");
		PurchaseOrderDetail purchaseOrderDetail = this.purchaseOrderModel
				.getPurchaseOrderDetail();
		Integer id = this.purchaseOrderModel.getId();
		if (null == id || "".equals(id)) {
			// 新增
			Integer purchaseNumber = purchaseOrderDetail.getPurchaseNumber();
			Double price = purchaseOrderDetail.getPrice();
			Double orderValue = price * purchaseNumber;
			purchaseOrderDetail.setOrderValue(orderValue);
			purchaseOrderDetailService.insert(purchaseOrderDetail);
		} else {
			// 修改
			purchaseOrderDetail = new PurchaseOrderDetail();
			purchaseOrderDetail.setId(id);
			purchaseOrderDetailService.delete(purchaseOrderDetail);
		}
		String formId = this.purchaseOrderModel.getFormId();
		this.purchaseOrderModel.setFormId(formId);
		return Action.EDITOR_SAVE;

	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		PurchaseOrderPrimary purchaseOrderPrimary = this.purchaseOrderModel
				.getPurchaseOrderPrimary();
		Integer id = this.purchaseOrderModel.getId();
		if (null != id && !"".equals(id)) {
			purchaseOrderPrimary.setId(id);
			purchaseOrderPrimaryService.update(purchaseOrderPrimary);
			LOGGER.debug("update storagePrimary id" + id);
		} else {
			// 新增
			purchaseOrderPrimaryService.insert(purchaseOrderPrimary);
			LOGGER.debug("add storagePrimary");
		}
		this.purchaseOrderModel.setFormId(purchaseOrderPrimary.getId()
				.toString());
		return Action.EDITOR_SAVE;
	}

	public PurchaseOrderModel getPurchaseOrderModel() {
		return purchaseOrderModel;
	}

	public void setPurchaseOrderModel(PurchaseOrderModel purchaseOrderModel) {
		this.purchaseOrderModel = purchaseOrderModel;
	}

	public PurchaseOrderPrimaryService getPurchaseOrderPrimaryService() {
		return purchaseOrderPrimaryService;
	}

	public void setPurchaseOrderPrimaryService(
			PurchaseOrderPrimaryService purchaseOrderPrimaryService) {
		this.purchaseOrderPrimaryService = purchaseOrderPrimaryService;
	}

	public PurchaseOrderDetailService getPurchaseOrderDetailService() {
		return purchaseOrderDetailService;
	}

	public void setPurchaseOrderDetailService(
			PurchaseOrderDetailService purchaseOrderDetailService) {
		this.purchaseOrderDetailService = purchaseOrderDetailService;
	}

}
