package com.zh.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.MenuDao;
import com.zh.base.model.bean.Menu;
import com.zh.base.service.MenuService;
import com.zh.core.model.Pager;

@Component("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public Menu query(Menu object) {
		// TODO Auto-generated method stub
		return menuDao.query(object);
	}

	@Override
	public void update(Menu object) {
		// TODO Auto-generated method stub
		menuDao.update(object);
	}

	@Override
	public List<Menu> queryList(Menu object, Pager page) {
		// TODO Auto-generated method stub
		return menuDao.queryPageList(object, page);
	}

	@Override
	public Integer count(Menu object) {
		// TODO Auto-generated method stub
		return menuDao.count(object);
	}

	@Override
	public void delete(Menu object) {
		// TODO Auto-generated method stub
		menuDao.delete(object);
	}

	@Override
	public void insert(Menu object) {
		// TODO Auto-generated method stub
		menuDao.insert(object);
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> queryList(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.queryList(menu);
	}

	
}
