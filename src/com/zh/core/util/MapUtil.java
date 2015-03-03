/**
 * Copyright 2005-2009 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2009-12-25
 */
package com.zh.core.util;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.collections.MapUtils;

/**
 * Map处理的工具类
 * @author Flouny.Caesar
 *
 */
public class MapUtil extends MapUtils {
	
	/**
	 * 将一个Bean转换成Map
	 * @param data
	 * @return
	 */
	public static Map<Object, Object> populateMap(Object data) {
		
		return populateMap(new HashMap<Object, Object>(), data);
	}
	
	/**
	 * 将一个Bean转换成Map
	 * @param map
	 * @param data
	 * @return
	 */
	public static Map<Object, Object> populateMap(Map<Object, Object> populateMap, Object data) {
		if (populateMap == null || data == null) throw new RuntimeException("populateMap and data is not empty!");
		
		BeanUtilsBean beanUtil = BeanUtilsBean.getInstance();
		PropertyDescriptor[] pds = beanUtil.getPropertyUtils().getPropertyDescriptors(data);
		try {
			for (PropertyDescriptor pd : pds) {
				if ("class".equals(pd.getName())) continue;
				
				String name = pd.getName();
				Object value = beanUtil.getPropertyUtils().getSimpleProperty(data, name);
				populateMap.put(name, value);
			}
		} catch (Exception e) {
			
			throw new RuntimeException("Unable to get the value of the object!");
		}
		
		return populateMap;
	}
}