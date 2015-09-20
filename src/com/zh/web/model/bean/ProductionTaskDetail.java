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
	private Long id;
	
	/**
	 * 生产任务单主表id
	 */
	private Long productionTaskID;
	

	
	/**
	 * 生产物料id
	 */
	private Long productsId;
	
	/**
	 * 生产数量
	 */
	private Float processingNumber;
	
	/**
	 * 工序
	 */
	private Long processID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductionTaskID() {
		return productionTaskID;
	}

	public void setProductionTaskID(Long productionTaskID) {
		this.productionTaskID = productionTaskID;
	}

	public Long getProductsId() {
		return productsId;
	}

	public void setProductsId(Long productsId) {
		this.productsId = productsId;
	}

	public Float getProcessingNumber() {
		return processingNumber;
	}

	public void setProcessingNumber(Float processingNumber) {
		this.processingNumber = processingNumber;
	}

	public Long getProcessID() {
		return processID;
	}

	public void setProcessID(Long processID) {
		this.processID = processID;
	}

}
