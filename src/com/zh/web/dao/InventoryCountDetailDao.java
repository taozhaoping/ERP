package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.InventoryCountDetail;

@Component("inventoryCountDetailDao")
public class InventoryCountDetailDao extends BaseDao<InventoryCountDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Inventory_Detail");
	}
}
