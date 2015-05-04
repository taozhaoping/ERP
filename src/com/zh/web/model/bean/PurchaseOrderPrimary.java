package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: PurchaseOrderPrimary.java 
* @Package com.zh.web.model.bean 
* @Description: 采购订单头表
* @date 2015年5月4日 上午10:35:31 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class PurchaseOrderPrimary extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7602391432738599635L;
	
	private Integer id;
	
	/**
	 * 订单号
	 */
	private String purchaseOrderID;
	
	/**
	 * 订单日期
	 */
	private String purchaseDate;
	
	/**
	 * 到货日期
	 */
	private String arrivalDate;
	
	/**
	 * 供应商
	 */
	private Integer customerID;
	
	/**
	 * 采购员
	 */
	private Integer userID;
	
	/**
	 * 仓库
	 */
	private Integer warehouseID;
	
	/**
	 * 备注
	 */
	private String remarks;
	
	/**
	 * 创建日期
	 */
	private String createDate;
	
	/**
	 * 修改日期
	 */
	private String updateDate;
	
	/**
	 * 状态
	 */
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(String purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Integer warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
}
