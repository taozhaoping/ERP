package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Authorities;
import com.zh.core.base.dao.BaseDao;

@Component("authoritiesDao")
public class AuthoritiesDao extends BaseDao<Authorities> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_Authorities");
	}

}
