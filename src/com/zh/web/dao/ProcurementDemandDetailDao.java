package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.ProcurementDemandDetail;

@Component("procurementDemandDetailDao")
public class ProcurementDemandDetailDao extends BaseDao<ProcurementDemandDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Procurement_Detail");
	}
}
