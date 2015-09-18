package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;



/**
 * 加工单入库_明细
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年9月16日 上午10:29:38
 *
 */
public class ProductionStorageDetail extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3674562558517621346L;

	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 加工单头表id，和加工单公用主表
	 */
	private Integer processingSingleId;
	
	/**
	 * 物料
	 */
	private Integer productsId;

	/**
	 * 数量
	 */
	private Float processingNumber;
	
	/**
	 * 产品类型 0:成本，1为剩余物料（半成品）
	 */
	private Integer warehouseType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProcessingSingleId() {
		return processingSingleId;
	}

	public void setProcessingSingleId(Integer processingSingleId) {
		this.processingSingleId = processingSingleId;
	}

	public Integer getProductsId() {
		return productsId;
	}

	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
	}

	public Float getProcessingNumber() {
		return processingNumber;
	}

	public void setProcessingNumber(Float processingNumber) {
		this.processingNumber = processingNumber;
	}

	public Integer getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(Integer warehouseType) {
		this.warehouseType = warehouseType;
	}
	
}
