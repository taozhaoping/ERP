package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Dictionary;
import com.zh.core.base.model.BaseModel;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.MailList;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.model.bean.SalesOrderPrimary;

public class CustomerModel extends BaseModel {

	private Customer customer = new Customer();
	
	private List<Customer> customerList = new ArrayList<Customer>();
	
	private List<Dictionary> typeList = new ArrayList<Dictionary>();
	
	private MailList mailList = new MailList();
	
	private List<MailList> mailListList = new ArrayList<MailList>();
	
	//采购记录
	private List<PurchaseOrderPrimary> purchaseOrderPrimaryList = new ArrayList<PurchaseOrderPrimary>();
	//采购记录分页
	private Pager purchasePageInfo = new Pager();
	
	//销售记录
	private List<SalesOrderPrimary> salesOrderPrimaryList = new ArrayList<SalesOrderPrimary>();
	//销售记录分页
	private Pager salesPageInfo = new Pager();

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

	public List<SalesOrderPrimary> getSalesOrderPrimaryList() {
		return salesOrderPrimaryList;
	}

	public void setSalesOrderPrimaryList(
			List<SalesOrderPrimary> salesOrderPrimaryList) {
		this.salesOrderPrimaryList = salesOrderPrimaryList;
	}

	public Pager getSalesPageInfo() {
		return salesPageInfo;
	}

	public void setSalesPageInfo(Pager salesPageInfo) {
		this.salesPageInfo = salesPageInfo;
	}

	public List<PurchaseOrderPrimary> getPurchaseOrderPrimaryList() {
		return purchaseOrderPrimaryList;
	}

	public void setPurchaseOrderPrimaryList(
			List<PurchaseOrderPrimary> purchaseOrderPrimaryList) {
		this.purchaseOrderPrimaryList = purchaseOrderPrimaryList;
	}

	public Pager getPurchasePageInfo() {
		return purchasePageInfo;
	}

	public void setPurchasePageInfo(Pager purchasePageInfo) {
		this.purchasePageInfo = purchasePageInfo;
	}
	
}
