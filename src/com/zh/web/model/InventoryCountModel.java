package com.zh.web.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.base.model.BaseModel;
import com.zh.web.model.bean.InventoryCountDetail;
import com.zh.web.model.bean.InventoryCountPrimary;

public class InventoryCountModel extends BaseModel {

	private InventoryCountPrimary inventoryCountPrimary = new InventoryCountPrimary();

	private List<InventoryCountPrimary> inventoryCountPrimaryList = new ArrayList<InventoryCountPrimary>();

	private InventoryCountDetail inventoryCountDetail = new InventoryCountDetail();

	private List<InventoryCountDetail> inventoryCountDetailList = new ArrayList<InventoryCountDetail>();

	private List<Warehouse> warehouseList = new ArrayList<Warehouse>();
	
	public InventoryCountPrimary getInventoryCountPrimary() {
		return inventoryCountPrimary;
	}

	public void setInventoryCountPrimary(InventoryCountPrimary inventoryCountPrimary) {
		this.inventoryCountPrimary = inventoryCountPrimary;
	}

	public List<InventoryCountPrimary> getInventoryCountPrimaryList() {
		return inventoryCountPrimaryList;
	}

	public void setInventoryCountPrimaryList(
			List<InventoryCountPrimary> inventoryCountPrimaryList) {
		this.inventoryCountPrimaryList = inventoryCountPrimaryList;
	}

	public InventoryCountDetail getInventoryCountDetail() {
		return inventoryCountDetail;
	}

	public void setInventoryCountDetail(InventoryCountDetail inventoryCountDetail) {
		this.inventoryCountDetail = inventoryCountDetail;
	}

	public List<InventoryCountDetail> getInventoryCountDetailList() {
		return inventoryCountDetailList;
	}

	public void setInventoryCountDetailList(
			List<InventoryCountDetail> inventoryCountDetailList) {
		this.inventoryCountDetailList = inventoryCountDetailList;
	}

	public List<Warehouse> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<Warehouse> warehouseList) {
		this.warehouseList = warehouseList;
	}

}
