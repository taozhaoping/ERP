package com.zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.EnterpriseDao;
import com.zh.base.model.bean.Enterprise;
import com.zh.base.service.EnterpriseService;
import com.zh.core.model.Pager;

@Component("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	private EnterpriseDao EnterpriseDao;

	@Override
	public Enterprise query(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return EnterpriseDao.query(enterprise);
	}

	@Override
	public void update(Enterprise enterprise) {
		// TODO Auto-generated method stub
		EnterpriseDao.update(enterprise);
	}

	@Override
	public List<Enterprise> queryList(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return EnterpriseDao.queryList(enterprise);
	}

	@Override
	public List<Enterprise> queryList(Enterprise enterprise, Pager page) {
		// TODO Auto-generated method stub
		return EnterpriseDao.queryPageList(enterprise, page);
	}

	@Override
	public Integer count(Enterprise enterprise) {
		// TODO Auto-generated method stub
		return EnterpriseDao.count(enterprise);
	}

	@Override
	public void delete(Enterprise enterprise) {
		// TODO Auto-generated method stub
		EnterpriseDao.delete(enterprise);
	}

	@Override
	public void insert(Enterprise enterprise) {
		// TODO Auto-generated method stub
		EnterpriseDao.insert(enterprise);
	}

}
