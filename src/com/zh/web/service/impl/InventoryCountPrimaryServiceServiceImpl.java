package com.zh.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zh.core.model.Pager;
import com.zh.web.dao.InventoryCountPrimaryDao;
import com.zh.web.model.bean.InventoryCountPrimary;
import com.zh.web.service.InventoryCountPrimaryService;

@Component("inventoryCountPrimaryService")
public class InventoryCountPrimaryServiceServiceImpl implements InventoryCountPrimaryService {

	@Autowired
	private InventoryCountPrimaryDao inventoryCountPrimaryDao;
	
	@Override
	public InventoryCountPrimary query(InventoryCountPrimary inventoryCountPrimary) {
		// TODO Auto-generated method stub
		return inventoryCountPrimaryDao.query(inventoryCountPrimary);
	}

	@Override
	public void update(InventoryCountPrimary inventoryCountPrimary) {
		// TODO Auto-generated method stub
		inventoryCountPrimaryDao.update(inventoryCountPrimary);
	}

	@Override
	public List<InventoryCountPrimary> queryList(InventoryCountPrimary inventoryCountPrimary) {
		// TODO Auto-generated method stub
		return inventoryCountPrimaryDao.queryList(inventoryCountPrimary);
	}

	@Override
	public List<InventoryCountPrimary> queryList(InventoryCountPrimary inventoryCountPrimary, Pager page) {
		// TODO Auto-generated method stub
		return inventoryCountPrimaryDao.queryPageList(inventoryCountPrimary, page);
	}

	@Override
	public Integer count(InventoryCountPrimary inventoryCountPrimary) {
		// TODO Auto-generated method stub
		return inventoryCountPrimaryDao.count(inventoryCountPrimary);
	}

	@Override
	public void delete(InventoryCountPrimary inventoryCountPrimary) {
		// TODO Auto-generated method stub
		inventoryCountPrimaryDao.delete(inventoryCountPrimary);
	}

	@Override
	public Integer insert(InventoryCountPrimary inventoryCountPrimary) {
		return inventoryCountPrimaryDao.insert(inventoryCountPrimary);
	}

	public InventoryCountPrimaryDao getInventoryCountPrimaryDao() {
		return inventoryCountPrimaryDao;
	}

	public void setInventoryCountPrimaryDao(
			InventoryCountPrimaryDao inventoryCountPrimaryDao) {
		this.inventoryCountPrimaryDao = inventoryCountPrimaryDao;
	}

}
