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

import java.util.ResourceBundle;

/**
 * 读取placeholder.properties资源
 * 
 * @author Flouny.Caesar
 *
 */
public class PropertiesUtil {
	
	protected static ResourceBundle res;
	protected static final String SERVER_STATIC = "server.web";
	protected static final String GLOBAL_PROPERTIES_FILE = "jdbc";
	
	protected static final String FILE_LOAD_PATH = "upload.file.path";
	
	static {
		if (res == null) res = ResourceBundle.getBundle(GLOBAL_PROPERTIES_FILE);
	}
	
	public static String get(String key) {
		
		return res.getString(key);
	}
}