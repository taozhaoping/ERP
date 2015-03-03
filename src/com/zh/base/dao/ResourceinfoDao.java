package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Resourceinfo;
import com.zh.core.base.dao.BaseDao;

@Component("resourceinfoDao")
public class ResourceinfoDao extends BaseDao<Resourceinfo> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_Resourceinfo");
	}

}
