<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>应用信息管理 - 气象局云服务平台海南决策服务</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<link rel="stylesheet" href="<%=basePath%>assets/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<style type="text/css">
	 .ellipsis_div{   
	 	width:100px;
	 	overflow:hidden;
	 	text-overflow:ellipsis;
	 	white-space:nowrap;
	 }
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<%@include file="/page/layout/html_navbar.jsp"%>
	<!-- /.navbar -->
	<!-- /.menu-inner -->
	<%@include file="/page/layout/html_menu.jsp"%>
	<!-- /.menu -->
	<div class="page-wrap">
		<div class="container-fluid" style="padding-top:5px;">

			<div class="row-fluid">
				<div class="span12 well">
					<div class="title">
						<ul class="nav nav-tabs">
                           	<li class="heading"></li>
							<li>
								<a href="<%=basePath%>app/index" >
									应用信息
								</a>
							</li>
							<li class="active">
								<a href="#" data-toggle="tab">
									编辑应用信息
								</a>
							</li>
						</ul> 
					</div>
					<div class="well-content">
						<form class="form-horizontal" id="publishMessageForm" name="publishMessageForm" 
							action="#" method="post">
							<fieldset>
								<div class="control-group">
									<label class="control-label">应用名称</label>
									<div class="controls">
										<input id="title" name="title" type="text" 
											value="${appInfo.title }" class="wmd-input span6" /><span style="font-weight:bold;color:red;">*</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">应用安装包名称</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" name="packageName" class="wmd-input span6" 
                                    			id="packageName" value="${appInfo.packageName }"/><span style="font-weight:bold;color:red;">*</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">版本号</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="version" name="version" class="wmd-input span6"
                                    			value="${appInfo.version}"/><span style="font-weight:bold;color:red;">*</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">版本地址</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="versionUrl" name="versionUrl" class="wmd-input span6" 
                                    			value="${appInfo.versionUrl}"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">版本介绍</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<textarea style="margin: 0px; height: 100px;" name="versionDescription"
                                    		 class="wmd-input span6" id="versionDescription">${appInfo.versionDescription }</textarea> 
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">联系电话</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="tel" name="tel" class="wmd-input span6" 
                                    			value="${appInfo.tel}"/><span style="font-weight:bold;color:red;">*</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">应用介绍</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<textarea style="margin: 0px; height: 100px;" name="description"
                                    		 class="wmd-input span6" id="description">${appInfo.description}</textarea> <span style="font-weight:bold;color:red;">*</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">应急响应数据源地址</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="emergency" name="emergency" class="wmd-input span6" 
                                    			value="${appInfo.emergency}"/> <span style="font-weight:bold;color:red;">*</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">模板选择</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                			<input type="text" id="templateId" name="templateId" class="wmd-input span6" 
                                    			value="${appInfo.templateId}"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">官方网址</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                			<input type="text" id="website" name="website" class="wmd-input span6" 
                                    			value="${appInfo.website}"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">联系邮箱</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                			<input type="text" id="email" name="email" class="wmd-input span6" 
                                    			value="${appInfo.email}"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">应用Icon</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<img alt="" style="width:209px;height:204px;" src="<%=basePath%>assets/img/icon.png"> <span style="font-weight:bold;color:red;">*</span>(1024*1024)
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">应用闪屏</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<img alt="" style="width:111px;height:203px;" src="<%=basePath%>assets/img/screen.jpg"> <!-- ${appInfo.screen } --> <span style="font-weight:bold;color:red;">*</span>(640*1200)
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Ios配置信息</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<textarea style="margin: 0px; height: 100px;" name="iosOther"
                                    		 class="wmd-input span6" id="iosOther">${appInfo.iosOther}</textarea> <span style="font-weight:bold;color:red;">*</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Android配置信息</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<textarea style="margin: 0px; height: 100px;" name="androidOther"
                                    		 class="wmd-input span6" id="androidOther">${appInfo.androidOther}</textarea><span style="font-weight:bold;color:red;">*</span> 
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">版权信息</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                			<input type="text" id="copyright" name="copyright" class="wmd-input span6" 
                                    			value="${appInfo.copyright}"/> <span style="font-weight:bold;color:red;">*</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"> </label>
									<div class="controls">
										<button id="formSubmit" type="button" class="btn btn-success" onclick="save();">保存</button> &nbsp;&nbsp;
										<button id="formCancel" type="button" class="btn btn-default" onclick="cancel();">取消</button> &nbsp;&nbsp;
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
			
	    /**
	    * 保存预警信息
	    */
	    function save(){
			
	    	var alertId = $("#alertId").val();
	    	var province = $("#province").val();
	    	var city = $("#city").val();
	    	var signalType = $("#signalType").val();
	    	var signalLevel = $("#signalLevel").val();
	    	var issueTime = $("#issueTime").val();
	    	var relieveTime = $("#relieveTime").val();
	    	if(issueTime != null && issueTime != ""){
	    		
	    		if(relieveTime != null && relieveTime != ""){
	    			
	    			var issueDate=Date.parse(issueTime.replace(/-/g,"/"));
	    			var relieveDate = Date.parse(relieveTime.replace(/-/g,"/"));
	    			
	    			if(issueDate > relieveDate){
	    				alert("发布时间不得晚于解除时间！");
	    				return false;
	    			}
	    		}
	    		
	    	}
	    	
	    	var issueContent = $("#issueContent").val();
	    	
			$.ajax({
				type: "POST",
				url: "<%=basePath%>alarm/save",
				data: {
						alertId: alertId,
						province: province,
						city: city,
						signalType: signalType,
						signalLevel: signalLevel,
						issueTime: issueTime,
						relieveTime: relieveTime,
						issueContent: issueContent
						},
				dataType: "json",
				success: function(json){
				
					if(json.success){
						window.location.href = "<%=basePath%>alarm/all";
					}
				}
			});
		}
	    
	    function cancel(){
	    	
	    	window.location.href = "<%=basePath%>app/index";
	    }
	</script>   
</body>
</html>