package com.zh.core.base.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zh.base.model.bean.Dictionary;
import com.zh.base.model.bean.Enterprise;
import com.zh.base.model.bean.User;
import com.zh.core.model.Pager;

/**
 * model模型
 * @author 陶照平
 *  email : taozhaoping@gmail.com
 */
public class BaseModel {

	private Pager pageInfo = new Pager();
	
	/**
	 * 删除条件
	 */
	private String jsonIDString;
	
	private Long id;
	
	private String spaceId;
	
	private String menuId;
	
	private String menu2Id;
	
	private String token;
	
	/**
	 * 是否启用或者停用
	 */
	private String enabled;
	
	/**
	 * 页面视图
	 */
	private String view;
	
	/**
	 * 需要展示的tab页面
	 */
	private String tabID;
	
	/**
	 * 基础数据
	 */
	private List<Dictionary> dictionaryList;
	
	/**
	 * 企业列表
	 */
	private List<Enterprise> enterpriseList;
	
	/**
	 * 返回界面列表使用
	 */
	private Map<String, Object> dataMap = new HashMap<String, Object>();

	/**
	 * 查询和修改返回的json对象
	 */
	private String reultObject;
	
	/**
	 * 表单的编号 
	 */
	private String formId;
	
	/**
	 * 传入的json格式列表
	 */
	private String jsonList;

	/**
	 * 所有的用户集合
	 */
	private List<User> userList;
	
	public Pager getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(Pager pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getJsonIDString() {
		return jsonIDString;
	}

	public void setJsonIDString(String jsonIDString) {
		this.jsonIDString = jsonIDString;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenu2Id() {
		return menu2Id;
	}

	public void setMenu2Id(String menu2Id) {
		this.menu2Id = menu2Id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getTabID() {
		return tabID;
	}

	public void setTabID(String tabID) {
		this.tabID = tabID;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getReultObject() {
		return reultObject;
	}

	public void setReultObject(String reultObject) {
		this.reultObject = reultObject;
	}

	public String getJsonList() {
		return jsonList;
	}

	public void setJsonList(String jsonList) {
		this.jsonList = jsonList;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Dictionary> getDictionaryList() {
		return dictionaryList;
	}

	public void setDictionaryList(List<Dictionary> dictionaryList) {
		this.dictionaryList = dictionaryList;
	}

	public List<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}

	public void setEnterpriseList(List<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}
	
}
