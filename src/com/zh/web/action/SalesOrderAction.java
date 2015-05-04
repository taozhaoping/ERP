package com.zh.web.action;

import java.util.List;

import org.apache.avalon.framework.parameters.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Dictionary;
import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.BasiTypeService;
import com.zh.base.util.DateUtil;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.SalesOrderModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.SalesOrderDetail;
import com.zh.web.model.bean.SalesOrderPrimary;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.CustomerService;
import com.zh.web.service.SalesOrderDetailService;
import com.zh.web.service.SalesOrderPrimaryService;
import com.zh.web.util.UtilService;

/**
 * 
* @Title: SalesOrderAction.java 
* @Package com.zh.web.action 
* @Description: 销售订单
* @date 2015年4月30日 上午10:29:28 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class SalesOrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 731437174900014739L;

	private static Logger LOGGER = LoggerFactory
			.getLogger(SalesOrderAction.class);

	@Autowired
	private SalesOrderPrimaryService salesOrderPrimaryService;
	
	@Autowired
	private SalesOrderDetailService salesOrderDetailService;
	
	@Autowired
	private CustomerService customerService;

	private SalesOrderModel salesOrderModel = new SalesOrderModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return salesOrderModel;
	}

	@Override
	public String execute() throws Exception {
		SalesOrderPrimary salesOrderPrimary = this.salesOrderModel
				.getSalesOrderPrimary();
		Integer count = salesOrderPrimaryService.count(salesOrderPrimary);
		Pager page = this.salesOrderModel.getPageInfo();
		page.setTotalRow(count);
		List<SalesOrderPrimary> salesOrderPrimaryList = salesOrderPrimaryService
				.queryList(salesOrderPrimary, page);
		this.salesOrderModel.setSalesOrderPrimaryList(salesOrderPrimaryList);
		return Action.SUCCESS;
	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.salesOrderModel.getId();
		
		//付款方式
		List<Dictionary> paymentTermList = queryDictionaryList(BasiTypeService.PAYMENT_TERM);
		this.salesOrderModel.setPaymentTermList(paymentTermList);
		//付款货币
		List<Dictionary> currencyPaymentList = queryDictionaryList(BasiTypeService.CURRENCY_PAYMENT);
		this.salesOrderModel.setCurrencyPaymentList(currencyPaymentList);
		
		// 客户信息
		Customer customer = new Customer();
		customer.setType(UtilService.CUSTOMER_TYPE_CUSTO);
		customer.setEnabled(UtilService.ENABLED_EFFECTIVE);
		List<Customer> customerList = customerService.queryList(customer);
		this.salesOrderModel.setCustomerList(customerList);
		
		if (null != id) {
			// 查询信息
			LOGGER.debug("editor StoragePrimary id " + id);
			SalesOrderPrimary salesOrderPrimary = this.salesOrderModel
					.getSalesOrderPrimary();
			salesOrderPrimary.setId(Integer.valueOf(id));
			SalesOrderPrimary reult = salesOrderPrimaryService.query(salesOrderPrimary);
			this.salesOrderModel.setSalesOrderPrimary(reult);

			// 销售明细列表
			SalesOrderDetail salesOrderDetail = this.salesOrderModel
					.getSalesOrderDetail();
			salesOrderDetail.setSalesOrderID(id);
			Pager page = this.salesOrderModel.getPageInfo();
			Integer count = salesOrderDetailService.count(salesOrderDetail);
			page.setTotalRow(count);
			List<SalesOrderDetail> list = salesOrderDetailService.queryList(
					salesOrderDetail, page);
			this.salesOrderModel.setSalesOrderDetailList(list);

			// 判断是否已经入库，入库状态下，只进入查看页面
			Integer status = reult.getStatus();
			String view = this.salesOrderModel.getView();
			if (status != 0 || "view".equals(view)) {
				return Action.VIEW;
			}
		} else {
			Integer userID = this.queryUser().getId();
			this.salesOrderModel.getSalesOrderPrimary().setUserID(userID);
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
		Integer id = this.salesOrderModel.getId();
		if (null == id || "".equals(id)) {
			throw new ParameterException("审核的单据号不允许为空!");
		}
		
		//计算销售订单的采购需求清单和修改头表状态 已下代码需要跟采购需求单计算放在一个事物里面，防止失败
		SalesOrderPrimary salesOrderPrimary = this.salesOrderModel
				.getSalesOrderPrimary();
		salesOrderPrimary.setId(id);
		salesOrderPrimary.setStatus(1);
		salesOrderPrimaryService.update(salesOrderPrimary);
		//============结束==================
		this.salesOrderModel.setFormId(String.valueOf(id));
		return Action.EDITOR_SAVE;
	}

	public String saveSalesOrderDetail() {
		LOGGER.debug("save StorageDetail ()");
		SalesOrderDetail salesOrderDetail = this.salesOrderModel.getSalesOrderDetail();
		Integer id = this.salesOrderModel.getId();
		if (null == id || "".equals(id)) {
			// 新增
			Integer storageNumber = salesOrderDetail.getStorageNumber();
			Double unitPrice = salesOrderDetail.getUnitPrice();
			Double orderValue = unitPrice * storageNumber;
			salesOrderDetail.setOrderValue(orderValue);
			salesOrderDetailService.insert(salesOrderDetail);
		} else {
			// 修改
			salesOrderDetail = new SalesOrderDetail();
			salesOrderDetail.setId(id);
			salesOrderDetailService.delete(salesOrderDetail);
		}
		String formId = this.salesOrderModel.getFormId();
		this.salesOrderModel.setFormId(formId);
		return Action.EDITOR_SAVE;

	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		SalesOrderPrimary salesOrderPrimary = this.salesOrderModel
				.getSalesOrderPrimary();
		Integer id = this.salesOrderModel.getId();
		if (null != id && !"".equals(id)) {
			salesOrderPrimary.setId(id);
			salesOrderPrimaryService.update(salesOrderPrimary);
			LOGGER.debug("update storagePrimary id" + id);
		} else {
			// 新增
			salesOrderPrimaryService.insert(salesOrderPrimary,
					UtilService.STORAGE_TYPE);
			LOGGER.debug("add storagePrimary");
		}
		this.salesOrderModel.setFormId(salesOrderPrimary.getId().toString());
		return Action.EDITOR_SAVE;
	}

	public SalesOrderPrimaryService getSalesOrderPrimaryService() {
		return salesOrderPrimaryService;
	}

	public void setSalesOrderPrimaryService(
			SalesOrderPrimaryService salesOrderPrimaryService) {
		this.salesOrderPrimaryService = salesOrderPrimaryService;
	}

	public SalesOrderDetailService getSalesOrderDetailService() {
		return salesOrderDetailService;
	}

	public void setSalesOrderDetailService(
			SalesOrderDetailService salesOrderDetailService) {
		this.salesOrderDetailService = salesOrderDetailService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public SalesOrderModel getSalesOrderModel() {
		return salesOrderModel;
	}

	public void setSalesOrderModel(SalesOrderModel salesOrderModel) {
		this.salesOrderModel = salesOrderModel;
	}
	
	
}
