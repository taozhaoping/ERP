package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Description: 销售订单明细表中物料的结构对象
* @Title: SalesOrderBom.java 
* @Package com.zh.web.model.bean 
* @date 2015年8月25日 上午10:01:19 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class SalesOrderBom extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3177653866959734491L;

	private Integer id;
	
	/**
	 * 销售订单号
	 */
	private	Integer orderID;
	
	/**
	 * 物料ID
	 */
	private Integer productsID;
	
	/**
	 * 数量
	 */
	private Float qty;
	
	/**
	 * 是否主要产品
	 */
	private Integer isMainProducts;
	
	/**
	 * 主物料ID
	 */
	private Integer mainProductsID;
	
	/**
	 * 父料id
	 */
	private Integer parentID;
	
	private Integer tier;
	
	/**
	 * 主料(Y)/替代料(N)
	 */
	private String mainSub;
	
	/**
	 * 产品类型(自生产，采购，委外加工)
	 */
	private Integer sourceType;
	
	private String createDate;
	
	private String updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getProductsID() {
		return productsID;
	}

	public void setProductsID(Integer productsID) {
		this.productsID = productsID;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Integer getIsMainProducts() {
		return isMainProducts;
	}

	public void setIsMainProducts(Integer isMainProducts) {
		this.isMainProducts = isMainProducts;
	}

	public Integer getMainProductsID() {
		return mainProductsID;
	}

	public void setMainProductsID(Integer mainProductsID) {
		this.mainProductsID = mainProductsID;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	public String getMainSub() {
		return mainSub;
	}

	public void setMainSub(String mainSub) {
		this.mainSub = mainSub;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
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
	
	
}
