package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Enterprise;
import com.zh.core.model.Pager;

public interface EnterpriseService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Enterprise query(Enterprise enterprise);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Enterprise enterprise);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Enterprise> queryList(Enterprise enterprise);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Enterprise> queryList(Enterprise enterprise , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Enterprise enterprise);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Enterprise enterprise);
	
	/**
	 * 新增
	 * @param 
	 */
	public void insert(Enterprise enterprise);
}
