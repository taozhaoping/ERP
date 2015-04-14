package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProductStructDao;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.service.ProductStructService;

@Component("productStructureService")
public class ProductStructServiceImpl implements ProductStructService {

	@Autowired
	private ProductStructDao productStructureDao;
	
	@Override
	public BomPrimary query(BomPrimary productStructure) {
		// TODO Auto-generated method stub
		return productStructureDao.query(productStructure);
	}

	@Override
	public void update(BomPrimary productStructure) {
		// TODO Auto-generated method stub
		productStructureDao.update(productStructure);
	}

	@Override
	public List<BomPrimary> queryList(BomPrimary productStructure) {
		// TODO Auto-generated method stub
		return productStructureDao.queryList(productStructure);
	}

	@Override
	public List<BomPrimary> queryList(BomPrimary productStructure,
			Pager page) {
		// TODO Auto-generated method stub
		return productStructureDao.queryList(productStructure);
	}

	@Override
	public Integer count(BomPrimary productStructure) {
		// TODO Auto-generated method stub
		return productStructureDao.count(productStructure);
	}

	@Override
	public void delete(BomPrimary productStructure) {
		// TODO Auto-generated method stub
		productStructureDao.delete(productStructure);
	}

	@Override
	public Integer insert(BomPrimary productStructure) {
		// TODO Auto-generated method stub
		return productStructureDao.insert(productStructure);
	}

}
