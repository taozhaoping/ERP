package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.AcceptanceListDao;
import com.zh.web.model.bean.AcceptanceList;
import com.zh.web.model.bean.Customer;
import com.zh.web.service.AcceptanceListService;

@Component("acceptanceListService")
public class AcceptanceListServiceImpl implements AcceptanceListService {

	@Autowired
	private AcceptanceListDao acceptanceListDao;
	
	@Override
	public AcceptanceList query(AcceptanceList acceptanceList) {
		// TODO Auto-generated method stub
		return acceptanceListDao.query(acceptanceList);
	}

	@Override
	public List<AcceptanceList> queryList(AcceptanceList acceptanceList) {
		// TODO Auto-generated method stub
		return acceptanceListDao.queryList(acceptanceList);
	}

	@Override
	public List<AcceptanceList> queryList(AcceptanceList acceptanceList,
			Pager page) {
		// TODO Auto-generated method stub
		return acceptanceListDao.queryPageList(acceptanceList, page);
	}

	@Override
	public Integer count(AcceptanceList acceptanceList) {
		// TODO Auto-generated method stub
		return acceptanceListDao.count(acceptanceList);
	}

	@Override
	public void update(AcceptanceList acceptanceList) {
		acceptanceListDao.update(acceptanceList);		
	}

}
