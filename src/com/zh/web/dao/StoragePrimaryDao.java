package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.StoragePrimary;

@Component("storagePrimaryDao")
public class StoragePrimaryDao extends BaseDao<StoragePrimary> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Storage_Primary");
	}
}
