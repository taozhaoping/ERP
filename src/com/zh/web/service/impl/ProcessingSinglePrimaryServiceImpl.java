package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;
import com.zh.web.dao.ProcessingSinglePrimaryDao;
import com.zh.web.model.bean.ProcessingSinglePrimary;
import com.zh.web.service.ProcessingSinglePrimaryService;
import com.zh.web.util.UtilService;

@Component("processingSinglePrimaryService")
public class ProcessingSinglePrimaryServiceImpl implements ProcessingSinglePrimaryService {

	@Autowired
	private ProcessingSinglePrimaryDao processingSinglePrimaryDao;


	@Override
	public ProcessingSinglePrimary query(ProcessingSinglePrimary processingSinglePrimary) {
		return processingSinglePrimaryDao.query(processingSinglePrimary);
	}

	@Override
	public void update(ProcessingSinglePrimary processingSinglePrimary) {
		processingSinglePrimaryDao.update(processingSinglePrimary);
	}

	@Override
	public List<ProcessingSinglePrimary> queryList(ProcessingSinglePrimary processingSinglePrimary) {
		return processingSinglePrimaryDao.queryList(processingSinglePrimary);
	}

	@Override
	public List<ProcessingSinglePrimary> queryList(ProcessingSinglePrimary processingSinglePrimary,
			Pager page) {
		return processingSinglePrimaryDao.queryPageList(processingSinglePrimary, page);
	}

	@Override
	public Integer count(ProcessingSinglePrimary processingSinglePrimary) {
		return processingSinglePrimaryDao.count(processingSinglePrimary);
	}

	@Override
	public void delete(ProcessingSinglePrimary processingSinglePrimary) {
		processingSinglePrimaryDao.delete(processingSinglePrimary);
	}

	@Override
	public Integer insert(ProcessingSinglePrimary processingSinglePrimary, String type) {
		//TODO
		Integer id = Integer.valueOf(processingSinglePrimaryDao.getSequence(SEQUENCE_STORAGE_PRIMARY).toString());
		String dateStr = DateUtil.getToday();
		processingSinglePrimary.setId(id);
		processingSinglePrimary.setProcessingSingleId(type + dateStr + id);
		processingSinglePrimary.setStatus(UtilService.STORAGE_STATUS_ON);
		
		//TODO
		return id;
	}

}
