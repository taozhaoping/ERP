package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.ProductionStorageDetail;

/**
 * 生产入库明细
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年9月10日 下午7:52:41
 *
 */
public interface ProductionStorageDetailService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProductionStorageDetail query(ProductionStorageDetail productionStorageDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProductionStorageDetail productionStorageDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProductionStorageDetail> queryList(ProductionStorageDetail productionStorageDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProductionStorageDetail> queryList(ProductionStorageDetail productionStorageDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProductionStorageDetail productionStorageDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProductionStorageDetail productionStorageDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(ProductionStorageDetail productionStorageDetail);
}
