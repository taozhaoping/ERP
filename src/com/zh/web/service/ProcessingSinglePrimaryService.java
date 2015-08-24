package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.ProcessingSinglePrimary;


public interface ProcessingSinglePrimaryService {

	String SEQUENCE_STORAGE_PRIMARY = "SEQUENCE_PROCESSINGSINGLE_PRIMARY";
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProcessingSinglePrimary query(ProcessingSinglePrimary processingSinglePrimary);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProcessingSinglePrimary processingSinglePrimary);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProcessingSinglePrimary> queryList(ProcessingSinglePrimary processingSinglePrimary);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProcessingSinglePrimary> queryList(ProcessingSinglePrimary processingSinglePrimary, Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProcessingSinglePrimary processingSinglePrimary);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProcessingSinglePrimary processingSinglePrimary);
	
	/**
	 * 新增 加工单，需要获取对应销售订单中的产品
	 * @param 
	 */
	public Integer insert(ProcessingSinglePrimary processingSinglePrimary);
	
}
