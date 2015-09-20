package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Title: ProductStructure.java
 * @Package com.zh.web.model.bean
 * @Description: 产品结构清单
 * @date 2015年4月1日 下午2:32:40
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class BomPrimary extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7931223535636799647L;

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 主产品编号
	 */
	private Long productsId;

	/**
	 * 主产品编号
	 */
	private String productsName;

	/**
	 * 描述
	 */
	private String descr;

	/**
	 * 生效日期
	 */
	private String effdt;

	/**
	 * 生效状态
	 */
	private String effStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductsId() {
		return productsId;
	}

	public void setProductsId(Long productsId) {
		this.productsId = productsId;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getEffdt() {
		return effdt;
	}

	public void setEffdt(String effdt) {
		this.effdt = effdt;
	}

	public String getEffStatus() {
		return effStatus;
	}

	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:").append(id).append(" productsId:").append(productsId)
				.append(" productsName:").append(productsName)
				.append(" descr:").append(descr).append(" effdt:")
				.append(effdt).append(" effStatus:").append(effStatus);
		return sb.toString();
	}
}
