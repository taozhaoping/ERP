package com.zh.web.model.bean;

import com.zh.core.base.model.BaseModel;

/***
* @Description: 库存变更明细表
* @Title: InventoryCountDetail.java 
* @Package com.zh.web.model.bean 
* @date 2015年7月16日 下午8:05:10 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class InventoryCountDetail extends BaseModel {

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 头表ID
	 */
	private Integer inventoryID;

	/**
	 * 物料编号
	 */
	private Integer productsID;

	/**
	 * 库存编号
	 */
	private Integer warehouseID;

	/**
	 * 变更前数量
	 */
	private Integer originalQuantiy;

	/**
	 * 变更后数量
	 */
	private Integer changeQuantiy;

	/***
	 * 创建时间
	 */
	private String createDate;

	/***
	 * 创建用户
	 */
	private Integer userID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(Integer inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Integer getProductsID() {
		return productsID;
	}

	public void setProductsID(Integer productsID) {
		this.productsID = productsID;
	}

	public Integer getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Integer warehouseID) {
		this.warehouseID = warehouseID;
	}

	public Integer getOriginalQuantiy() {
		return originalQuantiy;
	}

	public void setOriginalQuantiy(Integer originalQuantiy) {
		this.originalQuantiy = originalQuantiy;
	}

	public Integer getChangeQuantiy() {
		return changeQuantiy;
	}

	public void setChangeQuantiy(Integer changeQuantiy) {
		this.changeQuantiy = changeQuantiy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

}
