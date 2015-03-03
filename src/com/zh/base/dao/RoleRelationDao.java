package com.zh.base.dao;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Role;
import com.zh.base.model.bean.RoleAuthorities;
import com.zh.base.model.bean.RoleMenu;
import com.zh.core.base.dao.BaseDao;

@Component("roleRelationDao")
public class RoleRelationDao extends BaseDao<Role> {

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		this.setNamespace("M_ROLERELATION");
	}
	
	/***
	 * 删除角色权限关系
	 * @param roleAuthorities
	 */
	public void deleteRoleAuthorities(RoleAuthorities roleAuthorities){
		this.getSqlSessionTemplate().delete(this.getNamespace() + "deleteRoleAuthorities", roleAuthorities);
	}
	
	/***
	 * 删除角色菜单关系
	 * @param roleMenu
	 */
	public void deleteRoleMenu(RoleMenu roleMenu){
		this.getSqlSessionTemplate().delete(this.getNamespace() + "deleteRoleMenu", roleMenu);
	}
	
	/***
	 * 插入角色权限关系
	 * @param roleAuthorities
	 */
	public void insertRoleAuthorities(RoleAuthorities roleAuthorities){
		this.getSqlSessionTemplate().insert(this.getNamespace() + "insertRoleAuthorities", roleAuthorities);
	}

	/**
	 * 插入角色菜单关系
	 * @param roleMenu
	 */
	public void insertRoleMenu(RoleMenu roleMenu){
		this.getSqlSessionTemplate().insert(this.getNamespace() + "insertRoleMenu", roleMenu);
		
	}
}
