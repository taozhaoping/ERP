package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.BOMPrimary;

/**
 * 
* @Title: ProductStructureService.java 
* @Package com.zh.base.service 
* @Description: 产品结构清单接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface ProductStructureService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public BOMPrimary query(BOMPrimary productStructure);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(BOMPrimary productStructure);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<BOMPrimary> queryList(BOMPrimary productStructure);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<BOMPrimary> queryList(BOMPrimary productStructure , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(BOMPrimary productStructure);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(BOMPrimary productStructure);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(BOMPrimary productStructure);
}
