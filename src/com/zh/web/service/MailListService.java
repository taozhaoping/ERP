package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.MailList;

/**
 *  通讯录信息接口
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface MailListService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public MailList query(MailList mailList);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(MailList mailList);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<MailList> queryList(MailList mailList);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<MailList> queryList(MailList mailList , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(MailList mailList);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(MailList mailList);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(MailList mailList);
}
