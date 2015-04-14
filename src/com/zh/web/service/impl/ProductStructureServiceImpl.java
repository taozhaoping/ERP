package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProductStructureDao;
import com.zh.web.model.bean.BOMPrimary;
import com.zh.web.service.ProductStructureService;

@Component("productStructureService")
public class ProductStructureServiceImpl implements ProductStructureService {

	@Autowired
	private ProductStructureDao productStructureDao;
	
	@Override
	public BOMPrimary query(BOMPrimary productStructure) {
		// TODO Auto-generated method stub
		return productStructureDao.query(productStructure);
	}

	@Override
	public void update(BOMPrimary productStructure) {
		// TODO Auto-generated method stub
		productStructureDao.update(productStructure);
	}

	@Override
	public List<BOMPrimary> queryList(BOMPrimary productStructure) {
		// TODO Auto-generated method stub
		return productStructureDao.queryList(productStructure);
	}

	@Override
	public List<BOMPrimary> queryList(BOMPrimary productStructure,
			Pager page) {
		// TODO Auto-generated method stub
		return productStructureDao.queryList(productStructure);
	}

	@Override
	public Integer count(BOMPrimary productStructure) {
		// TODO Auto-generated method stub
		return productStructureDao.count(productStructure);
	}

	@Override
	public void delete(BOMPrimary productStructure) {
		// TODO Auto-generated method stub
		productStructureDao.delete(productStructure);
	}

	@Override
	public Integer insert(BOMPrimary productStructure) {
		// TODO Auto-generated method stub
		return productStructureDao.insert(productStructure);
	}

}
