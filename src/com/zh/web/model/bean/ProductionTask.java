package com.zh.web.model.bean;

import java.util.Date;

import com.zh.core.model.IDataObject;

/**
* @Description: 生产任务单
* @Title: ProductionTask.java 
* @Package com.zh.web.model.bean 
* @date 2015年8月24日 下午4:01:16 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class ProductionTask extends IDataObject {

	private Integer id;
	
	/**
	 * 加工单号
	 */
	private Integer inventoryCountID;
	
	/**
	 * 加工单编号
	 */
	private String processingsingleID;
	
	/**
	 * 生产任务单
	 */
	private String productionOrder;
	
	/**
	 * 开始时间
	 */
	private Date startDate;
	
	/**
	 * 结束时间
	 */
	private Date endDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInventoryCountID() {
		return inventoryCountID;
	}

	public void setInventoryCountID(Integer inventoryCountID) {
		this.inventoryCountID = inventoryCountID;
	}

	public String getProductionOrder() {
		return productionOrder;
	}

	public void setProductionOrder(String productionOrder) {
		this.productionOrder = productionOrder;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProcessingsingleID() {
		return processingsingleID;
	}

	public void setProcessingsingleID(String processingsingleID) {
		this.processingsingleID = processingsingleID;
	}
	
}
