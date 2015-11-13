<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-touch-fullscreen" content="yes">      
        <meta name="description" content="物流信息通管理后台">
        <meta name="author" content="CHENBO.WANG QQ.178855730">
        <!-- Styles -->
        <link href="<%=basePath%>assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link href="<%=basePath%>assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
        <link href="<%=basePath%>assets/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
        <link href="<%=basePath%>assets/gritter/css/jquery.gritter.css" rel="stylesheet" />
        <link href="<%=basePath%>assets/css/styles.css" rel="stylesheet" />
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
        <script src="<%=basePath%>assets/js/html5shiv.js"></script>
        <![endif]-->
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=basePath%>assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=basePath%>assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=basePath%>assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="<%=basePath%>assets/ico/apple-touch-icon-57-precomposed.png">
        <%-- <link rel="shortcut icon" href="<%=basePath%>assets/ico/favicon.png">  --%>
        <link rel="shortcut icon" href="<%=basePath%>assets/ico/favicon.ico"> 
        <script src="<%=basePath%>assets/js/jquery-1.7.min.js" type="text/javascript"></script>	
        <script src="<%=basePath%>assets/js/wlxxt.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/js/FormValid.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/js/FV_onBlur.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/js/uuid.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/js/SetTime.js" type="text/javascript"></script>
        <c:set var="ctx" value="${pageContext.request.contextPath}"/>
        <c:set var="ctxStatic" value="${pageContext.request.contextPath}/assets"/>
		<c:set var="webapp" value="${pageContext.request.contextPath}"/>
        
    
