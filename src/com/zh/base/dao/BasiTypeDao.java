package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.BasiType;
import com.zh.core.base.dao.BaseDao;

@Component("basiTypeDao")
public class BasiTypeDao extends BaseDao<BasiType> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_BASI_TYPE");
	}

}
