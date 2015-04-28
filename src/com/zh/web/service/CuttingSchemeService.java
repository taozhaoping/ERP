package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.CuttingScheme;

/**
 * 
* @Title: CuttingSchemeService.java 
* @Package com.zh.base.service 
* @Description: 切割方案接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface CuttingSchemeService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public CuttingScheme query(CuttingScheme cuttingScheme);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(CuttingScheme cuttingScheme);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<CuttingScheme> queryList(CuttingScheme cuttingScheme);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<CuttingScheme> queryList(CuttingScheme cuttingScheme , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(CuttingScheme cuttingScheme);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(CuttingScheme cuttingScheme);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(CuttingScheme cuttingScheme);
}
