package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.InventoryCountDetailDao;
import com.zh.web.model.bean.InventoryCountDetail;
import com.zh.web.service.InventoryCountDetailService;

@Component("inventoryCountDetailService")
public class InventoryCountDetailServiceImpl implements
		InventoryCountDetailService {

	@Autowired
	private InventoryCountDetailDao inventoryCountDetailDao;
	
	@Override
	public InventoryCountDetail query(InventoryCountDetail inventoryCountDetail) {
		// TODO Auto-generated method stub
		return inventoryCountDetailDao.query(inventoryCountDetail);
	}

	@Override
	public void update(InventoryCountDetail inventoryCountDetail) {
		// TODO Auto-generated method stub
		inventoryCountDetailDao.update(inventoryCountDetail);
	}

	@Override
	public List<InventoryCountDetail> queryList(
			InventoryCountDetail inventoryCountDetail) {
		// TODO Auto-generated method stub
		inventoryCountDetail.setOrderByClause("original_quantity desc");
		return inventoryCountDetailDao.queryList(inventoryCountDetail);
	}

	@Override
	public List<InventoryCountDetail> queryList(
			InventoryCountDetail inventoryCountDetail, Pager page) {
		// TODO Auto-generated method stub
		return inventoryCountDetailDao.queryPageList(inventoryCountDetail, page);
	}

	@Override
	public Integer count(InventoryCountDetail inventoryCountDetail) {
		// TODO Auto-generated method stub
		return inventoryCountDetailDao.count(inventoryCountDetail);
	}

	@Override
	public void delete(InventoryCountDetail inventoryCountDetail) {
		// TODO Auto-generated method stub
		inventoryCountDetailDao.delete(inventoryCountDetail);
	}

	@Override
	public Integer insert(InventoryCountDetail inventoryCountDetail) {
		// TODO Auto-generated method stub
		return inventoryCountDetailDao.insert(inventoryCountDetail);
	}

	public InventoryCountDetailDao getInventoryCountDetailDao() {
		return inventoryCountDetailDao;
	}

	public void setInventoryCountDetailDao(
			InventoryCountDetailDao inventoryCountDetailDao) {
		this.inventoryCountDetailDao = inventoryCountDetailDao;
	}
	
}
