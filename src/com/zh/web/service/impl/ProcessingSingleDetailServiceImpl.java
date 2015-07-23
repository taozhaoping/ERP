package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProcessingSingleDetailDao;
import com.zh.web.model.bean.ProcessingSingleDetail;
import com.zh.web.service.ProcessingSingleDetailService;

@Component("processingSingleDetailService")
@Scope("singleton")
public class ProcessingSingleDetailServiceImpl implements ProcessingSingleDetailService {

	@Autowired
	private ProcessingSingleDetailDao processingSingleDetailDao;

	@Override
	public ProcessingSingleDetail query(ProcessingSingleDetail processingSingleDetail) {
		return processingSingleDetailDao.query(processingSingleDetail);
	}

	@Override
	public void update(ProcessingSingleDetail processingSingleDetail) {
		processingSingleDetailDao.update(processingSingleDetail);
	}

	@Override
	public List<ProcessingSingleDetail> queryList(ProcessingSingleDetail processingSingleDetail) {
		return processingSingleDetailDao.queryList(processingSingleDetail);
	}

	@Override
	public List<ProcessingSingleDetail> queryList(ProcessingSingleDetail processingSingleDetail, Pager page) {
		return processingSingleDetailDao.queryPageList(processingSingleDetail, page);
	}

	@Override
	public Integer count(ProcessingSingleDetail processingSingleDetail) {
		return processingSingleDetailDao.count(processingSingleDetail);
	}

	@Override
	public void delete(ProcessingSingleDetail processingSingleDetail) {
		processingSingleDetailDao.delete(processingSingleDetail);
	}

	@Override
	public Integer insert(ProcessingSingleDetail processingSingleDetail) {
		return processingSingleDetailDao.insert(processingSingleDetail);
	}

}
