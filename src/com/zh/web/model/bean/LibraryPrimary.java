package com.zh.web.model.bean;

import com.zh.core.base.model.StockObject;
import com.zh.core.model.IDataObject;

/**
* @Title: LibraryPrimary.java 
* @Package com.zh.web.model.bean 
* @Description: 出库信息表头
* @date 2015年4月9日 下午5:26:55 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public class LibraryPrimary extends IDataObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9027360111757364893L;
	/**
	 * 
	 */
	
	private Long id;
	/**
	 * 出库单号
	 */
	private String orderNoID;
	
	/**
	 * 出库时间
	 */
	private String librarydate;
	
	/**
	 * 对应单据
	 */
	private String purchaseOrderID;
	
	/**
	 * 发货人
	 */
	private Long userID;
	
	/**
	 * 仓库
	 */
	private Long warehouseID;
	
	/**
	 * 金额
	 */
	private Float mountMeoey;
	
	/**
	 * 描述
	 */
	private String remarks;
	
	/**
	 * 收货客户
	 */
	private Long customerID;
	
	/**
	 * 创建时间
	 */
	private String createdate;
	
	/**
	 * 修改时间
	 */
	private String updatedate;
	
	/**
	 * 入库状态
	 */
	private Integer status;
	
	/**
	 * 集装箱号
	 */
	private String containerType;
	
	/**
	 * 是否订单出库(1销售订单出库，0为其他出库)
	 */
	private Integer isStorage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNoID() {
		return orderNoID;
	}

	public void setOrderNoID(String orderNoID) {
		this.orderNoID = orderNoID;
	}

	public String getLibrarydate() {
		return librarydate;
	}

	public void setLibrarydate(String librarydate) {
		this.librarydate = librarydate;
	}

	public String getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(String purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Long warehouseID) {
		this.warehouseID = warehouseID;
	}

	public Float getMountMeoey() {
		return mountMeoey;
	}

	public void setMountMeoey(Float mountMeoey) {
		this.mountMeoey = mountMeoey;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public Integer getIsStorage() {
		return isStorage;
	}

	public void setIsStorage(Integer isStorage) {
		this.isStorage = isStorage;
	}

}
