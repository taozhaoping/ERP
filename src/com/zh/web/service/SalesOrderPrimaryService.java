package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.SalesOrderPrimary;

/**
 * 
* @Title: SalesOrderPrimaryService.java 
* @Package com.zh.base.service 
* @Description: 销售订单接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface SalesOrderPrimaryService {

	String SEQUENCE_STORAGE_PRIMARY = "SEQUENCE_SALES_ORDER_PRIMARY";
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public SalesOrderPrimary query(SalesOrderPrimary salesOrderPrimary);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(SalesOrderPrimary salesOrderPrimary);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<SalesOrderPrimary> queryList(SalesOrderPrimary salesOrderPrimary);
	
	/**
	 * 查询不关联加工单的销售订单
	 * @return
	 */
	public List<SalesOrderPrimary> queryListNotRelevantProcess();
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<SalesOrderPrimary> queryList(SalesOrderPrimary salesOrderPrimary , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(SalesOrderPrimary salesOrderPrimary);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(SalesOrderPrimary salesOrderPrimary);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(SalesOrderPrimary salesOrderPrimary,String type);

}
