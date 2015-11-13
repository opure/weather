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
<link rel="stylesheet" href="<%=basePath%>assets/jquery-ui/jquery-ui.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>assets/jquery-ui/js/jquery-ui.js"></script>
<script type="text/javascript">
	
	var recipientId = '${recipientId}';
	
	function setReadFlag(msgId){
	
		$.ajax({
			type: "post",
			url: "<%=basePath%>message/setMessageReadFlag",
			data: {msgId:msgId, recipientId:recipientId},
			dataType: "json",
			success: function(json){
				if(json.success){
					window.location.href = "<%=basePath%>message/receiveMessageList";
				}
			}
		});
	}
	
	var uid = '${uid}';
	
	function setReadFlag(msgId){
	
		$.ajax({
			type: "post",
			url: "<%=basePath%>message/setMessageReadFlag",
			data: {msgId:msgId, recipientId:recipientId},
			dataType: "json",
			success: function(json){
				if(json.success){
					window.location.href = "<%=basePath%>message/receiveMessageList";
				}
			}
		});
	}
	
	function checkall(){
		var id = "checkall";
		var ischecked = $("#"+id).attr("checked");
		if(ischecked) {
			checkallbox();
		} else {
			discheckallbox();
		}
	}
	
	//选中全部复选框
	function checkallbox() {
		var boxarray = $("input[name=obj]");
		for(var i = 0; i < boxarray.length; i++) {
			boxarray[i].checked = true;
		}
	}
	
	//取消选中全部复选框
	function discheckallbox() {
	
		var boxarray = $("input[name=obj]");
		for(var i = 0; i < boxarray.length; i++) {
			boxarray[i].checked = false;
		}
	}
	
	//点击某个复选框，如果所有复选框都选中，“全选/全不选”复选框也选中 //否则如果所有复选框都取消选中，“全选/全不选”复选框也取消选中
	function checkonebox(){
		if(isallchecked()) {
			var id = "checkall";
			$("#"+id).attr("checked", true);
		}
		
		if(isalldischecked()) {
			var id = "checkall";
			$("#"+id).attr("checked", false);
		}
	}
	
	//是否全部选中
	function isallchecked() {
		var boxarray = $("input[name=obj]");
		for(var i = 0; i < boxarray.length; i++) {
			if(!boxarray[i].checked) {
				return false;
			}
		}

		return true;
	}

	//是否全部没有选中
	function isalldischecked() {
		var boxarray = $("input[name=obj]");
		for(var i = 0; i < boxarray.length; i++) {
			if(boxarray[i].checked) {
				return false;
			}
		}
		
		return true;
	}
	
	//得到选中项的值的集合
	function getallcheckedvalue() {
	
		var boxvalues = "";
		var boxarray = $("input[name=obj]");
		for(var i = 0; i < boxarray.length; i++) {
			if(boxarray[i].checked) {
				var boxvalue = boxarray[i].value;
				if(boxvalues == "") {
					boxvalues = boxvalue;
				} else {
					boxvalues = boxvalues + "," + boxvalue;
				}
			}
		 } 
		 
		 return boxvalues;
	}
		
	//只得到其中选中项的id值的集合 
	function getIds() {
	
		var boxvalues = getallcheckedvalue();
		var boxvaluesArray = boxvalues.split(",");
		var ids = "";
		for(var i = 0; i < boxvaluesArray.length; i++) {
			var boxvalue = boxvaluesArray[i];
			var boxvalueArray = boxvalue.split("|");
			var id = boxvalueArray[0];
			var username = boxvalueArray[1];
			if(ids == "") {
				ids = id;
			}else {
				ids = ids + "," + id;
			}
		}
		
		return ids;
	}
	
	/**
	* 批量处理信息已读状态
	*/
	function batchSubmit(flag){
		var ids = getIds();
		
		$.ajax({
			type: "post",
			url: "<%=basePath%>message/batchResetReadFlag",
			data: {uid: uid, ids: ids, flag: flag},
			dataType: "json",
			success: function(json){
				if(json.success){
					window.location.href = "<%=basePath%>message/receiveMessageList";
				}
			}
		});
	}
	
	$(document).ready(function(){
	
		$("#viewDialog").dialog({
			autoOpen: false,
			width: 600,
			buttons: [
				{
					text: "取消",
					click: function() {
						window.location.href="<%=basePath%>message/receiveMessageList";
						$(this).dialog("close");
					}
				} 
			]
		});
		
		
	});
	
	/**
	* 根据ID获取信息详情
	*/
	function viewMessage(msgId, isRead){
		
		$.ajax({
			type: "post",
			url: "<%=basePath%>message/getMessageDetailById",
			data: {msgId: msgId, isRead: isRead, recipientId: recipientId},
			dataType: "json",
			success: function(json){
				if(json.success){
					$("#title").val(json.title);
					$("#summary").val(json.summary);
					$("#content").val(json.content);
					$("#pubTime").val(json.pubTime);
					$("#publisher").val(json.publisher);
				}
			}
		});
		
		$("#viewDialog").dialog("open");
	}
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
						<a href="#">信息接收列表</a>
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
							<div class="span12">
								<div class="" id="managed-table_filter">
									<span class="btn blue" onclick="batchSubmit('0');">
										<i class="icon-edit"></i> 标记已读 
									</span>&nbsp;&nbsp;
									<span class="btn lightblue" onclick="batchSubmit('1');">
										<i class="icon-edit"></i> 标记未读 
									</span>
								</div>
							</div> 
						</div>
						<table class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th><input id="checkall" type="checkbox" value="" onclick="checkall();"/>&nbsp;全选</th>
									<th>序号</th>
									<th>收件人</th>
									<th>发件人</th>
									<th>标题</th>
									<th>概要</th>
									<th>状态</th>
									<th>时间</th>
									<th>操作</th> 
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${messageList}" var="message" varStatus="m">
									<tr>
										<td style="text-align:center;"><input type="checkbox" name="obj" value="${message.uid}"/></td>
										<td>${m.index+1}</td>
										<td>${message.recipientName}</td>
										<td>${message.publisher.name }</td>
										<td>${message.title }</td>
										<td>${message.summary }</td>
										<td>
											<c:if test="${message.isRead eq '0'}">
												<span class="label lightblue">未读</span>
											</c:if>
											<c:if test="${message.isRead ne '0'}">
												<span class="label light">已读</span>
											</c:if>
										</td>
										<%-- <td>${message.pubTime }</td> --%>
										<td><fmt:formatDate value="${message.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
										<%-- <c:if test="${message.isRead eq '0'}">
										<td><span class="btn blue" onclick="setReadFlag('${message.uid}');">
											<i class="icon-edit"></i> 标记已读 
											</span> </td> 
										</c:if>
										<c:if test="${message.isRead ne '0'}">
										<td></td> 
										</c:if> --%>
										<td>
											<span class="btn blue" onclick="viewMessage('${message.uid}', '${message.isRead}');">
												<i class="icon"></i> 查看 
											</span>
										</td>
										<%--<td>
											 <span class="btn blue" onclick="update('1234','update.jsp?id=');">
											<i class="icon-edit"></i> 修改 
											</span>  
											<span class="btn red">
												<i class="icon-trash"> </i>删除
											</span>
										</td>--%>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<form action="<%=basePath%>message/receiveMessageList" method="post" id="receiveMessageList">
							
						</form>
						<page:createPager pageSize="${pageSize}" totalPage="${totalPage}" totalCount="${totalCount}" curPage="${pageNum}" formId="receiveMessageList"/>  
						
					</div>
				</div>
			</div>
		</div>

		<!-- 信息查看dialog start -->
		<div id="viewDialog" class="container-fluid" title="信息详情">
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<td>发件人</td>
					<td><input type="text" id="publisher" class="span4" disabled/></td>
				</tr>
				<tr>
					<td>发布时间</td>
					<td><input type="text" id="pubTime" class="span4" disabled/></td>
				</tr>
				<tr>
					<td>标题</td>
					<td><input type="text" id="title" class="span4" disabled/></td>
				</tr>
				<tr>
					<td>概要</td>
					<td><input type="text" id="summary" class="span4" disabled /></td>
				</tr>
				<tr>
					<td>内容</td>
					<td>
						<textarea rows="4" cols="30" id="content" class="span4" disabled></textarea>
						<!-- <input type="text" id="content" disabled/> -->
					</td>
				</tr>
			</table>
		</div>
		<!-- 信息查看dialog end -->
		
		<%@include file="/page/layout/html_copyright.jsp"%>
	</div>
	<%@include file="/page/layout/html_footer_tables.jsp"%>
	<script>
		data_tables();
	</script>
</body>
</html>