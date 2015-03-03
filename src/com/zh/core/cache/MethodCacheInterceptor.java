package com.zh.core.cache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

public class MethodCacheInterceptor implements MethodInterceptor,
		InitializingBean {
	private static final Log logger = LogFactory
			.getLog(MethodCacheInterceptor.class);

	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public MethodCacheInterceptor() {
		super();
	}

	/**
	 * 
	 * 
	 * 拦截Service/DAO的方法，并查找该结果是否存在，如果存在就返回cache中的值， 否则，返回数据库查询结果，并将查询结果放入cache
	 */
	@SuppressWarnings("deprecation")
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String targetName = invocation.getThis().getClass().getName();
		Object[] arguments = invocation.getArguments();
		Object result;
		logger.debug("Find object from cache is " + cache.getName());
		String cacheKey = getCacheKey(targetName, arguments);
		Element element = cache.get(cacheKey);

		if (element == null) {
			logger.debug("Hold up method , Get method result and create cache........!");
			result = invocation.proceed();
			if (null == result)
			{
				return null;
			}
			element = new Element(cacheKey, (Serializable) result);
			cache.put(element);
		}
		return element.getValue();
	}

	/**
	 * 
	 * 
	 * 获得cache key的方法，cache key是Cache中一个Element的唯一标识 cache key包括
	 * 包名+类名+方法名，如com.co.cache.service.UserServiceImpl.getAllUser
	 */
	private String getCacheKey(String targetName,
			Object[] arguments) {
		StringBuffer sb = new StringBuffer();
		sb.append(targetName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				sb.append(".").append(arguments[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * 
	 * implement InitializingBean，检查cache是否为空
	 */
	public void afterPropertiesSet() throws Exception {

	}

	public Cache getCache() {
		return cache;
	}


}