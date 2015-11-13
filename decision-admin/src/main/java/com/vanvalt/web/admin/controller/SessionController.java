package com.vanvalt.web.admin.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionController extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Object session = request.getSession()
				.getAttribute("currentUser");
		if (null != session) {
			//request.getRequestDispatcher("/login.html").forward(request, response);
			return super.preHandle(request, response, handler);
		} else {
			//response.sendRedirect(request.getContentType()+"/login.jsp");
		     // 未登录  
            PrintWriter out = response.getWriter();  
            StringBuilder builder = new StringBuilder();  
            builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");  
            builder.append("alert(\"页面过期，请重新登录\");");  
            builder.append("window.top.location.href=\"");  
            //builder.append(Constants.basePath);  
            builder.append(request.getContextPath());
            builder.append("/login.jsp\";</script>");  
            out.print(builder.toString());  
            out.close();  
			return false;
		}
		
		
	}
}
