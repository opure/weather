<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <title>气象局云服务平台-中国天气通</title>
        <%@include file="/page/layout/html_header.jsp"%>
        <script type="text/javascript">
        	$(document).ready(function(){
        		
        		
        	});
        	
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
    	<div style="padding-top:50px;text-align:center;color:#fff;"><h1>海南决策气象服务管理平台</h1></div>
        <div class="login-page" style="height:85%;">
            <div class="login" style="display:block;">
            	<div id="login" style="">
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
	                            <a href="page/index.jsp" class="btn blue">
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
	                            <a href="page/index.jsp" class="btn blue">
	                            	提交
	                            </a>
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
        <div style="color: #fff;text-align:center;"><h5>版权所有 ©2013-2015 中国气象局公共气象服务中心</h5></div>
        <%@include file="/page/layout/html_footer_login.jsp"%>
        <script>
        </script>
    </body>
</html>

