package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Menu;
import com.zh.core.base.model.BaseModel;

public class MenuModel extends BaseModel {

	private List<Menu> menuList = new ArrayList<Menu>();
	
	private Menu menu = new Menu();

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
