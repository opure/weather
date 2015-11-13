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

<title>投票管理 - 拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<style type="text/css">
	 .ellipsis_div{   
	 	width:100px;
	 	overflow:hidden;
	 	text-overflow:ellipsis;
	 	white-space:nowrap;
	 }
</style>
<script type="text/javascript">
    function addVote(){
      window.location.href="<%=basePath%>vote/newVote";
    }

	function editVote(voteId){
	
		if(voteId != null){
			window.location.href = "<%=basePath%>vote/editVoteUI?voteId="+voteId;
		}
	}
<%-- 	function deleteVote(voteId){
		
		$.ajax({
			type: "post",
			url: "<%=basePath%>vote/deleteVote",
			data: {voteId:voteId},
			dataType: "json",
			success: function(json){
				if(json.success){
					window.location.href = "<%=basePath%>vote/voteList";
				}
			}
		});
	} --%>
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
									投票列表
								</a>
							</li>
						 <li>
								<a href="<%=basePath%>vote/newVote" >
									新建投票
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
								    <th style="width:10%"></th>
									<th style="width:6%;">序号</th>
									<th style="width:20%;">投票主题</th>
									<th style="width:10%;">创建人</th>
									<th style="width:18%;">问卷链接</th>
									<!-- <th style="width:10%;">投票类型</th> -->
									<!-- <th style="width:8%;">状态</th> -->
									<th style="width:14%;">时间</th>
									<th style="width:16%; text-align:center">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${voteList}" var="vote" varStatus="v">
									<tr>
									   <td><img src="${vote.imgurl}" width="50" height="64"></td>
										<td>${v.index+1}</td>
										<td>
										 <div class="ellipsis_div" title="${vote.title}">
											${vote.title}
										 </div>
										</td>
										<%-- <td>${fn:substring("",0,2)}${fn:length("")>2?'...':''}</td> --%>
										<td>${vote.userName}</td>
										<%-- <td>
											<c:if test="${vote.type == 0}">单选</c:if>
											<c:if test="${vote.type == 1}">多选</c:if>
										</td>
										<td>
											<c:if test="${vote.publish == 0}"><span class="label lightblue">开放</span></c:if>
											<c:if test="${vote.publish == 1}"><span class="label light">未开放</span></c:if>
										</td> --%>
										<td>${vote.votelink }</td>
										<td><fmt:formatDate value="${vote.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
										<%-- <td><span class="label light">未成交</span></td>
										<td><span class="label lightblue">认证</span></td> --%>
										<td>
											<%-- <span class="btn blue" onclick="update('1234','update.jsp?id=');">
											<i class="icon-edit"></i> 修改 
											</span>  --%>
											<span class="btn blue" onclick="editVote('${vote.voteId}');">
												<i class="icon-edit"></i> 修改 
											</span>
											<a href="<%=basePath%>vote/deleteVote?voteId=${vote.voteId}" onclick="return window.confirm('您确定要删除此投票吗？')">
											<span class="btn red" >
												<i class="icon-trash"></i>删除
											</span>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<form action="<%=basePath%>vote/voteList" method="post" id="voteList"></form>
						<page:createPager pageSize="${pageSize}" totalPage="${totalPage}" totalCount="${totalCount}" curPage="${pageNum}" formId="voteList"/>
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