package com.zh.base.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.AuthoritiesModel;
import com.zh.base.model.bean.Authorities;
import com.zh.base.service.AuthoritiesService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;

public class AuthoritiesAction extends BaseAction {

	/**
	 * 角色Action
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(AuthoritiesAction.class); 
	
	private AuthoritiesModel authoritiesModel = new AuthoritiesModel();
	
	@Autowired
	private AuthoritiesService authoritiesService;

	@Override
	public Object getModel() {
		return authoritiesModel;
	}
	
	/**
	 * 角色管理入口
	 */
	public String execute() {
		LOGGER.debug("execute()");
		Authorities authorities = this.authoritiesModel.getAuthorities();
		List<Authorities> authoritiesList = authoritiesService.queryList(authorities);
		this.authoritiesModel.setAuthoritiesList(authoritiesList);
		return Action.RETURN_JSON;
	}

	public AuthoritiesModel getAuthoritiesModel() {
		return authoritiesModel;
	}

	public void setAuthoritiesModel(AuthoritiesModel authoritiesModel) {
		this.authoritiesModel = authoritiesModel;
	}

	public AuthoritiesService getAuthoritiesService() {
		return authoritiesService;
	}

	public void setAuthoritiesService(AuthoritiesService authoritiesService) {
		this.authoritiesService = authoritiesService;
	}
	
	
}
