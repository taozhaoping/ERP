package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.BasiType;

/**
 * 
 * @Title: BasiTypeService.java
 * @Package com.zh.base.service
 * @Description: 基础类型资料
 * @date 2015年3月25日 下午3:23:21
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 * @version V1.0
 */
public interface BasiTypeService {

	/**
	 * 部门类型
	 */
	public static final Integer DEPT_TYPE = 5;
	
	/**
	 * 客户级别
	 */
	public static final Integer CUSTOMER_LEV = 3;
	
	/**
	 * 客户类型
	 */
	public static final Integer CUSTOMER_TYPE = 2;
	
	/**
	 * 产品来源
	 */
	public static final Integer SOURCE_TYPE = 9;
	
	/**
	 * 产品类型
	 */
	public static final Integer PRODUCT_TYPE = 11;
	
	/**
	 * 计量单位
	 */
	public static final Integer MEASUREMENT_COMPANYSOURCE_TYPE = 8;
	
	/**
	 * 颜色
	 */
	public static final Integer PAINT_COLR = 10;
	
	/**
	 * 付款方式
	 */
	public static final Integer PAYMENT_TERM = 12;
	
	/**
	 * 付款货币
	 */
	public static final Integer CURRENCY_PAYMENT = 13;
	
	/**
	 * 查询信息
	 * 
	 * @param
	 * @return
	 */
	public BasiType query(BasiType basiType);

	/**
	 * 查询列表
	 * 
	 * @param
	 * @return
	 */
	public List<BasiType> queryList(BasiType basiType);

	/**
	 * 查询用户列表，返回json格式
	 * 
	 * @param user
	 * @return
	 */
	public String queryListJson(BasiType basiType);

}
