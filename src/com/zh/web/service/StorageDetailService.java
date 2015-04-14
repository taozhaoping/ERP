package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.StorageDetail;

/**
 * 
* @Title: StorageDetailService.java 
* @Package com.zh.base.service 
* @Description: 入库表头信息接口接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface StorageDetailService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public StorageDetail query(StorageDetail storageDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(StorageDetail storageDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<StorageDetail> queryList(StorageDetail storageDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<StorageDetail> queryList(StorageDetail storageDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(StorageDetail storageDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(StorageDetail storageDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(StorageDetail storageDetail);
}
