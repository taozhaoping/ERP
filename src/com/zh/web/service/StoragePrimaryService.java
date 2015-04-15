package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.StoragePrimary;

/**
 * 
* @Title: StoragePrimaryService.java 
* @Package com.zh.base.service 
* @Description: 入库表头信息接口接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface StoragePrimaryService {

	String SEQUENCE_STORAGE_PRIMARY = "SEQUENCE_STORAGE_PRIMARY";
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public StoragePrimary query(StoragePrimary storagePrimary);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(StoragePrimary storagePrimary);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<StoragePrimary> queryList(StoragePrimary storagePrimary);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<StoragePrimary> queryList(StoragePrimary storagePrimary , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(StoragePrimary storagePrimary);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(StoragePrimary storagePrimary);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(StoragePrimary storagePrimary,String type);
	
	/**
	* 材料入库
	 */
	public void increaseStock(String id);
}
