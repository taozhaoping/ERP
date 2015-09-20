package com.zh.web.model.bean;

import com.zh.core.base.model.BaseModel;
import com.zh.core.model.IDataObject;

/**
* @Description: 工序
* @Title: Process.java 
* @Package com.zh.web.model.bean 
* @date 2015年7月22日 下午7:11:23 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class ProcessBean extends IDataObject {

	private Long id;
	
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
