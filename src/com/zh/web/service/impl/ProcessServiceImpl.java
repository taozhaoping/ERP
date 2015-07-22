package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProcessDao;
import com.zh.web.model.bean.ProcessBean;
import com.zh.web.service.ProcessService;

@Component("processService")
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private ProcessDao processDao;
	
	@Override
	public ProcessBean query(ProcessBean process) {
		// TODO Auto-generated method stub
		return processDao.query(process);
	}

	@Override
	public void update(ProcessBean process) {
		// TODO Auto-generated method stub
		processDao.update(process);
	}

	@Override
	public List<ProcessBean> queryList(ProcessBean process) {
		// TODO Auto-generated method stub
		return processDao.queryList(process);
	}

	@Override
	public List<ProcessBean> queryList(ProcessBean process, Pager page) {
		// TODO Auto-generated method stub
		return processDao.queryPageList(process, page);
	}

	@Override
	public Integer count(ProcessBean process) {
		// TODO Auto-generated method stub
		return processDao.count(process);
	}

	@Override
	public void delete(ProcessBean process) {
		// TODO Auto-generated method stub
		processDao.delete(process);
	}

	@Override
	public Integer insert(ProcessBean process) {
		// TODO Auto-generated method stub
		return processDao.insert(process);
	}

}
