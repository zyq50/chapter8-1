package com.bbas.Filter1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MyFilter1
 */
@WebFilter("/OrderServlet")
public class MyFilter1 implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest request1 =(HttpServletRequest)request;
		String username = (String) request1.getSession().getAttribute("username");
		if(username ==null){
			request1.getRequestDispatcher("/login.jsp").forward(request1, response);
			return;
		}
		else{
			request1.getRequestDispatcher("/order.jsp").forward(request1, response);
}
		chain.doFilter(request1, response);
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
