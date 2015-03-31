package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProductsDao;
import com.zh.web.model.bean.Products;
import com.zh.web.service.ProductsService;

@Component("productsService")
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsDao productsDao;
	
	@Override
	public Products query(Products products) {
		// TODO Auto-generated method stub
		return productsDao.query(products);
	}

	@Override
	public void update(Products products) {
		// TODO Auto-generated method stub
		productsDao.update(products);
	}

	@Override
	public List<Products> queryList(Products products) {
		// TODO Auto-generated method stub
		return productsDao.queryList(products);
	}

	@Override
	public List<Products> queryList(Products products, Pager page) {
		// TODO Auto-generated method stub
		return productsDao.queryPageList(products, page);
	}

	@Override
	public Integer count(Products products) {
		// TODO Auto-generated method stub
		return productsDao.count(products);
	}

	@Override
	public void delete(Products products) {
		// TODO Auto-generated method stub
		productsDao.delete(products);
	}

	@Override
	public Integer insert(Products products) {
		// TODO Auto-generated method stub
		return productsDao.insert(products);
	}

}
