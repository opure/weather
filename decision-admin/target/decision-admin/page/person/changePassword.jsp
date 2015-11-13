<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>修改密码 - 拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>

</head>
<body>
	<%@include file="/page/layout/html_navbar.jsp"%>
	<!-- /.navbar -->
	<!-- /.menu-inner -->
	<c:if test="${currentUser.type eq '1'}">
		<%@include file="/page/layout/html_menu_teacher.jsp"%>
	</c:if>
	<c:if test="${currentUser.type eq '2'}">
		<%@include file="/page/layout/html_menu_parent.jsp"%>
	</c:if>
	<!-- /.menu -->
	<div class="page-wrap">
		<!-- <div class="breadcrumb">
			<a class="btn orange" href="#"><i class="icon-plus"></i></a> <a
				class="btn" href=""> 发布个人信息</a>
			<div class="pull-right">
				<a class="btn btn-info" href="#"><i class="icon-calendar"></i></a> <a
					class="btn" href="#">13/08/13</a>
			</div>
		</div>  -->
		<div class="container-fluid" style="padding-top:5px;">

			<div class="row-fluid">
				<div class="span6 well">
					<div class="title">
						<a
							href="#">个人中心</a> > 修改密码
					</div>
					<div class="well-content">
						<form id="inputForm" action="<%=basePath%>changePassword" method="post" class="form-horizontal">
							<fieldset>
								 <div class="control-group">
                                      <label class="control-label">
                                     	 旧密码
                                      </label>
                                      <div class="controls">
                                          <input id="oldPassword" type="password" name="oldPassword" class="input span8" placeholder="请输入旧密码">
                                      </div>
                                  </div>
                                  <div class="control-group">
                                      <label class="control-label">
                                      	新密码
                                      </label>
                                      <div class="controls">
                                          <input class="input span8" type="password" id="newPassword" name="newPassword" placeholder="请输入新密码">
                                      </div>
                                  </div>
                                  <div class="control-group">
                                      <div class="controls">
                                      	<button id="changePasswordBtn" type="button" onclick="formSubmit();" class="btn btn-primary">保存</button>
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
	
	function formSubmit(){
	
		var password = $("#oldPassword").val();
		$.ajax({
				   type: "POST",
				   url: "<%=basePath%>checkPassword",
				   data: {
					      	password:password
					     },
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			changePassword();
				   		} else {
				   			alert(json.message);
				   		}
				   }
		});
		
	}
	
	function changePassword(){
	
		var password = $("#oldPassword").val();
		var newPassword = $("#newPassword").val();
		$.ajax({
				   type: "POST",
				   url: "<%=basePath%>changePassword",
				   data: {
					      	newPassword:newPassword
					     },
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			window.location.href="<%=basePath%>toChangePassword";
				   		}
				   }
		});
	}
</script>
	
</body>
</html>