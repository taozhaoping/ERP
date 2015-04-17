package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.BomDetail;
import com.zh.web.model.bean.BomPrimary;

/**
 * 
* @Title: ProductStructureService.java 
* @Package com.zh.base.service 
* @Description: 产品结构清单接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface ProductStructService {

	/**
	 * 查询主表信息
	 * @param 
	 * @return
	 */
	public BomPrimary queryPrimary(BomPrimary bomPrimary);
	
	/**
	 * 修改主表
	 * @param 
	 */
	public void updatePrimary(BomPrimary bomPrimary);
	
	/**
	 * 查询主表列表
	 * @param 
	 * @return
	 */
	public List<BomPrimary> queryPrimaryList(BomPrimary bomPrimary);
	
	/**
	 * 查询主表列表，带分页
	 * @param 
	 * @return
	 */
	public List<BomPrimary> queryPrimaryList(BomPrimary bomPrimary , Pager page);
	
	/**
	 * 查询主表数量
	 * @param 
	 * @return
	 */
	public Integer countPrimary(BomPrimary bomPrimary);
	
	/**
	 * 删除主表
	 * @param 
	 */
	public void deletePrimary(BomPrimary bomPrimary);
	
	/**
	 * 新增主表
	 * @param 
	 */
	public Integer insertPrimary(BomPrimary bomPrimary);
	
	/**
	 * 查询明细表信息
	 * @param 
	 * @return
	 */
	public BomDetail queryDetail(BomDetail bomDetail);
	
	/**
	 * 修改明细表
	 * @param 
	 */
	public void updateDetail(BomDetail bomDetail);
	
	/**
	 * 查询明细表列表
	 * @param 
	 * @return
	 */
	public List<BomDetail> queryDetailList(BomDetail bomDetail);
	
	/**
	 * 查询明细表列表，带分页
	 * @param 
	 * @return
	 */
	public List<BomDetail> queryDetailList(BomDetail bomDetail , Pager page);
	
	/**
	 * 查询明细表数量
	 * @param 
	 * @return
	 */
	public Integer countDetail(BomDetail bomDetail);
	
	/**
	 * 删除明细表
	 * @param 
	 */
	public void deleteDetail(BomDetail bomDetail);
	
	/**
	 * 新增明细表
	 * @param 
	 */
	public Integer insertDetail(BomDetail bomDetail);
}
