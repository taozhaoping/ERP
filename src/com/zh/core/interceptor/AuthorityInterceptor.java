package com.zh.core.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zh.core.model.VariableUtil;

/**
 * 权限验证拦截器
 * @author 陶照平
 *  email : taozhaoping@gmail.com
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		String servletPath = request.getServletPath();
		String actionName = servletPath.substring(servletPath.lastIndexOf("/")+1,servletPath.lastIndexOf("."));
		if(actionName.contains("!"))
		{
			actionName = actionName.substring(0,actionName.lastIndexOf("!"));
		}
		
		//所有action名字为main的都不验证,interface为接口方法，也不验证
		if("main".equals(actionName) || "interface".equals(actionName))
		{
			return invocation.invoke();
		}
		List<String> authoritySession = (List<String>)request.getSession().getAttribute(
				VariableUtil.AUTHORITY);
		if(null != authoritySession && authoritySession.contains(actionName))
		{
			return invocation.invoke();
		}
		request.setAttribute("errorMsg", "没有访问当前功能的权限!");
		return "error";
	}



}
