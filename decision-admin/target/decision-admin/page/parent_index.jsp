<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <title>后台管理系统(家长) - 拇指校园</title>
        <%@include file="/page/layout/html_header.jsp"%>
        <link href="<%=basePath%>assets/fullcalendar/css/fullcalendar.css" rel="stylesheet" />
        <link href="<%=basePath%>assets/fullcalendar/css/fullcalendar.print.css" rel="stylesheet" media="print" />
    </head>
    <body>
        <%@include file="/page/layout/html_navbar.jsp"%>
        <!-- /.navbar -->
        <!-- /.menu-inner -->
        <%@include file="/page/layout/html_menu_parent.jsp"%>
        <!-- /.menu -->
        <div class="page-wrap">
            <div class="breadcrumb">
               <!--  <a class="btn orange" href="#"><i class="icon-refresh"></i></a> <a class="btn" href="calendar.html">Calendar</a>
                <div class="pull-right">
                    <a class="btn btn-info" href="#"><i class="icon-calendar"></i></a> <a class="btn" href="#">13/08/13</a>
                </div> -->
                <div style="text-align:center;"><h2>欢迎来到拇指校园后台管理系统</h2></div>
            </div>
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12 well">
                        <div class="title">Calendar</div>
                        <div class="well-content">
                            <div class="row-fluid">
                                <div class="span3">
                                    <div id="external-events">
                                        <h5>Draggable Events</h5>
                                        <div class="external-event">
                                            <span class="label blue">
                                            <i class="icon-move"></i> Party at my house
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label blue">
                                            <i class="icon-move"></i> Lunch with my mates
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label lightblue">
                                            <i class="icon-move"></i> The Bank Robbery
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label blue">
                                            <i class="icon-move"></i> Dinner with my date
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label red">
                                            <i class="icon-move"></i> That big meeting
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label blue">
                                            <i class="icon-move"></i> Some friends birthday
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label orange">
                                            <i class="icon-move"></i> When the movie starts
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label green">
                                            <i class="icon-move"></i> Really good TV show starts
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label lightgreen">
                                            <i class="icon-move"></i> Dinner with my bro
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label red">
                                            <i class="icon-move"></i> Free Time
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label grey">
                                            <i class="icon-move"></i> The concert starts
                                            </span>
                                        </div>
                                        <div class="external-event">
                                            <span class="label black">
                                            <i class="icon-move"></i> When the plane leaves
                                            </span>
                                        </div>
                                        <p>
                                            <input type="checkbox" id="drop-remove" /> remove after drop 
                                        </p>
                                    </div>
                                </div>
                                <div class="span9">
                                    <div id='calendar'></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	        <%@include file="/page/layout/html_copyright.jsp"%>
	    </div>
        <%@include file="/page/layout/html_footer_index.jsp"%>
        <script src="http://code.jquery.com/jquery.js" type="text/javascript"></script>	
        <script src="<%=basePath%>assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/jquery-ui-bootstrap/js/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/fullcalendar/js/fullcalendar.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/js/script.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/js/menu.js" type="text/javascript"></script>
        <script>calendar();</script>
    </body>
</html>
