package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * 加工单_头信息
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年7月22日 下午8:14:40
 *
 */
public class ProcessingSinglePrimary extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6333019662890680692L;
	
	/**
	 * id
	 */
	private Integer id;
	
	/**
	 * 加工单号
	 */
	private String processingSingleId;
	
	/**
	 * 销售订单号
	 */
	private Integer purchaseOrderId;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	/**
	 * 入库状态
	 */
	private Integer status;
	
	/**
	 * 描述 
	 */
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProcessingSingleId() {
		return processingSingleId;
	}

	public void setProcessingSingleId(String processingSingleId) {
		this.processingSingleId = processingSingleId;
	}

	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getCreatedate() {
		return createDate;
	}

	public void setCreatedate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
