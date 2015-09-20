package com.zh.web.model.bean;

import java.util.Date;

import com.zh.core.base.model.StockObject;
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
public class ProductionTask extends StockObject {

	//private Long id;

	/**
	 * 加工单号
	 */
	private Long inventoryCountID;

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

	/**
	 * 状态(0：初始化，1：领料 2：生产 3：验收 4：完成)
	 */
	//private Integer status;

	public Long getInventoryCountID() {
		return inventoryCountID;
	}

	public void setInventoryCountID(Long inventoryCountID) {
		this.inventoryCountID = inventoryCountID;
	}

	public String getProcessingsingleID() {
		return processingsingleID;
	}

	public void setProcessingsingleID(String processingsingleID) {
		this.processingsingleID = processingsingleID;
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

}
