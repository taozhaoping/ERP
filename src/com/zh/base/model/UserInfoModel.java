package com.zh.base.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zh.base.model.bean.User;
import com.zh.core.base.model.BaseModel;

public class UserInfoModel extends BaseModel {

	private User userInfo = new User();
	
	private List<User> userList = new ArrayList<User>();
	
	private String newPassWord;
	
	
	private String reultObject;
	
	private String view;
	
	//删除条件
	private String jsonIDString;
	
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	
	private String loginName;

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	public String getReultObject() {
		return reultObject;
	}

	public void setReultObject(String reultObject) {
		this.reultObject = reultObject;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getJsonIDString() {
		return jsonIDString;
	}

	public void setJsonIDString(String jsonIDString) {
		this.jsonIDString = jsonIDString;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

}
