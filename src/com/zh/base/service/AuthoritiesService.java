package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Authorities;
import com.zh.core.model.Pager;

public interface AuthoritiesService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Authorities query(Authorities authorities);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Authorities authorities);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Authorities> queryList(Authorities authorities);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Authorities> queryList(Authorities authorities , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Authorities authorities);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Authorities authorities);
	
	/**
	 * 新增
	 * @param 
	 */
	public void insert(Authorities authorities);
}
