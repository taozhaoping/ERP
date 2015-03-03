package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Enterprise;
import com.zh.core.base.model.BaseModel;

public class EnterpriseModel extends BaseModel {

	private List<Enterprise> enterpriseList = new ArrayList<Enterprise>();
	
	private Enterprise enterprise = new Enterprise();

	public List<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}

	public void setEnterpriseList(List<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	
}
