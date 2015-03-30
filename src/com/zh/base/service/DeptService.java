package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Dept;
import com.zh.core.model.Pager;

/**
 * 
* @Title: DeptService.java 
* @Package com.zh.base.service 
* @Description: 部门管理接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface DeptService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Dept query(Dept dept);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Dept dept);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Dept> queryList(Dept dept);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Dept> queryList(Dept dept , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Dept dept);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Dept dept);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(Dept dept);
}
