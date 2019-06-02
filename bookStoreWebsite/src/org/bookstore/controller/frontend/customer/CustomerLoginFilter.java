package org.bookstore.controller.frontend.customer;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class CustomerLoginFilter implements Filter {

    public CustomerLoginFilter() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}
		
		
		
		boolean loggedIn = session != null && session.getAttribute("loggedCustomer") != null;
		
		if (!loggedIn && path.startsWith("/view_profile")) {
			String loginPage = "frontend/login.jsp";
			RequestDispatcher requestDispatcher = httpRequest.getRequestDispatcher(loginPage);
			requestDispatcher.forward(request, response);
		}else {
		chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
