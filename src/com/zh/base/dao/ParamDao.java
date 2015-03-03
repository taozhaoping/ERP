package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Param;
import com.zh.core.base.dao.BaseDao;

@Component("paramDao")
public class ParamDao extends BaseDao<Param> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("AM_PARAM");
		
	}

}
