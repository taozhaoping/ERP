package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.SalesOrderBom;

@Component("salesOrderBomDao")
public class SalesOrderBomDao extends BaseDao<SalesOrderBom> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_SalesOrderBom");
	}
}
