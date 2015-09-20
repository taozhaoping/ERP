package com.zh.base.model.bean;

import com.zh.core.model.IDataObject;

/**
 * 
* @Title: Warehouse.java 
* @Package com.zh.base.model.bean 
* @Description: 部门
* @date 2015年3月25日 下午7:32:36 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class Dept extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8970789225839780294L;

	private Long id;
	
	/**
	 * 名称
	 */
	private String deptName;
	
	/**
	 * 企业ID
	 */
	private Integer enterpriseID;
	
	/**
	 * 仓库类型
	 */
	private String type;
	
	/**
	 * 状态
	 */
	private Integer enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Integer getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(Integer enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}
