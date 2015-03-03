package com.zh.core.interceptor;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zh.core.util.RandomGUIDUtil;

/**
 * form表单重复提交拦截器 ，以下是使用方法
 * <input type="hidden" name="token" value="${token}"/><!-- 防止重复提交所用--> 
 * @author Administrator
 *
 */
public class TokenAtionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();

		HttpServletRequest request = ServletActionContext.getRequest();

		String strGUID = RandomGUIDUtil.newGuid();

		// 生成令牌
		String strRequestToken = (String) session.get("request_token");

		// 取出会话中的令牌
		String strToken = request.getParameter("token");

		// 页面中的令牌
		if (strRequestToken != null && strToken != null

		&& !strRequestToken.equals(strToken)) {
			// 重复提交，重置yi令牌
			session.put("request_token", strGUID);
			request.setAttribute("token", strGUID);
			request.setAttribute("errorMsg", "重复提交表单");
			return "error";

		}

		session.put("request_token", strGUID);

		request.setAttribute("token", strGUID);

		return invocation.invoke();
		// 否则正常运行

	}

}
