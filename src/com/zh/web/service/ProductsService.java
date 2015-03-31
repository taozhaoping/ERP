package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.Products;

/**
 * 
* @Title: ProductsService.java 
* @Package com.zh.base.service 
* @Description: 产品资源管理接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface ProductsService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Products query(Products products);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Products products);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Products> queryList(Products products);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Products> queryList(Products products , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Products products);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Products products);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(Products products);
}
