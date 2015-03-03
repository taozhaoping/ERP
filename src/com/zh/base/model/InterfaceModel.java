package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.User;
import com.zh.core.base.model.BaseModel;

public class InterfaceModel extends BaseModel {

	private String type;
	
	private User user = new User();
	
	private List<User> userList = new ArrayList<User>();
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
