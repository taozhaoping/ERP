package com.zh.core.interceptor;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LanguageInterceptor extends AbstractInterceptor {

	/**
	 * 国际化切换
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		Locale sessionLocale = (Locale)session.getAttribute("WW_TRANS_I18N_LOCALE");
		if( null == sessionLocale)
		{
			sessionLocale = ctx.getLocale();
			session.setAttribute("WW_TRANS_I18N_LOCALE", sessionLocale);
			request.setAttribute("language", sessionLocale.toString());
			return invocation.invoke();
		}
		//HttpServletRequest request = ServletActionContext.getRequest();
		String language = request.getParameter("language");

		if (null != language
				&& !sessionLocale.equals(language)) {
			Locale locale;
			if (language.equals("en_US")) {

				locale = new Locale("en", "US");
			} else {
				locale = new Locale("zh", "CN");
			}
			sessionLocale = locale;
			session.setAttribute("WW_TRANS_I18N_LOCALE",
					locale);
		}
		session.setAttribute("language", sessionLocale.toString());
		return invocation.invoke();
	}

}
