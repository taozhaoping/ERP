package com.zh.web.model.bean;

import com.zh.core.base.model.StockObject;

/**
* @Title: StoragePrimary.java 
* @Package com.zh.web.model.bean 
* @Description: 入库信息表头
* @date 2015年4月9日 下午5:26:55 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class StoragePrimary extends StockObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6333019662890680692L;
	private Integer id;
	/**
	 * 入库单号
	 */
	private String orderNoID;
	
	/**
	 * 入库时间
	 */
	private String storagedate;
	
	/**
	 * 对应单据
	 */
	private String purchaseOrderID;
	
	/**
	 * 收货人
	 */
	private Integer userID;
	
	/**
	 * 仓库
	 */
	private Integer warehouseID;
	
	/**
	 * 金额
	 */
	private Float mountMeoey;
	
	/**
	 * 描述
	 */
	private String remarks;
	
	/**
	 * 发货客户
	 */
	private Integer customerID;
	
	/**
	 * 创建时间
	 */
	private String createdate;
	
	/**
	 * 修改时间
	 */
	private String updatedate;
	
	/**
	 * 入库状态
	 */
	private Integer status;
	
	/**
	 * 是否订单入库(1订单入库，0为其他入库)
	 */
	private Integer isStorage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNoID() {
		return orderNoID;
	}

	public void setOrderNoID(String orderNoID) {
		this.orderNoID = orderNoID;
	}

	public String getStoragedate() {
		return storagedate;
	}

	public void setStoragedate(String storagedate) {
		this.storagedate = storagedate;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(String purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
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

	public Float getMountMeoey() {
		return mountMeoey;
	}

	public void setMountMeoey(Float mountMeoey) {
		this.mountMeoey = mountMeoey;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsStorage() {
		return isStorage;
	}

	public void setIsStorage(Integer isStorage) {
		this.isStorage = isStorage;
	}
	
}
