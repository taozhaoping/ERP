package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.FileInfo;

/**
 * 附件信息接口
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface FileInfoService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public FileInfo query(FileInfo fileInfo);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(FileInfo fileInfo);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<FileInfo> queryList(FileInfo fileInfo);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<FileInfo> queryList(FileInfo fileInfo , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(FileInfo fileInfo);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(FileInfo fileInfo);
	
	/**
	 * 新增
	 * @param 
	 */
	public void insert(FileInfo fileInfo);
}
