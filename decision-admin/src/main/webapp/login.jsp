<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>气象局云服务平台-中国天气通</title>
<%@include file="/page/layout/html_header.jsp"%>
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="author" content="vanvalt">
<!-- Styles -->
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="assets/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
<link href="assets/gritter/css/jquery.gritter.css" rel="stylesheet" />
<link href="assets/css/login-style.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
        <script src="assets/js/html5shiv.js"></script>
        <![endif]-->
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="assets/ico/favicon.png">
</head>
<body>
<h3 class="text-center" style="color:#072f57; font-family:：'黑体'; margin-top:2%"><img src="assets/img/logo.png">中国天气通</h3>
<h1 class="text-center" style="margin-top:8%; font-family:：'黑体';color:#e6f2ff;">海南决策气象服务管理平台</h1>

    <div class="loginbox">
      <form class="form-inline">
        <div class="form-group">
          <label class="sr-only" for="exampleInputEmail3">用户名</label>
          <input type="text" class="form-control" id="username" placeholder="用户名">
        </div>
      </form>
      <form class="form-inline">
        <div class="form-group">
          <label class="sr-only" for="exampleInputEmail3">密&nbsp;&nbsp;&nbsp;码</label>
          <input type="password" class="form-control" id="password" placeholder="密码">
        </div>
      </form>
      <button class="btn btn-primary" style="margin-left:73%;" onclick="login();">登录</button>
    </div>
    <p class="text-center" style="color:#b7cce1; margin-top:130px;">版权所有 ©2013-2015 中国气象局公共气象服务中心</p>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="assets/js/excanvas.min.js"></script><![endif]--> 
<%@include file="/page/layout/html_footer_tables.jsp"%>
<script type="text/javascript">
	
	function login(){
		
		window.location.href = "<%=basePath%>page/index.jsp";
	}
</script>
</body>
</html>
