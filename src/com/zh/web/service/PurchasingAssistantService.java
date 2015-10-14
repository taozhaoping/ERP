package com.zh.web.service;

import java.util.List;

import com.zh.core.model.Pager;
import com.zh.web.model.bean.PurchaseOrderPrimary;
import com.zh.web.model.bean.PurchasingAssistant;

/**
 * 
* @Description: 采购助理接口 
* @Title: PurchasingAssistantService.java 
* @Package com.zh.web.service 
* @date 2015年10月14日 下午1:36:41 
* @author taozhaoping 26078
* @author mail taozhaoping@gmail.com
* @version V1.0
 */
public interface PurchasingAssistantService {

	/**
	 * 查询列表
	 * @param 
	 * @return
	 */
	public List<PurchasingAssistant> queryList(PurchasingAssistant purchasingAssistant);

	/**
	 * 查询列表，带分页
	 * @param 
	 * @return
	 */
	public List<PurchasingAssistant> queryList(PurchasingAssistant purchasingAssistant , Pager page);
	
	/**
	 * 查询数量
	 * @param 
	 * @return
	 */
	public Integer count(PurchasingAssistant purchasingAssistant);
}
