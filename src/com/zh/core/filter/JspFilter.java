package com.zh.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zh.core.model.VariableUtil;
import com.zh.core.util.PropertiesUtil;

public class JspFilter implements Filter  {

	
	// 跳转的登陆地址
	private static String redirectURL = PropertiesUtil
			.get(VariableUtil.FORWARD_URL);
	
	// 跳转的主页地址
	private static String mainURL = PropertiesUtil
			.get(VariableUtil.MAIN_URL);
	
	public void destroy() {
		
	}

	@SuppressWarnings("unused")
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		if(request.getRequestURI().endsWith(".jsp"))
		{
			String url = redirectURL;
			if(session.getAttribute(VariableUtil.SESSION_KEY) != null) {
				url = mainURL;
			}
			return;
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
