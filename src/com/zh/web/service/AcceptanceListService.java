package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.AcceptanceList;
import com.zh.web.model.bean.Customer;

/**
 *  生产任务单_明细
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface AcceptanceListService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public AcceptanceList query(AcceptanceList acceptanceList);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<AcceptanceList> queryList(AcceptanceList acceptanceList);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<AcceptanceList> queryList(AcceptanceList acceptanceList , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(AcceptanceList acceptanceList);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(AcceptanceList acceptanceList);
	
}
