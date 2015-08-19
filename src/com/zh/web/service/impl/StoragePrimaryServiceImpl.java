package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.exception.ProjectException;
import com.zh.core.model.Pager;
import com.zh.core.util.DateUtil;
import com.zh.web.dao.StoragePrimaryDao;
import com.zh.web.model.bean.PurchaseOrderDetail;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.model.bean.StorageDetail;
import com.zh.web.model.bean.StoragePrimary;
import com.zh.web.service.PurchaseOrderDetailService;
import com.zh.web.service.PurchaseOrderPrimaryService;
import com.zh.web.service.StorageDetailService;
import com.zh.web.service.StoragePrimaryService;
import com.zh.web.util.StockUtil;
import com.zh.web.util.UtilService;

@Component("storagePrimaryService")
public class StoragePrimaryServiceImpl implements StoragePrimaryService {

	@Autowired
	private StoragePrimaryDao storagePrimaryDao;

	@Autowired
	private PurchaseOrderPrimaryService purchaseOrderPrimaryService;

	@Autowired
	private PurchaseOrderDetailService purchaseOrderDetailService;

	@Autowired
	private StorageDetailService storageDetailService;

	@Override
	public StoragePrimary query(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		return storagePrimaryDao.query(storagePrimary);
	}

	@Override
	public void update(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		storagePrimaryDao.update(storagePrimary);
	}

	@Override
	public List<StoragePrimary> queryList(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		return storagePrimaryDao.queryList(storagePrimary);
	}

	@Override
	public List<StoragePrimary> queryList(StoragePrimary storagePrimary,
			Pager page) {
		// TODO Auto-generated method stub
		return storagePrimaryDao.queryPageList(storagePrimary, page);
	}

	@Override
	public Integer count(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		return storagePrimaryDao.count(storagePrimary);
	}

	@Override
	public void delete(StoragePrimary storagePrimary) {
		// TODO Auto-generated method stub
		storagePrimaryDao.delete(storagePrimary);
	}

	@Override
	public Integer insert(StoragePrimary storagePrimary, String type) {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(storagePrimaryDao.getSequence(
				SEQUENCE_STORAGE_PRIMARY).toString());
		String dateStr = DateUtil.getToday();
		storagePrimary.setId(id);
		storagePrimary.setOrderNoID(type + dateStr + id);
		storagePrimary.setStatus(UtilService.STORAGE_STATUS_ON);

		// 判断是否有采购订单号
		if (storagePrimary.getPurchaseOrderID() != null
				|| storagePrimary.getPurchaseOrderID() != "") {
			// 获取采购订单信息
			PurchaseOrderPrimary purchaseOrderPrimary = new PurchaseOrderPrimary();
			purchaseOrderPrimary.setPurchaseOrderID(storagePrimary
					.getPurchaseOrderID());
			purchaseOrderPrimary
					.setStatus(UtilService.PURCHASEORDERPRIMARY_STATUS_OPEN);
			PurchaseOrderPrimary purchaseOrderReult = purchaseOrderPrimaryService
					.query(purchaseOrderPrimary);

			// 获取采购订单信息设置到订单入库头表
			storagePrimary.setCustomerID(purchaseOrderReult.getCustomerID());

			int count = storagePrimaryDao.insert(storagePrimary);
			if (count > 0) {

				// 修改采购订单的状态为入库审核
				purchaseOrderReult
						.setStatus(UtilService.PURCHASEORDERPRIMARY_STATUS_EXAMINE);
				purchaseOrderPrimaryService.update(purchaseOrderReult);

				// 获取采购订单明细，保存入采购订单明细
				PurchaseOrderDetail purchaseDetail = new PurchaseOrderDetail();
				purchaseDetail.setPurchaseOrderID(purchaseOrderReult.getId());
				List<PurchaseOrderDetail> purchaseOrderDetailList = purchaseOrderDetailService
						.queryList(purchaseDetail);
				for (PurchaseOrderDetail purchaseOrderDetail : purchaseOrderDetailList) {
					StorageDetail storageDetail = new StorageDetail();
					storageDetail.setStoragePrimaryID(storagePrimary.getId());
					storageDetail.setProductsID(purchaseOrderDetail
							.getProductsID());
					storageDetail.setStorageNumber(purchaseOrderDetail
							.getPurchaseNumber());
					storageDetail.setRemarks(purchaseOrderDetail.getRemarks());
					storageDetail.setProductsName(purchaseOrderDetail
							.getProductsName());
					storageDetailService.insert(storageDetail);
				}
			}
			return count;
		} else {
			return storagePrimaryDao.insert(storagePrimary);
		}
	}

	@Override
	public void increaseStock(String id) {
		StoragePrimary storagePrimary = new StoragePrimary();
		storagePrimary.setId(Integer.valueOf(id));
		StoragePrimary reult = this.query(storagePrimary);
		if (null == reult) {
			throw new ProjectException("数据库不存在该单据");
		}

		if (0 == reult.getStatus()) {
			// 设置入库状态
			storagePrimary.setStatus(1);
			this.update(storagePrimary);

			// 单据入库
			StockUtil stockUtil = StockUtil.getInstance();
			stockUtil.operationStock(reult, StockUtil.INCREASE);

			// 当存在订单号的时候,更改采购单状态
			String storageID = reult.getPurchaseOrderID();
			if (storageID != null && !storageID.equals("")) {
				PurchaseOrderPrimary purchaseOrderPrimary = new PurchaseOrderPrimary();
				purchaseOrderPrimary.setPurchaseOrderID(storageID);
				PurchaseOrderPrimary purchReult = purchaseOrderPrimaryService.query(purchaseOrderPrimary);
				purchaseOrderPrimary.setId(purchReult.getId());
				purchaseOrderPrimary
						.setStatus(UtilService.PURCHASEORDERPRIMARY_STATUS_END);
				purchaseOrderPrimaryService.update(purchaseOrderPrimary);
			}
		} else {
			throw new ProjectException("单据号：" + reult.getOrderNoID()
					+ "，已经入库!不允许重复入库");
		}

	}

}
