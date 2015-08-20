package com.zh.web.util;

public interface UtilService {

	/**
	 * 供应商
	 */
	public static Integer CUSTOMER_TYPE_SUPPLIER = 11;
	
	/**
	 * 客户
	 */
	public static Integer CUSTOMER_TYPE_CUSTO = 12;
	
	/**
	 * 有效
	 */
	public static Integer ENABLED_EFFECTIVE = 0;
	
	/**
	 * 无效
	 */
	public static Integer ENABLED_INVALID = 1;
	
	/**
	 * 未入库
	 */
	public static Integer STORAGE_STATUS_ON = 0;
	
	/**
	 * 入库
	 */
	public static Integer STORAGE_STATUS_OFF = 1;
	
	/**
	 * 其他入库
	 */
	public static String STORAGE_TYPE = "QTRK";
	
	/**
	 * 其他出库
	 */
	public static String LIBRARY_TYPE = "QTCK";
	
	/**
	 * 其他入库
	 */
	public static String ORDER_STORAGE_TYPE = "DDRK";
	
	/**
	 * 销售订单
	 */
	public static String SALES_ORDER_TYPE = "XSDD";
	
	/**
	 * 采购订单
	 */
	public static String PURCHASE_ORDER_TYPE = "CGDD";
	
	/**
	 * 发起
	 */
	public static Integer SALES_ORDER_ONE = 0;
	
	/**
	 * 清点中
	 */
	public static Integer INVENTORY_ZERO = 0;
	/**
	 * 完成
	 */
	public static Integer INVENTORY_ONE = 1;
	
	/**
	 * 采购订单状态（运输）
	 */
	public static Integer PURCHASEORDERPRIMARY_STATUS_OPEN = 1;
	
	/**
	 * 采购订单状态（入库审核

	 */
	public static Integer PURCHASEORDERPRIMARY_STATUS_EXAMINE = 2;
	
	/**
	 * 采购订单状态（入库审核）To examine

	 */
	public static Integer PURCHASEORDERPRIMARY_STATUS_END = 3;
	
	/**
	 * 采购需求订单,状态(审核)
	 */
	public static Integer PROCUREMENTDEMAND_STATUS_APPROVAL = 1;
	
	/**
	 * 采购需求订单,状态(完成)
	 */
	public static Integer PROCUREMENTDEMAND_STATUS_END = 1;
}
