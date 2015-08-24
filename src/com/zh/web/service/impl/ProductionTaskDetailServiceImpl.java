package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProductionTaskDetailDao;
import com.zh.web.model.bean.ProductionTaskDetail;
import com.zh.web.service.ProductionTaskDetailService;

@Component("productionTaskDetailService")
public class ProductionTaskDetailServiceImpl implements
		ProductionTaskDetailService {

	@Autowired
	private ProductionTaskDetailDao productionTaskDetailDao;
	@Override
	public ProductionTaskDetail query(ProductionTaskDetail productionTaskDetail) {
		// TODO Auto-generated method stub
		return productionTaskDetailDao.query(productionTaskDetail);
	}

	@Override
	public void update(ProductionTaskDetail productionTaskDetail) {
		// TODO Auto-generated method stub
		productionTaskDetailDao.update(productionTaskDetail);
	}

	@Override
	public List<ProductionTaskDetail> queryList(
			ProductionTaskDetail productionTaskDetail) {
		// TODO Auto-generated method stub
		return productionTaskDetailDao.queryList(productionTaskDetail);
	}

	@Override
	public List<ProductionTaskDetail> queryList(
			ProductionTaskDetail productionTaskDetail, Pager page) {
		// TODO Auto-generated method stub
		return productionTaskDetailDao.queryPageList(productionTaskDetail, page);
	}

	@Override
	public Integer count(ProductionTaskDetail productionTaskDetail) {
		// TODO Auto-generated method stub
		return productionTaskDetailDao.count(productionTaskDetail);
	}

	@Override
	public void delete(ProductionTaskDetail productionTaskDetail) {
		// TODO Auto-generated method stub
		productionTaskDetailDao.delete(productionTaskDetail);
	}

	@Override
	public Integer insert(ProductionTaskDetail productionTaskDetail) {
		// TODO Auto-generated method stub
		return productionTaskDetailDao.insert(productionTaskDetail);
	}

}
