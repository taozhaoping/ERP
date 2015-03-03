package com.zh.core.common;

public interface SqlCommon {

	public String SQL_SELECT = "select";
	
	public String SQL_CREATE = "create";
	
	public String SQL_UPDATE = "update";
	
	public String SQL_DELETE = "delete";
	
	//当用户字段isDelete为1的时候，标示逻辑删除
	public String USER_IS_DELETE ="1";
	
	public String USER_NOT_DELETE = "0";
	
	/**
	 * 验证用户是否登录
	 */
	public String SQL_QUERY_USER = "queryUser";
	
	
}
