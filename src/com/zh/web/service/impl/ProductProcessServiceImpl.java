package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProductProcessDao;
import com.zh.web.model.bean.ProductProcess;
import com.zh.web.service.ProductProcessService;

@Component("productProcessService")
public class ProductProcessServiceImpl implements ProductProcessService {

	@Autowired
	private ProductProcessDao productProcessDao;
	
	@Override
	public ProductProcess query(ProductProcess productProcess) {
		// TODO Auto-generated method stub
		return productProcessDao.query(productProcess);
	}

	@Override
	public void update(ProductProcess productProcess) {
		// TODO Auto-generated method stub
		productProcessDao.update(productProcess);
	}

	@Override
	public List<ProductProcess> queryList(ProductProcess productProcess) {
		// TODO Auto-generated method stub
		return productProcessDao.queryList(productProcess);
	}

	@Override
	public List<ProductProcess> queryList(ProductProcess productProcess, Pager page) {
		// TODO Auto-generated method stub
		return productProcessDao.queryPageList(productProcess, page);
	}

	@Override
	public Integer count(ProductProcess productProcess) {
		// TODO Auto-generated method stub
		return productProcessDao.count(productProcess);
	}

	@Override
	public void delete(ProductProcess productProcess) {
		// TODO Auto-generated method stub
		productProcessDao.delete(productProcess);
	}

	@Override
	public Integer insert(ProductProcess productProcess) {
		// TODO Auto-generated method stub
		return productProcessDao.insert(productProcess);
	}

}
