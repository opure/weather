<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <title>后台管理系统_拇指校园</title>
        <%@include file="/page/layout/html_header.jsp"%>
        <script type="text/javascript">
        	$(document).ready(function(){
        		
        		
        	});
        	
        	/**
        	* 登录入口
        	*/
        	function preLogin(type){
        		if(type == '2'){
        			$("#roleName").html("家长");
        		} else if(type == '1'){
        			$("#roleName").html("老师");
        		} else {
        			$("#roleName").html("");
        		}
        		
        		$("#type").val(type);
        	}
        	
        	/**
        	* 用户登录
        	*/
        	function toLogin(){
        	
        		var type = $("#type").val();
        		var phone = $("#phone").val();
		        var passwd = $("#passwd").val();
		       
		        if(phone == null || phone == ''){
		        	alert("请输入手机号码！");
		        	return;
		        }
		        
		        if(passwd == null || passwd == ''){
		        	alert("请输入密码！");
		        	return;
		        }
		        
		        $.ajax({
				   type: "POST",
				   url: "<%=basePath%>checkLogin",
				   data: {
					      phone:phone, passwd:passwd, type:type
					     },
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			location.href= "<%=basePath%>index"; 
				   		} else {
				   			alert(json.message);
				   		}
				   }
				});
        	
        	}
        </script>
    </head>
    <body>
        <div class="login-page">
            <div class="accounts">
                <h1>拇指校园管理后台</h1>
                <div id="user" class="users">
                    <a onclick="preLogin('2');" ><img src="assets/img/parents.png" alt="家长入口" /></a>
                </div>
                <div id="user2" class="users">
                    <a onclick="preLogin('1');" ><img src="assets/img/teacher.png" alt="老师入口" /></a>
                </div>
                <div id="user3" class="users">
                    <a onclick="preLogin('0');" ><img src="assets/img/school.png" alt="学校入口" /></a>
                </div>
            </div>
            <div class="login">
            	<div id="login">
            	<form id="loginForm" action="/login" method="post">
	                <h4><span id="roleName"></span>登录 <span class="pull-right users" onclick=""><i class="icon-remove-circle"></i></span></h4>
	                <div class="control-group">
	                    <div class="controls">
	                        <input type="text" id="phone" name="phone" placeholder="Username" class="input-block-level bordered-input">
	                        <input type="password" id="passwd" name="passwd" placeholder="Password" class="input-block-level bordered-input">
	                        <div class="pull-left">
	                            <a class="fpass" href="#" onclick="fpass();">
	                          	 	忘记密码?
	                            </a>
	                        </div>
	                        <div class="pull-right">
	                            <a id="submit" onclick="toLogin();" class="btn blue"><!--  <a href="page/index.jsp" class="btn blue"> -->
	                            	提交
	                            </a>
	                            <input type="hidden" id="type" name="type" value=""/>
	                        </div>
	                    </div>
	                </div>
                </form>
                </div>
                <div id="forget" style="display:none;">
            	<form id="forgetForm" action="/forget" method="post">
	                <h4><span id="roleName"></span>找回密码 <span class="pull-right users" onclick="back();"><i class="icon-remove-circle"></i></span></h4>
	                <div class="control-group">
	                    <div class="controls">
	                        <input type="text" id="phone" name="phone" placeholder="手机号码" class="input-block-level bordered-input">
	                        <input type="text" id="" name="" placeholder="验证码" class="">
	                        <button class="btn lightblue">获取验证码</button>
	                        <div class="pull-left">
	                            
	                        </div>
	                        <div class="pull-right">
	                            <a id="submit" onclick="" class="btn orange"><!--  <a href="page/index.jsp" class="btn blue"> -->
	                            	提交
	                            </a>
	                            <input type="hidden" id="type" name="type" value=""/>
	                        </div>
	                    </div>
	                </div>
                </form>
            </div>
            </div>
            
            <div class="container-fluid footer">
		        <div class="row-fluid">
		            <div class="span12">
		                <p class="pull-right"></p>
		            </div>
		        </div>
	        </div>
        </div>
        <%@include file="/page/layout/html_footer_login.jsp"%>
        <script>login();
        </script>
        <script type="text/javascript">
        	function fpass(){
        		$("#login").css("display", "none");
        		$("#forget").css("display", "block");
        	}
        	
        	function back(){
        		$("#login").css("display", "block");
        		$("#forget").css("display", "none");
        	}
        </script>
    </body>
</html>

