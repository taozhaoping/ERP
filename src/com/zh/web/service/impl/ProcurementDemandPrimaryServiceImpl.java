package com.zh.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zh.core.model.Pager;
import com.zh.web.dao.ProcurementDemandPrimaryDao;
import com.zh.web.model.bean.ProcurementDemandPrimary;
import com.zh.web.service.ProcurementDemandPrimaryService;

@Component("procurementDemandPrimaryService")
public class ProcurementDemandPrimaryServiceImpl implements ProcurementDemandPrimaryService {

	@Autowired
	private ProcurementDemandPrimaryDao procurementDemandPrimaryDao;
	
	@Override
	public ProcurementDemandPrimary query(ProcurementDemandPrimary procurementDemandPrimary) {
		// TODO Auto-generated method stub
		return procurementDemandPrimaryDao.query(procurementDemandPrimary);
	}

	@Override
	public void update(ProcurementDemandPrimary procurementDemandPrimary) {
		// TODO Auto-generated method stub
		procurementDemandPrimaryDao.update(procurementDemandPrimary);
	}

	@Override
	public List<ProcurementDemandPrimary> queryList(ProcurementDemandPrimary procurementDemandPrimary) {
		// TODO Auto-generated method stub
		return procurementDemandPrimaryDao.queryList(procurementDemandPrimary);
	}

	@Override
	public List<ProcurementDemandPrimary> queryList(ProcurementDemandPrimary procurementDemandPrimary, Pager page) {
		// TODO Auto-generated method stub
		return procurementDemandPrimaryDao.queryPageList(procurementDemandPrimary, page);
	}

	@Override
	public Integer count(ProcurementDemandPrimary procurementDemandPrimary) {
		// TODO Auto-generated method stub
		return procurementDemandPrimaryDao.count(procurementDemandPrimary);
	}

	@Override
	public void delete(ProcurementDemandPrimary procurementDemandPrimary) {
		// TODO Auto-generated method stub
		procurementDemandPrimaryDao.delete(procurementDemandPrimary);
	}

	@Override
	public Integer insert(ProcurementDemandPrimary procurementDemandPrimary) {
		// TODO Auto-generated method stub
		return procurementDemandPrimaryDao.insert(procurementDemandPrimary);
	}

	public ProcurementDemandPrimaryDao getProcurementDemandPrimaryDao() {
		return procurementDemandPrimaryDao;
	}

	public void setProcurementDemandPrimaryDao(
			ProcurementDemandPrimaryDao procurementDemandPrimaryDao) {
		this.procurementDemandPrimaryDao = procurementDemandPrimaryDao;
	}

}
