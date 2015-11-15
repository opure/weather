<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<title>预警管理 - 气象局云服务平台海南决策服务</title>
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
								<a href="<%=basePath%>alarm/index" >
									生效中
								</a>
							</li>
							<li>
								<a href="<%=basePath%>alarm/all" >
									全部预警
								</a>
							</li>
							<li class="active">
								<a href="#" data-toggle="tab">
									编辑预警信息
								</a>
							</li>
						</ul> 
					</div>
					<div class="well-content">
						<form class="form-horizontal" id="publishMessageForm" name="publishMessageForm" 
							action="#" method="post">
							<fieldset>
								<div class="control-group">
									<label class="control-label">预警ID</label>
									<div class="controls">
										<input id="alertId" name="alertId" type="text" disabled
											value="${alarmInfo.alertId }" class="wmd-input span6" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">预警PID</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" name="alertPid" class="wmd-input span6" disabled
                                    			id="alertPid" value="${alarmInfo.alertPid }"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">省名称</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="province" name="province" class="wmd-input span6"
                                    			value="${alarmInfo.province }"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">城市名称</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="city" name="city" class="wmd-input span6" 
                                    			value="${alarmInfo.city }"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">预警类型</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="signalType" name="signalType" class="wmd-input span6" 
                                    			value="${alarmInfo.signalType }"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">预警级别</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="signalLevel" name="signalLevel" class="wmd-input span6" 
                                    			value="${alarmInfo.signalLevel }"/>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">发布时间</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="issueTime" name="issueTime" class="wmd-input span3 form_datetime"
                                    			value="${alarmInfo.issueTime }" /> <span style="color:red;">(注意时间格式)</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">解除时间</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<input type="text" id="relieveTime" name="relieveTime" class="wmd-input span3 form_datetime" 
                                    			value="${alarmInfo.relieveTime }"/> <span style="color:red;">(注意时间格式)</span>
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">内容</label>
									<div class="controls">
                                		<div class="wmd-panel">
                                    		<textarea style="margin: 0px; height: 100px;" name="issueContent"
                                    		 class="wmd-input span6" id="issueContent">${alarmInfo.issueContent }</textarea> 
                                		</div>		
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"> </label>
									<div class="controls">
										<button id="formSubmit" type="button" class="btn btn-success" onclick="save();">保存</button> &nbsp;&nbsp;
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
	        format: "yyyy-mm-dd hh:ii:ss",
	        autoclose: true,
	        todayBtn: true,
	        pickerPosition: "bottom-left"
	        //pickerPosition: "top-right"
	    });
	    
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
	</script>   
</body>
</html>