package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Title: Products.java
 * @Package com.zh.web.model.bean
 * @Description: 产品信息
 * @date 2015年3月31日 上午11:30:57
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class Products extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6958330497434989824L;

	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 长度
	 */
	private Float longDegree;

	/**
	 * 宽度
	 */
	private Float wideDegree;

	/**
	 * 规格
	 */
	private String specifications;

	/**
	 * 表面处理
	 */
	private String surfaceTreatment;

	/**
	 * 颜色
	 */
	private Integer paint;

	/**
	 * 是否油漆
	 */
	private Integer isPaint;

	/**
	 * 计量单位
	 */
	private Integer measurementCompany;

	/**
	 * 来源
	 */
	private String sourceType;

	/**
	 * 审核人
	 */
	private Integer approvalUserID;

	/**
	 * 是否审核
	 */
	private String approval;

	/**
	 * 产品类型
	 */
	private Integer productType;

	/**
	 * 成本
	 */
	private Float processingFee;

	/**
	 * 预估价
	 */
	private Float estimatedPrice;

	/**
	 * 销售价
	 */
	private Float salesPrice;

	/**
	 * 安全库存
	 */
	private Integer safetyStock;

	/**
	 * 创建事件
	 */
	private String createdate;

	/**
	 * 修改事件
	 */
	private String updatedate;

	/**
	 * 更新者
	 */
	private Integer userID;

	/**
	 * 备注
	 */
	private String remarks;
	
	/**
	 * 仓库位
	 */
	private Integer position;
	
	/**
	 * 是否包含切割产品(0：包含切割产品，1：不包含切割产品)
	 */
	private Integer isCuttingScheme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getLongDegree() {
		return longDegree;
	}

	public void setLongDegree(Float longDegree) {
		this.longDegree = longDegree;
	}

	public Float getWideDegree() {
		return wideDegree;
	}

	public void setWideDegree(Float wideDegree) {
		this.wideDegree = wideDegree;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getSurfaceTreatment() {
		return surfaceTreatment;
	}

	public void setSurfaceTreatment(String surfaceTreatment) {
		this.surfaceTreatment = surfaceTreatment;
	}

	public Integer getPaint() {
		return paint;
	}

	public void setPaint(Integer paint) {
		this.paint = paint;
	}

	public Integer getIsPaint() {
		return isPaint;
	}

	public void setIsPaint(Integer isPaint) {
		this.isPaint = isPaint;
	}

	public Integer getMeasurementCompany() {
		return measurementCompany;
	}

	public void setMeasurementCompany(Integer measurementCompany) {
		this.measurementCompany = measurementCompany;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getApprovalUserID() {
		return approvalUserID;
	}

	public void setApprovalUserID(Integer approvalUserID) {
		this.approvalUserID = approvalUserID;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Float getProcessingFee() {
		return processingFee;
	}

	public void setProcessingFee(Float processingFee) {
		this.processingFee = processingFee;
	}

	public Float getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(Float estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	public Float getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Float salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Integer getSafetyStock() {
		return safetyStock;
	}

	public void setSafetyStock(Integer safetyStock) {
		this.safetyStock = safetyStock;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getIsCuttingScheme() {
		return isCuttingScheme;
	}

	public void setIsCuttingScheme(Integer isCuttingScheme) {
		this.isCuttingScheme = isCuttingScheme;
	}

}
