package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.SalesOrderBom;

/**
 * 
* @Title: SalesOrderBomService.java 
* @Package com.zh.base.service 
* @Description: 销售订单明细结构表接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface SalesOrderBomService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public SalesOrderBom query(SalesOrderBom salesOrderBom);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<SalesOrderBom> queryList(SalesOrderBom salesOrderBom);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<SalesOrderBom> queryList(SalesOrderBom salesOrderBom , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(SalesOrderBom salesOrderBom);
	
}
