package com.zh.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zh.core.model.Pager;
import com.zh.web.dao.CuttingSchemeDao;
import com.zh.web.model.bean.CuttingScheme;
import com.zh.web.service.CuttingSchemeService;

@Component("cuttingSchemeService")
public class CuttingSchemeServiceImpl implements CuttingSchemeService {

	@Autowired
	private CuttingSchemeDao cuttingSchemeDao;
	
	@Override
	public CuttingScheme query(CuttingScheme cuttingScheme) {
		// TODO Auto-generated method stub
		return cuttingSchemeDao.query(cuttingScheme);
	}

	@Override
	public void update(CuttingScheme cuttingScheme) {
		// TODO Auto-generated method stub
		cuttingSchemeDao.update(cuttingScheme);
	}

	@Override
	public List<CuttingScheme> queryList(CuttingScheme cuttingScheme) {
		// TODO Auto-generated method stub
		return cuttingSchemeDao.queryList(cuttingScheme);
	}

	@Override
	public List<CuttingScheme> queryList(CuttingScheme cuttingScheme, Pager page) {
		// TODO Auto-generated method stub
		return cuttingSchemeDao.queryPageList(cuttingScheme, page);
	}

	@Override
	public Integer count(CuttingScheme cuttingScheme) {
		// TODO Auto-generated method stub
		return cuttingSchemeDao.count(cuttingScheme);
	}

	@Override
	public void delete(CuttingScheme cuttingScheme) {
		// TODO Auto-generated method stub
		cuttingSchemeDao.delete(cuttingScheme);
	}

	@Override
	public Integer insert(CuttingScheme cuttingScheme) {
		// TODO Auto-generated method stub
		return cuttingSchemeDao.insert(cuttingScheme);
	}

	public CuttingSchemeDao getCuttingSchemeDao() {
		return cuttingSchemeDao;
	}

	public void setCuttingSchemeDao(CuttingSchemeDao cuttingSchemeDao) {
		this.cuttingSchemeDao = cuttingSchemeDao;
	}

}
