package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.ProcessingSingleDetail;

public interface ProcessingSingleDetailService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProcessingSingleDetail query(ProcessingSingleDetail processingSingleDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProcessingSingleDetail processingSingleDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProcessingSingleDetail> queryList(ProcessingSingleDetail processingSingleDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProcessingSingleDetail> queryList(ProcessingSingleDetail processingSingleDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProcessingSingleDetail processingSingleDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProcessingSingleDetail processingSingleDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(ProcessingSingleDetail processingSingleDetail);
}
