package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.Customer;

/**
 * 
* @Title: CustomerService.java 
* @Package com.zh.base.service 
* @Description: 客户资源管理接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface CustomerService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Customer query(Customer customer);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Customer customer);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Customer> queryList(Customer customer);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Customer> queryList(Customer customer , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Customer customer);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Customer customer);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(Customer customer);
}
