package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Title: ProductStructure.java
 * @Package com.zh.web.model.bean
 * @Description: 产品结构明细
 * @date 2015年4月1日 下午2:32:40
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class BomDetail extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5983973745022265180L;

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 产品结构头表主建
	 */
	private Integer primaryId;
	
	/**
	 * 子产品主键
	 */
	private Integer subProductsId;
	
	/**
	 * 库位号
	 */
	private Integer position;
	
	/**
	 * 是否主要产品
	 */
	private Integer isMainProducts;
	
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

	public Integer getIsMainProducts() {
		return isMainProducts;
	}

	public void setIsMainProducts(Integer isMainProducts) {
		this.isMainProducts = isMainProducts;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:").append(id)
		.append(" primaryId:").append(primaryId)
		.append(" subProductsId:").append(subProductsId)
		.append(" position:").append(position)
		.append(" isMainProducts:").append(isMainProducts)
		.append(" qty:").append(qty)
		.append(" remarks:").append(remarks);
		return sb.toString();
	}

}
