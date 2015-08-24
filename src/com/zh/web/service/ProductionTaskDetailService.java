package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.ProductionTaskDetail;

/**
 *  生产任务单_明细
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface ProductionTaskDetailService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProductionTaskDetail query(ProductionTaskDetail productionTaskDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProductionTaskDetail productionTaskDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProductionTaskDetail> queryList(ProductionTaskDetail productionTaskDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProductionTaskDetail> queryList(ProductionTaskDetail productionTaskDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProductionTaskDetail productionTaskDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProductionTaskDetail productionTaskDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(ProductionTaskDetail productionTaskDetail);
}
