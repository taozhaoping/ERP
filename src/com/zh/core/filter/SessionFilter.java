package com.zh.core.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
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

/**
 * 用于检查用户是否登录了系统的过滤器<br>
 * 创建日期：2012-01-09
 * 
 * @author <a href="mailto:hemingwang0902@126.com">何明旺</a>
 */
public class SessionFilter implements Filter {

	protected FilterConfig filterConfig = null;

	// 跳转的登陆地址
	private static String redirectURL = PropertiesUtil
			.get(VariableUtil.FORWARD_URL);

	// 不需要检查的地址列表
	private Set<String> notCheckURLList = new HashSet<String>();

	public void destroy() {
		notCheckURLList.clear();
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		if ((!checkRequestURIIntNotFilterList(request))
				&& session.getAttribute(VariableUtil.SESSION_KEY) == null) {
			response.sendRedirect(request.getContextPath() + "/" + redirectURL);
			return;
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	/**
	 * 检查不需要过滤的地址
	 * @param request
	 * @return
	 */
	private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {
		String uri = request.getServletPath()
				+ (request.getPathInfo() == null ? "" : request.getPathInfo());
		String temp = request.getRequestURI();
		temp = temp.substring(request.getContextPath().length() + 1);
		return notCheckURLList.contains(uri);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		String notCheckURLListStr = filterConfig
				.getInitParameter("notCheckURLList");
		if (notCheckURLListStr != null) {
			String[] params = notCheckURLListStr.split(",");
			for (int i = 0; i < params.length; i++) {
				notCheckURLList.add(params[i].trim());
			}
		}
	}
}