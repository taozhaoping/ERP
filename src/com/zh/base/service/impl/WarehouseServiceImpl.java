package com.zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.WarehouseDao;
import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.WarehouseService;
import com.zh.core.model.Pager;

@Component("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;
	
	@Override
	public Warehouse query(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseDao.query(warehouse);
	}

	@Override
	public void update(Warehouse warehouse) {
		// TODO Auto-generated method stub
		warehouseDao.update(warehouse);
	}

	@Override
	public List<Warehouse> queryList(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseDao.queryList(warehouse);
	}

	@Override
	public List<Warehouse> queryList(Warehouse warehouse, Pager page) {
		// TODO Auto-generated method stub
		return warehouseDao.queryPageList(warehouse, page);
	}

	@Override
	public Integer count(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseDao.count(warehouse);
	}

	@Override
	public void delete(Warehouse warehouse) {
		// TODO Auto-generated method stub
		warehouseDao.delete(warehouse);
	}

	@Override
	public Integer insert(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return warehouseDao.insert(warehouse);
	}

	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}

}
