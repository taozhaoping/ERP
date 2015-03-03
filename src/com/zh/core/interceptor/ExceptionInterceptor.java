package com.zh.core.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zh.core.exception.ProjectException;

/**
 * 统一异常处理拦截器
 * 
 * @author Administrator
 * 
 */
public class ExceptionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7012910296047970894L;

	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(ExceptionInterceptor.class); 

	@Override
	public String intercept(ActionInvocation actioninvocation) throws Exception {
		String result = null; // Action的返回值
		try {
			// 运行被拦截的Action,期间如果发生异常会被catch住
			result = actioninvocation.invoke();
			return result;
		} catch (Exception e) {
			/**
			 * 处理异常
			 */
			String errorMsg;
			// 通过instanceof判断到底是什么异常类型
			if (e instanceof ProjectException) {
				ProjectException be = (ProjectException) e;
				errorMsg = be.getManager();
				
				LOGGER.error(be.getManager());
				
			} else if (e instanceof RuntimeException) {
				// 未知的运行时异常
				RuntimeException re = (RuntimeException) e;
				errorMsg = re.getMessage();
				re.printStackTrace();
				LOGGER.error(re.getMessage());
			} else {
				// 未知的严重异常
				e.printStackTrace();
				LOGGER.error(e.getMessage());
				errorMsg = e.getMessage();
			}
			// 把自定义错误信息
			HttpServletRequest request = (HttpServletRequest) actioninvocation
					.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);

			/**
			 * 发送错误消息到页面
			 */
			request.setAttribute("errorMsg", errorMsg);

			//LOGGER.error(errorMsg, e);


			return "error";
		}// ...end of catch
	}

}
