package com.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.library.GoodsCatalogAction;
import com.bean.library.GoodsCatalog;

public class HomeFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)servletRequest;  
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession(false);
		
		ArrayList<GoodsCatalog> rootCatalogs = GoodsCatalogAction.findCatalogByParent(0);
		
		if (session != null && session.getAttribute("user_data") != null) {
			servletRequest.setAttribute("is_login", true);
			servletRequest.setAttribute("user_data", session.getAttribute("user_data"));
		}
		servletRequest.setAttribute("root_catalogs", rootCatalogs);
		
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
