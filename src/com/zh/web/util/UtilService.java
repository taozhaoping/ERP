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
	
	public static String STORAGE_TYPE = "QTRK";
}
