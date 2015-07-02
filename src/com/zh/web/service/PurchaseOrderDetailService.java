package com.zh.web.service;

import java.util.List;

import com.zh.core.model.IDataObject;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.PurchaseOrderDetail;

/**
 * 
* @Title: PurchaseOrderDetailService.java 
* @Package com.zh.base.service 
* @Description: 采购订单明细表接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface PurchaseOrderDetailService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public PurchaseOrderDetail query(PurchaseOrderDetail purchaseOrderDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(PurchaseOrderDetail purchaseOrderDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<PurchaseOrderDetail> queryList(PurchaseOrderDetail purchaseOrderDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<PurchaseOrderDetail> queryList(PurchaseOrderDetail purchaseOrderDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(PurchaseOrderDetail purchaseOrderDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(PurchaseOrderDetail purchaseOrderDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(PurchaseOrderDetail purchaseOrderDetail);
	
	/**
	 * 批量新增
	 * @param 
	 */
	public void insertList(List<IDataObject> purchaseOrderDetailList);

}
