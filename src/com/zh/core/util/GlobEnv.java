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


/**
 * 获取静态/动态资源
 * @author Flouny.Caesar
 *
 */
public class GlobEnv extends PropertiesUtil {
	
	private static String PATH = "";
	/**
	 * 获取静态根目录资源
	 * @return
	 */
	public static String getStaticRoot() {
		String rootPath = get(SERVER_STATIC);
		if (StringUtil.isBlank(rootPath)) return null;
		
		StringBuffer buffer = new StringBuffer();
		
		if(rootPath.startsWith("http://")) {
			buffer.append(rootPath.substring(0, rootPath.indexOf("//") + 2));
			String start = rootPath.substring(rootPath.indexOf("//") + 2);
			if (start.indexOf("/") != -1) {
				buffer.append(start.substring(0, start.indexOf("/")));
			} else {
				buffer.append(start + "/");
			}
		}
		
		return buffer.toString();
	}
	
	/**
	 * 获取静态资源
	 * @param path
	 * @return
	 */
	public static String getStaticURL(String path) {
		if("".equals(PATH))
		{
			PATH = System.getProperty("webapp.root");
		}
		return PATH.concat(path);
	}
	
	
	/**
	 * 获取资源路径
	 * @param prefixPath
	 * @return
	 */
	public static String getPath(String prefixPath) {
		if (StringUtil.isBlank(prefixPath)) return null;
		
		return get(prefixPath);
	}
	
	@SuppressWarnings("unused")
	private static String getURL(String base, String path) {
		if (StringUtil.isBlank(base)) return null;
		
		if (StringUtil.isNotBlank(base) && StringUtil.isBlank(path)) return base;
		
		String url = null;
		if (base.endsWith("/") && !path.startsWith("/")) {
			url = base + path;
		} else if (!base.endsWith("/") && path.startsWith("/")) {
			url = base + path;
		} else if (base.endsWith("/") && path.startsWith("/")) {
			base = base.substring(0, base.length() - 1);
			url = base + path;
		} else if (!base.endsWith("/") && !path.startsWith("/")) {
			url = base + "/" + path;
		}
		
		return url;
	}
	
	/**
	 * 获取上传文件保存目录
	 * @return
	 */
	public static StringBuffer getUploadFilePath()
	{
		String fileDiv = get(FILE_LOAD_PATH);
		StringBuffer filePath = new StringBuffer(fileDiv);
		if(!fileDiv.endsWith("//"))
		{
			filePath.append("//");
		}
		return filePath;
	}
	
	public static String getUploadFilePath(String numberID)
	{
		return get(numberID);
	}
}