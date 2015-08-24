package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProductionTaskDao;
import com.zh.web.model.bean.ProductionTask;
import com.zh.web.service.ProductionTaskService;

@Component("productionTaskService")
public class ProductionTaskServiceImpl implements ProductionTaskService {

	@Autowired
	private ProductionTaskDao productionTaskDao;
	@Override
	public ProductionTask query(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		return productionTaskDao.query(productionTask);
	}

	@Override
	public void update(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		productionTaskDao.update(productionTask);
	}

	@Override
	public List<ProductionTask> queryList(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		return productionTaskDao.queryList(productionTask);
	}

	@Override
	public List<ProductionTask> queryList(ProductionTask productionTask,
			Pager page) {
		// TODO Auto-generated method stub
		return productionTaskDao.queryPageList(productionTask, page);
	}

	@Override
	public Integer count(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		return productionTaskDao.count(productionTask);
	}

	@Override
	public void delete(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		productionTaskDao.delete(productionTask);
	}

	@Override
	public Integer insert(ProductionTask productionTask) {
		// TODO Auto-generated method stub
		return productionTaskDao.insert(productionTask);
	}

	public ProductionTaskDao getProductionTaskDao() {
		return productionTaskDao;
	}

	public void setProductionTaskDao(ProductionTaskDao productionTaskDao) {
		this.productionTaskDao = productionTaskDao;
	}

}
