package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.LibraryDetailDao;
import com.zh.web.model.bean.LibraryDetail;
import com.zh.web.service.LibraryDetailService;

@Component("libraryDetailService")
@Scope("singleton")
public class LibraryDetailServiceImpl implements LibraryDetailService {

	@Autowired
	private LibraryDetailDao libraryDetailDao;

	@Override
	public LibraryDetail query(LibraryDetail libraryDetail) {
		// TODO Auto-generated method stub
		return libraryDetailDao.query(libraryDetail);
	}

	@Override
	public void update(LibraryDetail libraryDetail) {
		// TODO Auto-generated method stub
		libraryDetailDao.update(libraryDetail);
	}

	@Override
	public List<LibraryDetail> queryList(LibraryDetail libraryDetail) {
		// TODO Auto-generated method stub
		return libraryDetailDao.queryList(libraryDetail);
	}

	@Override
	public List<LibraryDetail> queryList(LibraryDetail libraryDetail, Pager page) {
		// TODO Auto-generated method stub
		return libraryDetailDao.queryPageList(libraryDetail, page);
	}

	@Override
	public Integer count(LibraryDetail libraryDetail) {
		// TODO Auto-generated method stub
		return libraryDetailDao.count(libraryDetail);
	}

	@Override
	public void delete(LibraryDetail libraryDetail) {
		libraryDetailDao.delete(libraryDetail);
	}

	@Override
	public Integer insert(LibraryDetail libraryDetail) {
		return libraryDetailDao.insert(libraryDetail);
	}

}
