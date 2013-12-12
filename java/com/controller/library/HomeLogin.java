package com.controller.library;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.library.UserData;

public class HomeLogin extends HttpServlet {

	private static final long serialVersionUID = -4682581645999243786L;
	
	private String tpl_attr_action = "login";
	private String tpl_attr_actstr = "登录";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		index(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", tpl_attr_actstr);
		
		try {
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
