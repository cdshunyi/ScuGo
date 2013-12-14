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
							<td class="taskStatus"><strong>用户信息 ▶</strong></td>
						</tr>
						<tr>
							<td class="taskStatus"><a href="user?m=buyer">买家信息</a></td>
						</tr>
						<tr>
							<td class="taskStatus"><a href="user?m=password">密码修改</a></td>
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
				<h5>修改信息</h5>
			</div>
			<div class="widget-content nopadding" style="background: #fff;">
			
				<c:if test="${tpl_profile_error_msg != null}">
					<div class="alert alert-error">
						<button class="close" data-dismiss="alert">×</button>
						<strong>错误！</strong> ${tpl_profile_error_msg}
					</div>
				</c:if>
				
				<c:if test="${tpl_profile_succ_msg != null}">
					<div class="alert alert-success">
						<button class="close" data-dismiss="alert">×</button>
						 ${tpl_profile_succ_msg}
					</div>
				</c:if>
				
				<form action="user?m=profile" method="post" class="form-horizontal">
				
					<div class="control-group">
						<label class="control-label"> ID : </label>
						<div class="controls">
							<input type="text" class="span3"
								value="${tpl_user_data.usid}" disabled>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label"> 类型 : </label>
						<div class="controls">
							<input type="text" class="span3"
								value="<c:choose><c:when test="${tpl_user_data.type == 0}">管理员</c:when><c:when test="${tpl_user_data.type == 1}">用户</c:when></c:choose>" disabled>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label"> 用户名 : </label>
						<div class="controls">
							<input type="text" class="span3"
								value="${tpl_user_data.username}" disabled>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label"> 注册时间 : </label>
						<div class="controls">
							<input type="text" class="span3"
								value="<fmt:formatDate type="date" value="${utils:timestampToDate(tpl_user_data.timereg)}" />" disabled>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label"> Email : </label>
						<div class="controls">
							<input type="text" class="span3"
								value="${tpl_user_data.email}" disabled>
						</div>
					</div>
				
					<div class="control-group">
						<label class="control-label"> 性别 </label>
						<div class="controls">
							<div class="switch" data-on-label="男" data-off-label="女">
								<input type="checkbox" name="sex" id="sex" 
									<c:if test="${tpl_user_profile.sex == 0}">checked</c:if> />
							</div>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label"> 生日 : </label>
						<div class="controls">
							<input type="text" class="span4"
								value="${tpl_user_profile.birthday}" name="birthday"
								placeholder="生日">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label"> 收货人姓名 : </label>
						<div class="controls">
							<input type="text" class="span4" name="receiver"
								value="${tpl_user_profile.receiver}" placeholder="收货人姓名">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label"> 联系电话 : </label>
						<div class="controls">
							<input type="text" class="span4" name="phone"
								value="${tpl_user_profile.phone}" placeholder="联系电话">
						</div>
					</div>

					<div class="control-group">
						<label class="control-label"> 收货地址 : </label>
						<div class="controls">
							<textarea class="span4" name="address">${tpl_user_profile.address}</textarea>
						</div>
					</div>
					<input type="hidden" value="edit" name="edit">
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