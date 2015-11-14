<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <title>气象局云服务平台海南决策服务</title>
        <%@include file="/page/layout/html_header.jsp"%>
    </head>
    <body>
        <%@include file="/page/layout/html_navbar.jsp"%>
        <!-- /.navbar -->
        <!-- /.menu-inner -->
        <%@include file="/page/layout/html_menu.jsp"%>
        <!-- /.menu -->
        <div class="page-wrap index">
            <div class="dash-column-left">
                <div class="container-fluid">
                    <div class="row-fluid">
                        <div class="span12 well">
                            <div class="title">统计</div>
                            <div class="well-content">
                                <div class="row-fluid">
                                    <div class="span2">
                                        <div id="sparkline1"></div>
                                    </div>
                                    <div class="span10">
                                        <h3>9% <small>销售增长</small><span class="pull-right text-success"><i class="icon-arrow-up"></i></span></h3>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span2">
                                        <div id="sparkline3"></div>
                                    </div>
                                    <div class="span10">
                                        <h3>4% <small>会员增长</small><span class="pull-right text-success"><i class="icon-arrow-up"></i></span></h3>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span2">
                                        <div id="sparkline2"></div>
                                    </div>
                                    <div class="span10">
                                        <h3>46% <small>市场份额</small><span class="pull-right text-error"><i class="icon-arrow-down"></i></span></h3>
                                    </div>
                                </div>
                                <br />
                                <div class="row-fluid">
                                    <div class="span6">
                                        <a class="btn btn-block">34个销售订单</a>
                                    </div>
                                    <div class="span6">
                                        <a class="btn btn-block">18个新用户</a>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span6">
                                        <a class="btn btn-block">6条评论</a>
                                    </div>
                                    <div class="span6">
                                        <a class="btn btn-block">11条消息</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12 well">
                            <div class="title">新闻订阅</div>
                            <div class="well-content">
                                <div class="row-fluid">
                                    <div class="span3">
                                        <img src="<%=basePath%>assets/img/logo1.jpg">
                                    </div>
                                    <div class="span9">
                                        <p>Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. </p>
                                    </div>
                                    <p class="muted"><small>Lorem ipsum dolor sit amet</small><small class="pull-right"><i class="icon-time"></i> 35 minutes ago</small></p>
                                    <hr />
                                </div>
                                <div class="row-fluid">
                                    <div class="span3">
                                        <img src="<%=basePath%>assets/img/logo3.jpg">
                                    </div>
                                    <div class="span9">
                                        <p>Vestibulum suscipit rutrum nunc. Donec est lacus, tempor id rutrum id, semper ac purus. Curabitur dictum, mi sed tempor facilisis.</p>
                                    </div>
                                    <p class="muted"><small>Ut interdum varius arcu</small><small class="pull-right"><i class="icon-time"></i> 2 hours ago</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12 well">
                            <div class="title">
                                聊天 
                                <p class="pull-right muted"><small><i class="icon-user"></i> Chatting with user Stan Smith</small></p>
                            </div>
                            <div class="chat">
                                <div class="chat-right">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eget viverra tortor.</p>
                                    <p class="pull-right muted"><small><i class="icon-time"></i> 2 days ago</small></p>
                                </div>
                                <div class="chat-left">
                                    <p>Ut interdum varius arcu at ultrices. Duis in dui sem.</p>
                                    <p class="pull-right muted"><small><i class="icon-time"></i> 2 days ago</small></p>
                                </div>
                                <div class="chat-right">
                                    <p>Vestibulum suscipit rutrum nunc. Donec est lacus, tempor id rutrum id, semper ac purus.</p>
                                    <p class="pull-right muted"><small><i class="icon-time"></i> 1 days ago</small></p>
                                </div>
                                <div class="chat-left">
                                    <p>Curabitur dictum, mi sed tempor facilisis, enim turpis varius tortor.</p>
                                    <p class="pull-right muted"><small><i class="icon-time"></i> 1 days ago</small></p>
                                </div>
                                <div class="chat-right">
                                    <p>Donec bibendum tristique ullamcorper. In hac habitasse platea dictumst.</p>
                                    <p class="pull-right muted"><small><i class="icon-time"></i> 2 hours ago</small></p>
                                </div>
                                <div class="chat-left">
                                    <p>Phasellus quis erat adipiscing libero congue vulputate auctor non dui.</p>
                                    <p class="pull-right muted"><small><i class="icon-time"></i> 1 hour ago</small></p>
                                </div>
                                <div class="chat-left">
                                    <p>Sed fringilla elit risus, a tempor tortor cursus ac. Aliquam erat volutpat.</p>
                                    <p class="pull-right muted"><small><i class="icon-time"></i> 35 minutes ago</small></p>
                                </div>
                            </div>
                            <div class="chat-input">
                                <textarea type="text" class="span12 chat-bar"></textarea>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <p class="text-center">
                                <br />
                                <a class="btn btn-large">加载更多..<i class="icon-refresh refresh-icon"></i></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="dash-column-right">
                <div class="cart-bar">
                    <i class="icon-bar-chart"></i><span>本周销售</span>
                    <div class="pull-right">
                        <a class="btn black btn-small" href="#"><i class="icon-refresh"></i></a>
                    </div>
                </div>
                <div class="top-chart-holder orange">
                    <div id="chart" class="top-chart"></div>
                </div>
                <div class="icon-updates">
                    <p><i class="icon-shopping-cart icon"></i> 34个订单</p>
                </div>
                <div class="icon-updates">
                    <p><i class="icon-bar-chart icon"></i> 5%利润增长</p>
                </div>
                <div class="icon-updates">
                    <p><i class="icon-calendar icon"></i> 2条新闻</p>
                </div>
                <div class="icon-updates">
                    <p><i class="icon-cloud-download icon"></i> 1,245 下载</p>
                </div>
                <div class="container-fluid">
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="row-fluid">
                                <div class="span12 recent-title">
                                    <i class="icon-rss"></i> 最近
                                </div>
                            </div>
                            <div class="row-fluid">
                                <div class="span12 well">
                                    <div class="title recent-right">会员</div>
                                    <div class="well-content">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>姓名</th>
                                                    <th>注册时间</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Donna R. Folse</td>
                                                    <td>05/06/2013</td>
                                                </tr>
                                                <tr>
                                                    <td>Emily F. Burns</td>
                                                    <td>12/01/2013</td>
                                                </tr>
                                                <tr>
                                                    <td>Andrew A. Stout</td>
                                                    <td>08/21/2013</td>
                                                </tr>
                                                <tr>
                                                    <td>Mary M. Bryan</td>
                                                    <td>04/11/2013</td>
                                                </tr>
                                                <tr>
                                                    <td>Mary A. Lewis</td>
                                                    <td>02/01/2013</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="row-fluid">
                                <div class="span12 well">
                                    <div class="title recent-right">网站新闻</div>
                                    <div class="well-content">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec dolor felis, aliquam eget ornare vitae, molestie in ipsum. Phasellus gravida lobortis mi, eget fringilla velit scelerisque ac.</p>
                                        <p><i class="icon-time"></i> 03/11/13<span class="pull-right">Admin</span></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="row-fluid">
                                <div class="span12 well">
                                    <div class="title recent-left">任务</div>
                                    <div class="well-content">
                                        <ul id="tasks" class="unstyled tasks">
                                            <li>
                                                <label class="tasks-list-item">
                                                <input type="checkbox" class="checkbox-task" >
                                                <span class="tasks-list-desc">Breaking Bad</span>
                                                </label>
                                            </li>
                                            <li>
                                                <label class="tasks-list-item">
                                                <input type="checkbox" checked />
                                                <span class="tasks-list-desc">Arrested Development</span>
                                                </label>
                                            </li>
                                            <li>
                                                <label class="tasks-list-item">
                                                <input type="checkbox" />
                                                <span class="tasks-list-desc">Game of thrones</span>
                                                </label>
                                            </li>
                                            <li>
                                                <label class="tasks-list-item">
                                                <input type="checkbox" checked />
                                                <span class="tasks-list-desc">Lost</span>
                                                </label>
                                            </li>
                                            <li>
                                                <label class="tasks-list-item">
                                                <input type="checkbox" checked />
                                                <span class="tasks-list-desc">Banshee</span>
                                                </label>
                                            </li>
                                            <li>
                                                <label class="tasks-list-item">
                                                <input type="checkbox" />
                                                <span class="tasks-list-desc">Arrow</span>
                                                </label>
                                            </li>
                                        </ul>
                                        </fieldset>
                                    </div>
                                </div>
                            </div>
                            <div class="row-fluid">
                                <div class="span12 well">
                                    <div class="title recent-left">评论</div>
                                    <div class="well-content">
                                        <div class="row-fluid">
                                            <div class="span3 comment-img">
                                                <img class="img-rounded" src="<%=basePath%>assets/img/person.png" alt="" />
                                            </div>
                                            <div class="span9">
                                                <p><i class="icon-quote-left"></i> Sed congue, augue vitae mattis pulvinar, dolor mi luctus quam. <i class="icon-quote-right"></i></p>
                                                <p class="text-right">Michael Bluth</p>
                                            </div>
                                        </div>
                                        <div class="row-fluid">
                                            <div class="span3 comment-img">
                                                <img class="img-rounded" src="<%=basePath%>assets/img/person2.png" alt="" />
                                            </div>
                                            <div class="span9">
                                                <p><i class="icon-quote-left"></i> Etiam mollis elit et mi aliquet, ac laoreet sapien malesuada. <i class="icon-quote-right"></i></p>
                                                <p class="text-right">Jack Sparrow</p>
                                            </div>
                                        </div>
                                        <div class="row-fluid">
                                            <div class="span3 comment-img">
                                                <img class="img-rounded" src="<%=basePath%>assets/img/person3.png" alt="" />
                                            </div>
                                            <div class="span9">
                                                <p><i class="icon-quote-left"></i> Morbi egestas lectus velit. In velit dolor suscipit metus sapien. <i class="icon-quote-right"></i></p>
                                                <p class="text-right">Stan Smith</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
	        <%@include file="/page/layout/html_copyright.jsp"%>
	    </div>
        <%@include file="/page/layout/html_footer_index.jsp"%>
        <script>index();</script>
    </body>
</html>
