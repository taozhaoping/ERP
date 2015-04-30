package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.ProcurementDemandDetail;

/**
 * 
* @Title: ProcurementDemandDetailService.java 
* @Package com.zh.base.service 
* @Description: 采购需求清单明细表接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface ProcurementDemandDetailService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public ProcurementDemandDetail query(ProcurementDemandDetail procurementDemandDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(ProcurementDemandDetail procurementDemandDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<ProcurementDemandDetail> queryList(ProcurementDemandDetail procurementDemandDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<ProcurementDemandDetail> queryList(ProcurementDemandDetail procurementDemandDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(ProcurementDemandDetail procurementDemandDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(ProcurementDemandDetail procurementDemandDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(ProcurementDemandDetail procurementDemandDetail);
}
