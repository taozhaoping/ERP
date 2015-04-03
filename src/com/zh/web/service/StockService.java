package com.zh.web.service;

import java.util.List;
import com.zh.core.model.Pager;
import com.zh.web.model.bean.Stock;

/**
* @Title: StockService.java 
* @Package com.zh.base.service 
* @Description: 存库接口
* @date 2015年3月25日 下午7:41:39 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface StockService {

	/**
	 * 库位号
	 */
	public static final String SEQUENCE_POSITION = "SEQUENCE_POSITION";
	
	/**
	 * 查询信息
	 * @param 
	 * @return
	 */
	public Stock query(Stock stock);
	
	/**
	 * 修改
	 * @param 
	 */
	public void update(Stock stock);
	
	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<Stock> queryList(Stock stock);
	
	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<Stock> queryList(Stock stock , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(Stock stock);
	
	/**
	 * 删除
	 * @param 
	 */
	public void delete(Stock stock);
	
	/**
	 * 新增
	 * @param 
	 */
	public Integer insert(Stock stock);
}
