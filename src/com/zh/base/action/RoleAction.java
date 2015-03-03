package com.zh.base.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.RoleModel;
import com.zh.base.model.bean.Authorities;
import com.zh.base.model.bean.Menu;
import com.zh.base.model.bean.Role;
import com.zh.base.model.bean.RoleAuthorities;
import com.zh.base.model.bean.RoleMenu;
import com.zh.base.service.AuthoritiesService;
import com.zh.base.service.MenuService;
import com.zh.base.service.RoleService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;

public class RoleAction extends BaseAction {

	/**
	 * 角色Action
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(RoleAction.class); 
	
	private RoleModel roleModel = new RoleModel();
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private AuthoritiesService authoritiesService;

	@Override
	public Object getModel() {
		return roleModel;
	}
	
	/**
	 * 权限菜单接口，json返回格式
	 */
	public String authoritiesExecute() {
		LOGGER.debug("execute()");
		Authorities authorities = this.roleModel.getAuthorities();
		List<Authorities> authoritiesList = authoritiesService.queryList(authorities);
		this.roleModel.setAuthoritiesList(authoritiesList);
		return "authoritiesjson";
	}
	
	/**
	 * 获取菜单接口,json返回格式
	 */
	public String menuExecute() {
		LOGGER.debug("menuExecute() ");
		Menu menu = this.roleModel.getMenu();
		List<Menu> menuList = menuService.queryList(menu);
		
		List<Menu> newMenuList = new ArrayList<Menu>();
		Map<Integer, List<Menu>> map = new HashMap<Integer, List<Menu>>();
		for (Menu tempMenu : menuList) {
			Integer parentid = tempMenu.getParentid();
			if(parentid == 0){
				List<Menu> mList;
				if(map.containsKey(tempMenu.getId())){
					mList = map.get(tempMenu.getId());
				}else{
					mList = new ArrayList<Menu>();
				}
				tempMenu.setMenuList(mList);
				newMenuList.add(tempMenu);
				map.put(tempMenu.getId(), mList);
			}else{
				if(map.containsKey(parentid)){
					map.get(parentid).add(tempMenu);
				}else{
					ArrayList<Menu> mList = new ArrayList<Menu>();
					mList.add(tempMenu);
					map.put(parentid, mList);
				}
			}
		}
		this.roleModel.setMenuList(newMenuList);
		return "menujson";
	}
	
	/**
	 * 角色管理入口
	 */
	public String execute() {
		LOGGER.debug("execute() ");
		
		Role role = this.roleModel.getRole();
		Pager page = this.roleModel.getPageInfo();
		Integer count = roleService.count(role);
		page.setTotalRow(count);
		List<Role> roleList = roleService.queryList(role,page);
		this.roleModel.setRoleList(roleList);
		
		return Action.SUCCESS;
	}
	
	/***
	 * 编辑角色
	 * @return
	 */
	public String editor() {
		LOGGER.debug("editor()");
		
		Integer id = this.roleModel.getId();
		if(null == id || "".equals(id)){
			Role role = this.roleModel.getRole();
			role.setId(id);
			
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("osValue", "add");
			this.roleModel.setDataMap(dataMap );
		}else{
			Role role = this.roleModel.getRole();
			role.setId(id);
			
			Role roleRet = roleService.queryAuthoritiesToMenu(role);

			Map<String, Object> dataMap = new HashMap<String, Object>();
			//权限
			List<Authorities> authoritiesList= roleRet.getAuthoritiesList();
			String authListJson = JSONArray.fromObject(authoritiesList.toArray()).toString();
			//菜单
			List<Menu> menuList = roleRet.getMenuList();
			String menuListJson = JSONArray.fromObject(menuList.toArray()).toString();
			
			dataMap.put("osValue", "edit");
			dataMap.put("authListJson", authListJson);
			dataMap.put("menuListJson", menuListJson);
			this.roleModel.setDataMap(dataMap );
			this.roleModel.setRole(roleRet);
		}
		
		
		return Action.EDITOR;
		
	}
	
	/***
	 * 新增或者修改角色
	 * @return
	 */
	public String save() {
		LOGGER.debug("save()");
		
		Role role = this.roleModel.getRole();
		Integer id = role.getId();
		
		//判断是新增还是修改
		if(null == id || 0 == id){
			role.setCreatetime(new Date());
			roleService.insert(role);
			
			Integer newRoleId = role.getId();
			//菜单集合
			String menuListJsonValue = this.roleModel.getMenuListJsonValue();
			if(menuListJsonValue != null && !menuListJsonValue.isEmpty()){
				JSONArray menuJsonArray = JSONArray.fromObject(menuListJsonValue);
				Menu[] menus = (Menu[]) JSONArray.toArray(menuJsonArray ,Menu.class);
				
				List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>(); 
				for(Menu menu : menus){
					RoleMenu roleMenu = new RoleMenu();
					roleMenu.setRoleId(newRoleId);
					roleMenu.setMenuId(menu.getId());
					roleMenuList.add(roleMenu);
				}
				roleService.updateRoleMenu(roleMenuList);
			}
			
			//权限集合
			String authoritiesListJsonValue = this.roleModel.getAuthoritiesListJsonValue();
			if(authoritiesListJsonValue != null && !authoritiesListJsonValue.isEmpty()){
				JSONArray authJsonArray = JSONArray.fromObject(authoritiesListJsonValue);
				Authorities[] authorities = (Authorities[]) JSONArray.toArray(authJsonArray ,Authorities.class);
				
				List<RoleAuthorities> roleAuthoritiesList = new ArrayList<RoleAuthorities>();
				for(Authorities auth : authorities){
					RoleAuthorities roleAuthorities = new RoleAuthorities();
					roleAuthorities.setRoleId(newRoleId);
					roleAuthorities .setAuthoritiesId(auth.getId());
					roleAuthoritiesList.add(roleAuthorities);
				}
				roleService.updateRoleAuthorities(roleAuthoritiesList);
			}
			
		}else{
			role.setUpdatetime(new Date());
			roleService.update(role);

			//菜单集合
			String menuListJsonValue = this.roleModel.getMenuListJsonValue();
			
			JSONArray menuJsonArray = JSONArray.fromObject(menuListJsonValue);
			Menu[] menus = (Menu[]) JSONArray.toArray(menuJsonArray ,Menu.class);
			
			List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>(); 
			for(Menu menu : menus){
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setRoleId(id);
				roleMenu.setMenuId(menu.getId());
				roleMenuList.add(roleMenu);
			}
			roleService.updateRoleMenu(roleMenuList);
			
			//权限集合
			String authoritiesListJsonValue = this.roleModel.getAuthoritiesListJsonValue();
			
			JSONArray authJsonArray = JSONArray.fromObject(authoritiesListJsonValue);
			Authorities[] authorities = (Authorities[]) JSONArray.toArray(authJsonArray ,Authorities.class);
			
			List<RoleAuthorities> roleAuthoritiesList = new ArrayList<RoleAuthorities>();
			for(Authorities auth : authorities){
				RoleAuthorities roleAuthorities = new RoleAuthorities();
				roleAuthorities.setRoleId(id);
				roleAuthorities .setAuthoritiesId(auth.getId());
				roleAuthoritiesList.add(roleAuthorities);
			}
			roleService.updateRoleAuthorities(roleAuthoritiesList);
		}
		
		return Action.EDITOR_SUCCESS;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public AuthoritiesService getAuthoritiesService() {
		return authoritiesService;
	}

	public void setAuthoritiesService(AuthoritiesService authoritiesService) {
		this.authoritiesService = authoritiesService;
	}

}
