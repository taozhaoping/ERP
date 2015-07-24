package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.ProductProcess;

/**
 *  产品工序维护接口
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface ProductProcessService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProductProcess query(ProductProcess productProcess);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProductProcess productProcess);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProductProcess> queryList(ProductProcess productProcess);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProductProcess> queryList(ProductProcess productProcess , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProductProcess productProcess);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProductProcess productProcess);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(ProductProcess productProcess);
}
