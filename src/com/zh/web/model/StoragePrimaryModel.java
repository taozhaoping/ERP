package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;

public class StoragePrimaryModel extends BaseModel {

	private StoragePrimary storagePrimary = new StoragePrimary();

	private List<StoragePrimary> storagePrimaryList = new ArrayList<StoragePrimary>();

	private StorageDetail storageDetail = new StorageDetail();

	private List<StorageDetail> storageDetailList = new ArrayList<StorageDetail>();

	private List<Customer> customerList = new ArrayList<Customer>();

	private List<Warehouse> warehouseList = new ArrayList<Warehouse>();

	public StoragePrimary getStoragePrimary() {
		return storagePrimary;
	}

	public void setStoragePrimary(StoragePrimary storagePrimary) {
		this.storagePrimary = storagePrimary;
	}

	public List<StoragePrimary> getStoragePrimaryList() {
		return storagePrimaryList;
	}

	public void setStoragePrimaryList(List<StoragePrimary> storagePrimaryList) {
		this.storagePrimaryList = storagePrimaryList;
	}

	public StorageDetail getStorageDetail() {
		return storageDetail;
	}

	public void setStorageDetail(StorageDetail storageDetail) {
		this.storageDetail = storageDetail;
	}

	public List<StorageDetail> getStorageDetailList() {
		return storageDetailList;
	}

	public void setStorageDetailList(List<StorageDetail> storageDetailList) {
		storageDetailList = storageDetailList;
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

	
}
