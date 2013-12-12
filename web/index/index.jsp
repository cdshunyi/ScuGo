<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<jsp:include page="../common/header.jsp" />

<div class="w">
	<ul class="tab" id="tab-link">
		<li>
			<a href="index">全部商品分类</a>
		</li>
	</ul>
	<!--tab end-->
</div>


<div class="w" id="allsort" style="font-size:14px;">

	<style>
		#allsort a {
			line-height: 10px;
		}
		
		#allsort h2 {
			line-height: 30px;
		}
	</style>



	<div class="fl">
		<!--左主体分类-->
		
		<c:forEach items="${tpl_attr_catalog_roots}" var="item1" begin="0" step="2">
			<div class="m">
				<div class="mt">
					<h2>
						<a href="goods?m=catalog&id=${item1.value.caid}">${item1.value.name}</a>
					</h2>
				</div>
				<div class="mc">
					<c:forEach items="${item1.children}" var="item2">
					<dl>
						<dt>
							<a href="goods?m=catalog&id=${item2.value.caid}">${item2.value.name}</a>
						</dt>
						<dd>
							<c:forEach items="${item2.children}" var="item3">
								<em>
									<a href="goods?m=catalog&id=${item3.caid}">${item3.name}</a>
								</em>
							</c:forEach>
						</dd>
					</dl>
					</c:forEach>
				</div>
			</div>
		</c:forEach>

	</div>
	<!--fl end-->

	<div class="fr">
		<!--右主体分类-->

		<c:forEach items="${tpl_attr_catalog_roots}" var="item1" begin="1" step="2">
			<div class="m">
				<div class="mt">
					<h2>
						<a href="goods?m=catalog&id=${item1.value.caid}">${item1.value.name}</a>
					</h2>
				</div>
				<div class="mc">
					<c:forEach items="${item1.children}" var="item2">
					<dl>
						<dt>
							<a href="goods?m=catalog&id=${item2.value.caid}">${item2.value.name}</a>
						</dt>
						<dd>
							<c:forEach items="${item2.children}" var="item3">
								<em>
									<a href="goods?m=catalog&id=${item3.caid}">${item3.name}</a>
								</em>
							</c:forEach>
						</dd>
					</dl>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
		
	</div>
	<!--fr end-->

	<span class="clr"></span>
</div>

<%@ include file="../common/footer.jsp"%>