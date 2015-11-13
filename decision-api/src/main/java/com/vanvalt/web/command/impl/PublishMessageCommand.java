package com.vanvalt.web.command.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.vanvalt.util.json.ObjectMappingCustomer;
import com.vanvalt.web.command.ICommand;

/**
 * 发布信息命令
 * @author Xiaoyang
 *
 */
public class PublishMessageCommand implements ICommand {
	/**
	 * 日志.
	 */
	private static Logger logger = Logger.getLogger(PublishMessageCommand.class);
	
	private Map<String,Object> map;
	
	
	/**
	 * 构造方法.
	 */
	public PublishMessageCommand() {
		super();
	}
	
	/**
	 * 构造方法.
	 * @param json 待解析的json
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public PublishMessageCommand(String json) throws JsonParseException, JsonMappingException, IOException {

		//ObjectMapper mapper = new ObjectMapper();
		ObjectMappingCustomer mapper = new ObjectMappingCustomer();
		// this.post = mapper.readValue(json, Post.class);
		// 读取Json
		//JsonNode rootNode = mapper.readTree(Tools.replaceSpecialtyStr(json, null, null));
		JsonNode rootNode = mapper.readTree(json);
		if (null == this.map) {
			this.map = new HashMap<String,Object>();
		}
		// rootNode.path("xx")返回的还是一个JsonNode对象，调用该JsonNode的相应方法，得到键对应的值
		try {
			String uid = rootNode.path("uid").asText();
			map.put("uid", uid);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			String msgType = rootNode.path("msgType").asText();
			map.put("msgType", msgType);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			String msgTitle = rootNode.path("msgTitle").asText();
			map.put("msgTitle", msgTitle);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			String msgSummary = rootNode.path("msgSummary").asText();
			map.put("msgSummary", msgSummary);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			String msgContent = rootNode.path("msgContent").asText();
			map.put("msgContent", msgContent);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			/*Object msgTo = rootNode.path("msgTo");
			String msgToStr = msgTo.toString();
			
			List<String> contactList = Lists.newArrayList();
			List list = JSONArray.fromObject(msgTo.toString());
			for(int i=0;i<list.size();i++){
				Map map = (Map) list.get(i);
				String contactId = (String) map.get("contactId");
				
				contactList.add(contactId);
			}
			
			map.put("msgTo", contactList);*/
			
			Map<String,Object> msgToMap = new HashMap<String,Object>();
			
			List<String> groupList = Lists.newArrayList();
			List<String> contactList = Lists.newArrayList();
			JsonNode msgto = rootNode.path("msgTo");
			
			Iterator<JsonNode> msgToIt = msgto.iterator();
			
			while(msgToIt.hasNext()){
				
				JsonNode jsonNode = msgToIt.next();
				Iterator<String> keys = jsonNode.fieldNames();
				while(keys.hasNext()){
					String filedName = keys.next();
					if("groupId".equals(filedName)){
						groupList.add(jsonNode.path("groupId").asText());
					}
					
					if("contactId".equals(filedName)){
						contactList.add(jsonNode.path("contactId").asText());
					}
				}
				
			}
			
			msgToMap.put("groupList", groupList);
			msgToMap.put("contactList", contactList);
			
			map.put("msgTo", msgToMap);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			String pubTime = rootNode.path("pubTime").asText();
			map.put("pubTime", pubTime);
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
		PublishMessageCommand obj = new PublishMessageCommand();
		logger.debug(obj.toString());
		logger.debug(obj.toJson());
	}

}
