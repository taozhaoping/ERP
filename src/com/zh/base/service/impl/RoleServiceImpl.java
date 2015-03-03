package com.zh.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.dao.RoleDao;
import com.zh.base.dao.RoleRelationDao;
import com.zh.base.model.bean.Menu;
import com.zh.base.model.bean.Role;
import com.zh.base.model.bean.RoleAuthorities;
import com.zh.base.model.bean.RoleMenu;
import com.zh.base.service.RoleService;
import com.zh.core.model.Pager;

@Component("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RoleRelationDao roleRelationDao;
	
	@Override
	public Role query(Role role) {
		// TODO Auto-generated method stub
		return roleDao.query(role);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleDao.update(role);
	}

	@Override
	public List<Role> queryList(Role role) {
		// TODO Auto-generated method stub
		return roleDao.queryList(role);
	}

	@Override
	public List<Role> queryList(Role role, Pager page) {
		// TODO Auto-generated method stub
		return roleDao.queryPageList(role, page);
	}

	@Override
	public Integer count(Role role) {
		// TODO Auto-generated method stub
		return roleDao.count(role);
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		roleDao.delete(role);
	}

	@Override
	public void insert(Role role) {
		// TODO Auto-generated method stub
		roleDao.insert(role);
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public Role queryAuthoritiesToMenu(Role role) {
		// TODO Auto-generated method stub
		Role roleReult = roleDao.queryAuthoritiesToMenu(role);
		
		//菜单分层（树状）
		List<Menu> menuList = roleReult.getMenuList();
		List<Menu> newMenuList = new ArrayList<Menu>();
		Map<Integer, List<Menu>> map = new HashMap<Integer, List<Menu>>();
		for (Menu menu : menuList) {
			
			Integer parentid = menu.getParentid();
			if(parentid == 0)
			{
				List<Menu> mList;
				if(map.containsKey(menu.getId()))
				{
					mList = map.get(menu.getId());
				}else
				{
					mList = new ArrayList<Menu>();
				}
				menu.setMenuList(mList);
				newMenuList.add(menu);
				map.put(menu.getId(), mList);
			}else
			{
				if(map.containsKey(parentid))
				{
					map.get(parentid).add(menu);
				}else
				{
					ArrayList<Menu> mList = new ArrayList<Menu>();
					mList.add(menu);
					map.put(parentid, mList);
				}
			}
		}
		roleReult.setMenuList(newMenuList);
		return roleReult;
	}

	@Override
	public void updateRoleAuthorities(List<RoleAuthorities> roleAuthoritiesList) {
		if(roleAuthoritiesList.size() > 0){
			//删除
			roleRelationDao.deleteRoleAuthorities(roleAuthoritiesList.get(0));
			//增加
			for(RoleAuthorities roleAuthorities : roleAuthoritiesList){
				roleRelationDao.insertRoleAuthorities(roleAuthorities);
			}
		}
	}

	@Override
	public void updateRoleMenu(List<RoleMenu> roleMenuList) {
		if(roleMenuList.size() > 0){
			//删除
			roleRelationDao.deleteRoleMenu(roleMenuList.get(0));
			//增加
			for(RoleMenu roleMenu : roleMenuList){
				roleRelationDao.insertRoleMenu(roleMenu);
			}
		}
	}

}
