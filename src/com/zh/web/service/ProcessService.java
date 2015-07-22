package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.MailList;
import com.zh.web.model.bean.ProcessBean;

/**
 *  通讯录信息接口
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface ProcessService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProcessBean query(ProcessBean process);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProcessBean process);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProcessBean> queryList(ProcessBean process);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProcessBean> queryList(ProcessBean process , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProcessBean process);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProcessBean process);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(ProcessBean process);
}
