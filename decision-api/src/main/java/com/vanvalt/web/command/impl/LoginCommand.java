package com.vanvalt.web.command.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanvalt.web.command.ICommand;

/**
 * 用户命令
 * @author Xiaoyang
 *
 */
public class LoginCommand implements ICommand {
	/**
	 * 日志.
	 */
	private static Logger logger = Logger.getLogger(LoginCommand.class);
	/**
	 * 用户.
	 */
	private Map<String,Object> map;
	
	/**
	 * 构造方法.
	 */
	public LoginCommand() {
		super();
	}
	
	/**
	 * 构造方法.
	 * @param json 待解析的json
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public LoginCommand(String json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// this.post = mapper.readValue(json, Post.class);
		// 读取Json
		JsonNode rootNode = mapper.readTree(json);
		if (null == this.map) {
			this.map = new HashMap<String,Object>();
		}
		// rootNode.path("xx")返回的还是一个JsonNode对象，调用该JsonNode的相应方法，得到键对应的值
		try {
			// 用户登录手机号
			String phone = rootNode.path("phone").asText();
			this.map.put("phone", phone);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			// 密码
			String passwd = rootNode.path("passwd").asText();
			this.map.put("passwd", passwd);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
	}
	
	@Override
	public String toJson() {
		StringWriter stringWriter = new StringWriter();    
		try {
			ObjectMapper mapper = new ObjectMapper();    
			mapper.writeValue(stringWriter, this.map);
		} catch (JsonGenerationException e) {
			logger.debug(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.debug(e.getMessage(), e);
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
		}     
		return stringWriter.toString();  
		
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public static void main(String args[]) {
		LoginCommand obj = new LoginCommand();
		logger.debug(obj.toString());
		logger.debug(obj.toJson());
	}

}
