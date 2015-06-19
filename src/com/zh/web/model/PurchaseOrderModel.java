package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.ProcurementDemandDetail;
import com.zh.web.model.bean.PurchaseOrderDetail;
import com.zh.web.model.bean.PurchaseOrderPrimary;

public class PurchaseOrderModel extends BaseModel {

	private PurchaseOrderPrimary purchaseOrderPrimary = new PurchaseOrderPrimary();
	
	private PurchaseOrderDetail purchaseOrderDetail = new PurchaseOrderDetail();
	
	private List<PurchaseOrderPrimary> purchaseOrderPrimaryList = new ArrayList<PurchaseOrderPrimary>();
	
	private List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList<PurchaseOrderDetail>();

	private List<Customer> customerList = new ArrayList<Customer>();
	
	private List<Warehouse> warehouseList = new ArrayList<Warehouse>();
	
	//需求清单
	private List<ProcurementDemandDetail> procurementDemandDetailList = new ArrayList<ProcurementDemandDetail>();
	

	public PurchaseOrderPrimary getPurchaseOrderPrimary() {
		return purchaseOrderPrimary;
	}

	public void setPurchaseOrderPrimary(PurchaseOrderPrimary purchaseOrderPrimary) {
		this.purchaseOrderPrimary = purchaseOrderPrimary;
	}

	public PurchaseOrderDetail getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	public List<PurchaseOrderPrimary> getPurchaseOrderPrimaryList() {
		return purchaseOrderPrimaryList;
	}

	public void setPurchaseOrderPrimaryList(
			List<PurchaseOrderPrimary> purchaseOrderPrimaryList) {
		this.purchaseOrderPrimaryList = purchaseOrderPrimaryList;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetailList() {
		return purchaseOrderDetailList;
	}

	public void setPurchaseOrderDetailList(
			List<PurchaseOrderDetail> purchaseOrderDetailList) {
		this.purchaseOrderDetailList = purchaseOrderDetailList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Warehouse> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<Warehouse> warehouseList) {
		this.warehouseList = warehouseList;
	}

	public List<ProcurementDemandDetail> getProcurementDemandDetailList() {
		return procurementDemandDetailList;
	}

	public void setProcurementDemandDetailList(
			List<ProcurementDemandDetail> procurementDemandDetailList) {
		this.procurementDemandDetailList = procurementDemandDetailList;
	}


}
