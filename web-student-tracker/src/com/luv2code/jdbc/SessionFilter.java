package com.luv2code.jdbc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(urlPatterns = { "/list-students.jsp", "/update-student-form.jsp", "/add-student-form.jsp",
		"/StudentControllerServlet",
		"/StudentControllerServlet?command=LIST" }, servletNames = { "StudentControllerServlet" })
public class SessionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SessionFilter() {
		System.out.println("Session filter started");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Inside do filter");

		// downcast request and response
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		// check if user is logged in or
		HttpSession httpSession = httpServletRequest.getSession();
		System.out.println(httpSession);
		System.out.println(httpSession.getAttribute("user"));
		if ((httpSession.getAttribute("user") == null)) {
			System.out.println("Sorry you cannot access this webpage");
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp?message=NOACCESS");
			httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			httpServletResponse.setDateHeader("Expires", 0);
		} else {

			// pass the request along the filter chain
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("SessionFilter destroyed");
	}

}
