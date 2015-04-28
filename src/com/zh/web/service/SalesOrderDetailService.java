package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.SalesOrderDetail;

/**
 * 
* @Title: SalesOrderDetailService.java 
* @Package com.zh.base.service 
* @Description: 销售订单明细接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface SalesOrderDetailService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public SalesOrderDetail query(SalesOrderDetail salesOrderDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(SalesOrderDetail salesOrderDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<SalesOrderDetail> queryList(SalesOrderDetail salesOrderDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<SalesOrderDetail> queryList(SalesOrderDetail salesOrderDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(SalesOrderDetail salesOrderDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(SalesOrderDetail salesOrderDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(SalesOrderDetail salesOrderDetail);
}
