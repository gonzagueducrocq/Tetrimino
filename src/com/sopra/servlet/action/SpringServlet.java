package com.sopra.servlet.action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class SpringServlet extends HttpServlet {

	public void init(ServletConfig config) {
		try {
		super.init(config);
		}
		catch (ServletException e) {
		e.printStackTrace();
		}
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		}
	
	
}
