package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: Stock.java 
* @Package com.zh.web.model.bean 
* @Description: 库存信息表
* @date 2015年4月2日 下午5:13:59 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class Stock extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1948935877580356439L;

	private Long id;
	
	/**
	 * 库位
	 */
	private Integer position;
	
	/**
	 * 产品编号
	 */
	private Long productsID;
	
	/**
	 * 仓库编号
	 */
	private Long warehouseID;
	
	/**
	 * 库存量
	 */
	private Float stockNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Long getProductsID() {
		return productsID;
	}

	public void setProductsID(Long productsID) {
		this.productsID = productsID;
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
