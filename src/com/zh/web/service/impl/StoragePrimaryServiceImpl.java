package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.StoragePrimaryDao;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.StoragePrimaryService;

@Component("storagePrimaryService")
public class StoragePrimaryServiceImpl implements StoragePrimaryService {

	@Autowired
	private StoragePrimaryDao storagePrimaryDao;
	
	@Override
	public StoragePrimary query(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		return storagePrimaryDao.query(storagePrimary);
	}

	@Override
	public void update(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		storagePrimaryDao.update(storagePrimary);
	}

	@Override
	public List<StoragePrimary> queryList(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		return storagePrimaryDao.queryList(storagePrimary);
	}

	@Override
	public List<StoragePrimary> queryList(StoragePrimary storagePrimary, Pager page) {
		// TODO Auto-generated method stub
		return storagePrimaryDao.queryPageList(storagePrimary, page);
	}

	@Override
	public Integer count(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		return storagePrimaryDao.count(storagePrimary);
	}

	@Override
	public void delete(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		storagePrimaryDao.delete(storagePrimary);
	}

	@Override
	public Integer insert(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub

		return storagePrimaryDao.insert(storagePrimary);
	}

}
