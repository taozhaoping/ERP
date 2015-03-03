/**
 * Copyright 2005-2009 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2009-12-25
 */
package com.zh.core.base.dao;

import java.util.List;
import javax.annotation.PostConstruct;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.zh.core.exception.ProjectException;
import com.zh.core.model.Pager;

/**
 * 数据库查询基础类
 * 
 * @author 50103
 * 
 */
public abstract class BaseDao<IdataObject> {

	private String namespace;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private static Logger Logger = LoggerFactory.getLogger(BaseDao.class); 
	
	/**
	 * 初始化方法,必需设置namespace
	 */
	@PostConstruct
	public abstract void init();

	/**
	 * 获取序列号
	 * @param sequenceName
	 * @return
	 * @throws AgileException 
	 */
	public Long getSequence(String sequenceName) throws ProjectException
	{
		try {
			return sqlSessionTemplate.selectOne(namespace + "sequence", sequenceName);
		} catch (RuntimeException e) {
			Logger.error("获取表序列号失败!");
			throw new ProjectException("获取表序列号失败");
		}
	}
	/**
	 * 插入数据
	 * 
	 * @param data
	 * @return
	 */
	public int insert(IdataObject data) {
		return sqlSessionTemplate.insert(namespace + "insert", data);
	}

	/**
	 * 删除数据
	 * 
	 * @param data
	 *            条件
	 * @return
	 */
	public int delete(IdataObject data) {
		return sqlSessionTemplate.delete(namespace + "delete", data);
	}

	/**
	 * 查询数据
	 * @param data
	 * @return
	 */
	public IdataObject query(IdataObject data) {
		return sqlSessionTemplate.selectOne(namespace + "select", data);
	}
	
	/**
	 * 查询数据
	 * @param data
	 * @return
	 */
	public IdataObject query(String sqlId , IdataObject data) {
		return sqlSessionTemplate.selectOne(namespace + sqlId, data);
	}

	/**
	 * 查询数据列表
	 * @param data
	 * @return
	 */
	public List<IdataObject> queryList(IdataObject data)
	{
		return queryList("list", data);
	}
	
	/**
	 * 查询数据列表
	 * @param sqlID
	 * @param data
	 * @return
	 */
	public List<IdataObject> queryList(String sqlID , IdataObject data)
	{
		return sqlSessionTemplate.selectList(namespace + sqlID, data);
	}
	
	public List<IdataObject> queryPageList(IdataObject data,Pager page) throws ProjectException
	{
		return selectPageList("list", data, page);
	}
	
	
	/**
	 * 根据权限查询列表(创建者、或者审批者)
	 * @param data
	 * @param page
	 * @return 根据权限查询出来的流程列表
	 * @throws ProjectException
	 */
	public List<IdataObject> queryPageListByPermission(IdataObject data,Pager page) throws ProjectException{
		return selectPageList("listByPermission", data, page);
	}
	
	public List<IdataObject> selectPageList(String sqlID ,IdataObject data,Pager page) throws ProjectException
	{
		if( null == page )
		{
			Logger.error("pager class not is null !");
			throw  ProjectException.createException("pager class not is null !");
		}
		return sqlSessionTemplate.selectList(namespace + sqlID, data, page.getRowBounds());
	}
	/**
	 * 修改数据
	 * @param data
	 * @return
	 */
	public int update(IdataObject data) 
	{
		return sqlSessionTemplate.update(namespace + "update", data);
	}
	
	
	
	/**
	 * 获取数据总数
	 * @param data
	 * @return
	 */
	public int count(IdataObject data) {
		return sqlSessionTemplate.selectOne(namespace + "count", data);
	}

	/**
	 * 根据)权限获取数据总数，创建者和当前审批者
	 * @param data
	 * @return
	 */
	public int countByPermission(IdataObject data) {
		return sqlSessionTemplate.selectOne(namespace + "countByPermission", data);
	}

	/**
	 * 获取数据总数
	 * @param data
	 * @return
	 */
	public int count(String sqlId,IdataObject data) 
	{
		return sqlSessionTemplate.selectOne(namespace + sqlId, data);
	}
	
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace + ".";
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}