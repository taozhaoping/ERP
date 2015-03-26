package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.base.model.BaseModel;

public class WarehouseModel extends BaseModel {

	private Warehouse Warehouse = new Warehouse();
	
	private List<Warehouse> WarehouseList = new ArrayList<Warehouse>();

	public Warehouse getWarehouse() {
		return Warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		Warehouse = warehouse;
	}

	public List<Warehouse> getWarehouseList() {
		return WarehouseList;
	}

	public void setWarehouseList(List<Warehouse> warehouseList) {
		WarehouseList = warehouseList;
	}
	
	
}
