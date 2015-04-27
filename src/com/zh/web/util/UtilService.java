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
	 * 销售订单
	 */
	public static String SALES_ORDER_TYPE = "XSDD";
	
	/**
	 * 发起
	 */
	public static Integer SALES_ORDER_ONE = 0;
	
	
}
