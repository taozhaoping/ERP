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
	protected Long id;
	/**
	 * 出入库单号
	 */
	protected String orderNoID;
	
	/**
	 * 出入库对应单据
	 */
	protected String purchaseOrderID;
	
	/**
	 * 仓库
	 */
	protected Long warehouseID;
	
	/**
	 * 发货客户或者接收客户
	 */
	protected Long customerID;
	
	/**
	 * 入库状态
	 */
	protected Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Long warehouseID) {
		this.warehouseID = warehouseID;
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

	
}
