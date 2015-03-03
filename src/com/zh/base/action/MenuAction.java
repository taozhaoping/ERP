package com.zh.base.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.MenuModel;
import com.zh.base.model.bean.Menu;
import com.zh.base.service.MenuService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;

public class MenuAction extends BaseAction {

	/**
	 * 角色Action
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(MenuAction.class); 
	
	private MenuModel menuModel = new MenuModel();
	
	@Autowired
	private MenuService menuService;

	@Override
	public Object getModel() {
		return menuModel;
	}
	
	/**
	 * 角色管理入口
	 */
	public String execute() {
		LOGGER.debug("execute() ");
		
		Menu menu = this.menuModel.getMenu();
		List<Menu> menuList = menuService.queryList(menu);
		this.menuModel.setMenuList(menuList);
		return Action.RETURN_JSON;
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	
}
