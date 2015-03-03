package com.zh.base.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zh.base.model.bean.Resourceinfo;
import com.zh.base.service.ResourceinfoService;

@Component("resourceInfoUtil")
public class ResourceInfoUtil implements BeanFactoryAware{

	private static Logger LOGGER = LoggerFactory
			.getLogger(ResourceInfoUtil.class);
	
	@Autowired
	private static ResourceinfoService resourceinfoService;
	
	private static BeanFactory beanFactory;
	
	private static ResourceInfoUtil resourceInfoUtil;
	
	@Override
	public void setBeanFactory(BeanFactory bean) {
		beanFactory = bean;
	}
	
	private ResourceInfoUtil()
	{
	
	}
	
	@SuppressWarnings("static-access")
	public synchronized static ResourceInfoUtil getInstance() {
		
		if(null == resourceInfoUtil){
			resourceInfoUtil = (ResourceInfoUtil)beanFactory.getBean("resourceInfoUtil");
			resourceInfoUtil.setResourceinfoService((ResourceinfoService)beanFactory.getBean("resourceinfoService"));
		}
		return resourceInfoUtil;
	}

	public static List<Resourceinfo> typeQueryList(String type) {
		LOGGER.debug("typeQueryList()");
		List<Resourceinfo> list = new ArrayList<Resourceinfo>();
		if (null == type || "".equals(type)) {
			return list;
		}
		Resourceinfo resourceinfo = new Resourceinfo();
		resourceinfo.setType(type);
		list = resourceinfoService.queryList(resourceinfo);
		return list;
	}
	
	public static Resourceinfo queryResoure(Integer id)	{
		LOGGER.debug("queryResoure()");
		Resourceinfo resourceinfo = new Resourceinfo();
		if(null == id)
		{
			return resourceinfo;
		}
		resourceinfo.setId(id);
		return resourceinfoService.query(resourceinfo);
	}

	public static ResourceinfoService getResourceinfoService() {
		return resourceinfoService;
	}

	public static void setResourceinfoService(
			ResourceinfoService resourceinfoService) {
		ResourceInfoUtil.resourceinfoService = resourceinfoService;
	}

	public static ResourceInfoUtil getResourceInfoUtil() {
		return resourceInfoUtil;
	}

	public static void setResourceInfoUtil(ResourceInfoUtil resourceInfoUtil) {
		ResourceInfoUtil.resourceInfoUtil = resourceInfoUtil;
	}

	
}
