package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.AcceptanceList;

@Component("acceptanceListDao")
public class AcceptanceListDao extends BaseDao<AcceptanceList> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_AcceptanceList");
	}
	
}
