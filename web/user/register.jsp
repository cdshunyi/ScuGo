<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<jsp:include page="../common/header.jsp" />

<div class="w">

	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-star"></i>
			</span>
			<h5>注册</h5>
			<span style="float:right; margin-top:3px; margin-right:7px;"></span>
		</div>
		<div class="widget-content nopadding" style="background:#fff;">
			<div class="widget-content nopadding">

				<c:if test="${tpl_register_error_msg != null}">
					<div class="alert alert-error">
						<button class="close" data-dismiss="alert">×</button>
						<strong>错误！</strong> ${tpl_register_error_msg}
					</div>
				</c:if>
				
				<form action="user?m=register" method="post" class="form-horizontal">
					<div class="control-group">
						<label class="control-label">用户名 :</label>
						<div class="controls">
							<input type="text" class="span4" name="username" value="${tpl_register_attr_username}" placeholder="用户名">
							<span class="help-inline">5-20个英文开头的英文、数字、下划线</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">密码 :</label>
						<div class="controls">
							<input type="password" class="span4" value="${tpl_register_attr_password}" name="password" placeholder="密码 ">
							<span class="help-inline">6-20个字符，避免过于简单</span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">重复密码 :</label>
						<div class="controls">
							<input type="password" class="span4" value="${tpl_register_attr_password_r}" name="password_r" placeholder="重复密码">
							<span class="help-inline">重复输一次密码</span>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">邮箱 :</label>
						<div class="controls">
							<input type="text" class="span4" name="email" placeholder="邮箱">
							<span class="help-inline">输入您的Email地址</span>
						</div>
					</div>

					<div class="form-actions" style="padding-left:510px;">
						<button type="submit" class="btn btn-success">注册</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jsp"%>