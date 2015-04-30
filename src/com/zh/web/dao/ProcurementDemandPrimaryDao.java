package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.ProcurementDemandPrimary;

@Component("procurementDemandPrimaryDao")
public class ProcurementDemandPrimaryDao extends BaseDao<ProcurementDemandPrimary> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Procurement_Primary");
	}
}
