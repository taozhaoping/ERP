package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: PurchaseOrderDetail.java 
* @Package com.zh.web.model.bean 
* @Description: 采购订单明细
* @date 2015年5月4日 上午10:36:09 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class PurchaseOrderDetail extends IDataObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5431113151180787058L;

	private Integer  id;
	
	/**
	 * 头表ID
	 */
	private Integer  purchaseOrderID;
	
	/**
	 * 产品编号
	 */
	private Integer  productsID;
	
	/**
	 * 数量
	 */
	private Integer  purchaseNumber;
	
	/**
	 * 价格
	 */
	private Double  price;
	
	/**
	 * 总价
	 */
	private Double orderValue;
	
	/**
	 * 备注
	 */
	private Integer  remarks;
	
	/**
	 * 需求清单明细ID
	 */
	private Integer  procurementID;
	
	/**
	 * 产品名称
	 */
	private String productsName;
	
	/**
	 * 规格
	 */
	private String measurementCompany;
	
	/**
	 * 产品采购价格
	 */
	private Double estimatedPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(Integer purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

	public Integer getProductsID() {
		return productsID;
	}

	public void setProductsID(Integer productsID) {
		this.productsID = productsID;
	}

	public Integer getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(Integer purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getRemarks() {
		return remarks;
	}

	public void setRemarks(Integer remarks) {
		this.remarks = remarks;
	}

	public Integer getProcurementID() {
		return procurementID;
	}

	public void setProcurementID(Integer procurementID) {
		this.procurementID = procurementID;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public String getMeasurementCompany() {
		return measurementCompany;
	}

	public void setMeasurementCompany(String measurementCompany) {
		this.measurementCompany = measurementCompany;
	}

	public Double getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(Double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

}
