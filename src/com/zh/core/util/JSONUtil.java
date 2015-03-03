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

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zh.core.exception.ProjectException;
import com.zh.core.model.IDataObject;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

/**
 * 
 * @author Flouny.Caesar
 * 
 */
public class JSONUtil {

	private static Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class); 

	public static String object2json(Object obj) {
		LOGGER.debug("object2json()");
		StringBuilder json = new StringBuilder();
		if (obj == null) {
			json.append("\"\"");
		} else if (obj instanceof String || obj instanceof Integer
				|| obj instanceof Float || obj instanceof Boolean
				|| obj instanceof Short || obj instanceof Double
				|| obj instanceof Long || obj instanceof BigDecimal
				|| obj instanceof BigInteger || obj instanceof Byte) {
			json.append("\"").append(string2json(obj.toString())).append("\"");
		} else if (obj instanceof Date) {
			Date date = (Date)obj;
			json.append(date.getTime());
		} else if (obj instanceof Object[]) {
			json.append(array2json((Object[]) obj));
		} else if (obj instanceof List) {
			json.append(list2json((List<?>) obj));
		} else if (obj instanceof Map) {
			json.append(map2json((Map<?, ?>) obj));
		} else if (obj instanceof Set) {
			json.append(set2json((Set<?>) obj));
		} else {
			json.append(bean2json(obj));
		}
		return json.toString();
	}

	public static String bean2json(Object bean) {
		LOGGER.debug("bean2json()");
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = object2json(props[i].getName());
					String value = object2json(props[i].getReadMethod().invoke(
							bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	public static String list2json(List<?> list) {
		StringBuilder json = new StringBuilder();
		
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(object2json(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}
	
	public static String list2jsonRows(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(object2json(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String array2json(Object[] array) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (array != null && array.length > 0) {
			for (Object obj : array) {
				json.append(object2json(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String map2json(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if (map != null && map.size() > 0) {
			for (Object key : map.keySet()) {
				json.append(object2json(key));
				json.append(":");
				json.append(object2json(map.get(key)));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	public static String set2json(Set<?> set) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (set != null && set.size() > 0) {
			for (Object obj : set) {
				json.append(object2json(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String string2json(String s) {
		if (s == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				if (ch >= '\u0000' && ch <= '\u001F') {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
	
	public static Object[] jsonStringToarry(String key,String jsonString)
	{
		JSONArray jsonArray =JSONArray.fromObject(jsonString);
		List<String> dataString = new ArrayList<String>();
		for (Iterator<?> iterator = jsonArray.iterator(); iterator.hasNext();) {
			JSONObject object = JSONObject.fromObject(iterator.next());
				String id = object.get(key).toString();
				dataString.add(id.toString());
		}
		return dataString.toArray();
	}
	
	/**
	 *  json数组对象转换为list对象返回
	 * @param jsonString
	 * @param beanClass
	 * @return
	 * @throws AgileException
	 */
	public static List<IDataObject>  jsonArrToListObject(String jsonString,Class<?> beanClass) throws ProjectException
	{
		ArrayList<IDataObject> arrayList = new ArrayList<IDataObject>();
		if(null ==jsonString ||"".equals(jsonString))
		{
			LoggerUtil.error(LOGGER, "json String is null error!");
		}
		JSONArray arr = JSONArray.fromObject(jsonString);
		for (int i = 0; i < arr.size(); i++) {
			JSONObject obj= (JSONObject)arr.get(i);
			String[] dateFormats = new String[] {"yyyy-MM-dd"};    
			JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));   
			IDataObject advancedSearch = (IDataObject)JSONObject.toBean(obj, beanClass);
			arrayList.add(advancedSearch);
		}
		return arrayList;
	}
	
	/**
	 *  json数组对象转换为list对象返回
	 * @param jsonString
	 * @param beanClass
	 * @return
	 * @throws AgileException
	 */
	public static List<IDataObject>  jsonArrToListObject(String jsonString,Class<?> beanClass,Map<?, ?> classMap) throws ProjectException
	{
		ArrayList<IDataObject> arrayList = new ArrayList<IDataObject>();
		if(null ==jsonString ||"".equals(jsonString))
		{
			LoggerUtil.error(LOGGER, "json String is null error!");
		}
		JSONArray arr = JSONArray.fromObject(jsonString);
		for (int i = 0; i < arr.size(); i++) {
			JSONObject obj= (JSONObject)arr.get(i);
			IDataObject advancedSearch = (IDataObject)JSONObject.toBean(obj, beanClass,classMap);
			arrayList.add(advancedSearch);
		}
		return arrayList;
	}
}
