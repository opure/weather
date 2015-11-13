package com.vanvalt.web.admin.interceptor;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Repository
public class LoginedCheckInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request,  
            HttpServletResponse response, Object handler) throws Exception {  
  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");  
  
        // 后台session控制  
        String[] noFilters = new String[] { "login.jsp", "index.jsp", "logout.jsp" };  
        String uri = request.getRequestURI();  
  
        // 对登录与注销请求直接放行,不予拦截
        if(uri.indexOf("login") != -1 || uri.indexOf("logout") != -1 || uri.indexOf("index") != -1){
        	 boolean beFilter = true; 
             for (String s : noFilters) {  
                 if (uri.indexOf(s) != -1) {  
                     beFilter = false;  
                     break;  
                 }  
             }  
        } else {
            Object obj = request.getSession().getAttribute("currentUser");
                		 
            if (null == obj) {  
  
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
            } else {  
                // 添加日志  
                  /*  String operateContent = Constants.operateContent(uri);  
                    if (null != operateContent) {  
                        String url = uri.substring(uri.indexOf("background"));  
                        String ip = request.getRemoteAddr();  
                        Integer userId = ((SystemUserForm) obj).getId();  
                        SystemLoggerForm form = new SystemLoggerForm();  
                        form.setUserId(userId);  
                        form.setIp(ip);  
                        form.setOperateContent(operateContent);  
                        form.setUrl(url);  
                        this.systemLoggerService.edit(form);  
                    }  */
            }  
        }
  
        Map paramsMap = request.getParameterMap();  
  
        for (Iterator<Map.Entry> it = paramsMap.entrySet().iterator(); it  
                .hasNext();) {  
            Map.Entry entry = it.next();  
            Object[] values = (Object[]) entry.getValue();  
            for (Object obj : values) { 
            	System.out.println("LoginedCheckInterceptor: "+obj.toString());
               /* if (!DataUtil.isValueSuccessed(obj)) {  
                    throw new RuntimeException("有非法字符：" + obj);  
                }  */
            }  
        }  
  
        return super.preHandle(request, response, handler);  
    }  
  
}  

