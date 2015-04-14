package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.StorageDetail;

@Component("storageDetailDao")
public class StorageDetailDao extends BaseDao<StorageDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Storage_Detail");
	}
}
