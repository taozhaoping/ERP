package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Dictionary;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.SalesOrderPrimary;

public class SalesOrderModel extends BaseModel {

	private SalesOrderPrimary salesOrderPrimary = new SalesOrderPrimary();
	
	private List<SalesOrderPrimary> salesOrderPrimaryList = new ArrayList<SalesOrderPrimary>();

	private List<Dictionary> paymentTermList = new ArrayList<Dictionary>();
	
	private List<Dictionary> currencyPaymentList = new ArrayList<Dictionary>();
	
	public SalesOrderPrimary getSalesOrderPrimary() {
		return salesOrderPrimary;
	}

	public void setSalesOrderPrimary(SalesOrderPrimary salesOrderPrimary) {
		this.salesOrderPrimary = salesOrderPrimary;
	}

	public List<SalesOrderPrimary> getSalesOrderPrimaryList() {
		return salesOrderPrimaryList;
	}

	public void setSalesOrderPrimaryList(
			List<SalesOrderPrimary> salesOrderPrimaryList) {
		this.salesOrderPrimaryList = salesOrderPrimaryList;
	}

	public List<Dictionary> getPaymentTermList() {
		return paymentTermList;
	}

	public void setPaymentTermList(List<Dictionary> paymentTermList) {
		this.paymentTermList = paymentTermList;
	}

	public List<Dictionary> getCurrencyPaymentList() {
		return currencyPaymentList;
	}

	public void setCurrencyPaymentList(List<Dictionary> currencyPaymentList) {
		this.currencyPaymentList = currencyPaymentList;
	}


}
