package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Menu;
import com.zh.core.base.dao.BaseDao;

@Component("menuDao")
public class MenuDao extends BaseDao<Menu> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("AM_Menu");
	}

}
