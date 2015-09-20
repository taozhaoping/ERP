package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.InventoryCountPrimary;

/**
 * 
* @Title: InventoryCountPrimaryService.java 
* @Package com.zh.base.service 
* @Description: 库存盘点头表
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface InventoryCountPrimaryService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public InventoryCountPrimary query(InventoryCountPrimary inventoryCountPrimary);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(InventoryCountPrimary inventoryCountPrimary);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<InventoryCountPrimary> queryList(InventoryCountPrimary inventoryCountPrimary);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<InventoryCountPrimary> queryList(InventoryCountPrimary inventoryCountPrimary , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(InventoryCountPrimary inventoryCountPrimary);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(InventoryCountPrimary inventoryCountPrimary);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(InventoryCountPrimary inventoryCountPrimary);
	
	/**
	 * 盘点入库
	 */
	public void increaseStock(Long id);

}
