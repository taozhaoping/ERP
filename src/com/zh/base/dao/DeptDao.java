package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Dept;
import com.zh.core.base.dao.BaseDao;

@Component("deptDao")
public class DeptDao extends BaseDao<Dept> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_Dept");
	}

}
