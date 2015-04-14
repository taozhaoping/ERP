package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.BOMPrimary;

@Component("productStructureDao")
public class ProductStructureDao extends BaseDao<BOMPrimary> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_ProductStructure");
	}
}
