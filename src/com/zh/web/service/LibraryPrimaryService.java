package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.LibraryPrimary;

/**
 * 
* @Title: LibraryPrimaryService.java 
* @Package com.zh.base.service 
* @Description: 入库表头信息接口接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface LibraryPrimaryService {

	String SEQUENCE_STORAGE_PRIMARY = "SEQUENCE_LIBRARY_PRIMARY";
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public LibraryPrimary query(LibraryPrimary libraryPrimary);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(LibraryPrimary libraryPrimary);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<LibraryPrimary> queryList(LibraryPrimary libraryPrimary);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<LibraryPrimary> queryList(LibraryPrimary libraryPrimary , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(LibraryPrimary libraryPrimary);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(LibraryPrimary libraryPrimary);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(LibraryPrimary libraryPrimary,String type);
	
	/**
	* 材料出库
	 */
	public void increaseStock(String id);
}
