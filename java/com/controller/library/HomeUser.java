package com.controller.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.library.SystemUtils;
import com.action.library.UserDataAction;
import com.bean.library.UserData;

public class HomeUser extends HttpServlet {

	private static final long serialVersionUID = -7292711163678701875L;
	
	private String m;		// 操作方法
	private String path;	// 访问路径
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		m = request.getParameter("m");
		path = request.getRequestURI();
		
		if (m.equals("login")) {
			loginGet(request, response);
		}
		else if (m.equals("logout")) {
			logoutGet(request, response);
		}
		else if (m.equals("register")) {
			registerGet(request, response);
		}
		// TODO 其他User方法
		else {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		m = request.getParameter("m");
		path = request.getRequestURI();
		
		if (m.equals("login")) {
			loginPost(request, response);
		}
		else if (m.equals("register")) {
			registerPost(request, response);
		}
	}
	
	/**
	 * 显示登录页面
	 * @param request
	 * @param response
	 */
	private void loginGet(HttpServletRequest request, HttpServletResponse response) {
		
		String tpl_attr_action = "login";
		String tpl_attr_actstr = "登录";
		
		if (request.getSession().getAttribute("user_data") != null) {
			try {
				response.sendRedirect("index");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}

		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", tpl_attr_actstr);
		
		try {
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loginPost(HttpServletRequest request, HttpServletResponse response) {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		
		String tpl_login_error_msg = null;
		String tpl_login_attr_username = null;
		
		if (username.length() == 0 || !SystemUtils.usernameValidation(username)) {
			tpl_login_error_msg = new String("用户名输入错误！");
			request.setAttribute("tpl_login_error_msg", tpl_login_error_msg);
			loginGet(request, response);
			return;
		}
		else if (UserDataAction.findUserDataByUsername(username) == null) {
			tpl_login_error_msg = new String("用户名不存在！");
			request.setAttribute("tpl_login_error_msg", tpl_login_error_msg);
			loginGet(request, response);
			return;
		}
		else {
			UserData uData = UserDataAction.loginCheck(username, password);
			if (uData == null) {
				tpl_login_error_msg = new String("密码错误！");
				tpl_login_attr_username = username;
				request.setAttribute("tpl_login_error_msg", tpl_login_error_msg);
				request.setAttribute("tpl_login_attr_username", tpl_login_attr_username);
				loginGet(request, response);
				return;
			}
			else {
				request.getSession().setAttribute("user_data", uData);
				try {
					if (path.indexOf("/logout") > -1) {
						response.sendRedirect(path);
					}
					else {
						response.sendRedirect("index");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 处理注销
	 * @param request
	 * @param response
	 */
	private void logoutGet(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user_data", null);
		try {
			if (path.indexOf("/logout") > -1) {
				response.sendRedirect(path);
			}
			else {
				response.sendRedirect("index");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void registerGet(HttpServletRequest request, HttpServletResponse response) {
		
		String tpl_attr_action = "register";
		String tpl_attr_actstr = "注册";
		
		if (request.getSession().getAttribute("user_data") != null) {
			try {
				response.sendRedirect("index");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", tpl_attr_actstr);
		
		try {
			request.getRequestDispatcher("/user/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registerPost(HttpServletRequest request, HttpServletResponse response) {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String password_r = (String) request.getParameter("password_r");
		String email = (String) request.getParameter("email");
		
		String tpl_register_error_msg = null;
		
		if (username.length() == 0 || !SystemUtils.usernameValidation(username)) {
			tpl_register_error_msg = new String("用户名格式错误！");
			request.setAttribute("tpl_register_error_msg", tpl_register_error_msg);
			registerGet(request, response);
			return;
		}
		else if (UserDataAction.findUserDataByUsername(username) != null) {
			tpl_register_error_msg = new String("此用户名已存在！");
			request.setAttribute("tpl_register_error_msg", tpl_register_error_msg);
			registerGet(request, response);
			return;
		}
		else if (!SystemUtils.passwordValidation(password)) {
			tpl_register_error_msg = new String("密码格式错误！");
			request.setAttribute("tpl_register_error_msg", tpl_register_error_msg);
			request.setAttribute("tpl_register_attr_username", username);
			registerGet(request, response);
			return;
		}
		else if (!password.equals(password_r)) {
			tpl_register_error_msg = new String("两次密码输入不一致！");
			request.setAttribute("tpl_register_error_msg", tpl_register_error_msg);
			request.setAttribute("tpl_register_attr_username", username);
			registerGet(request, response);
			return;
		}
		else if (email.length() < 5) {
			tpl_register_error_msg = new String("Email格式错误！");
			request.setAttribute("tpl_register_error_msg", tpl_register_error_msg);
			request.setAttribute("tpl_register_attr_username", username);
			request.setAttribute("tpl_register_attr_password", password);
			request.setAttribute("tpl_register_attr_password_r", password_r);
			registerGet(request, response);
			return;
		}
		else {
			UserData uData = new UserData();
			String salt = SystemUtils.randomString(6);

			uData.setType(1);
			uData.setUsername(username);
			uData.setPassword( SystemUtils.MD5(SystemUtils.MD5(password)+salt) );
			uData.setSalt(salt);
			uData.setTimereg( (int)(System.currentTimeMillis()/1000 ));
			uData.setEmail(email);
			uData.setIsseller(0);
			
			if (UserDataAction.registerUserData(uData)) {
				request.getSession().setAttribute("user_data", uData);
				try {
					response.sendRedirect("index");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				tpl_register_error_msg = new String("注册失败，请稍后再试！");
				request.setAttribute("tpl_register_error_msg", tpl_register_error_msg);
				request.setAttribute("tpl_register_attr_username", username);
				request.setAttribute("tpl_register_attr_password", password);
				request.setAttribute("tpl_register_attr_password_r", password_r);
				registerGet(request, response);
				return;
			}
		}
	}

}
