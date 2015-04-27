package com.zh.web.model.bean;

import com.zh.core.model.IDataObject;

/**
 * @Title: SalesOrderPrimary.java
 * @Package com.zh.web.model.bean
 * @Description: 销售订单
 * @date 2015年4月27日 上午11:32:24
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public class SalesOrderPrimary extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -329763143033086853L;

	private Integer id;

	/**
	 * 销售订单
	 */
	private String orderID;

	/**
	 * 合同单号
	 */
	private String contractNumber;

	/**
	 * 客户主键
	 */
	private Integer customerID;

	/**
	 * 付款方式
	 */
	private Integer paymentTerm;

	/**
	 * 检查日期
	 */
	private String inspection;

	/**
	 * 进港日期
	 */
	private String lrddate;

	/**
	 * 集装箱号
	 */
	private String containerType;

	/**
	 * 装货港口
	 */
	private String loadingPort;

	/**
	 * 卸货港口
	 */
	private String dischargePort;

	/**
	 * 订单状态
	 */
	private Integer status;

	/**
	 * 总价
	 */
	private Double price;

	private String createdate;

	private String updatedate;

	/**
	 * 付款货币
	 */
	private Integer currencyPayment;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 发起人
	 */
	private Integer userID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Integer getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(Integer paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getInspection() {
		return inspection;
	}

	public void setInspection(String inspection) {
		this.inspection = inspection;
	}

	public String getLrddate() {
		return lrddate;
	}

	public void setLrddate(String lrddate) {
		this.lrddate = lrddate;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getLoadingPort() {
		return loadingPort;
	}

	public void setLoadingPort(String loadingPort) {
		this.loadingPort = loadingPort;
	}

	public String getDischargePort() {
		return dischargePort;
	}

	public void setDischargePort(String dischargePort) {
		this.dischargePort = dischargePort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public Integer getCurrencyPayment() {
		return currencyPayment;
	}

	public void setCurrencyPayment(Integer currencyPayment) {
		this.currencyPayment = currencyPayment;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

}
