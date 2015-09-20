package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Title: SalesOrderPrimary.java
 * @Package com.zh.web.model.bean
 * @Description: 销售订单明细表
 * @date 2015年4月27日 上午11:32:24
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class SalesOrderDetail extends IDataObject {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2057884432860261616L;

	private Long id;

	/**
	 * 销售主表ID
	 */
	private Long salesOrderID;
	
	/**
	 * 物料ID
	 */
	private Long productsID;
	
	/**
	 * 产品名称
	 */
	private String productsName;
	
	/**
	 * 产品价格
	 */
	private Double salesPrice;
	
	/**
	 * 数量
	 */
	private Integer storageNumber;
	
	/**
	 * 单价
	 */
	private Double unitPrice;
	
	/**
	 * 总价
	 */
	private Double orderValue;
	
	/**
	 * 是否需要FSC
	 */
	private String FSCType;
	
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

	public Long getSalesOrderID() {
		return salesOrderID;
	}

	public void setSalesOrderID(Long salesOrderID) {
		this.salesOrderID = salesOrderID;
	}

	public Long getProductsID() {
		return productsID;
	}

	public void setProductsID(Long productsID) {
		this.productsID = productsID;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Integer getStorageNumber() {
		return storageNumber;
	}

	public void setStorageNumber(Integer storageNumber) {
		this.storageNumber = storageNumber;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public String getFSCType() {
		return FSCType;
	}

	public void setFSCType(String fSCType) {
		FSCType = fSCType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
