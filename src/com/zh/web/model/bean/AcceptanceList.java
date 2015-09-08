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

	private Integer id;
	
	private Integer productionTaskID;
	
	private Integer productsID;
	
	private Integer processID;
	
	private String processName;
	
	private String acceptanceDate;
	
	private String isAcceptance;

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

	public Integer getProductsID() {
		return productsID;
	}

	public void setProductsID(Integer productsID) {
		this.productsID = productsID;
	}

	public Integer getProcessID() {
		return processID;
	}

	public void setProcessID(Integer processID) {
		this.processID = processID;
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

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}
