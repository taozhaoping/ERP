package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.User;
import com.zh.core.model.Pager;

/**
 * 用户帐号相关操作（查询动作）
 * @author Administrator
 *
 */
public interface UserInfoService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public User query(User user);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(User user);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<User> queryList(User user);
	
	/**
	 * 查询用户列表，返回json格式
	 * @param user
	 * @return
	 */
	public String queryListJson();
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<User> queryList(User user , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(User user);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(User user);
	
	/**
	 * 新增
	 * @param 
	 */
	public void insert(User user);
	

}
