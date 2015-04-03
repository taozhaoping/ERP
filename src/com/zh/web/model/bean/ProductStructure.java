package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Title: ProductStructure.java
 * @Package com.zh.web.model.bean
 * @Description: 产品结构清单
 * @date 2015年4月1日 下午2:32:40
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class ProductStructure extends IDataObject {

	private Integer id;

	/**
	 * 主产品id
	 */
	private Integer productsid;
	
	/**
	 * 子产品id
	 */
	private Integer subProductsid;
	
	private Products products;
	
	/**
	 * 是否主要产品
	 */
	private Integer ismainproducts;
	
	/**
	 * 组
	 */
	private Integer groupID;
	
	/**
	 * 主料/替代料
	 */
	private Integer maAlMeterials;
	
	/**
	 * 数量
	 */
	private Integer productsNumber;
	
	private String createDate;
	
	private String updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductsid() {
		return productsid;
	}

	public void setProductsid(Integer productsid) {
		this.productsid = productsid;
	}

	public Integer getIsmainproducts() {
		return ismainproducts;
	}

	public void setIsmainproducts(Integer ismainproducts) {
		this.ismainproducts = ismainproducts;
	}

	public Integer getGroupID() {
		return groupID;
	}

	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}

	public Integer getMaAlMeterials() {
		return maAlMeterials;
	}

	public void setMaAlMeterials(Integer maAlMeterials) {
		this.maAlMeterials = maAlMeterials;
	}

	public Integer getProductsNumber() {
		return productsNumber;
	}

	public void setProductsNumber(Integer productsNumber) {
		this.productsNumber = productsNumber;
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

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Integer getSubProductsid() {
		return subProductsid;
	}

	public void setSubProductsid(Integer subProductsid) {
		this.subProductsid = subProductsid;
	}

	
}
