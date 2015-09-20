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
	private Long id;
	
	/**
	 * 生产任务单号id，和生产任务单公用主表
	 */
	private Long productiontaskId;
	
	/**
	 * 物料
	 */
	private Long productsId;

	/**
	 * 生产数量
	 */
	private Float materialNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductiontaskId() {
		return productiontaskId;
	}

	public void setProductiontaskId(Long productiontaskId) {
		this.productiontaskId = productiontaskId;
	}

	public Long getProductsId() {
		return productsId;
	}

	public void setProductsId(Long productsId) {
		this.productsId = productsId;
	}

	public Float getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(Float materialNumber) {
		this.materialNumber = materialNumber;
	}

	
}
