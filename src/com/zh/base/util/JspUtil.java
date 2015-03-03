package com.zh.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.zh.base.model.bean.User;
import com.zh.base.service.UserInfoService;

public class JspUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext; // Spring应用上下文环境
	
	private static UserInfoService userInfoService;
	
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
	}

	public static String queryUserName(String id) {
		getBean();
		if(null ==id)
		{
			return "";
		}
		User user = new User();
		user.setId(Integer.valueOf(id));
		User reult = userInfoService.query(user);
		return reult.getName();
	}
}
