package com.ymsli.mvc.web.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DbDriverListner implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		String driverName = sce.getServletContext().getInitParameter("jdbc.driver");
		try {
			Class.forName(driverName);
			System.out.println("Class Loaded ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}
