package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.ProcessingSingleDetailDao;
import com.zh.web.dao.ProcessingSinglePrimaryDao;
import com.zh.web.dao.SalesOrderDetailDao;
import com.zh.web.model.bean.ProcessingSingleDetail;
import com.zh.web.model.bean.ProcessingSinglePrimary;
import com.zh.web.model.bean.SalesOrderDetail;
import com.zh.web.service.ProcessingSinglePrimaryService;

@Component("processingSinglePrimaryService")
public class ProcessingSinglePrimaryServiceImpl implements ProcessingSinglePrimaryService {

	@Autowired
	private ProcessingSinglePrimaryDao processingSinglePrimaryDao;

	@Autowired
	private ProcessingSingleDetailDao processingSingleDetailDao;
	
	@Autowired
	private SalesOrderDetailDao salesOrderDetailDao;

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
	public Integer insert(ProcessingSinglePrimary processingSinglePrimary) {
		processingSinglePrimaryDao.insert(processingSinglePrimary);
		int processingSingleId = processingSinglePrimary.getId();
		//销售订单id
		int salesOrdePrimaryId = processingSinglePrimary.getPurchaseOrderId();
		SalesOrderDetail data = new SalesOrderDetail();
		data.setSalesOrderID(salesOrdePrimaryId);
		//销售中的产品
		List<SalesOrderDetail> salesOrderDetailList = salesOrderDetailDao.queryList(data);
		for(SalesOrderDetail sod : salesOrderDetailList){
			int sodId = sod.getId();
			//int sodNum = sod.getStorageNumber();
			ProcessingSingleDetail psd = new ProcessingSingleDetail();
			psd.setProcessingSingleId(processingSingleId);
			psd.setProductsId(sodId);
			processingSingleDetailDao.insert(psd);
		}
		return processingSingleId;
	}

}
