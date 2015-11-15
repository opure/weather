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
<title>预警管理 - 气象局云服务平台海南决策服务</title>
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
							<li>
								<a href="<%=basePath%>alarm/index">
									生效中
								</a>
							</li>
							<li class="active">
								<a href="#tab" data-toggle="tab">
									全部预警
								</a>
							</li>
						</ul> 
					</div>
					<div class="well-content">
						<%-- <div class="row-fluid">
							<div class="span12">
								<div class="" id="managed-table_filter">
									<label>
										关键词: <input type="text" aria-controls="managed-table"> 
										<span class="btn ">搜索</span>
								    	
								    </label>
								</div>
							</div>
						</div> --%>
						<table class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th style="width:16%">AlertId</th>
									<th style="width:6%">Province</th>
									<th style="width:6%">City</th>
									<th style="width:8%">预警类型</th>
									<th style="width:8%">预警级别</th>
									<th style="width:6%">Change</th>
									<th style="width:14%">发布时间</th>
									<th style="width:14%">解除时间</th>
									<th style="width:8%">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${alarmInfoList}" var="alarm" varStatus="a">
									<tr>
										<td>${alarm.alertId}</td>
										<td>${alarm.province }</td>
										<td>${alarm.city }</td>
										<td>${alarm.signalType }</td>
										<td>${alarm.signalLevel }</td>
										<td>${alarm.change }</td>
										<td>${alarm.issueTime }</td>
										<td>${alarm.relieveTime }</td>
										<%--<td><fmt:formatDate value="${message.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
										<td><span class="label light">未成交</span></td>
										<td><span class="label lightblue">认证</span></td> --%>
										<td>
											<span class="btn blue" onclick="edit('${alarm.alertId}','alarm/edit?alertId=');">
												<i class="icon-edit"></i> 修改 
											</span>  
											<%-- <span class="btn red">
												<i class="icon-trash"> </i>删除
											</span> --%>
										</td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<form action="<%=basePath%>alarm/all" method="post" id="all"></form>
						<page:createPager pageSize="${pageSize}" totalPage="${totalPage}" totalCount="${totalCount}" curPage="${pageNum}" formId="all"/>  
						
					</div>
				</div>
			</div>
		</div>

		<%@include file="/page/layout/html_copyright.jsp"%>
	</div>
	<%@include file="/page/layout/html_footer_tables.jsp"%>
	<script>
		data_tables();
		
		function edit(alertid, url){
			
			var alertStr = encodeURI(encodeURI(alertid));
			window.location.href = "<%=basePath%>"+url+alertStr;
		}
		
		function formatDateStr(str){
			
			var dateStr = "";
			if(str != null && str.length > 0){
				var year = str.substring(0, 3);
				var month = str.substring(4, 5);
				var day = str.substring(6, 7);
				var hour = str.substring(8, 9);
				var miunte = str.substring(10, 11);
				var second = str.substring(12, 13);
				
				dateStr = year +"-"+ month +"-"+ day +" "+ hour +":"+ miunte +":"+ second;
			}
			
			return dateStr;
		}
	</script>
</body>
</html>