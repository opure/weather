<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
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
									编辑投票
								</a>
							</li>
						</ul> 
					</div>
					<div id="voteDiv" class="well-content"   style="padding-left: 150px;">
								<div class="control-group" >
								<%-- 	<div class="controls">
										<p><span>${vote.title}</span></p>
									</div> --%>
									
								</div>
								<c:if test="${not empty voteContentList }">
									<c:forEach items="${voteContentList}" var="content" varStatus="c">
										<div id="div_${content.voteContentId}" class="control-group">
											<label class="control-label">投票项${c.index + 1}</label>
											<div class="controls">
												<input id="publisherName" name="title" type="text"
													value="${content.content}" class="input span3" />
												<span class="btn red" onclick="deleteVoteContent('${content.voteContentId}');">
													<i class="icon-trash"></i>删除
												</span>
											</div>
										</div> 
									</c:forEach>
								</c:if>
								<sf:form action="editVote" method="post" modelAttribute="vote">
									<div class="control-group">
									<sf:input type="hidden" path="voteId"/>
									<label class="control-label">投票主题:</label>
									<div class="controls">
										<sf:input type="text" id="title" path="title"/>
									</div>
									</div>
								<div class="control-group">
									<label class="control-label">问卷链接:</label>
									<div class="controls">
										<sf:input type="text" id="votelink" path="votelink"/>
									</div>
									</div>
								<div class="control-group">
									<label class="control-label"> </label>
									<div class="controls">
										<button id="updateBtn" type="submit" class="btn btn-success">更新</button> 
									</div>
								</div>
						    </sf:form>
					</div>
				</div>
			</div>
		</div>

		<%@include file="/page/layout/html_copyright.jsp"%>
	</div>
	<%@include file="/page/layout/html_footer_tables.jsp"%>
	
	<script type="text/javascript">
<%-- 	$("#updateBtn").bind("click", function(){
		var title=$("#title").val();
		var votelink=$("#votelink").val();
		$.ajax({
			type: "post",
			url: "<%=basePath%>vote/editVote",
			data: {title:title,votelink:votelink},
			dataType: "json",
			success: function(json){
				if(json.success){
					window.location.href = "<%=basePath%>vote/voteList";
				}
			}
		});
	}); --%>
			
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