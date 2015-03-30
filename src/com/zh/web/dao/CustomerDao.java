package com.zh.web.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.core.base.dao.BaseDao;
import com.zh.web.model.bean.Customer;

@Component("customerDao")
public class CustomerDao extends BaseDao<Customer> {

	@Override
	@PostConstruct
	public void init() {
		this.setNamespace("M_Customer");
	}

}
