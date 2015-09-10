package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.MaterialRequisitionDetail;

/**
 * 领料单明细
 * @author 21829(cai_yingying@dahuatech.com)
 *
 * 2015年9月10日 下午7:52:41
 *
 */
public interface MaterialRequisitionDetailService {

	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public MaterialRequisitionDetail query(MaterialRequisitionDetail materialRequisitionDetail);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(MaterialRequisitionDetail materialRequisitionDetail);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<MaterialRequisitionDetail> queryList(MaterialRequisitionDetail materialRequisitionDetail);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<MaterialRequisitionDetail> queryList(MaterialRequisitionDetail materialRequisitionDetail , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(MaterialRequisitionDetail materialRequisitionDetail);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(MaterialRequisitionDetail materialRequisitionDetail);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(MaterialRequisitionDetail materialRequisitionDetail);
}
