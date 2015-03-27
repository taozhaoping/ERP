package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.base.model.BaseModel;

public class WarehouseModel extends BaseModel {

	private Warehouse warehouse = new Warehouse();
	
	private List<Warehouse> warehouseList = new ArrayList<Warehouse>();

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<Warehouse> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<Warehouse> warehouseList) {
		this.warehouseList = warehouseList;
	}

	
}
