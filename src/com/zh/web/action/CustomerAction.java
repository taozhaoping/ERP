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
import com.zh.core.model.Pager;
import com.zh.web.model.CustomerModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.service.CustomerService;

public class CustomerAction extends BaseAction {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomerAction.class); 
	
	private CustomerModel customerModel = new CustomerModel();
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
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
		return Action.SUCCESS;

	}

	public String editor() throws Exception {
		LOGGER.debug("editor()");
		Integer id = this.customerModel.getId();
		
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
			customer.setId(Integer.valueOf(id));
			Customer reult = customerService.query(customer);
			this.customerModel.setCustomer(reult);
		}
		
		return Action.EDITOR;
	}

	public String save() throws Exception {
		LOGGER.debug("save()");
		Customer customer = this.customerModel.getCustomer();
		Integer id = this.customerModel.getId();
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
