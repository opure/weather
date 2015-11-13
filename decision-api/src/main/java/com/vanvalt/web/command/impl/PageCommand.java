package com.vanvalt.web.command.impl;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vanvalt.util.mybatis.dialect.PageParameter;
import com.vanvalt.web.command.ICommand;

/**
 * 分页命令.
 * @author chenbowang
 *
 */
public class PageCommand implements ICommand {
	/**
	 * 日志.
	 */
	private static Logger logger = Logger.getLogger(PageCommand.class);
	/**
	 * 分页对象.
	 */
	private PageParameter page = null;
	/**
	 * 构造方法.
	 */
	public PageCommand() {
		
	}
	
	public PageCommand(PageParameter page) {
		super();
		this.page = page;
	}



	/**
	 * 构造方法.
	 * @param json 待解析的json
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public PageCommand(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// 读取Json
		JsonNode rootNode = mapper.readTree(json);
		
		if (null == this.page) {
			this.page = new PageParameter();
		}
		// rootNode.path("xx")返回的还是一个JsonNode对象，调用该JsonNode的相应方法，得到键对应的值
		try {
			this.page.setPageSize(rootNode.path("pageSize").asInt());
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		try {
			this.page.setCurrentPage(rootNode.path("currentPage").asInt());
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
		
	}

	@Override
	public String toJson() {
		StringWriter stringWriter = new StringWriter();    
		try {
			ObjectMapper mapper = new ObjectMapper();    
			JsonGenerator generator;
			generator = new JsonFactory().createJsonGenerator(stringWriter);
			mapper.writeValue(generator, this.page);
			generator.close();
		} catch (JsonGenerationException e) {
			logger.debug(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.debug(e.getMessage(), e);
		} catch (IOException e) {
			logger.debug(e.getMessage(), e);
		}     
		return stringWriter.toString();  
		
	}

	public PageParameter getPage() {
		return page;
	}

	public void setPage(PageParameter page) {
		this.page = page;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageCommand [page=");
		builder.append(page);
		builder.append("]");
		return builder.toString();
	}

	
}
