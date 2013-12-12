<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>

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
	<title>${tpl_attr_metstr} - 四川大学购物平台管理中心</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<!-- The styles -->
	<link id="bs-css" href="css/bootstrap-united.css" rel="stylesheet" />

	<style type="text/css">
		body {
			font-size: 14px;
		}
		.sidebar-nav {
			padding: 9px 0;
		}
	</style>
	
	<link rel="stylesheet" href="css/bootstrap-responsive.css">
	<link rel="stylesheet" href="css/charisma-app.css">
	<link rel="stylesheet" href="css/jquery-ui-1.8.21.custom.css">
	<link rel="stylesheet" href='css/fullcalendar.css'>
	<link rel="stylesheet" href='css/fullcalendar.print.css' media='print'>
	<link rel="stylesheet" href='css/chosen.css'>
	<link rel="stylesheet" href='css/uniform.default.css'>
	<link rel="stylesheet" href='css/colorbox.css'>
	<link rel="stylesheet" href='css/jquery.cleditor.css'>
	<link rel="stylesheet" href='css/jquery.noty.css'>
	<link rel="stylesheet" href='css/noty_theme_default.css'>
	<link rel="stylesheet" href='css/elfinder.min.css'>
	<link rel="stylesheet" href='css/elfinder.theme.css'>
	<link rel="stylesheet" href='css/jquery.iphone.toggle.css'>
	<link rel="stylesheet" href='css/opa-icons.css'>
	<link rel="stylesheet" href='css/uploadify.css'>
	
	<!-- 额外CSS样式文件 -->
	<c:forEach items="${tpl_include_css}" var="item">
		<link rel="stylesheet" href="css/${item}" />
	</c:forEach>

	<!--[if lt IE 9]>
		<script src="js/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico"></head>

<body>
	<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.html">
					<img alt="Charisma Logo" src="img/logo20.png" />
					<span>首页</span>
				</a>
				
				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-tint"></i><span class="hidden-phone"> 修改主题</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i class="icon-blank"></i> Classic</a></li>
						<li><a data-value="cerulean" href="#"><i class="icon-blank"></i> Cerulean</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i> Cyborg</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i> Redy</a></li>
						<li><a data-value="journal" href="#"><i class="icon-blank"></i> Journal</a></li>
						<li><a data-value="simplex" href="#"><i class="icon-blank"></i> Simplex</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i> Slate</a></li>
						<li><a data-value="spacelab" href="#"><i class="icon-blank"></i> Spacelab</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i> United</a></li>
					</ul>
				</div>
				<!-- theme selector ends -->

				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i>
						<span class="hidden-phone">admin</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="#">个人信息</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="login.html">退出</a>
						</li>
					</ul>
				</div>
				<!-- user dropdown ends -->

				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li>
							<a href="#">前台首页<i class="icon icon-white icon-extlink"></i></a>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
	<div class="container-fluid">
		<div class="row-fluid">

			<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">首页</li>
						<li>
							<a href="index.html">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;控制台</span>
							</a>
						</li>
						
						<li class="nav-header hidden-tablet">用户</li>
						<li <c:if test="${tpl_attr_action == 'user' && tpl_attr_method == 'index'}"> class="active"</c:if>>
							<a href="user?m=index">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;用户管理</span>
							</a>
						</li>
						<li <c:if test="${tpl_attr_action == 'user' && tpl_attr_method == 'seller'}"> class="active"</c:if>>
							<a href="user?m=buyer">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;卖家管理</span>
							</a>
						</li>
						<li <c:if test="${tpl_attr_action == 'user' && tpl_attr_method == 'apply'}"> class="active"</c:if>>
							<a href="user?m=seller">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;卖家申请</span>
							</a>
						</li>
						
						<li class="nav-header hidden-tablet">商品</li>
						<li <c:if test="${tpl_attr_action == 'goods' && tpl_attr_method == 'catalog'}"> class="active"</c:if>>
							<a href="goods?m=catalog">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;分类管理</span>
							</a>
						</li>
						<li <c:if test="${tpl_attr_action == 'goods' && tpl_attr_method == 'off'}"> class="active"</c:if>>
							<a href="goods?m=off">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;下架管理</span>
							</a>
						</li>
						
						<li class="nav-header hidden-tablet">店铺</li>
						<li <c:if test="${tpl_attr_action == 'shop' && tpl_attr_method == 'index'}"> class="active"</c:if>>
							<a href="shop?m=index">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;店铺管理</span>
							</a>
						</li>
						
						<li class="nav-header hidden-tablet">银行</li>
						<li <c:if test="${tpl_attr_action == 'bank' && tpl_attr_method == 'key'}"> class="active"</c:if>>
							<a href="bank?m=key">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;充值卡密</span>
							</a>
						</li>
						<li <c:if test="${tpl_attr_action == 'bank' && tpl_attr_method == 'generate'}"> class="active"</c:if>>
							<a href="bank?m=generate">
								<span class="hidden-tablet">&nbsp;&nbsp;&nbsp;&nbsp;生成卡密</span>
							</a>
						</li>
						
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<!-- left menu ends -->

			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">警告！</h4>
					<p>
						你必须启用
						<a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a>
						.
					</p>
				</div>
			</noscript>

			<div id="content" class="span10">
			<!-- content starts -->
			
				<div>
					<ul class="breadcrumb">
						<li>
							<a href="#">${tpl_attr_actstr}</a> <span class="divider">/</span>
						</li>
						<li>
							<a href="#">${tpl_attr_metstr}</a>
						</li>
					</ul>
				</div>
			