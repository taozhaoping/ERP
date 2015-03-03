package com.zh.base.dao;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Enterprise;
import com.zh.core.base.dao.BaseDao;

@Component("enterpriseDao")
public class EnterpriseDao extends BaseDao<Enterprise> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_Enterprise");
	}

}
