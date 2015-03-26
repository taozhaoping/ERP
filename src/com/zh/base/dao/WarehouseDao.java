package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.base.dao.BaseDao;

@Component("warehouseDao")
public class WarehouseDao extends BaseDao<Warehouse> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_Warehouse");
	}

}
