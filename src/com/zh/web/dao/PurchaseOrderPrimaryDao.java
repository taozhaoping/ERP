package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.PurchaseOrderPrimary;

@Component("purchaseOrderPrimaryDao")
public class PurchaseOrderPrimaryDao extends BaseDao<PurchaseOrderPrimary> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_purchaseOrder_Primary");
	}
}
