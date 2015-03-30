package com.zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.DeptDao;
import com.zh.base.model.bean.Dept;
import com.zh.base.service.DeptService;
import com.zh.core.model.Pager;

@Component("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public Dept query(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.query(dept);
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.update(dept);
	}

	@Override
	public List<Dept> queryList(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.queryList(dept);
	}

	@Override
	public List<Dept> queryList(Dept dept, Pager page) {
		// TODO Auto-generated method stub
		return deptDao.queryPageList(dept, page);
	}

	@Override
	public Integer count(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.count(dept);
	}

	@Override
	public void delete(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.delete(dept);
	}

	@Override
	public Integer insert(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.insert(dept);
	}

	public DeptDao getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

}
