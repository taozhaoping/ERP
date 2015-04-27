package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.SalesOrderPrimary;

@Component("salesOrderPrimaryDao")
public class SalesOrderPrimaryDao extends BaseDao<SalesOrderPrimary> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Sales_Order_Primary");
	}
}
