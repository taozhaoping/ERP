package com.zh.web.action;

import java.util.List;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Dictionary;
import com.zh.base.service.BasiTypeService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.PurchaseOrderModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.PurchaseOrderDetail;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.model.bean.SalesOrderDetail;
import com.zh.web.model.bean.SalesOrderPrimary;
import com.zh.web.service.CustomerService;
import com.zh.web.service.PurchaseOrderDetailService;
import com.zh.web.service.PurchaseOrderPrimaryService;
import com.zh.web.util.UtilService;

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
	private CustomerService customerService;
	
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
		
		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			PurchaseOrderPrimary purchaseOrderPrimary = this.purchaseOrderModel
					.getPurchaseOrderPrimary();
			purchaseOrderPrimary.setId(Integer.valueOf(id));
			PurchaseOrderPrimary reult = purchaseOrderPrimaryService.query(purchaseOrderPrimary);
			this.purchaseOrderModel.setPurchaseOrderPrimary(reult);

			// 销售明细列表
			PurchaseOrderDetail purchaseOrderDetail = this.purchaseOrderModel
					.getPurchaseOrderDetail();
			purchaseOrderDetail.setPurchaseOrderID(id);
			Pager page = this.purchaseOrderModel.getPageInfo();
			Integer count = purchaseOrderDetailService.count(purchaseOrderDetail);
			page.setTotalRow(count);
			List<PurchaseOrderDetail> list = purchaseOrderDetailService.queryList(
					purchaseOrderDetail, page);
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
	
	/**
	 * 
	* @Title: examineSalesOrder 
	* @Description: 审核（修改订单状态和计算采购需求需求数量） 
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 * @throws ParameterException 
	 */
	public String examineSalesOrder() throws ParameterException
	{
		LOGGER.debug("examine SalesOrder ()");
		Integer id = this.purchaseOrderModel.getId();
		if (null == id || "".equals(id)) {
			throw new ParameterException("审核的单据号不允许为空!");
		}
		
		//计算销售订单的采购需求清单和修改头表状态 已下代码需要跟采购需求单计算放在一个事物里面，防止失败
		PurchaseOrderPrimary purchaseOrderPrimary = this.purchaseOrderModel
				.getPurchaseOrderPrimary();
		purchaseOrderPrimary.setId(id);
		purchaseOrderPrimary.setStatus(1);
		purchaseOrderPrimaryService.update(purchaseOrderPrimary);
		//============结束==================
		this.purchaseOrderModel.setFormId(String.valueOf(id));
		return Action.EDITOR_SAVE;
	}

	public String saveSalesOrderDetail() {
		LOGGER.debug("save StorageDetail ()");
		PurchaseOrderDetail purchaseOrderDetail = this.purchaseOrderModel.getPurchaseOrderDetail();
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
		this.purchaseOrderModel.setFormId(purchaseOrderPrimary.getId().toString());
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
