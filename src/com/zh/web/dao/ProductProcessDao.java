package com.zh.web.dao;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.ProductProcess;

@Component("productProcessDao")
public class ProductProcessDao extends BaseDao<ProductProcess> {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_ProductProcess");
	}

}
