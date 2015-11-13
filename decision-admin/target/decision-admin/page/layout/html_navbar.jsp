<%@ page language="java" pageEncoding="UTF-8"%>
	<script type="text/javascript">
		
		$(document).ready(function(){
			
			/**
			* 加载用户信息
			*/
			$.ajax({
				   type: "POST",
				   url: "<%=basePath%>getCurrentUser",
				   data: {},
				   dataType: 'json',
				   success: function(json){
				   		if(json.success){
				   			$("#nav_name").html(json.name);
				   			$("#nav_phone").html(json.phone);
				   			$("#nav_image").attr("src", json.image);
				   			$("#nav_unread").html(json.unreadCount);
				   		}
				   }
			});
			
		});
		
	</script>
        <div class="navbar navbar-static-top">
            <div class="navbar-inner">
                <a class="brand" href="<%=basePath%>page/index.jsp">拇指校园</a>
                <ul class="nav">
                    <li id="menu-icon"><a class="menu-icon" href="#"><i class="icon-reorder"></i></a></li>
                    <li class="dropdown">
                        <a  class="dropdown-toggle menu-icon" data-toggle="dropdown" href="#"><i class="icon-user"></i></a>
                        <ul class="user dropdown-menu">
                            <li>
                                <div class="container-fluid">
                                    <div class="row-fluid">
                                        <div class="span4">
                                            <img id="nav_image" class="profile" src="<%=basePath%>assets/img/bruce.jpg" alt="">
                                        </div>
                                        <div class="span8 details">
                                            <small>欢迎光临 <a href="#"><span id="nav_name"></span></a></small>
                                            <ul class="unstyled">
                                            	<li><a href="#"><small><i class="icon-phone icon"></i> <span id="nav_phone"></span></small></a></li>
                                                <li><a href="<%=basePath%>message/receiveMessageList"><small><i class="icon-comments icon"></i><span id="nav_unread"></span> 条未读信息</small></a></li>
                                               <!--  <li><a href="#"><small><i class="icon-bar-chart icon"></i> 2条订单</small></a></li> -->
                                            </ul>
                                        </div>
                                    </div>
                                    <!-- End Row -->
                                    <div class="row-fluid sales">
                                    
                                    <!-- <div class="span12 well" style="padding-left:5px;padding-bottom:5px;">
                                    	<button id="logout" type="button" class="btn grey" onclick="logout();">安全退出</button>
                                    </div> -->
                                        <!-- <div class="span12 well">
                                            <div class="row-fluid">
                                            
                                                <div class="border-right span6">
                                                    <p class="text-center">销售: $800</p>
                                                </div>
                                                <div class="span6">
                                                    <p class="text-center">用户: 1267</p>
                                                </div>
                                            </div> 
                                            End Row
                                        </div> -->
                                    </div>
                                    <!-- End Row -->
                                </div>
                                <!-- End Container -->
                            </li>
                        </ul>
                    </li>
                    
                    <%-- <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">提示 <span class="top-alert vibrate"><span class="arrow"></span>4</span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">
                                    <p class="padding"><img class="pull-left picture" src="<%=basePath%>assets/img/flat_icons/message.png" width="30" alt="" /><small>第一条提示信息查看</small></p>
                                    <p><small class="muted"><i class="icon-user"></i> Stan Smith<span class="pull-right"><i class="icon-time"></i>2小时以前</span></small></p>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <p class="padding"><img class="pull-left picture" src="<%=basePath%>assets/img/flat_icons/calendar.png" width="30" alt="" /><small>第一条提示信息查看<span class="text-warning">两天以前</span> time at 6pm</small></p>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <p class="padding"><img class="pull-left picture" src="<%=basePath%>assets/img/flat_icons/charts.png" width="30" alt="" /><small>第一条提示信息查看<span class="text-success">15%</span> while others are up <span class="text-warning">2%</span></small></p>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <p class="padding"><img class="pull-left picture" src="<%=basePath%>assets/img/flat_icons/cone.png" width="30" alt="" /><small><span class="text-error">事故发生了.</span> The cron needs your attention</small></p>
                                </a>
                            </li>
                        </ul>
                    </li> --%>
                </ul>
                <ul class="nav pull-right search">
                    <form class="nav-search" action="">
                        <input type="text">
                    </form>
                </ul>
            </div>
            <!-- /.navbar-inner -->
        </div>
    
