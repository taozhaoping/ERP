package com.zh.web.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.service.WarehouseService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;
import com.zh.web.model.StockModel;
import com.zh.web.model.bean.InventoryCountPrimary;
import com.zh.web.model.bean.Stock;
import com.zh.web.service.StockService;

/**
 * @Description: 库存
 * @Title: InventoryCountAction.java
 * @Package com.zh.web.action
 * @date 2015年7月7日 下午7:07:11
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class StockAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LoggerFactory.getLogger(StockAction.class);

	@Autowired
	private StockService stockService;

	@Autowired
	private WarehouseService warehouseService;

	private StockModel stockModel = new StockModel();

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return stockModel;
	}

	@Override
	public String execute() throws Exception {
		Stock stock = this.stockModel.getStock();
		Integer count = stockService.count(stock);
		Pager page = this.stockModel.getPageInfo();
		page.setTotalRow(count);
		List<Stock> stockList = stockService.queryList(stock, page);
		this.stockModel.setStockList(stockList);
		return Action.SUCCESS;
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
