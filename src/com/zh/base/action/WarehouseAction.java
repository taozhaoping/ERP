package com.zh.base.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zh.base.model.WarehouseModel;
import com.zh.base.service.WarehouseService;
import com.zh.core.base.action.BaseAction;

public class WarehouseAction extends BaseAction {

	private static Logger LOGGER = LoggerFactory.getLogger(WarehouseAction.class); 
	
	private WarehouseModel WarehouseModel = new WarehouseModel();
	
	private WarehouseService warehouseService;
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return WarehouseModel;
	}
	
	@Override
	public String execute() throws Exception {
		
		return "usersjson";

	}
	
	public WarehouseModel getWarehouseModel() {
		return WarehouseModel;
	}
	
	public void setWarehouseModel(WarehouseModel warehouseModel) {
		WarehouseModel = warehouseModel;
	}
	
	public WarehouseService getWarehouseService() {
		return warehouseService;
	}
	
	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}

	@Override
	public String editor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
