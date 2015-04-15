package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.BomPrimaryDao;
import com.zh.web.model.bean.BomPrimary;
import com.zh.web.service.ProductStructService;

@Component("productStructureService")
public class ProductStructServiceImpl implements ProductStructService {

	@Autowired
	private BomPrimaryDao bomPrimaryDao;
	
	@Override
	public BomPrimary queryPrimary(BomPrimary bomPrimary) {
		return bomPrimaryDao.query(bomPrimary);
	}

	@Override
	public void updatePrimary(BomPrimary bomPrimary) {
		bomPrimaryDao.update(bomPrimary);
	}

	@Override
	public List<BomPrimary> queryPrimaryList(BomPrimary bomPrimary) {
		return bomPrimaryDao.queryList(bomPrimary);
	}

	@Override
	public List<BomPrimary> queryPrimaryList(BomPrimary bomPrimary,
			Pager page) {
		return bomPrimaryDao.queryList(bomPrimary);
	}

	@Override
	public Integer countPrimary(BomPrimary bomPrimary) {
		return bomPrimaryDao.count(bomPrimary);
	}

	@Override
	public void deletePrimary(BomPrimary bomPrimary) {
		bomPrimaryDao.delete(bomPrimary);
	}

	@Override
	public Integer insertPrimary(BomPrimary bomPrimary) {
		return bomPrimaryDao.insert(bomPrimary);
	}

}
