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

	private Long  id;
	
	/**
	 * 头表ID
	 */
	private Long  purchaseOrderID;
	
	/**
	 * 产品编号
	 */
	private Long  productsID;
	
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
	private String  remarks;
	
	/**
	 * 需求清单明细ID
	 */
	private Long  procurementID;
	
	/**
	 * 产品名称
	 */
	private String productsName;
	
	/**
	 * 计量单位
	 */
	private Integer measurementCompany;
	
	/**
	 * 产品采购价格
	 */
	private Double estimatedPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(Long purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

	public Long getProductsID() {
		return productsID;
	}

	public void setProductsID(Long productsID) {
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

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getProcurementID() {
		return procurementID;
	}

	public void setProcurementID(Long procurementID) {
		this.procurementID = procurementID;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public Integer getMeasurementCompany() {
		return measurementCompany;
	}

	public void setMeasurementCompany(Integer measurementCompany) {
		this.measurementCompany = measurementCompany;
	}

	public Double getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(Double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

}
