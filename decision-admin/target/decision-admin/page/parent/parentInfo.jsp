<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="page" uri="/tag/pager.tld" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>家长信息 - 拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<script type="text/javascript">
	
</script>
</head>
<body>
	<%@include file="/page/layout/html_navbar.jsp"%>
	<!-- /.navbar -->
	<!-- /.menu-inner -->
	<%@include file="/page/layout/html_menu_parent.jsp"%>
	<!-- /.menu -->
	<div class="page-wrap">
		<%-- <div class="breadcrumb">
			<a class="btn orange" href="#"><i class="icon-plus"></i></a> <a
				class="btn" href="<%=basePath%>page/car/add.jsp"> 发布信息</a>
			<div class="pull-right">
				<a class="btn btn-info" href="#"><i class="icon-calendar"></i></a> <a
					class="btn" href="#">13/08/13</a>
			</div>
		</div> --%>
		<div class="container-fluid" style="padding-top:5px;">

			<div class="row-fluid">
				<div class="span12 well">
					<div class="title">
						<a href="#">宝贝信息列表</a>
					</div>
					<div class="well-content">
						<div class="row-fluid">
							<%-- <div class="span12">
								<div class="" id="managed-table_filter">
									<label>
										关键词: <input type="text" aria-controls="managed-table"> 
										<span class="btn ">搜索</span>
								    	
								    </label>
								</div>
							</div> --%>
						</div>
						<table class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>学生学号</th>
									<th>学生姓名</th>
									<th>班级</th>
									<th>学校</th>
									<th>家长姓名</th>
									<th>家长手机号码</th>
								</tr>
							</thead>
							<tbody>
								<%-- <c:forEach items="${contactList}" var="contact" varStatus="c">
									<tr>
										<td>${c.index+1}</td>
										<td>${contact.name}</td>
										<td></td>
										<td>${parent.name}</td>
										<td>${parent.phone}</td>
										<td>${parent.email}</td>
									</tr>
								</c:forEach> --%>
								<c:forEach items="${childrenList}" var="children" varStatus="c">
									<tr>
										<td>${c.index+1}</td>
										<td>${children.sno}</td>
										<td>${children.childName}</td>
										<td>${children.childClass}</td>
										<td>${children.childSchool}</td>
										<td>${parent.name}</td>
										<td>${parent.phone}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<%@include file="/page/layout/html_copyright.jsp"%>
	</div>
	<%@include file="/page/layout/html_footer_tables.jsp"%>
	<script>
		data_tables();
	</script>
</body>
</html>