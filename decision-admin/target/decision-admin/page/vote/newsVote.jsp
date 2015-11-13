<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>拇指校园</title>
<%@include file="/page/layout/html_header_tables.jsp"%>
<style type="text/css">
</style>
<script src="<%=basePath%>js/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="<%=basePath%>assets/js/uuid.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/uploadify.css">

<link rel="stylesheet" href="<%=basePath%>assets/jquery-ui/jquery-ui.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>assets/ztree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="<%=basePath%>assets/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<%-- <script type="text/javascript" src="<%=basePath%>js/getToken.js"></script> --%>
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
						<form class="form-horizontal" id="" name="" action="saveVote" method="post">
								<div class="control-group" style="margin-top:10px">
									<label class="control-label">投票主题:</label>
									<div class="controls">
										<input id="title" name="title" type="text"
											placeholder="" value="" class="input span3" />
									</div>
									<input type="hidden" id="" name="" value="${uid}" />
									
								</div>
								<div class="control-group">
									<label class="control-label">问卷链接:</label>
									 <div class="controls">
										<input id="votelink" name="votelink" type="text"
											placeholder="请输入问卷链接" class="input span6" />
									  </div>
							     </div>
							     	<div class="control-group">
									<label class="control-label">问卷图标:</label>
									 <div class="controls">
								       <div id="queue"></div>  
								        <input type="file" name=file_upload" id="file_upload" multiple="true" />  
								        <input name="token" type="hidden" id="token" value=""/>
								        <input type="hidden" name="imgurl" id="imgurl" value=""/>
									   </div>
							       </div>
								<div class="control-group" style="padding-top:15px;">
									<label class="control-label"></label>
									<div class="controls">
										<button id="saveBtn" type="submit" class="btn btn-success">保存</button> &nbsp;&nbsp;
										<button type="reset" class="btn">重置</button>
									</div>
								</div>
								</form>
								<script>
						 		var uploadify_formData = {'token' : ''+$("#token").val()+''};
								var uploadify_config = {
								    'uploader' : 'http://upload.qiniu.com/',
								    'swf' : '<%=request.getContextPath()%>/js/uploadify.swf',
								    'onSelect' : function(file){
								    	var uuid = new UUID().createUUID();
								    	uuid +=/\.[^\.]+/.exec(file.name);
								    	this.addPostParam("key",uuid);//改变文件名的编码
								    },
								    'fileObjName' : 'file', 	    
								    'wmode' : 'transparent',
								    'removeTimeout' : 0,
								    'width' : 120,
								    'height' : 30,
								    'multi' : true,
								    'auto' : true,
								    'buttonText' : '上传图片',
								    'hideButton' : 'true',
								    'fileTypeExts' : '*.png;*.jpg;*.jpeg',
								    'fileSizeLimit' : '3MB',	        
								    'fileTypeDesc' : '文件格式：*.png;*.jpg;*.jpeg',
								    'formData' : uploadify_formData,
								    'onUploadSuccess' : function(file, data, response) {
								        data=$.parseJSON(data);
								        console.log(data);
								    	var key=data.key;
								    	$("#imgurl").val("http://7xiwdw.com2.z0.glb.qiniucdn.com/"+data.key);
								    	console.log(data.key);
							        }
								};
								//通过ajax请求获取token
								$(function() {
									$.ajax({
										url:"/mzxy-admin/vote/getToken",//要请求的地址
										type:"post",
										async:false,
										cache:false,
										success:function(data){
											data = $.parseJSON(data);
											$("#token").val(data.token);
											}
									}),
									$("#file_upload").uploadify(uploadify_config);
								});	
							</script>
                    </body>
                </html>