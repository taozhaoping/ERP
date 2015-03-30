package com.zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.DictionaryDao;
import com.zh.base.model.bean.Dept;
import com.zh.base.model.bean.Dictionary;
import com.zh.base.service.DictionaryService;
import com.zh.core.util.JSONUtil;

@Component("dictionaryService")
public class DictionaryServiceImpl implements
		DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;
	
	@Override
	public Dictionary query(Dictionary dictionary) {
		// TODO Auto-generated method stub
		return dictionaryDao.query(dictionary);
	}

	@Override
	public List<Dictionary> queryList(Dictionary dictionary) {
		// TODO Auto-generated method stub
		return dictionaryDao.queryList(dictionary);
	}
	
	public List<Dictionary> queryList(Integer typeid)
	{
		Dictionary dictionary = new Dictionary();
		dictionary.setBasiTypeID(typeid);
		return this.queryList(dictionary);
		
	}

	@Override
	public String queryListJson(Dictionary dictionary) {
		List<Dictionary> list = this.queryList(dictionary);
		return JSONUtil.list2json(list);
	}

}
