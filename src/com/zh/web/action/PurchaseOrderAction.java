package com.zh.web.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
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

import com.zh.base.model.bean.Dictionary;
import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.BasiTypeService;
import com.zh.base.service.WarehouseService;
import com.zh.base.util.Tools;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.IDataObject;
import com.zh.core.model.Pager;
import com.zh.core.util.JSONUtil;
import com.zh.web.model.PurchaseOrderModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.ProcurementDemandDetail;
import com.zh.web.model.bean.Products;
import com.zh.web.model.bean.PurchaseOrderDetail;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.model.template.ProductModel;
import com.zh.web.service.CustomerService;
import com.zh.web.service.ProcurementDemandDetailService;
import com.zh.web.service.ProductsService;
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
	private ProductsService productsService;
	
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
		this.purchaseOrderModel.setPurchaseOrderPrimaryList(purchaseOrderPrimaryList);
		
		// 供应商信息
		Customer customer = new Customer();
		customer.setType(UtilService.CUSTOMER_TYPE_SUPPLIER);
		customer.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Customer> customerList = customerService.queryList(customer);
		this.purchaseOrderModel.setCustomerList(customerList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Long id = this.purchaseOrderModel.getId();

		// 供应商信息
		Customer customer = new Customer();
		customer.setType(UtilService.CUSTOMER_TYPE_SUPPLIER);
		customer.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Customer> customerList = customerService.queryList(customer);
		this.purchaseOrderModel.setCustomerList(customerList);

		// 获取仓库信息
		Warehouse warehouse = new Warehouse();
		warehouse.setEnabled(UtilService.ENABLED_EFFECTIVE);
		warehouse.setType(UtilService.WAREHOUSE_TYPE_ZERO);
		List<Warehouse> warehouseList = warehouseService.queryList(warehouse);
		this.purchaseOrderModel.setWarehouseList(warehouseList);

		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			PurchaseOrderPrimary purchaseOrderPrimary = this.purchaseOrderModel
					.getPurchaseOrderPrimary();
			purchaseOrderPrimary.setId(Long.valueOf(id));
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
			Long userID = this.queryUser().getId();
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
		Long id = this.purchaseOrderModel.getId();
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
		
		String purchaseOrderId = this.purchaseOrderModel.getPurchaseOrderPrimary().getPurchaseOrderID();
		Long customerId = this.purchaseOrderModel.getPurchaseOrderPrimary().getCustomerID();
		String arrivalDate = this.purchaseOrderModel.getPurchaseOrderPrimary().getArrivalDate();
		try {
			
			Customer customer = new Customer();
			customer.setId(customerId);
			customer = customerService.query(customer);
			
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate("purchaseContract.xml");
			
			Map<String, Object> rootMap = new HashMap<String, Object>();
			//供应商的信息
			rootMap.put("contractNo", purchaseOrderId);
			rootMap.put("supplierName", customer.getName());
			rootMap.put("supplierFax", customer.getFaxNumber());
			rootMap.put("supplierAddress", customer.getAddress());
			rootMap.put("supplierTel", customer.getIphone());
			rootMap.put("supplierBankName", customer.getOpeningBank());
			rootMap.put("supplierCardNo", customer.getBankAccount());
			//交货时间地点
			String year = "";
			String month = "";
			String day = "";
			if(!arrivalDate.isEmpty()){
				String[] ads = arrivalDate.split("-");
				if(ads.length == 3){
					year = ads[0];
					month = ads[1];
					day = ads[2];
				}
			}
			rootMap.put("year", year);
			rootMap.put("month", month);
			rootMap.put("day", day);
			
			//产品列表
			List<PurchaseOrderDetail> detailList = purchaseOrderDetailService.queryList(this.purchaseOrderModel.getPurchaseOrderDetail());
			List<ProductModel> products = new ArrayList<ProductModel>();
			//记录单位
			List<Dictionary> dictionaryList = queryDictionaryList(BasiTypeService.MEASUREMENT_COMPANYSOURCE_TYPE);
			Map<Integer, String> dictionary = new HashMap<Integer, String>();
			for(Dictionary d : dictionaryList){
				dictionary.put(d.getKey(), d.getDescr());
			}
			double total = 0d;
			for (int i = 0; i < detailList.size(); i++) {
				PurchaseOrderDetail detail = detailList.get(i);
				//产品编号
				Long productId = detail.getProductsID();
				
				Products product = new Products();
				product.setId(productId);
				product = productsService.query(product);
				
				//产品名称
				String pName = product.getName();
				//产品规格
				String pSpec = product.getSpecifications();
				//单位
				int pUite = product.getMeasurementCompany();
				//数量
				int pQty = detail.getPurchaseNumber();
				//单价
				double pPrice = detail.getPrice();
				//总价
				double pTotalPrice = detail.getOrderValue();
				//交货时间 arrivalDate
				//总价
				total = total + pTotalPrice;
				
				ProductModel productModel = new ProductModel();
				productModel.setNo(i+1);
				productModel.setNumber(String.valueOf(productId));
				productModel.setName(pName);
				productModel.setSpec(pSpec);
				productModel.setUnit(dictionary.get(pUite));
				productModel.setQty(pQty);
				productModel.setPrice(String.valueOf(pPrice));
				productModel.setTotalPrice(String.valueOf(pTotalPrice));
				productModel.setDeliveryTime(arrivalDate);
				products.add(productModel);
			}
			
			//金额合计人民币
			rootMap.put("total", total);
			String totalDigit = Tools.digitUppercase(total);
			rootMap.put("totalChinese",totalDigit);
			
			rootMap.put("products", products);
			
//			String templatePath = request.getSession().getServletContext()
//					.getRealPath("templates");
//			String templateFullPath = templatePath + File.separator
//					+ "purchaseContract.doc";

			// InputStream is = new FileInputStream(templateFullPath);
//			File file = new File(templateFullPath);

			String fileName = purchaseOrderId + ".doc";
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", new String(
					("filename=" + fileName).getBytes("UTF-8"), "ISO-8859-1"));
			os = response.getOutputStream();
//			fis = new FileInputStream(file);
//			byte[] buf = new byte[1024];
//			int length = 0;
//			while ((fis != null) && ((length = fis.read(buf)) != -1)) {
//				os.write(buf, 0, length);
//			}
			Writer out = new OutputStreamWriter(os,"UTF-8");
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
		Long id = this.purchaseOrderModel.getId();
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
		Long id = this.purchaseOrderModel.getId();
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

	public WarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public ProductsService getProductsService() {
		return productsService;
	}

	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}

	public ProcurementDemandDetailService getProcurementDemandDetailService() {
		return procurementDemandDetailService;
	}

	public void setProcurementDemandDetailService(
			ProcurementDemandDetailService procurementDemandDetailService) {
		this.procurementDemandDetailService = procurementDemandDetailService;
	}

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}

	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		return freeMarkerConfigurer;
	}

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

}
