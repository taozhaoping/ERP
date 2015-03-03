package com.zh.base.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.core.base.model.KeyObject;

@Component("userNameDao")
public class UserNameDao extends BaseDao<KeyObject> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("AM_User");
	}
	
	public List<KeyObject> queryUserName()
	{
		return queryList("queryUserName", null);
	}
}
