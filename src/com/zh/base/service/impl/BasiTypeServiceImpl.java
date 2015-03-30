package com.zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.BasiTypeDao;
import com.zh.base.model.bean.BasiType;
import com.zh.base.service.BasiTypeService;
import com.zh.core.util.JSONUtil;

@Component("basiTypeService")
public class BasiTypeServiceImpl implements BasiTypeService {
	
	@Autowired
	private BasiTypeDao basiTypeDao;
	
	@Override
	public BasiType query(BasiType basiType) {
		// TODO Auto-generated method stub
		return basiTypeDao.query(basiType);
	}

	@Override
	public List<BasiType> queryList(BasiType basiType) {
		// TODO Auto-generated method stub
		return basiTypeDao.queryList(basiType);
	}

	@Override
	public String queryListJson(BasiType basiType) {
		List<BasiType> list = this.queryList(basiType);
		return JSONUtil.list2json(list);
	}

}
