package com.zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.ResourceinfoDao;
import com.zh.base.model.bean.Resourceinfo;
import com.zh.base.service.ResourceinfoService;
import com.zh.core.cache.MethodCacheAfterAdvice;
import com.zh.core.model.Pager;

@Component("resourceinfoService")
public class ResourceinfoServiceImpl extends MethodCacheAfterAdvice implements ResourceinfoService {

	@Autowired
	private ResourceinfoDao resourceinfoDao;
	
	@Override
	public Resourceinfo query(Resourceinfo resourceinfo) {
		// TODO Auto-generated method stub
		return resourceinfoDao.query(resourceinfo);
	}

	@Override
	public void update(Resourceinfo resourceinfo) {
		// TODO Auto-generated method stub
		resourceinfoDao.update(resourceinfo);
	}

	@Override
	public List<Resourceinfo> queryList(Resourceinfo resourceinfo) {
		// TODO Auto-generated method stub
		return resourceinfoDao.queryList(resourceinfo);
	}

	@Override
	public List<Resourceinfo> queryList(Resourceinfo resourceinfo, Pager page) {
		// TODO Auto-generated method stub
		return resourceinfoDao.queryPageList(resourceinfo, page);
	}

	@Override
	public Integer count(Resourceinfo resourceinfo) {
		// TODO Auto-generated method stub
		return resourceinfoDao.count(resourceinfo);
	}

	@Override
	public void delete(Resourceinfo resourceinfo) {
		// TODO Auto-generated method stub
		resourceinfoDao.delete(resourceinfo);
	}

	@Override
	public void insert(Resourceinfo resourceinfo) {
		// TODO Auto-generated method stub
		resourceinfoDao.insert(resourceinfo);
	}

}
