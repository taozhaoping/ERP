package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Description: 采购助理bean
 * @Title: PurchasingAssistant.java
 * @date 2015年10月13日 下午3:34:41
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class PurchasingAssistant extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -879361833483864761L;

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
	 * 入库单号
	 */
	private String orderNoID;

	/**
	 * 供应商
	 */
	private Long customerID;
	
	/**
	 * 订单状态
	 */
	private Integer status;

	/**
	 * 仓库
	 */
	private String warehouseName;

	/**
	 * 入库时间
	 */
	private String storagedate;

	/**
	 * 送货单号
	 */
	private String deliveryNumber;

	/**
	 * 入库产品
	 */
	private Long productsID;

	private String productsName;

	/**
	 * 采购数量
	 */
	private Integer purchaseNumber;

	/**
	 * 入库数量
	 */
	private Integer storageNumber;

	/**
	 * 价格
	 */
	private Double price;

	/**
	 * 总价
	 */
	private Double orderValue;

	/**
	 * 计量单位
	 */
	private String measurementCompany;
	
	private String startDate;

	private String endDate;

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

	public String getOrderNoID() {
		return orderNoID;
	}

	public void setOrderNoID(String orderNoID) {
		this.orderNoID = orderNoID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getStoragedate() {
		return storagedate;
	}

	public void setStoragedate(String storagedate) {
		this.storagedate = storagedate;
	}

	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
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

	public Integer getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(Integer purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public Integer getStorageNumber() {
		return storageNumber;
	}

	public void setStorageNumber(Integer storageNumber) {
		this.storageNumber = storageNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMeasurementCompany() {
		return measurementCompany;
	}

	public void setMeasurementCompany(String measurementCompany) {
		this.measurementCompany = measurementCompany;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

}
