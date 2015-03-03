/**
 * Copyright 2005-2010 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2010-12-01
 */
package com.zh.core.validatecode.service;

/**
 * 验证码服务接口
 * @author Flouny.Caesar
 *
 */
public interface ValidateCodeService {
	
	/**
	 * 检查验证码是否正确
	 * @param sessionID
	 * @param code
	 * @return
	 */
	public boolean isCheckValidateCode(String sessionID, String code);
}