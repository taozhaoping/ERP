/**
 * Copyright 2005-2010 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2010-12-01
 */
package com.zh.core.validatecode.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.util.CookieManager;
import com.zh.core.util.GlobEnv;
import com.zh.core.util.StringUtil;
import com.zh.core.validatecode.model.ValidateCode;
import com.zh.core.validatecode.service.ValidateImageManager;

/**
 * 图形验证码 Action
 * 
 * 
 * @author Flouny.Caesar
 *
 */
public class ValidateCodeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用于保存已经生成的图形验证码输入流对象，以便在前台显示图形
	 */
	private ByteArrayInputStream inputStream;

	/**
	 * 图形验证码创建接口
	 */
	@Autowired
	private ValidateImageManager validateImageManager;
	
	
	private ValidateCode vc = new ValidateCode();
	
	private Map<String,String> dataMap = new HashMap<String, String>();
	
	/**
	 * 生成验证码
	 * 
	 * <img src="http://xxxxxxxxx:xxxx/validatecode/validate!execute.jspa" />
	 * 
	 */
	public String execute() {
		CookieManager cookie = new CookieManager(this.getRequest(), this.getResponse());
		try {
			cookie.addCookie("validateCode", createInputStream(ValidateImageManager.DISTURB_TYPE_DEFAULT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * ajax刷新验证码
	 */
	public String showValidateCode() {
		dataMap.put("imgUrl", GlobEnv.get("validate.code.path") + getRequest().getSession().getId()+ "&random=" + new Date().getTime());
		return Action.RETURN_JSON;
	}
	/**
	 * 检查验证码是否正确
	 * 
	 * http://xxxxxxxxx:xxxx/validatecode/validate!checkCode.jspa?code=xxxxxx
	 * 
	 * @return
	 */
	public String checkCode() {
		CookieManager cookie = new CookieManager(this.getRequest(), this.getResponse());
		String code = cookie.getCookieValue("validateCode");
		if (StringUtil.isBlank(code) || !code.toUpperCase().equals(vc.getCode().toUpperCase())) {
			setReturnJSON("false");
		} else {
			setReturnJSON("true");
		}
		
		return Action.RETURN_JSON;
	}
	
	/**
	 * 在Action层创建图形验证码，并将创建好的图形字节流保存到inputStream对象中，并返回验证码
	 * @param disturbType 绘制干扰线的类型
	 *                    0：不绘制干扰线
	 *                    1：绘制单一色调的干扰线
	 *                    2：绘制复杂的干扰线
	 * @return 返回已经生成好的验证码字符
	 * @throws IOException 
	 */
	private String createInputStream(int disturbType) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		String validateCode = validateImageManager.createValidateCode(disturbType, 25, bos, 100, 20, getText("System.validateCode", ValidateImageManager.DEFAULT_VALIDATE_CODE), 4);  
		
		inputStream = new ByteArrayInputStream(bos.toByteArray());
		
		bos.close();
		
		return validateCode;
	}
	
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}	

	public ValidateCode getVc() {
		return vc;
	}

	public void setVc(ValidateCode vc) {
		this.vc = vc;
	}

	public Object getModel() {
		
		return vc;
	}
	
	public void setValidateImageManager(ValidateImageManager validateImageManager) {
		this.validateImageManager = validateImageManager;
	}
	public Map<String, String> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}
	
}