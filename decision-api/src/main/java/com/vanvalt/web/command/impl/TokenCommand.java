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
import com.vanvalt.entity.Token;
import com.vanvalt.web.command.ICommand;

/**
 * 令牌命令
 * @author Xiaoyang
 *
 */
public class TokenCommand implements ICommand {
	/**
	 * 日志.
	 */
	private static Logger logger = Logger.getLogger(TokenCommand.class);
	/**
	 * 令牌对象.
	 */
	private Token token;
	
	/**
	 * 构造方法.
	 */
	public TokenCommand() {
		super();
	}
	public TokenCommand( Token token) {
		super();
		this.token = token;
	}
	
	
	/**
	 * 构造方法.
	 * @param json 待解析的json
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public TokenCommand(String json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// this.post = mapper.readValue(json, Post.class);
		// 读取Json
		JsonNode rootNode = mapper.readTree(json);
		if (null == this.token) {
			this.token = new Token();
		}
		// rootNode.path("xx")返回的还是一个JsonNode对象，调用该JsonNode的相应方法，得到键对应的值
		/*try {
			// 令牌类型
			this.token.setTokenType(rootNode.path("tokenType").asText());
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		try {
			// 令牌
			this.token.setToken(rootNode.path("token").asText());
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}*/

	}

	@Override
	public String toJson() {
		StringWriter stringWriter = new StringWriter();    
		try {
			ObjectMapper mapper = new ObjectMapper();    
			mapper.writeValue(stringWriter, this.token);
		} catch (JsonGenerationException e) {
			logger.debug(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.debug(e.getMessage(), e);
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
		}     
		return stringWriter.toString();  
		
	}

	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public static void main(String args[]) {
		TokenCommand tc = new TokenCommand();
		tc.setToken(new Token());
		logger.debug(tc.toString());
		logger.debug(tc.toJson());
	}


}
