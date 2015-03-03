package com.zh.core.base.service;

import java.util.List;
import com.zh.core.model.IDataObject;
import com.zh.core.model.Pager;

/**
 * 基础接口
 * @author taozhaoping 26078
 * @author mail taozhaoping@gmail.com
 */
public interface BaseService<IdataObject> {

	/**
	 * 查询用户信息
	 * @param userInfo
	 * @return
	 */
	public IDataObject query(IDataObject object);
	
	/**
	 * 修改
	 * @param userinfo
	 */
	public void update(IDataObject object);
	
	/**
	 * 查询列表，带分页
	 * @param userInfo
	 * @return
	 */
	public List<IDataObject> queryList(IDataObject object , Pager page);
	
	/**
	 * 查询数量
	 * @param userInfo
	 * @return
	 */
	public Integer count(IDataObject object);
	
	/**
	 * 删除
	 * @param UserInfo
	 */
	public void delete(IDataObject object);
	
	/**
	 * 新增
	 * @param object
	 */
	public void insert(IDataObject object);
	
	/**
	 * 获取主建
	 * @return
	 */
	public Long querySequence();
}
