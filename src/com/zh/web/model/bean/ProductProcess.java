package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Description: 产品对应加工工序
 * @Title: ProductProcess.java
 * @Package com.zh.web.model.bean
 * @date 2015年7月23日 下午7:26:30
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class ProductProcess extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 产品结构ID
	 */
	private Long bomPrimaryID;
	
	/**
	 * 工序ID
	 */
	private Long processID;

	/**
	 * 工序名称
	 */
	private String name;

	/**
	 * 价格
	 */
	private Double referencePrice;

	/**
	 * 周期
	 */
	private Double processingCycle;

	/**
	 * 描述
	 */
	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBomPrimaryID() {
		return bomPrimaryID;
	}

	public void setBomPrimaryID(Long bomPrimaryID) {
		this.bomPrimaryID = bomPrimaryID;
	}

	public Long getProcessID() {
		return processID;
	}

	public void setProcessID(Long processID) {
		this.processID = processID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getReferencePrice() {
		return referencePrice;
	}

	public void setReferencePrice(Double referencePrice) {
		this.referencePrice = referencePrice;
	}

	public Double getProcessingCycle() {
		return processingCycle;
	}

	public void setProcessingCycle(Double processingCycle) {
		this.processingCycle = processingCycle;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
