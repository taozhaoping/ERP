package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Role;
import com.zh.base.model.bean.RoleAuthorities;
import com.zh.base.model.bean.RoleMenu;
import com.zh.core.model.Pager;

public interface RoleService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Role query(Role role);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Role role);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Role> queryList(Role role);
	
	/**
	 * 查询角色信息，并带出相应的菜单信息和权限信息
	 * @param role id不允许为空
	 * @return
	 */
	public Role queryAuthoritiesToMenu(Role role);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Role> queryList(Role role , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Role role);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Role role);
	
	/**
	 * 新增
	 * @param 
	 */
	public void insert(Role role);
	
	/***
	 * 更新角色权限关系
	 * @param roleAuthorities
	 */
	public void updateRoleAuthorities(List<RoleAuthorities> roleAuthoritiesList);
	
	/**
	 * 更新角色菜单关系
	 * @param roleMenu
	 */
	public void updateRoleMenu(List<RoleMenu> roleMenuList);
}
