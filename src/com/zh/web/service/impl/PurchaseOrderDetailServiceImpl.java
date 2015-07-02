package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.IDataObject;
import com.zh.core.model.Pager;
import com.zh.web.dao.PurchaseOrderDetailDao;
import com.zh.web.model.bean.PurchaseOrderDetail;
import com.zh.web.service.PurchaseOrderDetailService;

@Component("purchaseOrderDetailService")
public class PurchaseOrderDetailServiceImpl implements
		PurchaseOrderDetailService {

	@Autowired
	private PurchaseOrderDetailDao purchaseOrderDetailDao;

	@Override
	public PurchaseOrderDetail query(PurchaseOrderDetail purchaseOrderDetail) {
		// TODO Auto-generated method stub
		return purchaseOrderDetailDao.query(purchaseOrderDetail);
	}

	@Override
	public void update(PurchaseOrderDetail purchaseOrderDetail) {
		// TODO Auto-generated method stub
		purchaseOrderDetailDao.update(purchaseOrderDetail);
	}

	@Override
	public List<PurchaseOrderDetail> queryList(
			PurchaseOrderDetail purchaseOrderDetail) {
		// TODO Auto-generated method stub
		return purchaseOrderDetailDao.queryList(purchaseOrderDetail);
	}

	@Override
	public List<PurchaseOrderDetail> queryList(
			PurchaseOrderDetail purchaseOrderDetail, Pager page) {
		// TODO Auto-generated method stub
		return purchaseOrderDetailDao.queryPageList(purchaseOrderDetail, page);
	}

	@Override
	public Integer count(PurchaseOrderDetail purchaseOrderDetail) {
		// TODO Auto-generated method stub
		return purchaseOrderDetailDao.count(purchaseOrderDetail);
	}

	@Override
	public void delete(PurchaseOrderDetail purchaseOrderDetail) {

		// 修改对应库存
		/*
		 * StockUtil stockUtil = StockUtil.getInstance();
		 * stockUtil.reduceStock(purchaseOrderDetail);
		 */
		purchaseOrderDetailDao.delete(purchaseOrderDetail);
	}

	@Override
	public Integer insert(PurchaseOrderDetail purchaseOrderDetail) {
		// 修改对应库存
		/*
		 * StockUtil stockUtil = StockUtil.getInstance();
		 * stockUtil.increaseStock(purchaseOrderDetail);
		 */
		return purchaseOrderDetailDao.insert(purchaseOrderDetail);
	}

	@Override
	public void insertList(List<IDataObject> purchaseOrderDetailList) {
		// TODO Auto-generated method stub
		for (IDataObject dataObject : purchaseOrderDetailList) {
			// 新增
			PurchaseOrderDetail purchaseOrderDetail = (PurchaseOrderDetail) dataObject;
			Integer purchaseNumber = purchaseOrderDetail.getPurchaseNumber();
			Double price = purchaseOrderDetail.getPrice();
			Double orderValue = price * purchaseNumber;
			purchaseOrderDetail.setOrderValue(orderValue);
			this.insert(purchaseOrderDetail);
		}
	}

}
