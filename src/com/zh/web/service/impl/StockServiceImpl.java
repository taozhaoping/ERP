package com.zh.web.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Warehouse;
import com.zh.base.service.WarehouseService;
import com.zh.core.model.Pager;
import com.zh.web.dao.StockDao;
import com.zh.web.model.bean.Stock;
import com.zh.web.service.StockService;

@Component("stockService")
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private WarehouseService warehouseService;

	@Override
	public Stock query(Stock stock) {
		// TODO Auto-generated method stub
		return stockDao.query(stock);
	}

	@Override
	public void update(Stock stock) {
		// TODO Auto-generated method stub
		stockDao.update(stock);
	}

	@Override
	public List<Stock> queryList(Stock stock) {
		// TODO Auto-generated method stub
		return stockDao.queryList(stock);
	}

	@Override
	public List<Stock> queryList(Stock stock, Pager page) {
		// TODO Auto-generated method stub
		return stockDao.queryPageList(stock, page);
	}

	@Override
	public Integer count(Stock stock) {
		// TODO Auto-generated method stub
		return stockDao.insert(stock);
	}

	@Override
	public void delete(Stock stock) {
		// TODO Auto-generated method stub
		stockDao.delete(stock);
	}

	@Override
	public Integer insert(Stock stock) {
		// TODO Auto-generated method stub
		Integer position = stock.getPosition();
		if (null == position) {
			position = Integer.valueOf(stockDao.getSequence(SEQUENCE_POSITION)
					.toString());
			stock.setPosition(position);
		}
		stock.setStockNumber(0F);
		stock.setPosition(position);
		List<Warehouse> list = warehouseService.queryList(new Warehouse());
		for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
			Warehouse warehouse = (Warehouse) iterator.next();
			stock.setWarehouseID(warehouse.getId());
			stockDao.insert(stock);
		}
		return position;
	}

}
