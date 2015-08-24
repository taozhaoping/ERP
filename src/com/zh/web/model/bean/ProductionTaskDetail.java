package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * 生产任务单明细
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年7月22日 下午8:14:36
 *
 */
public class ProductionTaskDetail extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3674562558517621346L;

	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 生产任务单主表id
	 */
	private Integer productionTaskID;
	

	
	/**
	 * 生产物料id
	 */
	private Integer productsId;
	
	/**
	 * 生产数量
	 */
	private Float processingNumber;
	
	/**
	 * 工序
	 */
	private Integer processID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductionTaskID() {
		return productionTaskID;
	}

	public void setProductionTaskID(Integer productionTaskID) {
		this.productionTaskID = productionTaskID;
	}

	public Integer getProductsId() {
		return productsId;
	}

	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
	}

	public Float getProcessingNumber() {
		return processingNumber;
	}

	public void setProcessingNumber(Float processingNumber) {
		this.processingNumber = processingNumber;
	}

	public Integer getProcessID() {
		return processID;
	}

	public void setProcessID(Integer processID) {
		this.processID = processID;
	}

}
