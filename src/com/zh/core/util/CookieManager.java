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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie管理器
 * @author Flouny.Caesar
 *
 */
public class CookieManager {
	
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpServletResponse response;
	
	public CookieManager(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		response.setHeader("P3P", "CP=CAO PSA OUR");
	}
	
	public void addCookie(String cookieName, String cookieValue) {
		addCookie(cookieName, cookieValue, "");
	}
	
	public void addCookie(String cookieName, String cookieValue, String domain) {
		addCookie(cookieName, cookieValue, domain, "/");
	}
	
	public void addCookie(String cookieName, String cookieValue, String domain, String path) {
		addCookie(cookieName, cookieValue, domain, path, -1);
	}
	
	public void addCookie(String cookieName, String cookieValue, String domain, String path, int age) {
//		Cookie cookie = new Cookie(cookieName, cookieValue);
//		cookie.setPath(path);
//		cookie.setMaxAge(age);
//		cookie.setDomain(domain);
		this.request.getSession().setAttribute("code", cookieValue);
		//response.addCookie(cookie);
	}
	
	public String getCookieValue(String cookieName) {
		if (StringUtil.isBlank(cookieName)) return null;
		
		Cookie[] cookies = request.getCookies();
		
		String value = null;
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookieName.equals(cookie.getName())) {
					value = cookie.getValue();
				}
			}
		}
		
		return value;
	}
	
	public void deleteCookie(String cookieName) {
		if (StringUtil.isBlank(cookieName)) return;
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				cookie.setMaxAge(0);
				cookie.setPath("/");
			}
		}
	}
}