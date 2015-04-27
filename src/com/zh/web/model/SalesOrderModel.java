package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.SalesOrderPrimary;

public class SalesOrderModel extends BaseModel {

	private SalesOrderPrimary salesOrderPrimary = new SalesOrderPrimary();
	
	private List<SalesOrderPrimary> salesOrderPrimaryList = new ArrayList<SalesOrderPrimary>();

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


}
