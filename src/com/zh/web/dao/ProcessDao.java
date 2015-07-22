package com.zh.web.dao;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.ProcessBean;

@Component("processDao")
public class ProcessDao extends BaseDao<ProcessBean> {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_Process");
	}

}
