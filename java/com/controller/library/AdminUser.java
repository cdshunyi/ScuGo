package com.controller.library;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.library.UserDataAction;
import com.bean.library.UserData;

public class AdminUser extends HttpServlet {

	private static final long serialVersionUID = -6593546167416123562L;
	
	private String tpl_attr_action = "user";
	private String tpl_attr_actstr = "用户";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", tpl_attr_actstr);
		
		index(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) {
		
		String tpl_attr_method = "index";
		String tpl_attr_metstr = "用户管理";
		String tpl_script_js = "TableManaged.init();";
		
		ArrayList<String> tpl_include_js = new ArrayList<String>();
		tpl_include_js.add("table-user-index.js");
		
		request.setAttribute("tpl_attr_method", tpl_attr_method);
		request.setAttribute("tpl_attr_metstr", tpl_attr_metstr);
		request.setAttribute("tpl_include_js", tpl_include_js);
		request.setAttribute("tpl_script_js", tpl_script_js);
		
		ArrayList<UserData> tpl_attr_udata_list = UserDataAction.getAllUsersData();
		request.setAttribute("tpl_attr_udata_list", tpl_attr_udata_list);
		
		try {
			request.getRequestDispatcher("/admin/user_index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
