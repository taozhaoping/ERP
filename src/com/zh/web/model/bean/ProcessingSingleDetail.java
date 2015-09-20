package com.zh.web.model.bean;

import java.util.Date;

import com.zh.core.model.IDataObject;

/**
 * 加工单详细信息
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年7月22日 下午8:14:36
 *
 */
public class ProcessingSingleDetail extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6333019662890680692L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 加工单头表id
	 */
	private Long processingSingleId;
	
	/**
	 * 销售订单分解结构表ID
	 */
	private Long salesOrderBomID;
	
	/**
	 * 生产日期
	 */
	private Date startDate;
	
	/**
	 * 结束日期
	 */
	private Date endDate;
	
	/**
	 * 生产物料id
	 */
	private Long productsId;
	
	/**
	 * 生产数量
	 */
	private Float processingNumber;
	
	/**
	 * 主料物料编号
	 */
	private Long mainProductsID;
	
	/**
	 * 是否主料/替代料
	 */
	private String mainsub;
	
	/**
	 * 生产表示(0：生产，1：不生产)
	 */
	private Integer productionMark;
	
	/**
	 * 层级
	 */
	private Integer tier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProcessingSingleId() {
		return processingSingleId;
	}

	public void setProcessingSingleId(Long processingSingleId) {
		this.processingSingleId = processingSingleId;
	}

	public Long getSalesOrderBomID() {
		return salesOrderBomID;
	}

	public void setSalesOrderBomID(Long salesOrderBomID) {
		this.salesOrderBomID = salesOrderBomID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getProductsId() {
		return productsId;
	}

	public void setProductsId(Long productsId) {
		this.productsId = productsId;
	}

	public Float getProcessingNumber() {
		return processingNumber;
	}

	public void setProcessingNumber(Float processingNumber) {
		this.processingNumber = processingNumber;
	}

	public Long getMainProductsID() {
		return mainProductsID;
	}

	public void setMainProductsID(Long mainProductsID) {
		this.mainProductsID = mainProductsID;
	}

	public String getMainsub() {
		return mainsub;
	}

	public void setMainsub(String mainsub) {
		this.mainsub = mainsub;
	}

	public Integer getProductionMark() {
		return productionMark;
	}

	public void setProductionMark(Integer productionMark) {
		this.productionMark = productionMark;
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	
}
