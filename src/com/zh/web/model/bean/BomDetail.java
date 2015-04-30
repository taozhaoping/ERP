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
	 * 主产品主键
	 */
	private Integer productsId;
	
	/**
	 * 子产品主键
	 */
	private Integer subProductsId;

	/**
	 * 子产品名称
	 */
	private String subProductsName;
	
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

	public Integer getProductsId() {
		return productsId;
	}

	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
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
	
	public String getSubProductsName() {
		return subProductsName;
	}

	public void setSubProductsName(String subProductsName) {
		this.subProductsName = subProductsName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:").append(id)
		.append(" primaryId:").append(primaryId)
		.append(" productsId:").append(productsId)
		.append(" subProductsId:").append(subProductsId)
		.append(" subProductsName:").append(subProductsName)
		.append(" position:").append(position)
		.append(" isMainProducts:").append(isMainProducts)
		.append(" qty:").append(qty)
		.append(" remarks:").append(remarks);
		return sb.toString();
	}

}
