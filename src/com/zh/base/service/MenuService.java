package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Menu;
import com.zh.core.model.Pager;

public interface MenuService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Menu query(Menu object);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Menu object);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Menu> queryList(Menu menu);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Menu> queryList(Menu object , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Menu object);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Menu object);
	
	/**
	 * 新增
	 * @param 
	 */
	public void insert(Menu object);
	
}
