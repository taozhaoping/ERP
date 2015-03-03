/**
 * Copyright 2005-2009 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2009-12-25
 */
package com.zh.core.base.action;

/**
 * 
 * @author Flouny.Caesar
 *
 */
public interface Action extends com.opensymphony.xwork2.Action {
	
	/**
	 * 返回JSON文本
	 */
	public final static String RETURN_JSON = "json";
	
	public final static String SUCCESS = "success";
	
	public final static String EDITOR = "editor";
	
	public final static String EDITOR_SUCCESS = "editorSuccess";
	
	public final static String JSON_ERROR = "json_error";
	
	public final static String FORM_ERROR = "form_error";
}