package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.exception.ProjectException;
import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;
import com.zh.web.dao.LibraryPrimaryDao;
import com.zh.web.model.bean.LibraryPrimary;
import com.zh.web.service.LibraryPrimaryService;
import com.zh.web.util.StockUtil;
import com.zh.web.util.UtilService;

@Component("libraryPrimaryService")
public class LibraryPrimaryServiceImpl implements LibraryPrimaryService {

	@Autowired
	private LibraryPrimaryDao libraryPrimaryDao;
	
	@Override
	public LibraryPrimary query(LibraryPrimary libraryPrimary) {
		// TODO Auto-generated method stub
		return libraryPrimaryDao.query(libraryPrimary);
	}

	@Override
	public void update(LibraryPrimary libraryPrimary) {
		// TODO Auto-generated method stub
		libraryPrimaryDao.update(libraryPrimary);
	}

	@Override
	public List<LibraryPrimary> queryList(LibraryPrimary libraryPrimary) {
		// TODO Auto-generated method stub
		return libraryPrimaryDao.queryList(libraryPrimary);
	}

	@Override
	public List<LibraryPrimary> queryList(LibraryPrimary libraryPrimary, Pager page) {
		// TODO Auto-generated method stub
		return libraryPrimaryDao.queryPageList(libraryPrimary, page);
	}

	@Override
	public Integer count(LibraryPrimary libraryPrimary) {
		// TODO Auto-generated method stub
		return libraryPrimaryDao.count(libraryPrimary);
	}

	@Override
	public void delete(LibraryPrimary libraryPrimary) {
		// TODO Auto-generated method stub
		libraryPrimaryDao.delete(libraryPrimary);
	}

	@Override
	public Integer insert(LibraryPrimary libraryPrimary,String type) {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(libraryPrimaryDao.getSequence(SEQUENCE_LIBRARY_PRIMARY).toString());
		String dateStr = DateUtil.getToday();
		libraryPrimary.setId(id);
		libraryPrimary.setOrderNoID(type + dateStr + id);
		libraryPrimary.setStatus(UtilService.STORAGE_STATUS_ON);
		return libraryPrimaryDao.insert(libraryPrimary);
	}

	@Override
	public void increaseStock(String id) {
		LibraryPrimary libraryPrimary = new LibraryPrimary();
		libraryPrimary.setId(Integer.valueOf(id));
		LibraryPrimary reult = this.query(libraryPrimary);
		if (null == reult)
		{
			throw new ProjectException("数据库不存在该单据");
		}
		
		if (0 == reult.getStatus())
		{
			//设置入库状态
			libraryPrimary.setStatus(1);
			this.update(libraryPrimary);
			
			//单据入库
			StockUtil stockUtil = StockUtil.getInstance();
			stockUtil.operationStock(reult,StockUtil.REDUCE);
		}else
		{
			throw new ProjectException("单据号：" + reult.getOrderNoID() + "，已经入库!不允许重复入库");
		}
		
	}

}
