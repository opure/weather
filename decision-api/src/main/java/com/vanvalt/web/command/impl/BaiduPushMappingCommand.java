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
 * 百度推送绑定命令
 * @author Xiaoyang
 *
 */
public class BaiduPushMappingCommand implements ICommand {
	/**
	 * 日志.
	 */
	private static Logger logger = Logger.getLogger(BaiduPushMappingCommand.class);
	/**
	 * 
	 */
	private Map<String,Object> map;
	
	/**
	 * 构造方法.
	 */
	public BaiduPushMappingCommand() {
		super();
	}
	
	/**
	 * 构造方法.
	 * @param json 待解析的json
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public BaiduPushMappingCommand(String json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// this.post = mapper.readValue(json, Post.class);
		// 读取Json
		JsonNode rootNode = mapper.readTree(json);
		if (null == this.map) {
			this.map = new HashMap<String,Object>();
		}
		// rootNode.path("xx")返回的还是一个JsonNode对象，调用该JsonNode的相应方法，得到键对应的值
		try {
			// 用户ID
			String uid = rootNode.path("uid").asText();
			this.map.put("uid", uid);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			// 百度userId
			String userId = rootNode.path("userId").asText();
			this.map.put("userId", userId);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			// 百度推送ID
			String channelId = rootNode.path("channelId").asText();
			this.map.put("channelId", channelId);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			// 百度deviceType
			String deviceType = rootNode.path("deviceType").asText();
			this.map.put("deviceType", deviceType);
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
		BaiduPushMappingCommand obj = new BaiduPushMappingCommand();
		logger.debug(obj.toString());
		logger.debug(obj.toJson());
	}

}
