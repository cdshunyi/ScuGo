<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://scugo.nsmss.com/utils" prefix="utils" %>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>

<jsp:include page="header.jsp" />

<div class="row-fluid sortable">		
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-user"></i> 用户管理</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
			<table class="table table-striped table-bordered bootstrap-datatable datatable" id="table_user_index">
			  <thead>
				  <tr>
				  	  <th style="width:8px;">
				  	  	<input type="checkbox" class="group-checkable" data-set="#table_user_index .checkboxes" />
				  	  </th>
					  <th>ID</th>
					  <th>用户名</th>
					  <th>注册时间</th>
					  <th>类型</th>
					  <th>Email</th>
					  <th>是否是卖家</th>
					  <th>操作</th>
				  </tr>
			  </thead>   
			  <tbody>
			  
			  	<c:forEach items="${tpl_attr_udata_list}" var='item'>
					<tr>
						<td class="center"><input type="checkbox" class="checkboxes" name="checkbox_${item.usid}" value="${item.usid}" /></td>
						<td class="center">${item.usid}</td>
						<td class="center">${item.username}</td>
						<td class="center"><fmt:formatDate type="date" value="${utils:timestampToDate(item.timereg)}" /></td>
						<td class="center">
							<c:choose>
								<c:when test="${item.type == 0}">管理员</c:when>
								<c:when test="${item.type == 1}">用户</c:when>
							</c:choose>
						</td>
						<td>${item.email}</td>
						<td class="center">
							<c:choose>
								<c:when test="${item.isseller == 1}">
									<span class="label label-success">是</span>
								</c:when>
								<c:otherwise>
									否
								</c:otherwise>
							</c:choose>
						</td>
						<td class="center">
							<a class="btn btn-info" href="#">
								<i class="icon-edit icon-white"></i>  
								编辑                                            
							</a>
							<a class="btn btn-danger" href="#">
								<i class="icon-trash icon-white"></i> 
								删除
							</a>
						</td>
					</tr>
				</c:forEach>
				
			  </tbody>
		  </table>
		  
		  <div style="margin-top:-40px; padding-bottom:20px;">
		  	<a class="btn btn-large btn-primary" href="#"><i class="icon-white icon-trash"></i> 删除所选</a>
		  	<a class="btn btn-large btn-success" href="#"><i class="icon-white icon-plus"></i> 添加用户</a>
		  </div>
		</div>
	</div><!--/span-->

</div><!--/row-->


<jsp:include page="footer.jsp" />
