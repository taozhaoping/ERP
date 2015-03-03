package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Authorities;
import com.zh.base.model.bean.Menu;
import com.zh.base.model.bean.Role;
import com.zh.core.base.model.BaseModel;

public class RoleModel extends BaseModel {

	private List<Role> roleList = new ArrayList<Role>();
	
	private Role role = new Role();

	private Menu menu = new Menu();
	
	private List<Menu> menuList = new ArrayList<Menu>();
	
	private Authorities authorities = new Authorities();
	
	private List<Authorities> authoritiesList = new ArrayList<Authorities>();
	
	
	private String authoritiesListJsonValue;
	
	private String menuListJsonValue;

	public String getAuthoritiesListJsonValue() {
		return authoritiesListJsonValue;
	}

	public void setAuthoritiesListJsonValue(String authoritiesListJsonValue) {
		this.authoritiesListJsonValue = authoritiesListJsonValue;
	}

	public String getMenuListJsonValue() {
		return menuListJsonValue;
	}

	public void setMenuListJsonValue(String menuListJsonValue) {
		this.menuListJsonValue = menuListJsonValue;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Authorities getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}

	public List<Authorities> getAuthoritiesList() {
		return authoritiesList;
	}

	public void setAuthoritiesList(List<Authorities> authoritiesList) {
		this.authoritiesList = authoritiesList;
	}
	
}
