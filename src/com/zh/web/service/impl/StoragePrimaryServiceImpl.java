package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.exception.ProjectException;
import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;
import com.zh.web.dao.StoragePrimaryDao;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.StoragePrimaryService;
import com.zh.web.util.StockUtil;
import com.zh.web.util.UtilService;

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
	public Integer insert(StoragePrimary storagePrimary,String type) {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(storagePrimaryDao.getSequence(SEQUENCE_STORAGE_PRIMARY).toString());
		String dateStr = DateUtil.getToday();
		storagePrimary.setId(id);
		storagePrimary.setOrderNoID(type + dateStr + id);
		storagePrimary.setStatus(UtilService.STORAGE_STATUS_ON);
		return storagePrimaryDao.insert(storagePrimary);
	}

	@Override
	public void increaseStock(String id) {
		StoragePrimary storagePrimary = new StoragePrimary();
		storagePrimary.setId(Integer.valueOf(id));
		StoragePrimary reult = this.query(storagePrimary);
		if (null == reult)
		{
			throw new ProjectException("数据库不存在该单据");
		}
		
		if (0 == reult.getStatus())
		{
			//设置未入库状态
			storagePrimary.setStatus(1);
			this.update(storagePrimary);
			
			//单据入库
			StockUtil stockUtil = StockUtil.getInstance();
			stockUtil.operationStock(reult,StockUtil.INCREASE);
		}else
		{
			throw new ProjectException("单据号：" + reult.getOrderNoID() + "，已经入库!不允许重复入库");
		}
		
	}

}
