package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Dictionary;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.MailList;

public class CustomerModel extends BaseModel {

	private Customer customer = new Customer();
	
	private List<Customer> customerList = new ArrayList<Customer>();
	
	private List<Dictionary> typeList = new ArrayList<Dictionary>();
	
	private MailList mailList = new MailList();
	
	private List<MailList> mailListList = new ArrayList<MailList>();

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

	public MailList getMailList() {
		return mailList;
	}

	public void setMailList(MailList mailList) {
		this.mailList = mailList;
	}

	public List<MailList> getMailListList() {
		return mailListList;
	}

	public void setMailListList(List<MailList> mailListList) {
		this.mailListList = mailListList;
	}
	
}
