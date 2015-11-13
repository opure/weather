<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileUploader.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>assets/js/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>assets/js/ajaxfileupload.js"></script>
	<script type="text/javascript">  
		function ajaxFileUpload() {  
		 
		    $("#loading").ajaxStart(function() {  
		        $(this).show();  
		    })//开始上传文件时显示一个图片  
		    .ajaxComplete(function() {  
		        $(this).hide();  
		    });//文件上传完成将图片隐藏起来  
		 
		    $.ajaxFileUpload( {  
		        url : 'fileUpload.action',//用于文件上传的服务器端请求地址  
		        secureuri : false,//一般设置为false  
		        fileElementId : 'file',//文件上传控件的id属性  
		        dataType : 'json',//返回值类型 一般设置为json  
		        success : function(data, status) //服务器成功响应处理函数  
		        {  
		           alert(data.message);//从服务器返回的json中取出message中的数据,其中message为在struts2中定义的成员变量  
		            if (typeof (data.error) != 'undefined') {  
		                if (data.error != '') {  
		                   alert(data.error);  
		               } else {  
		                    alert(data.message);  
		                }  
		            }  
		        },  
		        error : function(data, status, e)//服务器响应失败处理函数  
		        {  
		            alert(e);  
		        }  
		    })  
		    return false;  
		}  
	</script>  
</head>  
<body>  
       <img src="img/loading.gif" id="loading" style="display: none;">  
        <input type="file" id="file" name="file" />  
       <br />  
       <input type="button" value="上传" onclick="return ajaxFileUpload();">  
    </body>  
</html>  
