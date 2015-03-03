package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Authorities;
import com.zh.core.base.model.BaseModel;

public class AuthoritiesModel extends BaseModel {

	private List<Authorities> authoritiesList = new ArrayList<Authorities>();
	
	private Authorities authorities = new Authorities();

	public List<Authorities> getAuthoritiesList() {
		return authoritiesList;
	}

	public void setAuthoritiesList(List<Authorities> authoritiesList) {
		this.authoritiesList = authoritiesList;
	}

	public Authorities getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
}
