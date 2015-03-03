package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Notice;
import com.zh.core.model.Pager;

/**
 * 系统公告接口
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface NoticeService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Notice query(Notice notice);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Notice notice);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Notice> queryList(Notice notice);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Notice> queryList(Notice notice , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Notice notice);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Notice notice);
	
	/**
	 * 新增
	 * @param 
	 */
	public void insert(Notice notice);
}
