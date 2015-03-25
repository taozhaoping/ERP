package com.zh.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.zh.base.model.bean.BasiType;
import com.zh.base.model.bean.Dictionary;
import com.zh.base.model.bean.User;
import com.zh.base.service.BasiTypeService;
import com.zh.base.service.DictionaryService;
import com.zh.base.service.UserInfoService;

public class JspUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext; // Spring应用上下文环境
	
	private static UserInfoService userInfoService;
	
	private static BasiTypeService basiTypeService;
	
	private static DictionaryService dictionaryService;
	
	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 * 
	 * @param applicationContext
	 * @throws BeansException
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		JspUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object 一个以所给名字注册的bean的实例
	 * @throws BeansException
	 */
	public synchronized static void getBean() throws BeansException {
		if(null == userInfoService)
		{
			userInfoService = (UserInfoService) applicationContext.getBean("userInfoService");
		}
		
		if(null == basiTypeService)
		{
			basiTypeService = (BasiTypeService) applicationContext.getBean("basiTypeService");
		}
		
		if(null == dictionaryService)
		{
			dictionaryService = (DictionaryService) applicationContext.getBean("dictionaryService");
		}
	}

	public static String queryUserName(String id) {
		
		if(null ==id)
		{
			return "";
		}
		User user = new User();
		user.setId(Integer.valueOf(id));
		User reult = userInfoService.query(user);
		return reult.getName();
	}
	
	/**
	* @Title: queryBasiType 
	* @Description: 查询基础类型资料
	* @param  @param id
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public static String queryBasiType(String id)
	{
		if(null ==id)
		{
			return "";
		}
		
		BasiType basiType = new BasiType();
		basiType.setId(Integer.valueOf(id));
		BasiType reult = basiTypeService.query(basiType);
		if (reult ==null)
		{
			return "";
		}else
		{
			return reult.getName();
		}
	}
	
	/**
	 * 
	* @Title: queryDictionary 
	* @Description: 查询数据库字典
	* @param  @param id
	* @param  @return   参数 
	* @return String    返回类型 
	* @throws 
	* @author taozhaoping 26078
	* @author mail taozhaoping@gmail.com
	 */
	public static String queryDictionary(String id)
	{
		if(null ==id)
		{
			return "";
		}
		
		Dictionary dictionary = new Dictionary();
		dictionary.setBasiTypeID(Integer.valueOf(id));
		Dictionary reult = dictionaryService.query(dictionary);
		if (reult ==null)
		{
			return "";
		}else
		{
			return reult.getDescr();
		}
	}
}
