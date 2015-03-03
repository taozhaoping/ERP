package com.zh.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.ParamDao;
import com.zh.base.model.bean.Param;
import com.zh.base.service.ParamService;

@Component("paramService")
public class ParamServiceImpl implements ParamService {

	@Autowired
	private ParamDao paramDao;
	@Override
	public Param query() {
		// TODO Auto-generated method stub
		Param param = new Param();
		param.setId(1);
		return paramDao.query(param);
	}

	@Override
	public void update(Param param) {
		// TODO Auto-generated method stub
		paramDao.update(param);
	}

}
