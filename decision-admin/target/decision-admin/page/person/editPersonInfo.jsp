<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>个人信息修改 - 拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>

</head>
<body>
	<%@include file="/page/layout/html_navbar.jsp"%>
	<!-- /.navbar -->
	<!-- /.menu-inner -->
	<%@include file="/page/layout/html_menu_teacher.jsp"%>
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
						<a href="<%=basePath%>page/car">个人中心</a> > 个人信息
					</div>
					<div class="well-content">
						<form id="inputForm" action="<%=basePath%>teacher/savePersonInfo" method="post" class="form-horizontal">
							<fieldset>
								 <div class="control-group">
                                      <label class="control-label">
                                     	 老师职务
                                      </label>
                                      <div class="controls">
                                          <input id="focusedInput" type="text" name="roleName" value="${customer.roleName}" class="input span8">
                                      </div>
                                  </div>
                                  <div class="control-group">
                                      <label class="control-label">
                                      	老师姓名
                                      </label>
                                      <div class="controls">
                                          <input class="input span8" type="text" name="name" value="${customer.name}" placeholder="老师姓名">
                                      </div>
                                  </div>
                                  <div class="control-group">
                                      <label class="control-label">
                                      	老师电话
                                      </label>
                                      <div class="controls">
                                          <input class="input span8 disabled" type="text" name="phone" value="${customer.phone}" disabled="" placeholder="登录手机号">
                                          <input type="hidden" name="uid" value="${customer.uid}" />
                                      </div>
                                  </div>
                                  <div class="control-group">
                                      <label class="control-label">
                                      	老师邮箱
                                      </label>
                                      <div class="controls">
                                          <div class="input-prepend">
                                              <span class="add-on">
                                              @
                                              </span>
                                              <input class="span8" type="text" name="email" value="${customer.email}" placeholder="Email Address" />
                                          </div>
                                      </div>
                                  </div>
                                  <div class="control-group">
                                      <div class="controls">
                                      	<button id="savePersonInfoBtn" type="button" onclick="formSubmit();" class="btn btn-primary">保存</button>
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
		$("#inputForm").submit();
	}
</script>
	
</body>
</html>