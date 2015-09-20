package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.bean.Dictionary;
import com.zh.base.model.bean.Enterprise;
import com.zh.base.service.BasiTypeService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.exception.ProjectException;
import com.zh.core.model.Pager;
import com.zh.web.model.CustomerModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.MailList;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.model.bean.SalesOrderPrimary;
import com.zh.web.service.CustomerService;
import com.zh.web.service.MailListService;
import com.zh.web.service.PurchaseOrderPrimaryService;
import com.zh.web.service.SalesOrderPrimaryService;

/**
* @Description: 客户资源
* @Title: CustomerAction.java 
* @Package com.zh.web.action 
* @date 2015年7月7日 下午7:07:46 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class CustomerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerAction.class); 
	
	private CustomerModel customerModel = new CustomerModel();
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MailListService mailListService;
	
	@Autowired
	private SalesOrderPrimaryService salesOrderPrimaryService;
	
	@Autowired
	private PurchaseOrderPrimaryService purchaseOrderPrimaryService;
	
	@Override
	public Object getModel() {
		return customerModel;
	}

	@Override
	public String execute() throws Exception {
		Customer customer = this.customerModel.getCustomer();
		Integer count = customerService.count(customer);
		Pager page = this.customerModel.getPageInfo();
		page.setTotalRow(count);
		List<Customer> list = customerService.queryList(customer, page);
		this.customerModel.setCustomerList(list);
		//客户类型
		List<Dictionary> typeList = queryDictionaryList(BasiTypeService.CUSTOMER_TYPE);
		this.customerModel.setTypeList(typeList);
		//客户等级
		List<Dictionary> levList = queryDictionaryList(BasiTypeService.CUSTOMER_LEV);
		this.customerModel.setDictionaryList(levList);
		
		return Action.SUCCESS;

	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Long id = this.customerModel.getId();
		
		//客户类型
		List<Dictionary> typeList = queryDictionaryList(BasiTypeService.CUSTOMER_TYPE);
		this.customerModel.setTypeList(typeList);
		//客户等级
		List<Dictionary> list = queryDictionaryList(BasiTypeService.CUSTOMER_LEV);
		this.customerModel.setDictionaryList(list);
		
		//获取企业列表
		List<Enterprise> enterpriseList = this.queryEnterpriseList();
		this.customerModel.setEnterpriseList(enterpriseList);
		
		if (null != id)
		{
			//查询信息
			LOGGER.debug("editor Customer id " + id );
			Customer customer = this.customerModel.getCustomer();
			customer.setId(Long.valueOf(id));
			Customer reult = customerService.query(customer);
			this.customerModel.setCustomer(reult);
			
			//查询通讯录
			MailList mailList = this.customerModel.getMailList();
			mailList.setForeignId(id);
			Integer count = mailListService.count(mailList);
			Pager page = this.customerModel.getPageInfo();
			page.setTotalRow(count);
			List<MailList> mailListList = mailListService.queryList(mailList, page);
			this.customerModel.setMailListList(mailListList);
			
			//查询销售记录
			SalesOrderPrimary salesOrderPrimary = new SalesOrderPrimary();
			salesOrderPrimary.setCustomerID(id);
			Integer sCount = salesOrderPrimaryService.count(salesOrderPrimary);
			Pager salesPage = this.customerModel.getSalesPageInfo();
			salesPage.setTotalRow(sCount);
			List<SalesOrderPrimary> salesOrderPrimaryList = salesOrderPrimaryService.queryList(salesOrderPrimary, salesPage);
			this.customerModel.setSalesOrderPrimaryList(salesOrderPrimaryList);
			
			//查询采购记录
			PurchaseOrderPrimary purchaseOrderPrimary = new PurchaseOrderPrimary();
			purchaseOrderPrimary.setCustomerID(id);
			Integer purchaseCount = purchaseOrderPrimaryService.count(purchaseOrderPrimary);
			Pager purchasePage = this.customerModel.getPurchasePageInfo();
			purchasePage.setTotalRow(purchaseCount);
			List<PurchaseOrderPrimary> purchaseOrderPrimaryList = purchaseOrderPrimaryService.queryList(purchaseOrderPrimary, purchasePage);
			this.customerModel.setPurchaseOrderPrimaryList(purchaseOrderPrimaryList);		
		}
		
		return Action.EDITOR;
	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		Customer customer = this.customerModel.getCustomer();
		Long id = this.customerModel.getId();
		if (null != id && !"".equals(id))
		{
			String view = this.customerModel.getView();
			if (null != view && "enabled".equals(view))
			{
				String enabled = this.customerModel.getEnabled();
				customer = new Customer();
				
				if ("0".equals(enabled))
				{
					customer.setEnabled(1);
				}else
				{
					customer.setEnabled(0);
				}
				LOGGER.debug("update customer enabled " + customer.getEnabled());
			}
			customer.setId(id);
			customerService.update(customer);
			LOGGER.debug("update customer id" + id);
		}else
		{
			//新增
			customerService.insert(customer);
			LOGGER.debug("add customer");
		}
		return Action.EDITOR_SUCCESS;
	}
	
	public String saveMailList() {
		LOGGER.debug("saveMailList()");
		String formId = this.customerModel.getFormId();
		Long id = this.customerModel.getId();
		String view = this.customerModel.getView();
		
		if (null == formId || "".equals(formId)) {
			throw ProjectException
					.createException("当前的流程编号不允许为空！请先保存当前流程的基本信息");
		}
		
		if (null != view && (null == id || "".equals(id))) {
			throw ProjectException.createException("当前的活动编号不允许为空！");
		}
		
		MailList mailList = this.customerModel.getMailList();
		mailList.setForeignId(Long.valueOf(formId));

		if (null != view && "delete".equals(view)) {
			mailList.setId(id);
			mailListService.delete(mailList);
		} else {
			mailListService.insert(mailList);
		}
		return "save";
	}

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	
}
