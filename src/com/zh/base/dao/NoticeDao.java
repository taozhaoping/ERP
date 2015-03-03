package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Notice;
import com.zh.core.base.dao.BaseDao;

@Component("noticeDao")
public class NoticeDao extends BaseDao<Notice> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_NOTICE");
	}
}
