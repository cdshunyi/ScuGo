package com.controller.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.library.GoodsCatalogAction;

public class HomeIndex extends HttpServlet {

	private static final long serialVersionUID = -5250988675841810033L;
	
	private String tpl_attr_action = "index";
	private String tpl_attr_actstr = "首页";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", tpl_attr_actstr);
		
		index(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) {

		ArrayList<HashMap<String, Object>> tpl_attr_catalog_roots = GoodsCatalogAction.findRoots();
		
		request.setAttribute("tpl_attr_catalog_roots", tpl_attr_catalog_roots);
		
		try {
			request.getRequestDispatcher("/index/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
