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

<title>信息接收 - 拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<script type="text/javascript">

	function deleteMessage(msgId, publisherId){
		
		$.ajax({
			type: "post",
			url: "<%=basePath%>message/deleteSentMessage",
			data: {msgId:msgId, publisherId:publisherId},
			dataType: "json",
			success: function(json){
				if(json.success){
					window.location.href = "<%=basePath%>message/sentMessageMgt";
				}
			}
		});
	}
</script>
</head>
<body>
	<%@include file="/page/layout/html_navbar.jsp"%>
	<!-- /.navbar -->
	<!-- /.menu-inner -->
	<%@include file="/page/layout/html_menu_teacher.jsp"%>
	<!-- /.menu -->
	<div class="page-wrap">
		<div class="container-fluid" style="padding-top:5px;">

			<div class="row-fluid">
				<div class="span12 well">
					<div class="title">
						 <ul class="nav nav-tabs">
                           	<li class="heading"></li>
							<li class="active">
								<a href="#tab" data-toggle="tab">
									已发信息列表
								</a>
							</li>
							<li>
								<a href="<%=basePath%>message/publishMessage" >
									发送信息
								</a>
							</li>
						</ul> 
					</div>
					<div class="well-content">
						
						<table class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th style="width:5%;">序号</th>
									<th style="width:10%;">收件人</th>
									<th style="width:10%;">标题</th>
									<th style="width:12%;">概要</th>
									<th style="width:35%;">内容</th>
									<th style="width:12%;">时间</th>
									<th style="width:8%;">
										操作
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${messageList}" var="message" varStatus="m">
									<tr>
										<td>${m.index+1}</td>
										<td>${message.recipients}</td>
										<td>${message.title }</td>
										<td>${message.summary }</td>
										<td>${message.content }</td>
										<td><fmt:formatDate value="${message.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
										<td>
											<span class="btn red" onclick="confirm('确认要删除该信息？',deleteMessage('${message.uid}', '${message.publisherId}'));">
												<i class="icon-trash"> </i>删除
											</span>
										</td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<form action="<%=basePath%>message/sentMessageMgt" method="post" id="sentMessageList"></form>
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