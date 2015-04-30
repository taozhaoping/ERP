package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
* @Title: ProcurementDemandDetail.java 
* @Package com.zh.web.model.bean 
* @Description: 采购需求清单明细表
* @date 2015年4月30日 上午9:51:59 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class ProcurementDemandDetail extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2646268575260258392L;

	private Integer id;
	
	/**
	 * 头表ID
	 */
	private Integer procurementID;
	
	/**
	 * 产品编号
	 */
	private Integer productsID;
	
	/**
	 * 数量
	 */
	private Integer demandNumber;
	
	/**
	 * 备注
	 */
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProcurementID() {
		return procurementID;
	}

	public void setProcurementID(Integer procurementID) {
		this.procurementID = procurementID;
	}

	public Integer getProductsID() {
		return productsID;
	}

	public void setProductsID(Integer productsID) {
		this.productsID = productsID;
	}

	public Integer getDemandNumber() {
		return demandNumber;
	}

	public void setDemandNumber(Integer demandNumber) {
		this.demandNumber = demandNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
