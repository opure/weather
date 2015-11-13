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

<title>已发送信息 - 拇指校园</title>
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
	<%@include file="/page/layout/html_menu_teacher.jsp"%>
	<!-- /.menu -->
	<div class="page-wrap">
		<div class="breadcrumb">
			<a class="btn orange" href="#"><i class="icon-plus"></i></a> <a
				class="btn" href="<%=basePath%>message/publishMessage"> 发布信息</a>
			<!-- <div class="pull-right">
				<a class="btn btn-info" href="#"><i class="icon-calendar"></i></a> <a
					class="btn" href="#">13/08/13</a>
			</div> --> 
		</div>
		<div class="container-fluid" style="padding-top:5px;">

			<div class="row-fluid">
				<div class="span12 well">
					<div class="title">
						<a href="#">已发送信息列表</a> 
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
									<th>序号</th>
									<th>收件人</th>
									<th>标题</th>
									<th>概要</th>
									<th>内容</th>
									<th>时间</th>
									<!-- <th>状态</th>
									<th>状态</th> -->
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${messageList}" var="message" varStatus="m">
									<tr>
										<td>${m.index+1}</td>
										<td>${message.recipients}</td>
										<td>${message.title }</td>
										<td>${message.summary }</td>
										<td><div class="ellipsis_div">${message.content }</div></td>
										<%-- <td>${message.pubTime }</td> --%>
										<td><fmt:formatDate value="${message.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
										<%-- <td><span class="label light">未成交</span></td>
										<td><span class="label lightblue">认证</span></td> --%>
										<td>
											<%-- <span class="btn blue" onclick="update('1234','update.jsp?id=');">
											<i class="icon-edit"></i> 修改 
											</span>  --%>
											<span class="btn red">
												<i class="icon-trash"> </i>删除
											</span>
										</td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<form action="<%=basePath%>message/sentMessageList" method="post" id="sentMessageList">
							
						</form>
						<page:createPager pageSize="${pageSize}" totalPage="${totalPage}" totalCount="${totalCount}" curPage="${pageNum}" formId="sentMessageList"/>  
						
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