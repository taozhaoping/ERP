package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Warehouse;
import com.zh.core.model.Pager;

/**
 * 
* @Title: WarehouseService.java 
* @Package com.zh.base.service 
* @Description: 仓库管理接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface WarehouseService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Warehouse query(Warehouse warehouse);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Warehouse warehouse);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Warehouse> queryList(Warehouse warehouse);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Warehouse> queryList(Warehouse warehouse , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Warehouse warehouse);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Warehouse warehouse);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(Warehouse warehouse);
}
