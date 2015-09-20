package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Description: 验收单
* @Title: AcceptanceList.java 
* @Package com.zh.web.model.bean 
* @date 2015年9月7日 下午8:08:50 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class AcceptanceList extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3280404658467577945L;

	private Long id;
	
	private Long productionTaskID;
	
	private Long productsID;
	
	private Long processID;
	
	private String processName;
	
	private String acceptanceDate;
	
	private String isAcceptance;

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

	public Long getProductsID() {
		return productsID;
	}

	public void setProductsID(Long productsID) {
		this.productsID = productsID;
	}

	public Long getProcessID() {
		return processID;
	}

	public void setProcessID(Long processID) {
		this.processID = processID;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getAcceptanceDate() {
		return acceptanceDate;
	}

	public void setAcceptanceDate(String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	public String getIsAcceptance() {
		return isAcceptance;
	}

	public void setIsAcceptance(String isAcceptance) {
		this.isAcceptance = isAcceptance;
	}

	
}
