package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.InventoryCountDetail;

/**
 * 
* @Title: InventoryCountDetailService.java 
* @Package com.zh.base.service 
* @Description: 库存盘点_明细表
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface InventoryCountDetailService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public InventoryCountDetail query(InventoryCountDetail inventoryCountDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(InventoryCountDetail inventoryCountDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<InventoryCountDetail> queryList(InventoryCountDetail inventoryCountDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<InventoryCountDetail> queryList(InventoryCountDetail inventoryCountDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(InventoryCountDetail inventoryCountDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(InventoryCountDetail inventoryCountDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(InventoryCountDetail inventoryCountDetail);
}
