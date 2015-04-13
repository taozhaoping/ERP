package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.StoragePrimary;

public class StoragePrimaryModel extends BaseModel {

	private StoragePrimary StoragePrimary = new StoragePrimary();
	
	private List<StoragePrimary> storagePrimaryList = new ArrayList<StoragePrimary>();

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

	
}
