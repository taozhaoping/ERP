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

	private Long id;
	
	/**
	 * 头表ID
	 */
	private Long procurementID;
	
	/**
	 * 产品编号
	 */
	private Long productsID;
	
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
	
	/**
	 * 采购需求单状态
	 */
	private Integer approvalStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProcurementID() {
		return procurementID;
	}

	public void setProcurementID(Long procurementID) {
		this.procurementID = procurementID;
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

	public Integer getMeasurementCompany() {
		return measurementCompany;
	}

	public void setMeasurementCompany(Integer measurementCompany) {
		this.measurementCompany = measurementCompany;
	}

	public Integer getIsMainProducts() {
		return isMainProducts;
	}

	public void setIsMainProducts(Integer isMainProducts) {
		this.isMainProducts = isMainProducts;
	}

	public Integer getDemandNumber() {
		return demandNumber;
	}

	public void setDemandNumber(Integer demandNumber) {
		this.demandNumber = demandNumber;
	}

	public Integer getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(Integer estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	public Integer getPlaceOrderNumber() {
		return placeOrderNumber;
	}

	public void setPlaceOrderNumber(Integer placeOrderNumber) {
		this.placeOrderNumber = placeOrderNumber;
	}

	public Integer getNotPlaceOrderNumber() {
		return notPlaceOrderNumber;
	}

	public void setNotPlaceOrderNumber(Integer notPlaceOrderNumber) {
		this.notPlaceOrderNumber = notPlaceOrderNumber;
	}

	public Integer getStorageNumber() {
		return storageNumber;
	}

	public void setStorageNumber(Integer storageNumber) {
		this.storageNumber = storageNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Integer getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

}
