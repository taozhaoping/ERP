package com.zh.base.service;

import java.util.List;

import com.zh.base.model.bean.Dictionary;

/**
 * 
* @Title: DictionaryService.java 
* @Package com.zh.base.service 
* @Description: 数据库字典
* @date 2015年3月25日 下午3:35:22 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface DictionaryService {
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Dictionary query(Dictionary dictionary);
	
	/**
	 * 根据传入的类型返回数据
	* @Title: queryList 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param  @param typeid
	* @param  @return   参数 
	* @return List<Dictionary>    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public List<Dictionary> queryList(Integer typeid);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Dictionary> queryList(Dictionary dictionary);
	
	/**
	 * 查询用户列表，返回json格式
	 * @param user
	 * @return
	 */
	public String queryListJson(Dictionary dictionary);
	
	
}
