package com.vanvalt.util.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JsonConversion {
	/**
	 * 日志.
	 */
	private static Logger logger = Logger.getLogger(JsonConversion.class);
	private static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * java对象转换成json字符串
	 * @param obj
	 */
	public static final String writeEntityJSON(Object obj) {
		
		StringWriter stringWriter = new StringWriter();

		ObjectMappingCustomer mapper = new ObjectMappingCustomer();
		mapper.setDateFormat(new SimpleDateFormat(SIMPLE_DATE_FORMAT));
		try {
			mapper.writeValue(stringWriter, obj);
		} catch (JsonGenerationException e) {
			logger.debug(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.debug(e.getMessage(), e);
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
		}
		
		return stringWriter.toString();  
	}
	
	/**
	 * List集合转JSON字符串.
	 * @param list
	 * @return
	 */	
	public static final String writeListJSON(List<?> list) {
		
		StringWriter stringWriter = new StringWriter();    
		try {
			ObjectMappingCustomer mapper = new ObjectMappingCustomer(); 
			mapper.setDateFormat(new SimpleDateFormat(SIMPLE_DATE_FORMAT));
			mapper.writeValue(stringWriter,list);
		} catch (JsonGenerationException e) {
			logger.debug(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.debug(e.getMessage(), e);
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
		}     
		return stringWriter.toString();  
	    
	}
	/**
	 * Map集合转换成Json字符串.
	 * @param map
	 * @return
	 */
	public static final String writeMapJSON(Map<?, ?> map) {
		StringWriter stringWriter = new StringWriter();    
		try {
			ObjectMappingCustomer mapper = new ObjectMappingCustomer();   
			mapper.setDateFormat(new SimpleDateFormat(SIMPLE_DATE_FORMAT));
			mapper.writeValue(stringWriter,map);
		} catch (JsonGenerationException e) {
			logger.debug(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.debug(e.getMessage(), e);
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
		}     
		return stringWriter.toString();  
	}
	
	/**
	 * 使用Servlet的输出java对象转换成的json字符串.
	 * @param json
	 * @throws IOException
	 */
	/*public static final void writeEntityJSONToHttpServletResponse(Object obj) throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		
		 * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码),
		 * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会
		 * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。
		 * 
		response.setContentType("text/html;charset=utf-8");
		//response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//JSON在传递过程中是普通字符串形式传递
		out.println(writeEntityJSON(obj));
		out.flush();
		out.close();
	}*/
}
