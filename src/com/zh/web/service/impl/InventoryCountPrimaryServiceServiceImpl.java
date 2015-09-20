package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.base.model.StockObject;
import com.zh.core.model.Pager;
import com.zh.web.dao.InventoryCountPrimaryDao;
import com.zh.web.model.bean.InventoryCountDetail;
import com.zh.web.model.bean.InventoryCountPrimary;
import com.zh.web.model.bean.Stock;
import com.zh.web.service.InventoryCountDetailService;
import com.zh.web.service.InventoryCountPrimaryService;
import com.zh.web.service.StockService;
import com.zh.web.util.StockUtil;
import com.zh.web.util.UtilService;

@Component("inventoryCountPrimaryService")
public class InventoryCountPrimaryServiceServiceImpl implements InventoryCountPrimaryService {

	@Autowired
	private InventoryCountPrimaryDao inventoryCountPrimaryDao;
	
	@Autowired
	private InventoryCountDetailService inventoryCountDetailService;
	
	@Autowired
	private StockService stockService;
	
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
		
		inventoryCountPrimary.setStatus(UtilService.INVENTORY_ZERO);
		int reult = inventoryCountPrimaryDao.insert(inventoryCountPrimary);
		
		//保存前，先盘点库存剩余产品
		Stock stock = new Stock();
		if (inventoryCountPrimary.getWarehouseID() != 0) {
			stock.setWarehouseID(inventoryCountPrimary.getWarehouseID());
		}
		Long inventoryID = inventoryCountPrimary.getId();
		List<Stock> stockList = stockService.queryList(stock);
		for (Stock stockReult : stockList) {
			InventoryCountDetail inventoryCountDetail = new InventoryCountDetail();
			inventoryCountDetail.setInventoryID(inventoryID);
			inventoryCountDetail.setProductsID(stockReult.getProductsID());
			inventoryCountDetail.setWarehouseID(stockReult.getWarehouseID());
			inventoryCountDetail.setOriginalQuantiy(stockReult.getStockNumber());
			inventoryCountDetail.setChangeQuantiy(0f);
			inventoryCountDetail.setStockID(stockReult.getId());
			inventoryCountDetailService.insert(inventoryCountDetail);
		}
		
		return reult;
	}

	public void increaseStock(Long id)
	{
		InventoryCountPrimary inventoryCountPrimary = new InventoryCountPrimary();
		inventoryCountPrimary.setId(id);
		inventoryCountPrimary.setStatus(1);
		this.update(inventoryCountPrimary);
		
		// 单据入库
		StockUtil stockUtil = StockUtil.getInstance();
		stockUtil.operationStock(id,0L, stockUtil.INVENTORY_COUNT);
	}
	
	public InventoryCountPrimaryDao getInventoryCountPrimaryDao() {
		return inventoryCountPrimaryDao;
	}

	public void setInventoryCountPrimaryDao(
			InventoryCountPrimaryDao inventoryCountPrimaryDao) {
		this.inventoryCountPrimaryDao = inventoryCountPrimaryDao;
	}

}
