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
		return authoritiesDao.query(authorities);
	}

	@Override
	public void update(Authorities authorities) {
		authoritiesDao.update(authorities);
	}

	@Override
	public List<Authorities> queryList(Authorities authorities, Pager page) {
		return authoritiesDao.queryPageList(authorities, page);
	}

	@Override
	public Integer count(Authorities authorities) {
		return authoritiesDao.count(authorities);
	}

	@Override
	public void delete(Authorities authorities) {
		authoritiesDao.delete(authorities);
	}

	@Override
	public void insert(Authorities authorities) {
		authoritiesDao.insert(authorities);
	}

	@Override
	public List<Authorities> queryList(Authorities authorities) {
		return authoritiesDao.queryList(authorities);
	}

	public AuthoritiesDao getAuthoritiesDao() {
		return authoritiesDao;
	}

	public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
		this.authoritiesDao = authoritiesDao;
	}

	@Override
	public List<Authorities> queryListById(Long roleId) {
		return authoritiesDao.queryAuthoritiesByRoleId(roleId);
	}

}
