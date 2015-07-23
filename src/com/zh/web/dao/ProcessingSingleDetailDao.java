package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.ProcessingSingleDetail;

@Component("processingSingleDetailDao")
public class ProcessingSingleDetailDao extends BaseDao<ProcessingSingleDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_ProcessingSingle_Detail");
	}
}
