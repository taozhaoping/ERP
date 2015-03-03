package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Resourceinfo;
import com.zh.core.model.Pager;

public interface ResourceinfoService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Resourceinfo query(Resourceinfo resourceinfo);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Resourceinfo resourceinfo);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Resourceinfo> queryList(Resourceinfo resourceinfo);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Resourceinfo> queryList(Resourceinfo resourceinfo , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Resourceinfo resourceinfo);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Resourceinfo resourceinfo);
	
	/**
	 * 新增
	 * @param 
	 */
	public void insert(Resourceinfo resourceinfo);
}
