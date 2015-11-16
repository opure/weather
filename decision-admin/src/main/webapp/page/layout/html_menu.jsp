<%@ page language="java" pageEncoding="UTF-8"%>
        <ul class="menu">
            <li class="active">
                <a href="<%=basePath%>page/index.jsp"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/dashboard.png" alt="" />首页</span></a>
            </li>
            <li>
                <a href="<%=basePath%>app/index"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/phone.png" alt="" />应用管理</span></a>
            </li>
            <li>
               <a href="<%=basePath%>column/allColumn"> <span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/document.png" alt="" />栏目管理</span></a>
            </li>
            <li>
                <a href="<%=basePath%>alarm/index"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/cone.png" alt="" />预警管理</span></a>
            </li>
            <li>
                <span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/document.png" alt="" />内容管理</span>
            </li>
            <li>
                <span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/pin.png" alt="" />推送管理</span>
            </li>
            <li>
                <span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/charts.png" alt="" />信息统计</span>
            </li>
            <li>
                <span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/person.png" alt="" />用户管理</span>
            </li>
            <li>
                <span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/settings.png" alt="" />权限管理</span>
            </li>
             <li>
                <span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/support.png" alt="" /><b>个人中心</b><i class="icon-angle-down"></i></span>
                <ul>
                	<li>
		                <a href="#">个人信息</a>
		            </li>
		            <li>
		                <a href="#">密码修改</a>
		            </li>
                </ul>
            </li>
            <li>
                <a href="<%=basePath%>login.jsp"><span><img class="img-icon" src="<%=basePath%>assets/img/flat_icons/sheild.png" alt="" />安全退出</span></a>
            </li>
        </ul>
    
