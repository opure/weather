<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="page" uri="/tag/pager.tld" %>    
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>应用信息管理 - 气象局云服务平台海南决策服务</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<style type="text/css">
	.ellipsis_div{   
	    overflow:hidden;   
	    text-overflow:ellipsis;   
	    white-space:nowrap; 
	}    
</style>
</head>
<body>
	<%@include file="/page/layout/html_navbar.jsp"%>
	<!-- /.navbar -->
	<!-- /.menu-inner -->
	<%@include file="/page/layout/html_menu.jsp"%>
	<!-- /.menu -->
	<div class="page-wrap">
		<%-- <div class="breadcrumb">
			<a class="btn orange" href="#"><i class="icon-plus"></i></a> <a
				class="btn" href="<%=basePath%>message/publishMessage"> 发布信息</a>
			<!-- <div class="pull-right">
				<a class="btn btn-info" href="#"><i class="icon-calendar"></i></a> <a
					class="btn" href="#">13/08/13</a>
			</div> --> 
		</div> --%>
		<div class="container-fluid" style="padding-top:5px;">

			<div class="row-fluid">
				<div class="span12 well">
					<div class="title">
						<ul class="nav nav-tabs">
                           	<li class="heading"></li>
							<li class="active">
								<a href="#" data-toggle="tab">
									应用信息
								</a>
							</li>
						</ul> 
					</div>
					<div class="well-content">
						<table class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th>名称</th>
									<th>Icon</th>
									<th>闪屏</th>
									<th>版本</th>
									<th style="width:30%;">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${appList}" var="app" varStatus="a">
									<tr>
										<td>${app.title}</td>
										<td><img style="width:150px;height:150px;" src="<%=basePath%>assets/img/icon.png"></td>
										<td><img style="width:82px;height:150px;" src="<%=basePath%>assets/img/screen.jpg"></td>
										<td>${app.version}</td>
										<%--<td><fmt:formatDate value="${message.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
										<td><span class="label light">未成交</span></td>
										<td><span class="label lightblue">认证</span></td> --%>
										<td>
											<span class="btn blue" onclick="edit('${app.id}','app/edit?id=');">
												<i class="icon-edit"></i> 修改 
											</span> 
											<span class="btn orange" onclick="view('${app.id}','app/view?id=');">
												<i class="icon-search"></i> 查看 
											</span> 
											<span class="btn green" onclick="">
												<i class="icon-book"></i> 栏目管理 
											</span>  
											<%-- <span class="btn red">
												<i class="icon-trash"> </i>删除
											</span> --%>
										</td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<form action="<%=basePath%>app/index" method="post" id="index"></form>
						<page:createPager pageSize="${pageSize}" totalPage="${totalPage}" totalCount="${totalCount}" curPage="${pageNum}" formId="index"/>  
						
					</div>
				</div>
			</div>
		</div>

		<%@include file="/page/layout/html_copyright.jsp"%>
	</div>
	<%@include file="/page/layout/html_footer_tables.jsp"%>
	<script>
		data_tables();
		
		function edit(id, url){
			
			//var alertStr = encodeURI(encodeURI(alertid));
			window.location.href = "<%=basePath%>"+url+id;
		}
		
		function view(id, url){
			
			//var alertStr = encodeURI(encodeURI(alertid));
			window.location.href = "<%=basePath%>"+url+id;
		}
		
	</script>
</body>
</html>