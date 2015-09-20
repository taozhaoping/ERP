package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: ProcurementDemandPrimary.java 
* @Package com.zh.web.model.bean 
* @Description: 采购需求清单头表
* @date 2015年4月30日 上午9:51:41 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class ProcurementDemandPrimary extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7949566103367164628L;

	private Long id;
	
	/**
	 * 申请时间
	 */
	private String createDate;
	
	/**
	 * 期限
	 */
	private String limitDate;
	
	/**
	 * 创建人
	 */
	private Long userID;
	
	/**
	 * 销售订单号
	 */
	private String orderID;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 备注
	 */
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
