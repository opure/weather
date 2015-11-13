package com.vanvalt.web.buisness;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vanvalt.service.AdminService;
import com.vanvalt.util.command.WebConfig;
import com.vanvalt.util.encrypt.Encoder;
import com.vanvalt.util.json.JsonConversion;
import com.vanvalt.web.command.impl.LoginCommand;
import com.vanvalt.web.command.impl.RequestCommand;
import com.vanvalt.web.command.impl.ResponseCommand;
import com.vanvalt.web.command.util.ErrorCode;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月13日 下午12:45:29 
 * 
 */
public class AdminProcess extends BaseProcess{

	/**
	 *日志.
	 */
	@SuppressWarnings("unused")
	private static Logger 		logger = Logger.getLogger(AdminProcess.class);
	private static HttpServletRequest	httpServletRequest	= ((ServletRequestAttributes) RequestContextHolder
			.getRequestAttributes()).getRequest();
	
	/**
	 * 用户自定义配置项.
	 */
	private WebConfig 					webConfig;
	
	private AdminService				adminService;
	
	/**
	 * 构造方法.
	 */	
	public AdminProcess(){
		super();
	}
	
	/**
	 * 构造方法.
	 * @param adminService
	 * @param webConfig
	 */
	public AdminProcess(AdminService adminService,
			 WebConfig webConfig) {
		super();
		this.adminService = adminService;
		this.webConfig = webConfig;
	}
	
	/**
	 * 登录
	 * @param requestCommand
	 * @param responseCommand
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws JSONException 
	 */
	public ResponseCommand login(RequestCommand requestCommand,
			ResponseCommand responseCommand) throws JsonParseException, JsonMappingException, IOException, JSONException {
	
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		LoginCommand loginCommand = initLoginCommand(requestCommand);
		
		Map<String,Object> map = loginCommand.getMap();
		String phone = (String) map.get("phone");
		String passwd = (String) map.get("passwd");
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("phone", phone);
		/*RowBounds rowBounds = new RowBounds(webConfig.getWebSqlPageOffset(), 
				webConfig.getWebSqlPageSizeMax());*/
		
		
		return returnResult(ErrorCode.ERR_CODE_STATUS_TRUE, ErrorCode.ERR_CODE_SUCCESS, 
				JsonConversion.writeMapJSON(resultMap), responseCommand);
	}
	
}
