/**
 * Copyright 2005-2010 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2010-12-01
 */
package com.zh.core.validatecode.service.impl;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.zh.core.util.GlobEnv;
import com.zh.core.util.StringUtil;
import com.zh.core.validatecode.service.ValidateCodeService;

/**
 * 验证码服务接口
 * @author Flouny.Caesar
 *
 */
@Component("validateCodeService")
public class ValidateCodeServiceImpl implements ValidateCodeService {
	
	private Logger LOG = Logger.getLogger(ValidateCodeServiceImpl.class);
	
	/**
	 * 检查验证码是否正确
	 * @param sessionID
	 * @param code
	 * @return
	 */
	public boolean isCheckValidateCode(String sessionID, String code) {
		String url = GlobEnv.get("check.validate.code") + "sessionID=" + sessionID + "&code=" + code;
		
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 30000);
		client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
		
		try {
			if (client.executeMethod(getMethod) != HttpStatus.SC_OK) throw new RuntimeException("check validateCode error!");
			
			String temp = getMethod.getResponseBodyAsString();
			
			return (StringUtil.isNotBlank(temp) && "true".equals(temp))?true : false;
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			
			return false;
		} finally {
			getMethod.releaseConnection();
		}
	}
}