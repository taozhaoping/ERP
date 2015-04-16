package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.LibraryDetail;

/**
 * 
* @Title: LibraryDetailService.java 
* @Package com.zh.base.service 
* @Description: 入库表头信息接口接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface LibraryDetailService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public LibraryDetail query(LibraryDetail libraryDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(LibraryDetail libraryDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<LibraryDetail> queryList(LibraryDetail libraryDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<LibraryDetail> queryList(LibraryDetail libraryDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(LibraryDetail libraryDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(LibraryDetail libraryDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(LibraryDetail libraryDetail);
}
