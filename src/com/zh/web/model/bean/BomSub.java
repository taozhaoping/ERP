package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Title: ProductStructure.java
 * @Package com.zh.web.model.bean
 * @Description: 产品结构替代料
 * @date 2015年4月1日 下午2:32:40
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class BomSub extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2984289025067968893L;

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 产品结构头表主建
	 */
	private Integer primaryId;
	
	/**
	 * 主料主键
	 */
	private Integer mainProductsId;

	/**
	 * 替代料主键
	 */
	private Integer subProductsId;
	
	/**
	 * 库位号
	 */
	private Integer position;
	
	/**
	 * 数量
	 */
	private Float qty;
	
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

	public Integer getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(Integer primaryId) {
		this.primaryId = primaryId;
	}

	public Integer getMainProductsId() {
		return mainProductsId;
	}

	public void setMainProductsId(Integer mainProductsId) {
		this.mainProductsId = mainProductsId;
	}

	public Integer getSubProductsId() {
		return subProductsId;
	}

	public void setSubProductsId(Integer subProductsId) {
		this.subProductsId = subProductsId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
