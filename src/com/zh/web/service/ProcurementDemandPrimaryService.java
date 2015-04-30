package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.ProcurementDemandPrimary;

/**
 * 
* @Title: ProcurementDemandPrimaryService.java 
* @Package com.zh.base.service 
* @Description: 采购需求清单头表
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface ProcurementDemandPrimaryService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProcurementDemandPrimary query(ProcurementDemandPrimary procurementDemandPrimary);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProcurementDemandPrimary procurementDemandPrimary);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProcurementDemandPrimary> queryList(ProcurementDemandPrimary procurementDemandPrimary);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProcurementDemandPrimary> queryList(ProcurementDemandPrimary procurementDemandPrimary , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProcurementDemandPrimary procurementDemandPrimary);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProcurementDemandPrimary procurementDemandPrimary);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(ProcurementDemandPrimary procurementDemandPrimary,String type);

}
