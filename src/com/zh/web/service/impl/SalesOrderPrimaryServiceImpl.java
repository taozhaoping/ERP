package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;
import com.zh.web.dao.SalesOrderPrimaryDao;
import com.zh.web.model.bean.SalesOrderPrimary;
import com.zh.web.service.SalesOrderPrimaryService;
import com.zh.web.util.UtilService;

@Component("salesOrderPrimaryService")
public class SalesOrderPrimaryServiceImpl implements SalesOrderPrimaryService {

	@Autowired
	private SalesOrderPrimaryDao salesOrderPrimaryDao;

	@Override
	public SalesOrderPrimary query(SalesOrderPrimary salesOrderPrimary) {
		// TODO Auto-generated method stub
		return salesOrderPrimaryDao.query(salesOrderPrimary);
	}

	@Override
	public void update(SalesOrderPrimary salesOrderPrimary) {
		// TODO Auto-generated method stub
		salesOrderPrimaryDao.update(salesOrderPrimary);
	}

	@Override
	public List<SalesOrderPrimary> queryList(SalesOrderPrimary salesOrderPrimary) {
		// TODO Auto-generated method stub
		return salesOrderPrimaryDao.queryList(salesOrderPrimary);
	}

	@Override
	public List<SalesOrderPrimary> queryList(
			SalesOrderPrimary salesOrderPrimary, Pager page) {
		// TODO Auto-generated method stub
		return salesOrderPrimaryDao.queryPageList(salesOrderPrimary, page);
	}

	@Override
	public Integer count(SalesOrderPrimary salesOrderPrimary) {
		return salesOrderPrimaryDao.count(salesOrderPrimary);
	}

	@Override
	public void delete(SalesOrderPrimary salesOrderPrimary) {
		// TODO Auto-generated method stub
		salesOrderPrimaryDao.delete(salesOrderPrimary);
	}

	@Override
	public Integer insert(SalesOrderPrimary salesOrderPrimary, String type) {
		Integer id = Integer.valueOf(salesOrderPrimaryDao.getSequence(SEQUENCE_STORAGE_PRIMARY).toString());
		String dateStr = DateUtil.getToday();
		salesOrderPrimary.setId(id);
		salesOrderPrimary.setOrderID(UtilService.SALES_ORDER_TYPE + dateStr + id);
		salesOrderPrimary.setStatus(UtilService.SALES_ORDER_ONE);
		return salesOrderPrimaryDao.insert(salesOrderPrimary);
	}

	public SalesOrderPrimaryDao getSalesOrderPrimaryDao() {
		return salesOrderPrimaryDao;
	}

	public void setSalesOrderPrimaryDao(SalesOrderPrimaryDao salesOrderPrimaryDao) {
		this.salesOrderPrimaryDao = salesOrderPrimaryDao;
	}

	@Override
	public List<SalesOrderPrimary> queryListNotRelevantProcess() {
		return salesOrderPrimaryDao.querySqlIDList("listNotRelevantProcess");
	}

}
