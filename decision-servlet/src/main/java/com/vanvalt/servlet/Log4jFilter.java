package com.vanvalt.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.MDC;

public class Log4jFilter implements Filter {
	
	public static String remoteIP = null;
	
	public static final String MAP_KEY_IP = "ip";
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		remoteIP = req.getRemoteAddr();		
		
		MDC.put(MAP_KEY_IP, remoteIP);		
		
		chain.doFilter(req, res);
		
		MDC.remove(MAP_KEY_IP);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}