package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.MaterialRequisitionDetail;

@Component("materialRequisitionDetailDao")
public class MaterialRequisitionDetailDao extends BaseDao<MaterialRequisitionDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_MaterialRequisitionDetail");
	}
	
}
