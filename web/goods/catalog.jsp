<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://scugo.nsmss.com/utils" prefix="utils" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<jsp:include page="../common/header.jsp" />

<style>
.list-h li {
	width: 100px;
}
</style>

<div class="w">
	
	<div class="breadcrumb1">
	
		<c:forEach items="${tpl_goods_path}" var="item" varStatus="status">
			<c:if test="${!status.last}">
				<a href="goods?m=catalog&id=${item.caid}">${item.name}</a>&nbsp;&gt;&nbsp;
			</c:if>
			<c:if test="${status.last}">
				<a href="goods?m=catalog&id=${item.caid}"><strong>${item.name}</strong></a>
			</c:if>
		</c:forEach>

	</div>
	
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-star"></i> </span>
			<h5>${tpl_goods_catalog.name}</h5>
		</div>
		<div class="widget-content nopadding" style="background: #fff;">
		
			<c:choose>
				 <c:when test="${tpl_goods_catalog.isbottom == 0}">
				 
				 	<div class="m psearch quick-actions_homepage " id="plist" style="heigth: auto;">
						<ul class="quick-actions">
						
							<c:forEach items="${tpl_goods_catalog_children}" var="item">
								<li class="${utils:randomColorStyle()}" style="width: 200px; margin-left: 7px; border:none;">
									<a href="goods?m=catalog&id=${item.caid}" 
									style="font-size: 20px; font-weight: bold; padding-top: 30px; padding-bottom:30px;">${item.name}</a>
								</li>
							</c:forEach>
							
						</ul>
					</div>
					
				 </c:when>
				 <c:otherwise>
				 
				 	<div class="m psearch " id="plist">
						<ul class="list-h clearfix">
							<c:forEach items="${tpl_goods_catalog_items}" var="item">
								<li style="width: 215px;">
									<div class="p-img">
										<a href="goods?m=item&id=${item.itid}"> 
											<img width="160" height="160" src="${item.picture}" class="err-product">
										</a>
									</div>
									<div style="line-height: 20px; margin-top: 10px; height: 40px;">
										<a href="goods?m=item&id=${item.itid}">${item.name}</a>
									</div>
									<div class="p-price" style="margin-top:-2px;">
										<strong class="J_650385">￥${item.pricenormal}</strong>
									</div>
									<div class="extra">
										<a target="_blank" href="goods?m=item&id=${item.itid}">销售量：${item.soldnum}</a>
										<a style="float:right; padding-right:20px;" target="_blank" href="goods?m=item&id=${item.itid}">评价数：${item.commentnum}</a>
									</div>
									<div class="btns">
										<a href="#" onClick="window.location.href='trade?m=cart&mod=add&id=${item.itid}'; " class="btn-buy">加入购物车</a>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					
				 </c:otherwise>
			</c:choose>
		
			<div style="clear: both"></div>
		</div>
	</div>
</div>

<%@ include file="../common/footer.jsp"%>