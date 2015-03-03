package com.zh.core.cache;

import java.util.List;

import net.sf.ehcache.Cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.InitializingBean;

public class MethodCacheAfterAdvice implements AfterReturningAdvice,
		InitializingBean {
	private static final Log logger = LogFactory
			.getLog(MethodCacheAfterAdvice.class);

	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public MethodCacheAfterAdvice() {
		super();
	}

	public void afterPropertiesSet() throws Exception {

	}

	public void afterReturning(Object returnValue,
			java.lang.reflect.Method method, Object[] args, Object classObj)
			throws Throwable {
		logger.debug("afterReturning()");
		String className = classObj.getClass().getName();
		String cacheKey = getCacheKey(className, args);
		List<?> list = cache.getKeys();
		if(list.contains(cacheKey))
		{
			cache.remove(cacheKey);
		}
	}
	
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

}
