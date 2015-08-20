package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProcurementDemandDetailDao;
import com.zh.web.model.bean.ProcurementDemandDetail;
import com.zh.web.service.ProcurementDemandDetailService;

@Component("procurementDemandDetailService")
public class ProcurementDemandDetailServiceImpl implements ProcurementDemandDetailService {

	@Autowired
	private ProcurementDemandDetailDao procurementDemandDetailDao;

	@Override
	public ProcurementDemandDetail query(ProcurementDemandDetail procurementDemandDetail) {
		// TODO Auto-generated method stub
		return procurementDemandDetailDao.query(procurementDemandDetail);
	}

	@Override
	public void update(ProcurementDemandDetail procurementDemandDetail) {
		// TODO Auto-generated method stub
		procurementDemandDetailDao.update(procurementDemandDetail);
	}

	@Override
	public List<ProcurementDemandDetail> queryList(ProcurementDemandDetail procurementDemandDetail) {
		// TODO Auto-generated method stub
		return procurementDemandDetailDao.queryList(procurementDemandDetail);
	}
	
	public List<ProcurementDemandDetail> queryPopList(ProcurementDemandDetail procurementDemandDetail)
	{
		return procurementDemandDetailDao.queryList("", procurementDemandDetail);
	}

	@Override
	public List<ProcurementDemandDetail> queryList(ProcurementDemandDetail procurementDemandDetail, Pager page) {
		// TODO Auto-generated method stub
		return procurementDemandDetailDao.queryPageList(procurementDemandDetail, page);
	}
	
	@Override
	public Integer count(ProcurementDemandDetail procurementDemandDetail) {
		// TODO Auto-generated method stub
		return procurementDemandDetailDao.count(procurementDemandDetail);
	}

	@Override
	public void delete(ProcurementDemandDetail procurementDemandDetail) {
		procurementDemandDetailDao.delete(procurementDemandDetail);
	}

	@Override
	public Integer insert(ProcurementDemandDetail procurementDemandDetail) {
		return procurementDemandDetailDao.insert(procurementDemandDetail);
	}

	public ProcurementDemandDetailDao getProcurementDemandDetailDao() {
		return procurementDemandDetailDao;
	}

	public void setProcurementDemandDetailDao(
			ProcurementDemandDetailDao procurementDemandDetailDao) {
		this.procurementDemandDetailDao = procurementDemandDetailDao;
	}

	
}
