package com.zh.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.core.model.Pager;
import com.zh.web.dao.CustomerDao;
import com.zh.web.model.bean.Customer;
import com.zh.web.service.CustomerService;

@Component("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer query(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.query(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	@Override
	public List<Customer> queryList(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.queryList(customer);
	}

	@Override
	public List<Customer> queryList(Customer customer, Pager page) {
		// TODO Auto-generated method stub
		return customerDao.queryPageList(customer, page);
	}

	@Override
	public Integer count(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.count(customer);
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.delete(customer);
	}

	@Override
	public Integer insert(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.insert(customer);
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
