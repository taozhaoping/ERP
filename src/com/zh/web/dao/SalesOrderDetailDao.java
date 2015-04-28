package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.SalesOrderDetail;

@Component("salesOrderDetailDao")
public class SalesOrderDetailDao extends BaseDao<SalesOrderDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Sales_Order_Detail");
	}
}
