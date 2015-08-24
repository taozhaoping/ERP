package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.ProductionTask;

/**
 *  生产任务单
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface ProductionTaskService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProductionTask query(ProductionTask productionTask);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProductionTask productionTask);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProductionTask> queryList(ProductionTask productionTask);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProductionTask> queryList(ProductionTask productionTask , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProductionTask productionTask);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProductionTask productionTask);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(ProductionTask productionTask);
}
