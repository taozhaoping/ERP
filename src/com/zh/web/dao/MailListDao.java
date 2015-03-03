package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.MailList;

@Component("mailListDao")
public class MailListDao extends BaseDao<MailList> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_MailList");
	}
}
