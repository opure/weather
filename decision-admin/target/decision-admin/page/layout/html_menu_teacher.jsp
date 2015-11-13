<%@ page language="java" pageEncoding="UTF-8"%>
        <ul class="menu">
            <li class="active">
                <a href="<%=basePath%>index"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/dashboard.png" alt="" />首页</span></a>
            </li>
           <%--  <li>
                <a href="<%=basePath%>message/publishMessage"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/message.png" alt="" />信息发送</span></a>
            </li>
            <li>
                <a href="<%=basePath%>message/sentMessageList"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/chat.png" alt="" />已发信息</span></a>
            </li> --%>
            <li>
                <a href="<%=basePath%>message/sentMessageMgt"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/chat.png" alt="" />已发信息</span></a>
            </li>
            <li>
                <a href="<%=basePath%>message/receiveMessageList"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/mail.png" alt="" />信息接收</span></a>
            </li>
            <li>
                <a href="<%=basePath%>template/list"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/shelf.png" alt="" />信息模板</span></a>
            </li>
            <li>
                <a href="<%=basePath%>contact/myContacts"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/document.png" alt="" />通讯录</span></a>
            </li>
            <li>
                <a href="<%=basePath%>vote/voteList"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/document.png" alt="" />投票管理</span></a>
            </li>
            <li>
                <span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/person.png" alt="" /><b>个人中心</b><i class="icon-angle-down"></i></span>
                <%-- <ul>
                	<li>
		                <a href="<%=basePath%>teacher/editPersonInfo"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/support.png" alt="" />个人信息</span></a>
		            </li>
		            <li>
		                <a href="<%=basePath%>toChangePassword"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/edit.png" alt="" />密码修改</span></a>
		            </li>
                </ul> --%>
                <ul>
                	<li>
		                <a href="<%=basePath%>teacher/editPersonInfo">个人信息</a>
		            </li>
		            <li>
		                <a href="<%=basePath%>toChangePassword">密码修改</a>
		            </li>
                </ul>
            </li>
            <li>
                <a href="<%=basePath%>logout"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/sheild.png" alt="" />安全退出</span></a>
            </li>
        </ul>
    
