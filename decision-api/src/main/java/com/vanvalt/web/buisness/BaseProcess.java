package com.vanvalt.web.buisness;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vanvalt.web.command.impl.BaiduPushMappingCommand;
import com.vanvalt.web.command.impl.LoginCommand;
import com.vanvalt.web.command.impl.PageCommand;
import com.vanvalt.web.command.impl.RequestCommand;
import com.vanvalt.web.command.impl.ResponseCommand;

public class BaseProcess {

	/**
	 *日志.
	 */
	private static Logger 		logger = Logger.getLogger(BaseProcess.class);
	
	/**
	 * 初始化分页参数.
	 * 
	 * @param pageCommand
	 * @param requestCommand
	 * @return
	 */
	public PageCommand initPagecommand(PageCommand pageCommand, RequestCommand requestCommand) {
		try {
			pageCommand = new PageCommand(requestCommand.getObject().toString());
		}
		catch (JsonParseException e) {
			logger.debug(e.getMessage(), e);
		}
		catch (JsonMappingException e) {
			logger.debug(e.getMessage(), e);
		}
		catch (IOException e) {
			logger.debug(e.getMessage(), e);
		}
		return pageCommand;
	}
	
	/**
	 * 用户登录参数
	 * @param requestCommand
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public LoginCommand initLoginCommand(RequestCommand requestCommand) throws JsonParseException, JsonMappingException, IOException{
		LoginCommand command = new LoginCommand(requestCommand.getObject().toString());
		return command;
	}
	
	/**
	 * 百度推送绑定参数
	 * @param requestCommand
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public BaiduPushMappingCommand initBaiduPushMappingCommand(RequestCommand requestCommand) throws JsonParseException, JsonMappingException, IOException{
		BaiduPushMappingCommand command = new BaiduPushMappingCommand(requestCommand.getObject().toString());
		return command;
	}
	
	/**
	 * 返回请求结果。
	 * @param status
	 * @param code
	 * @param responseCommand
	 * @return
	 */
	public ResponseCommand returnResult(boolean status,String code,ResponseCommand responseCommand){
		responseCommand.setStatus(status);
		responseCommand.setCode(code);
		return responseCommand;
	}
	
	/**
	 * 返回请求结果。
	 * @param status
	 * @param code
	 * @param object
	 * @param responseCommand
	 * @return
	 */
	public ResponseCommand returnResult(boolean status,String code,Object object,ResponseCommand responseCommand){
		responseCommand.setObject(object);
		responseCommand.setStatus(status);
		responseCommand.setCode(code);
		return responseCommand;
	}
}
