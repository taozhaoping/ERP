package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: StorageDetail.java 
* @Package com.zh.web.model.bean 
* @Description: 出库信息明细表
* @date 2015年4月9日 下午5:26:55 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class LibraryDetail extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -726926002801037061L;

	private Long id;
	
	/**
	 * 头表id
	 */
	private Long libraryPrimaryID;
	
	/**
	 * 入库产品
	 */
	private Long productsID;
	
	/**
	 * 库位
	 */
	private Long position;
	
	/**
	 * 入库数量
	 */
	private Integer storageNumber;
	
	/**
	 * 用途
	 */
	private String use;
	
	/**
	 * 描述
	 */
	private String remarks;
	
	/**
	 * 产品名称
	 */
	private String productsName;
	
	/**
	 * 仓库
	 */
	private Long warehouseID;
	
	/**
	 * 库存数量
	 */
	private Float stockNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLibraryPrimaryID() {
		return libraryPrimaryID;
	}

	public void setLibraryPrimaryID(Long libraryPrimaryID) {
		this.libraryPrimaryID = libraryPrimaryID;
	}

	public Long getProductsID() {
		return productsID;
	}

	public void setProductsID(Long productsID) {
		this.productsID = productsID;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Integer getStorageNumber() {
		return storageNumber;
	}

	public void setStorageNumber(Integer storageNumber) {
		this.storageNumber = storageNumber;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
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

	public Long getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Long warehouseID) {
		this.warehouseID = warehouseID;
	}

	public Float getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(Float stockNumber) {
		this.stockNumber = stockNumber;
	}

	
}
