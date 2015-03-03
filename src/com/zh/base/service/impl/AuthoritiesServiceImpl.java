package com.zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.AuthoritiesDao;
import com.zh.base.model.bean.Authorities;
import com.zh.base.service.AuthoritiesService;
import com.zh.core.model.Pager;

@Component("authoritiesService")
public class AuthoritiesServiceImpl implements AuthoritiesService {

	@Autowired
	private AuthoritiesDao authoritiesDao;
	
	@Override
	public Authorities query(Authorities authorities) {
		// TODO Auto-generated method stub
		return authoritiesDao.query(authorities);
	}

	@Override
	public void update(Authorities authorities) {
		// TODO Auto-generated method stub
		authoritiesDao.update(authorities);
	}

	@Override
	public List<Authorities> queryList(Authorities authorities, Pager page) {
		// TODO Auto-generated method stub
		return authoritiesDao.queryPageList(authorities, page);
	}

	@Override
	public Integer count(Authorities authorities) {
		// TODO Auto-generated method stub
		return authoritiesDao.count(authorities);
	}

	@Override
	public void delete(Authorities authorities) {
		// TODO Auto-generated method stub
		authoritiesDao.delete(authorities);
	}

	@Override
	public void insert(Authorities authorities) {
		// TODO Auto-generated method stub
		authoritiesDao.insert(authorities);
	}

	@Override
	public List<Authorities> queryList(Authorities authorities) {
		// TODO Auto-generated method stub
		return authoritiesDao.queryList(authorities);
	}

	public AuthoritiesDao getAuthoritiesDao() {
		return authoritiesDao;
	}

	public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
		this.authoritiesDao = authoritiesDao;
	}

}
