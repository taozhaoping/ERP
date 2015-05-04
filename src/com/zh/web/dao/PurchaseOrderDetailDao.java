package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.PurchaseOrderDetail;

@Component("purchaseOrderDetailDao")
public class PurchaseOrderDetailDao extends BaseDao<PurchaseOrderDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_PurchaseOrder_Detail");
	}
}
