package com.zh.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zh.core.model.Pager;
import com.zh.web.dao.SalesOrderDetailDao;
import com.zh.web.model.bean.SalesOrderDetail;
import com.zh.web.service.SalesOrderDetailService;

@Component("salesOrderDetailService")
public class SalesOrderDetailServiceImpl implements SalesOrderDetailService {

	@Autowired
	private SalesOrderDetailDao salesOrderDetailDao;

	@Override
	public SalesOrderDetail query(SalesOrderDetail salesOrderDetail) {
		// TODO Auto-generated method stub
		return salesOrderDetailDao.query(salesOrderDetail);
	}

	@Override
	public void update(SalesOrderDetail salesOrderDetail) {
		// TODO Auto-generated method stub
		salesOrderDetailDao.update(salesOrderDetail);
	}

	@Override
	public List<SalesOrderDetail> queryList(SalesOrderDetail salesOrderDetail) {
		// TODO Auto-generated method stub
		return salesOrderDetailDao.queryList(salesOrderDetail);
	}

	@Override
	public List<SalesOrderDetail> queryList(SalesOrderDetail salesOrderDetail, Pager page) {
		// TODO Auto-generated method stub
		return salesOrderDetailDao.queryPageList(salesOrderDetail, page);
	}

	@Override
	public Integer count(SalesOrderDetail salesOrderDetail) {
		// TODO Auto-generated method stub
		return salesOrderDetailDao.count(salesOrderDetail);
	}

	@Override
	public void delete(SalesOrderDetail salesOrderDetail) {

		// 修改对应库存
		/*StockUtil stockUtil = StockUtil.getInstance();
		stockUtil.reduceStock(salesOrderDetail);*/
		salesOrderDetailDao.delete(salesOrderDetail);
	}

	@Override
	public Integer insert(SalesOrderDetail salesOrderDetail) {
		// 修改对应库存
		/*StockUtil stockUtil = StockUtil.getInstance();
		stockUtil.increaseStock(salesOrderDetail);*/
		return salesOrderDetailDao.insert(salesOrderDetail);
	}

}
