package com.zh.core.base.model;

import com.zh.core.model.IDataObject;

/**
 * 
* @Title: StockObject.java 
* @Package com.zh.core.base.model 
* @Description: 库存流水基本类
* @date 2015年4月16日 下午2:01:46 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class StockObject extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4068023572629052599L;
	private Integer id;
	/**
	 * 出入库单号
	 */
	private String orderNoID;
	
	/**
	 * 出入库对应单据
	 */
	private String purchaseOrderID;
	
	/**
	 * 仓库
	 */
	private Integer warehouseID;
	
	/**
	 * 发货客户或者接收客户
	 */
	private Integer customerID;
	
	/**
	 * 入库状态
	 */
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNoID() {
		return orderNoID;
	}

	public void setOrderNoID(String orderNoID) {
		this.orderNoID = orderNoID;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(String purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

	public Integer getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Integer warehouseID) {
		this.warehouseID = warehouseID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
