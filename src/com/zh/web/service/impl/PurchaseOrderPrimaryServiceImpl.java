package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;
import com.zh.web.dao.PurchaseOrderPrimaryDao;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.service.PurchaseOrderPrimaryService;
import com.zh.web.util.UtilService;

@Component("purchaseOrderPrimaryService")
public class PurchaseOrderPrimaryServiceImpl implements PurchaseOrderPrimaryService {

	@Autowired
	private PurchaseOrderPrimaryDao purchaseOrderPrimaryDao;
	
	@Override
	public PurchaseOrderPrimary query(PurchaseOrderPrimary purchaseOrderPrimary) {
		// TODO Auto-generated method stub
		return purchaseOrderPrimaryDao.query(purchaseOrderPrimary);
	}

	@Override
	public void update(PurchaseOrderPrimary purchaseOrderPrimary) {
		// TODO Auto-generated method stub
		
		purchaseOrderPrimaryDao.update(purchaseOrderPrimary);
	}

	@Override
	public List<PurchaseOrderPrimary> queryList(PurchaseOrderPrimary purchaseOrderPrimary) {
		// TODO Auto-generated method stub
		return purchaseOrderPrimaryDao.queryList(purchaseOrderPrimary);
	}

	@Override
	public List<PurchaseOrderPrimary> queryList(PurchaseOrderPrimary purchaseOrderPrimary, Pager page) {
		// TODO Auto-generated method stub
		return purchaseOrderPrimaryDao.queryPageList(purchaseOrderPrimary, page);
	}

	@Override
	public Integer count(PurchaseOrderPrimary purchaseOrderPrimary) {
		// TODO Auto-generated method stub
		return purchaseOrderPrimaryDao.count(purchaseOrderPrimary);
	}

	@Override
	public void delete(PurchaseOrderPrimary purchaseOrderPrimary) {
		// TODO Auto-generated method stub
		purchaseOrderPrimaryDao.delete(purchaseOrderPrimary);
	}

	@Override
	public Integer insert(PurchaseOrderPrimary purchaseOrderPrimary) {
		Long id = Long.valueOf(purchaseOrderPrimaryDao.getSequence(SEQUENCE_PURCHASE_PRIMARY).toString());
		String dateStr = DateUtil.getToday();
		purchaseOrderPrimary.setId(id);
		purchaseOrderPrimary.setPurchaseOrderID(UtilService.PURCHASE_ORDER_TYPE + dateStr + id);
		purchaseOrderPrimary.setStatus(UtilService.SALES_ORDER_ONE);
		return purchaseOrderPrimaryDao.insert(purchaseOrderPrimary);
	}

	public PurchaseOrderPrimaryDao getPurchaseOrderPrimaryDao() {
		return purchaseOrderPrimaryDao;
	}

	public void setPurchaseOrderPrimaryDao(
			PurchaseOrderPrimaryDao purchaseOrderPrimaryDao) {
		this.purchaseOrderPrimaryDao = purchaseOrderPrimaryDao;
	}

}
