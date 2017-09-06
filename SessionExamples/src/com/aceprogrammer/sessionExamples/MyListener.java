package com.aceprogrammer.sessionExamples;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements HttpSessionListener {

	ServletContext servletContext = null;
	static int totalUsers = 0, currentUsers = 0;

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		totalUsers++;
		currentUsers++;

		System.out.println("Inside sessionCreated method");
		servletContext = httpSessionEvent.getSession().getServletContext();
		servletContext.setAttribute("totalUsers", totalUsers);
		servletContext.setAttribute("currentUsers", currentUsers);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		currentUsers--;
		System.out.println("Inside destroy session");
		servletContext.setAttribute("currentUsers", currentUsers);
	}

}
