<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<jsp:include page="../common/header.jsp" />

<div class="w">

	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-star"></i> </span>
			<h5>登录</h5>
			<span style="float: right; margin-top: 3px; margin-right: 7px;"></span>
		</div>
		<div class="widget-content nopadding" style="background: #fff;">
			<div class="widget-content nopadding">
			
				<c:if test="${tpl_login_error_msg != null}">
					<div class="alert alert-error">
						<button class="close" data-dismiss="alert">×</button>
						<strong>错误！</strong> ${tpl_login_error_msg}
					</div>
				</c:if>
				
				<form action="login" method="post" class="form-horizontal">
					<div class="control-group">
						<label class="control-label">用户名 :</label>
						<div class="controls">
							<input type="text" name="login_name" class="span4" placeholder="用户名">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">密码 :</label>
						<div class="controls">
							<input type="password" name="login_password" class="span4" placeholder="密码">
						</div>
					</div>
					
					<div class="form-actions" style="padding-left:510px;">
						<button type="submit" class="btn btn-success">登录</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</div>
<%@ include file="../common/footer.jsp"%>