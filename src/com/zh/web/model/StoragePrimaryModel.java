package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.Customer;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;

public class StoragePrimaryModel extends BaseModel {

	private StoragePrimary StoragePrimary = new StoragePrimary();

	private List<StoragePrimary> storagePrimaryList = new ArrayList<StoragePrimary>();

	private StorageDetail StorageDetail = new StorageDetail();

	private List<StorageDetail> StorageDetailList = new ArrayList<StorageDetail>();

	private List<Customer> customerList = new ArrayList<Customer>();

	private List<Warehouse> warehouseList = new ArrayList<Warehouse>();

	public StoragePrimary getStoragePrimary() {
		return StoragePrimary;
	}

	public void setStoragePrimary(StoragePrimary storagePrimary) {
		StoragePrimary = storagePrimary;
	}

	public List<StoragePrimary> getStoragePrimaryList() {
		return storagePrimaryList;
	}

	public void setStoragePrimaryList(List<StoragePrimary> storagePrimaryList) {
		this.storagePrimaryList = storagePrimaryList;
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

	public StorageDetail getStorageDetail() {
		return StorageDetail;
	}

	public void setStorageDetail(StorageDetail storageDetail) {
		StorageDetail = storageDetail;
	}

	public List<StorageDetail> getStorageDetailList() {
		return StorageDetailList;
	}

	public void setStorageDetailList(List<StorageDetail> storageDetailList) {
		StorageDetailList = storageDetailList;
	}

}
