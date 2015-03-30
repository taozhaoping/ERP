package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Dictionary;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.Customer;

public class CustomerModel extends BaseModel {

	private Customer customer = new Customer();
	
	private List<Customer> customerList = new ArrayList<Customer>();
	
	private List<Dictionary> typeList = new ArrayList<Dictionary>();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Dictionary> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Dictionary> typeList) {
		this.typeList = typeList;
	}
	
}
