package com.controller.library;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.library.SystemUtils;
import com.action.library.UserBuyerAction;
import com.action.library.UserDataAction;
import com.action.library.UserProfileAction;
import com.bean.library.UserBuyer;
import com.bean.library.UserData;
import com.bean.library.UserProfile;

public class HomeUser extends HttpServlet {

	private static final long serialVersionUID = -7292711163678701875L;
	
	private String m;		// 操作方法
	private String from;	// 来源路径
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		m = request.getParameter("m");
		from = request.getParameter("from");
		
		if (m.equals("login")) {
			loginGet(request, response);
		}
		else if (m.equals("logout")) {
			logoutGet(request, response);
		}
		else if (m.equals("register")) {
			registerGet(request, response);
		}
		else if (m.equals("profile")) {
			profileGet(request, response);
		}
		else if (m.equals("buyer")) {
			buyerGet(request, response);
		}
		else if (m.equals("password")) {
			passwordGet(request, response);
		}
		// TODO 其他User方法
		else {
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		m = request.getParameter("m");
		from = request.getParameter("from");
		
		if (m.equals("login")) {
			loginPost(request, response);
		}
		else if (m.equals("register")) {
			registerPost(request, response);
		}
		else if (m.equals("profile")) {
			profilePost(request, response);
		}
		else if (m.equals("password")) {
			passwordPost(request, response);
		}
		
		// TODO 其他User方法
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
	
	/**
	 * 处理登录表单
	 * @param request
	 * @param response
	 */
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
					if (from == null || from.length() == 0 || from.equals("login")) {
						response.sendRedirect("index");
					}
					else {
						response.sendRedirect(from);
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
			response.sendRedirect("index");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示注册页面
	 * @param request
	 * @param response
	 */
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
	
	/**
	 * 注册表单处理
	 * @param request
	 * @param response
	 */
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
			
			int maxUsId = UserDataAction.registUserData(uData);
			uData.setUsid(maxUsId);
			
			UserProfileAction.addNewUserProfile(maxUsId);
			UserBuyerAction.addNewUserBuyer(maxUsId);
			
			if (maxUsId > 0) {
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
	
	/**
	 * 显示用户信息页面
	 * @param request
	 * @param response
	 */
	private void profileGet(HttpServletRequest request, HttpServletResponse response) {

		String tpl_attr_action = "profile";
		String tpl_attr_actstr = "用户信息";
		
		// 判断用户是否登录
		UserData uData = (UserData) request.getSession().getAttribute("user_data");
		if (uData == null || uData.getUsid() == 0) {
			try {
				response.sendRedirect("user?m=login&from="+tpl_attr_action);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		UserProfile uProfile = UserProfileAction.findUserProfileByUsId(uData.getUsid());
		
		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", tpl_attr_actstr);
		request.setAttribute("tpl_user_data", uData);
		request.setAttribute("tpl_user_profile", uProfile);
		
		try {
			request.getRequestDispatcher("/user/profile.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 处理用户信息表单
	 * @param request
	 * @param response
	 */
	private void profilePost(HttpServletRequest request, HttpServletResponse response) {
		
		String tpl_attr_action = "profile";
		
		// 判断用户是否登录
		UserData uData = (UserData) request.getSession().getAttribute("user_data");
		if (uData == null || uData.getUsid() == 0) {
			try {
				response.sendRedirect("user?m=login&from="+tpl_attr_action);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		UserProfile uProfile = UserProfileAction.findUserProfileByUsId(uData.getUsid());
		
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String receiver = request.getParameter("receiver");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		if (sex == null) {
			uProfile.setSex(1);
		}
		else {
			uProfile.setSex("on".equals(sex)?0:1);
		}
		uProfile.setBirthday(birthday);
		uProfile.setReceiver(receiver);
		uProfile.setPhone(phone);
		uProfile.setAddress(address);
		
		UserProfileAction.savaUserProfile(uProfile);
		
		request.setAttribute("tpl_profile_succ_msg", "修改成功！");
		profileGet(request, response);
	}

	/**
	 * 显示买家信息
	 * @param request
	 * @param response
	 */
	private void buyerGet(HttpServletRequest request, HttpServletResponse response) {
		
		String tpl_attr_action = "buyer";
		String tpl_attr_actstr = "买家信息";
		
		// 判断用户是否登录
		UserData uData = (UserData) request.getSession().getAttribute("user_data");
		if (uData == null || uData.getUsid() == 0) {
			try {
				response.sendRedirect("user?m=login&from="+tpl_attr_action);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		UserBuyer uBuyer = UserBuyerAction.findUserProfileByUsId(uData.getUsid());
		
		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", tpl_attr_actstr);
		request.setAttribute("tpl_user_data", uData);
		request.setAttribute("tpl_user_buyer", uBuyer);
		
		try {
			request.getRequestDispatcher("/user/buyer.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 显示修改密码
	 * @param request
	 * @param response
	 */
	private void passwordGet(HttpServletRequest request, HttpServletResponse response) {
		
		String tpl_attr_action = "password";
		String tpl_attr_actstr = "密码修改";
		
		// 判断用户是否登录
		UserData uData = (UserData) request.getSession().getAttribute("user_data");
		if (uData == null || uData.getUsid() == 0) {
			try {
				response.sendRedirect("user?m=login&from="+tpl_attr_action);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		request.setAttribute("tpl_attr_action", tpl_attr_action);
		request.setAttribute("tpl_attr_actstr", tpl_attr_actstr);
		
		try {
			request.getRequestDispatcher("/user/password.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void passwordPost(HttpServletRequest request, HttpServletResponse response) {
		
		String tpl_attr_action = "password";
		
		// 判断用户是否登录
		UserData uData = (UserData) request.getSession().getAttribute("user_data");
		if (uData == null || uData.getUsid() == 0) {
			try {
				response.sendRedirect("user?m=login&from="+tpl_attr_action);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		String password_o = request.getParameter("password_o");
		String password_n = request.getParameter("password_n");
		String password_r = request.getParameter("password_r");
		
		UserData uData1 = UserDataAction.loginCheck(uData.getUsername(), password_o);
		
		if (!SystemUtils.passwordValidation(password_o) || uData1 == null) {
			request.setAttribute("tpl_password_error_msg", "原始密码错误！");
			passwordGet(request, response);
			return;
		}
		else if (!SystemUtils.passwordValidation(password_n)) {
			request.setAttribute("tpl_password_error_msg", "新密码格式错误！");
			passwordGet(request, response);
			return;
		}
		else if (!password_n.equals(password_r)) {
			request.setAttribute("tpl_password_error_msg", "两次密码输入不一致！");
			passwordGet(request, response);
			return;
		}
		else {
			String salt = SystemUtils.randomString(6);
			uData.setPassword( SystemUtils.MD5(SystemUtils.MD5(password_n)+salt) );
			uData.setSalt(salt);
			UserDataAction.saveUserData(uData);
			request.getSession().setAttribute("user_data", uData);
			request.setAttribute("tpl_password_succ_msg", "修改成功！");
			passwordGet(request, response);
		}
	}

}
