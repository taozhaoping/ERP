package com.zh.base.dao;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Dictionary;
import com.zh.core.base.dao.BaseDao;

@Component("dictionaryDao")
public class DictionaryDao extends BaseDao<Dictionary> {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_DICTIONARY");
	}

}
