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

	private Long id;
	
	/**
	 * 销售订单号
	 */
	private	Long orderID;
	
	/**
	 * 物料ID
	 */
	private Long productsID;
	
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
	private Long mainProductsID;
	
	/**
	 * 父料id
	 */
	private Long parentID;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getProductsID() {
		return productsID;
	}

	public void setProductsID(Long productsID) {
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

	public Long getMainProductsID() {
		return mainProductsID;
	}

	public void setMainProductsID(Long mainProductsID) {
		this.mainProductsID = mainProductsID;
	}

	public Long getParentID() {
		return parentID;
	}

	public void setParentID(Long parentID) {
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
