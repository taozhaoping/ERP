package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.ProductionTaskDetail;

@Component("productionTaskDetailDao")
public class ProductionTaskDetailDao extends BaseDao<ProductionTaskDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_ProductionTaskDetail");
	}
	
}
