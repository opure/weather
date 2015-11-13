<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../commInc/inc_voteInfo.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<style type="text/css">

</style>
<link rel="stylesheet" href="<%=basePath%>assets/jquery-ui/jquery-ui.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>assets/ztree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>assets/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">

		$(document).ready(function(){
			
			// 初始化dialog
			$("#dialog").dialog({
				autoOpen: false,
				width: 400,
				buttons: [
					{
						text: "确定",
						click: function() {
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
			
			// 下一步
			$("#nextBtn").bind("click", function(){
				
				if(validation()){
					
					var count = $("#count").val();
					$("#voteItems").empty();
					generateVoteItem(count);
					
					$("#voteDiv").css("display", "none");
					$("#voteContentDiv").css("display", "block");
				} 
				
			});
			// 上一步
			$("#lastBtn").bind("click", function(){
				
				$("#voteDiv").css("display", "block");
				$("#voteContentDiv").css("display", "none");
			});
			// 保存
			$("#saveBtn").bind("click", function(){
				
				$("input[name='voteContent']").each(
					function(){
						//alert($(this).val());
					}
					
				);
				
				var voteContentObj = $("input[name='voteContent']").map(
										function(){ 
											return $(this).val();
										}
									).get().join(",");
				
				$("#voteContentTitle").append(voteContentObj);
				
				var title = $("#title").val();
				var voteType = $("input[name='voteType']:checked").val();
				var publish = $("input[name='publish']:checked").val();
				
				//alert(title +", "+ voteType +", "+ publish);
				$.ajax({
					type: "post",
					url: "<%=basePath%>vote/saveVote",
					data: {title:title, voteType:voteType, publish:publish, voteContent:voteContentObj},
					dataType: "json",
					success: function(json){
						if(json.success){
							window.location.href = "<%=basePath%>vote/voteList";
						}
					}
				});
				
			});
			
		});
		
		/** 
		* 动态生成投票项
		*/
		function generateVoteItem(count){
			
			for(var i=0;i<count;i++){
				var index = i+1;
				$("#voteItems").append('<div class="control-group">')
								.append('<label class="control-label"> 第 ' + index + ' 项 &nbsp; </label>')
								.append('<div class="controls">')
								.append('<input id="voteItem_"'+ index +' name="voteContent" type="text" placeholder="请输入投票选项内容" class="input span3" />')
								.append('</div></div>');
			}
		}
		
		/**
		* 数值校验
		*/
		function validation(){
		
			var title = $("#title").val();
			var count = $("#count").val();
			
			if(title == ''){
				alert("标题不能为空！");
				return false;
			}
			
			if(count == ''){
				alert("请输入子选项个数！");
				return false;
			} else if(isNaN(count)){
				alert("子选项个数输入有误！");
				return false;
			}
			
			return true;
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
							<li>
								<a href="<%=basePath%>vote/voteList" >
									投票列表
								</a>
							</li>
							<li class="active">
								<a href="#" data-toggle="tab">
									新建投票
								</a>
							</li>
						</ul> 
					</div>
					<div id="voteDiv" class="well-content">
						<form class="form-horizontal" id="" name="" action="#" method="post">
							<fieldset>
								<div class="control-group">
									<label class="control-label">投票主题</label>
									<div class="controls">
										<input id="title" name="title" type="text"
											placeholder="" value="" class="input span3" />
									</div>
									<input type="hidden" id="" name="" value="${uid}" />
								</div>
								<div class="control-group">
									<label class="control-label">子选项个数</label>
									<div class="controls">
										<input id="count" name="count" type="text"
											placeholder="请输入子选项个数" class="input span6" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">投票类型 </label>
									<div class="controls">
										<c:forEach items="${_voteType}" var="voteType" varStatus="v">
											<input type="radio" name="voteType" value="${voteType.key}" <c:if test="${voteType.key eq 0}"> checked=checked</c:if>/>
											&nbsp;${voteType.value}&nbsp;&nbsp;
										</c:forEach>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">是否开放 </label>
									<div class="controls">
										<c:forEach items="${_publish}" var="publish" varStatus="p">
											<input type="radio" name="publish" value="${publish.key}" <c:if test="${publish.key eq 0}"> checked=checked</c:if>/>
											&nbsp;${publish.value}&nbsp;&nbsp;
										</c:forEach>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label"> </label>
									<div class="controls">
										<button id="nextBtn" type="button" class="btn btn-success">下一步</button> &nbsp;&nbsp;
										<button type="button" class="btn">重置</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					
					<div id="voteContentDiv" class="well-content" style="display:none;">
						<form class="form-horizontal" id="" name="" action="#" method="post">
							<fieldset>
								<div class="control-group">
									<label id="voteContentTitle" class="control-label">请输入投票项内容：</label>
								</div>
								<div id="voteItems">
									<!-- 
									<div class="control-group">
										<label class="control-label">投票项</label>
										<div class="controls">
											<input id="publisherName" name="title" type="text"
												placeholder="" value="" class="input span3" />
										</div>
									</div> 
									-->
								</div>
								
								<div class="control-group" style="padding-top:15px;">
									<label class="control-label"></label>
									<div class="controls">
										<button id="lastBtn" type="button" class="btn btn-success">上一步</button> &nbsp;&nbsp;
										<button id="saveBtn" type="button" class="btn btn-success">保存</button> &nbsp;&nbsp;
										<button type="button" class="btn">重置</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					
				</div>
			</div>
		</div>

		<%@include file="/page/layout/html_copyright.jsp"%>
	</div>
	<%@include file="/page/layout/html_footer_tables.jsp"%>
	
	<script type="text/javascript">
			
	    $(".form_datetime").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true,
	        //pickerPosition: "bottom-left"
	        pickerPosition: "top-right"
	    });
	    
	</script>   
</body>
</html>