<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>信息模板 - 拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<link rel="stylesheet" href="<%=basePath%>assets/jquery-ui/jquery-ui.css" type="text/css">
<script type="text/javascript">

	var uid = '${uid}';
	
	$(document).ready(function(){
	
		// 初始化dialog
		$("#editDialog").dialog({
			autoOpen: false,
			width: 450,
			buttons: [
				{
					text: "确定",
					click: function() {
						saveTemplate();
						$(this).dialog("close");
					}
				},
				{
					text: "取消",
					click: function() {
						$(this).dialog("close");
					}
				}
			]
		});
		
		
	});
	
	/**
	* 新增信息模板
	*/
	function addTemplate(){
		
		$.ajax({
			type: "post",
			url: "<%=basePath%>template/templateCount",
			data: {uid:uid},
			dataType: "json",
			success: function(json){
				if(json.success){
					var totalCount = json.count;
					if(totalCount >=10){
						alert("对不起，至多可以创建10条信息模板！");
					} else {
						$("#editDialog").dialog("open");
					}
				}
			}
		});
		
	}
	
	/**
	* 保存信息模板
	*/
	function saveTemplate(){
	
		var title = $("#title").val();
		var summary = $("#summary").val();
		var template = $("#template").val();
		var templateId = $("#templateId").val();
		
		$.ajax({
			type: "post",
			url: "<%=basePath%>template/save",
			data: {uid:uid, title:title, summary:summary, template:template, templateId:templateId},
			dataType: "json",
			success: function(json){
				if(json.success){
					window.location.href = "<%=basePath%>template/list";
				}
			}
		});
		
	}
	
	/**
	* 编辑信息模板（初始化）
	*/
	function editTemplate(id){
	
		$.ajax({
			type: "post",
			url: "<%=basePath%>template/editTemplate",
			data: {id:id},
			dataType: "json",
			success: function(json){
				$("#title").val(json.title);
				$("#summary").val(json.summary);
				$("#template").html(json.template);
				$("#templateId").val(id);
				$("#editDialog").dialog("open");
			}
		});
	}
	
	/**
	* 删除信息模板
	*/
	function deleteTemplate(id){
		
		$.ajax({
			type: "post",
			url: "<%=basePath%>template/deleteTemplate",
			data: {id:id},
			dataType: "json",
			success: function(json){
				if(json.success){
					window.location.href = "<%=basePath%>template/list";
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
		<div class="container-fluid">

			<div class="row-fluid" style="padding-top:5px;">
				<div class="span12 well">
					<div class="title">
						<a href="#">信息模板列表</a> 
					</div>
					<div class="well-content">
						<div class="row-fluid">
							<div class="span12">
								<div class="" id="managed-table_filter">
									<span class="btn blue" onclick="addTemplate();">
										<i class="icon-edit"></i> 新增 
									</span> 
								</div>
							</div>
						</div>
						<tags:message content="${message}"/>
						<table class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th style="width:6%;">序号</th>
									<th style="width:10%;">标题</th>
									<th style="width:10%;">概要</th>
									<th style="width:44%;">内容</th>
									<!-- <th>类型</th> -->
									<th style="width:14%;">创建时间</th>
									<th style="width:16%;">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${messageTemplateList}" var="template" varStatus="t">
									<tr>
										<td>${t.index+1}</td>
										<td>${template.title}</td>
										<td>${template.summary}</td>
										<td>${template.template}</td>
										<!-- <td></td> -->
										<td><fmt:formatDate value="${template.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
										<%-- <td><span class="label light">未成交</span></td>
										<td><span class="label lightblue">认证</span></td> --%>
										<td>
											<span class="btn blue" onclick="editTemplate('${template.uid}');">
												<i class="icon-edit"></i> 修改 
											</span> 
											<span class="btn red" onclick="confirm('确认要删除该模板？',deleteTemplate('${template.uid}'));">
												<i class="icon-trash"> </i>删除
											</span>
										</td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
				<!-- 群组名称编辑dialog -->
				<div id="editDialog" title="信息模板">
					<div class="control-group">
						<label class="control-label">标题</label>
						<div class="controls">
                      		<div class="wmd-panel">
                          		<input class="input" type="text" id="title" name="title" value="" placeholder="标题"/>
                      		</div>		
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">概要</label>
						<div class="controls">
                      		<div class="wmd-panel">
                          		<input class="input" type="text" id="summary" name="summary" value="" placeholder="概要"/>
                      		</div>		
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">内容</label>
						<div class="controls">
                      		<div class="wmd-panel">
                          		<textarea style="margin: 0px; height: 100px;" id="template" name="template"
                        			class="wmd-input span4" placeholder="请填写模板内容" id="wmd-input"></textarea>
                      		</div>		
						</div>
					</div>
					<input type="hidden" id="templateId" name="templateId" />
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