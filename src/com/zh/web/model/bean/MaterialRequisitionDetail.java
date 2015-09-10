package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;


/**
 * 生产任务单明细
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年9月10日 下午7:34:17
 *
 */
public class MaterialRequisitionDetail extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3674562558517621346L;

	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 生产任务单号id，和生产任务单公用主表
	 */
	private Integer productiontaskId;
	
	/**
	 * 物料
	 */
	private Integer productsId;

	/**
	 * 生产数量
	 */
	private Float materialNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductiontaskId() {
		return productiontaskId;
	}

	public void setProductiontaskId(Integer productiontaskId) {
		this.productiontaskId = productiontaskId;
	}

	public Integer getProductsId() {
		return productsId;
	}

	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
	}

	public Float getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(Float materialNumber) {
		this.materialNumber = materialNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
