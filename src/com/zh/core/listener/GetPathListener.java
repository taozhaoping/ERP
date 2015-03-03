package com.zh.core.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class GetPathListener extends ContextLoaderListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		super.contextDestroyed(event);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
//		String webAppRootKey = event.getServletContext().getRealPath("/");
//		System.setProperty("webapp.root", webAppRootKey);
	}

	
}
