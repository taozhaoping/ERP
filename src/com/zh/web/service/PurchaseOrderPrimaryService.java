package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.PurchaseOrderPrimary;

/**
 * 
* @Title: PurchaseOrderPrimaryService.java 
* @Package com.zh.base.service 
* @Description: 采购订单头表
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface PurchaseOrderPrimaryService {
	
	String SEQUENCE_PURCHASE_PRIMARY = "SEQUENCE_PURCHASE_PRIMARY";
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public PurchaseOrderPrimary query(PurchaseOrderPrimary purchaseOrderPrimary);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(PurchaseOrderPrimary purchaseOrderPrimary);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<PurchaseOrderPrimary> queryList(PurchaseOrderPrimary purchaseOrderPrimary);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<PurchaseOrderPrimary> queryList(PurchaseOrderPrimary purchaseOrderPrimary , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(PurchaseOrderPrimary purchaseOrderPrimary);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(PurchaseOrderPrimary purchaseOrderPrimary);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(PurchaseOrderPrimary purchaseOrderPrimary);

}
