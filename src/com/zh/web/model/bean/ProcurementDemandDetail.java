package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: ProcurementDemandDetail.java 
* @Package com.zh.web.model.bean 
* @Description: 采购需求清单明细表
* @date 2015年4月30日 上午9:51:59 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class ProcurementDemandDetail extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2646268575260258392L;

	private Integer id;
	
	/**
	 * 头表ID
	 */
	private Integer procurementID;
	
	/**
	 * 产品编号
	 */
	private Integer productsID;
	
	/**
	 * 产品名称
	 */
	private String productsName;
	
	/**
	 * 计量单位
	 */
	private Integer measurementCompany;
	
	/**
	 * 是否主要产品
	 */
	private Integer isMainProducts;
	
	/**
	 * 数量
	 */
	private Integer demandNumber;
	
	/**
	 * 预估价
	 */
	private Integer estimatedPrice;
	
	/**
	 * 下单数
	 */
	private Integer placeOrderNumber;
	
	private Integer notPlaceOrderNumber;
	
	/**
	 * 入库数
	 */
	private Integer storageNumber;
	
	/**
	 * 备注
	 */
	private String remarks;
	
	/**
	 * 销售单号
	 */
	private String orderID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProcurementID() {
		return procurementID;
	}

	public void setProcurementID(Integer procurementID) {
		this.procurementID = procurementID;
	}

	public Integer getProductsID() {
		return productsID;
	}

	public void setProductsID(Integer productsID) {
		this.productsID = productsID;
	}

	public Integer getDemandNumber() {
		return demandNumber;
	}

	public void setDemandNumber(Integer demandNumber) {
		this.demandNumber = demandNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Integer getPlaceOrderNumber() {
		return placeOrderNumber;
	}

	public void setPlaceOrderNumber(Integer placeOrderNumber) {
		this.placeOrderNumber = placeOrderNumber;
	}

	public Integer getStorageNumber() {
		return storageNumber;
	}

	public void setStorageNumber(Integer storageNumber) {
		this.storageNumber = storageNumber;
	}

	public Integer getIsMainProducts() {
		return isMainProducts;
	}

	public void setIsMainProducts(Integer isMainProducts) {
		this.isMainProducts = isMainProducts;
	}

	public Integer getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(Integer estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	public Integer getNotPlaceOrderNumber() {
		return notPlaceOrderNumber;
	}

	public void setNotPlaceOrderNumber(Integer notPlaceOrderNumber) {
		this.notPlaceOrderNumber = notPlaceOrderNumber;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
}
