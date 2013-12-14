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
							<td class="taskStatus"><strong>买家信息 ▶</strong></td>
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
				<h5>买家信息</h5>
			</div>
			<div class="widget-content nopadding" style="background: #fff;">
			
				<table class="table table-hover" style="font-size:14px;">
					<tr>
						<td width="150" style="text-align:right;">用户名：</td>
						<td width="800"><strong>${tpl_user_data.username}</strong></td>
					</tr>
					<tr>
						<td width="150" style="text-align:right;">账户余额：</td>
						<td width="800">
							<strong style="font-size:16px; color:#FAA732">${tpl_user_buyer.balance} </strong>元&nbsp;&nbsp;
							<a href="bank?m=charge" class="btn btn-mini btn-success" style="color:white">充值</a>
						</td>
					</tr>
					<tr>
						<td width="150" style="text-align:right;">我的积分：</td>
						<td width="800"><strong>${tpl_user_buyer.credit}</strong></td>
					</tr>
					<tr>
						<td width="150" style="text-align:right;">我的等级：</td>
						<td width="800">
							<span style="font-size:12px">
								当前等级：<strong>${tpl_user_buyer.level}</strong>，
								距离下次升级还需<strong>${100-tpl_user_buyer.credit}</strong>积分
							</span><br>
							<div class="progress span2" style="margin: 3px 0 0 0;">
							  <div class="bar bar-warning" style="width: ${tpl_user_buyer.credit}%;"></div>
							</div>
							<span style="font-size:12px">
								&nbsp;&nbsp;&nbsp;<strong>(${tpl_user_buyer.credit}/100)</strong>
							</span>
						</td>
					</tr>
					<tr>
						<td width="150" style="text-align:right;">待处理订单：</td>
						<td width="800"><a href="trade?m=invoice"><strong style="color:#BD362F">(0)</strong></a></td>
					</tr>
					<tr>
						<td width="150" style="text-align:right;">待评论商品：</td>
						<td width="800"><a href="trade?m=invoice"><strong style="color:#BD362F">(0)</strong></a></td>
					</tr>
				</table>
				
			</div>
		</div>
		
	</div>
	<div class="clearfix"></div>
</div>

<%@ include file="../common/footer.jsp"%>