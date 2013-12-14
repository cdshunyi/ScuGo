<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://scugo.nsmss.com/utils" prefix="utils" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<jsp:include page="../common/header.jsp" />

<div class="w">

	<div style="width: 200px; float: left; font-size:14px;">

		<div class="widget-box">
			<div class="widget-title">
				<span class="icon"> <i class="icon-eye-open"></i>
				</span>
				<h5>用户管理</h5>
			</div>
			<div class="widget-content nopadding">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="taskStatus"><a href="user?m=profile">用户信息 </a></td>
						</tr>
						<tr>
							<td class="taskStatus"><a href="user?m=buyer">买家信息</a></td>
						</tr>
						<tr>
							<td class="taskStatus"><strong>密码修改 ▶</strong></td>
						</tr>
						<tr>
							<td class="taskStatus"><a href="trade?m=cart">购物车</a></td>
						</tr>
						<tr>
							<td class="taskStatus"><a href="trade?m=invoice">账单管理</a></td>
						</tr>
						<c:if test="${user_data.isseller == 0}">
							<tr>
								<td class="taskStatus"><a href="shop?m=apply">卖家申请</a></td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>

		<c:if test="${user_data.isseller == 1}">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-eye-open"></i>
					</span>
					<h5>卖家管理</h5>
				</div>
				<div class="widget-content nopadding">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="taskStatus"><a href="user?m=seller">卖家信息</a></td>
							</tr>
							<tr>
								<td class="taskStatus"><a href="shop?m=info">店铺管理</a></td>
							</tr>
							<tr>
								<td class="taskStatus"><a href="shop">商品管理</a></td>
							</tr>
							<tr>
								<td class="taskStatus"><a href="trade?m=sell">发货管理</a></td>
							</tr>
							<tr>
								<td class="taskStatus"><a href="shop?m=stock">库存管理</a></td>
							</tr>
							<tr>
								<td class="taskStatus"><a href="shop?m=statistic">销售统计</a></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>

	</div>

	<div style="float: left; width: 770px; margin-left: 20px;">
	
		<div class="widget-box">
			<div class="widget-title">
				<span class="icon"> + </span>
				<h5>密码修改</h5>
			</div>
			<div class="widget-content nopadding" style="background: #fff;">
			
				<c:if test="${tpl_password_error_msg != null}">
					<div class="alert alert-error">
						<button class="close" data-dismiss="alert">×</button>
						<strong>错误！</strong> ${tpl_password_error_msg}
					</div>
				</c:if>
				
				<c:if test="${tpl_password_succ_msg != null}">
					<div class="alert alert-success">
						<button class="close" data-dismiss="alert">×</button>
						 ${tpl_password_succ_msg}
					</div>
				</c:if>
				
				<form action="user?m=password" method="post" class="form-horizontal">
				
					<div class="control-group">
						<label class="control-label"> 原始密码 : </label>
						<div class="controls">
							<input type="password" class="span3" name="password_o" placeholder="原始密码">
							<span class="help-inline">输入原始登录密码</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label"> 新密码 : </label>
						<div class="controls">
							<input type="password" class="span3" name="password_n" placeholder="新密码">
							<span class="help-inline">设置新密码，6-20个字符，避免过于简单</span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label"> 新密码确认 : </label>
						<div class="controls">
							<input type="password" class="span3" name="password_r" placeholder="新密码确认">
							<span class="help-inline">重复输一次新密码</span>
						</div>
					</div>

					<div class="form-actions">
						<button type="submit" class="btn btn-success btn-large"
							style="margin-left: 180px;">确认修改</button>
					</div>
				</form>
			</div>
		</div>
		
	</div>
	<div class="clearfix"></div>
</div>

<%@ include file="../common/footer.jsp"%>