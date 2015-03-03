/**
 * Copyright 2005-2012 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2010-12-01
 */

package com.zh.core.interceptor;

import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zh.core.model.VariableUtil;
import com.zh.core.util.PropertiesUtil;

/**
 * 登录拦截器
 * 
 * @author Flouny.Caesar
 * 
 */
public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String forwardUrl = PropertiesUtil
			.get(VariableUtil.FORWARD_URL);

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx
				.get(ServletActionContext.HTTP_RESPONSE);
		String servletPath = request.getServletPath();
		// String forwardUrl = PropertiesUtil.get(VariableUtil.FORWARD_URL);
		// 如果请求的路径与forwardUrl相同，或请求的路径是排除的URL时，则直接放行
		if (servletPath.equals(forwardUrl)) {
			return invocation.invoke();
		}

		Object sessionObj = request.getSession().getAttribute(
				VariableUtil.SESSION_KEY);
		// 如果Session为空，则跳转到指定页面
		if (sessionObj == null) {
			String contextPath = request.getContextPath();
			String redirect = servletPath + "?"
					+ StringUtils.defaultString(request.getQueryString());
			/*
			 * login.jsp 的 <form> 表单中新增一个隐藏表单域： <input type="hidden"
			 * name="redirect" value="${param.redirect }">
			 * 
			 * LoginServlet.java 的 service 的方法中新增如下代码： String redirect =
			 * request.getParamter("redirect"); if(loginSuccess){ if(redirect ==
			 * null || redirect.length() == 0){ // 跳转到项目主页（home.jsp） }else{ //
			 * 跳转到登录前访问的页面（java.net.URLDecoder.decode(s, "UTF-8")） } }
			 */
			response.sendRedirect(contextPath
					+ StringUtils.defaultIfEmpty(forwardUrl, "/")
					+ "?redirect=" + URLEncoder.encode(redirect, "UTF-8"));
		} else {
			return invocation.invoke();
		}
		/*
		 * CookieManager cookie = new CookieManager(request, response); String
		 * email = cookie.getCookieValue("itjob_email"); String company_email =
		 * cookie.getCookieValue("company_email"); if
		 * (StringUtil.isNotBlank(email) && (userInfoService.getUserInfo(email)
		 * != null)) { return invocation.invoke(); }else
		 * if(StringUtil.isNotBlank(company_email)){ return invocation.invoke();
		 * } cookie.addCookie("itjob_sign", "itjob_sign");
		 */
		return "returnLogin";
	}
}