package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.InventoryCountPrimary;

@Component("inventoryCountPrimaryDao")
public class InventoryCountPrimaryDao extends BaseDao<InventoryCountPrimary> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Inventory_Primary");
	}
}
