package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.LibraryDetail;

@Component("libraryDetailDao")
public class LibraryDetailDao extends BaseDao<LibraryDetail> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Library_Detail");
	}
}
