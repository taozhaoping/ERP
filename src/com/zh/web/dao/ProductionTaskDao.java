package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.ProductionTask;

@Component("productionTaskDao")
public class ProductionTaskDao extends BaseDao<ProductionTask> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_ProductionTask");
	}
	
}
