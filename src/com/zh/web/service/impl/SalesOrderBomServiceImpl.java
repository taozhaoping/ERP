package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.SalesOrderBomDao;
import com.zh.web.model.bean.SalesOrderBom;
import com.zh.web.service.SalesOrderBomService;

@Component("salesOrderBomService")
public class SalesOrderBomServiceImpl implements SalesOrderBomService {

	@Autowired
	private SalesOrderBomDao salesOrderBomDao;
	@Override
	public SalesOrderBom query(SalesOrderBom salesOrderBom) {
		// TODO Auto-generated method stub
		return salesOrderBomDao.query(salesOrderBom);
	}

	@Override
	public List<SalesOrderBom> queryList(SalesOrderBom salesOrderBom) {
		// TODO Auto-generated method stub
		return salesOrderBomDao.queryList(salesOrderBom);
	}

	@Override
	public List<SalesOrderBom> queryList(SalesOrderBom salesOrderBom, Pager page) {
		// TODO Auto-generated method stub
		return salesOrderBomDao.queryPageList(salesOrderBom, page);
	}

	@Override
	public Integer count(SalesOrderBom salesOrderBom) {
		// TODO Auto-generated method stub
		return salesOrderBomDao.count(salesOrderBom);
	}

}
