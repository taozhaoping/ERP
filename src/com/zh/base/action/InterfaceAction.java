package com.zh.base.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.InterfaceModel;
import com.zh.base.model.bean.User;
import com.zh.base.service.UserInfoService;
import com.zh.core.base.action.BaseAction;

public class InterfaceAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(InterfaceAction.class); 

	/**
	 * 系统用户接口
	 */
	@Autowired
	private UserInfoService userInfoService;
	
	
	private InterfaceModel interfaceModel = new InterfaceModel();

	@Override
	public String execute() throws Exception {
		
		return "usersjson";

	}
	
	/**
	 * 获取用户接口,json返回格式
	 */
	public String queryUsers() {
		LOGGER.debug("queryUsers() ");
		//所有所有激活的用户
		User user = new User();
		user.setEnabled("0");
		List<User> userList = userInfoService.queryList(user);
		this.interfaceModel.setUserList(userList);
		return "usersjson";
	}
	
	
	public Object getModel() {
		return interfaceModel;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public InterfaceModel getInterfaceModel() {
		return interfaceModel;
	}

	public void setInterfaceModel(InterfaceModel interfaceModel) {
		this.interfaceModel = interfaceModel;
	}

}
