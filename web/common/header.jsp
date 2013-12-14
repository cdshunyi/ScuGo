<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>

<%
// tpl_attr_action 操作名英文
// tpl_attr_actstr 操作名中文
// tpl_attr_method 方法名英文
// tpl_attr_metstr 方法名中文
// tpl_include_css CSS文件数组
// tpl_include_js  JS文件数组
// tpl_script_js   页面JS代码
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${tpl_attr_actstr} - 四川大学购物平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<style type="text/css">
#navitems-2013 li:hover {
	background: #A40000;
}
</style>

<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css" >
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/pshow.css" />
<link rel="stylesheet" href="css/psearch.css" />
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/allsort.css" />
<link rel="stylesheet" href="css/bootstrapSwitch.css" />
<link rel="stylesheet" href="css/psearch.css" />
</head>

<body>

	<!--Header-part-->
	<div id="shortcut-2013">
		<div class="w">
			<ul class="fl lh">
				<li class="fore1 ld"><b></b><a
					href="javascript:addToFavorite()" rel="nofollow">加入收藏</a></li>
			</ul>
			<ul class="fr lh">

				<c:if test="${is_login == true}">
					<li class="fore1" id="loginbar">您好， <a
						href="user?m=profile&id=${user_data.usid}" rel="nofollow"><strong>${user_data.username}</strong>
					</a>
					</li>
					<li class="fore2 ld"><a href="trade?m=order" rel="nofollow"><strong>我的订单</strong></a>
					</li>
					<li class="fore2 ld"><a href="user?m=logout" rel="nofollow"><strong>注销</strong></a>
					</li>

				</c:if>

				<c:if test="${is_login != true}">
					<li class="fore1" id="loginbar">您好，欢迎来到四川大学购物平台</li>
					<li class="fore2 ld"><a href="user?m=login" rel="nofollow"><strong>登录</strong></a>
					</li>
					<li class="fore3 ld"><a href="user?m=register" rel="nofollow"><strong>注册</strong></a>
					</li>
				</c:if>
			</ul>
			<span class="clr"></span>
		</div>
	</div>
	<!--close-Header-part-->

	<div id="o-header-2013" style="margin-bottom:10px;">
		<div class="w" id="header-2013">
			<div id="logo-2013" class="ld">
				<a href="index" hidefocus="true"><b></b> <img
					src="img/logo-201305.png" width="270" height="60"> </a>
			</div>
			<!--logo end-->
			<div id="search-2013">
				<div class="i-search ld">
					<ul id="shelper" class="hide">
					</ul>
					<div class="form">
						<form action="search" method="post">
							<input type="text" class="text" name="key"> <input
								type="submit" value="搜索" class="button">
						</form>
					</div>
				</div>
				<div id="hotwords">
					<strong>热门搜索：</strong><a href="">江安神偶</a><a href="">电影</a><a
						href="">旧书</a><a href="">笔记本</a><a href="">华联</a><a href="">二手</a>
				</div>
			</div>
			<!--search end-->
			<div id="my360buy-2013"
				onMouseOver="$('#userpanerl').addClass('hover')"
				onMouseOut="$('#userpanerl').removeClass('hover')">

				<dl class="" load="1" id="userpanerl">
					<dt class="ld">
						<s></s>账户 <b></b>
					</dt>
					<dd style="width: 150px;">
						<div class="uclist">
							<ul class="fore1" style="border: none;">
							
								<c:if test="${is_login == true}">
									<li><a href="user?m=profile">账户资料</a></li>
									<li><a href="trade?m=invoice">我的账单</a></li>
									<c:if test="${user_data.isseller == 1}">
										<li><a href="shop">店铺管理</a></li>
									</c:if>
									<c:if test="${user_data.isseller == 0}">
										<li><a href="shop">卖家申请</a></li>
									</c:if>
								</c:if>
								<c:if test="${is_login != true}">
									<li><a href="user?m=login">登录</a></li>
									<li><a href="user?m=register">注册</a></li>
								</c:if>

							</ul>
						</div>
					</dd>
				</dl>
			</div>
			<!--my360buy end-->
			<div id="settleup-2013">
				<dl>
					<dt class="ld" onClick="window.location.href='trade-cart'">
						<span class="shopping"><span id="shopping-amount">0</span></span>
						<a href="trade?m=cart" id="settleup-url">购物车</a> <b></b>
					</dt>
				</dl>
			</div>
			<!--settleup end-->
		</div>
		<!--header end-->
		<div class="w">
			<div id="nav-2013">
				<div id="categorys-2013" onMouseOver="$('#JD_ALLSORT').css('display','block')" onMouseOut="$('#JD_ALLSORT').css('display', 'none');">
					<div class="mt ld">
						<h2><a href="index">全部商品分类<b></b></a></h2>
					</div>
					<div id="JD_ALLSORT" class="mc" style="display: none; height: auto;">

						<c:forEach items="${root_catalogs}" var="item">
							<div class="item fore1">
								<h3><a href="goods?m=catalog&id=${item.caid}">${item.name}</a></h3>
							</div>
						</c:forEach>

						<div class="extra">
							<a href="index">全部商品分类</a>
						</div>
					</div>
				</div>
				<div id="treasure"></div>
				<ul id="navitems-2013">
					<li class="fore1" id="nav-home"><a href="index">首页</a></li>
					<li class="fore2" id="nav-fashion"><a href="#">餐馆</a></li>
					<li class="fore3" id="nav-chaoshi"><a href="#">超市</a></li>
					<li class="fore4" id="nav-tuan"><a href="#">图书</a></li>
					<li class="fore6" id="nav-wan"><a href="#">二手市场</a></li>
				</ul>
			</div>
		</div>
	</div>
