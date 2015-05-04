package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.PurchaseOrderDetail;
import com.zh.web.model.bean.PurchaseOrderPrimary;

public class PurchaseOrderModel extends BaseModel {

	private PurchaseOrderPrimary PurchaseOrderPrimary = new PurchaseOrderPrimary();
	
	private PurchaseOrderDetail PurchaseOrderDetail = new PurchaseOrderDetail();
	
	private List<PurchaseOrderPrimary> PurchaseOrderPrimaryList = new ArrayList<PurchaseOrderPrimary>();
	
	private List<PurchaseOrderDetail> PurchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();

	List<Customer> customerList = new ArrayList<Customer>();
	
	public PurchaseOrderPrimary getPurchaseOrderPrimary() {
		return PurchaseOrderPrimary;
	}

	public void setPurchaseOrderPrimary(PurchaseOrderPrimary purchaseOrderPrimary) {
		PurchaseOrderPrimary = purchaseOrderPrimary;
	}

	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return PurchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		PurchaseOrderDetail = purchaseOrderDetail;
	}

	public List<PurchaseOrderPrimary> getPurchaseOrderPrimaryList() {
		return PurchaseOrderPrimaryList;
	}

	public void setPurchaseOrderPrimaryList(
			List<PurchaseOrderPrimary> purchaseOrderPrimaryList) {
		PurchaseOrderPrimaryList = purchaseOrderPrimaryList;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
		return PurchaseOrderDetailList;
	}

	public void setPurchaseOrderDetailList(
			List<PurchaseOrderDetail> purchaseOrderDetailList) {
		PurchaseOrderDetailList = purchaseOrderDetailList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

}
