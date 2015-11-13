package com.vanvalt.web.buisness;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.qiniu.api.auth.AuthException;
import com.qiniu.storage.model.FileInfo;
import com.vanvalt.entity.Token;
import com.vanvalt.util.json.JsonConversion;
import com.vanvalt.util.qiniu.Buckets;
import com.vanvalt.util.qiniu.Uptoken;
import com.vanvalt.web.command.impl.RequestCommand;
import com.vanvalt.web.command.impl.ResponseCommand;
import com.vanvalt.web.command.impl.TokenCommand;
import com.vanvalt.web.command.util.ErrorCode;
import com.vanvalt.util.command.WebConfig;

/**
 * 学生家长处理接口
 * @author Xiaoyang
 *
 */
public class TokenProcess extends BaseProcess {
	/**
	 *日志.
	 */
	@SuppressWarnings("unused")
	private static Logger 		logger = Logger.getLogger(TokenProcess.class);
	private static HttpServletRequest	httpServletRequest	= ((ServletRequestAttributes) RequestContextHolder
			.getRequestAttributes()).getRequest();
	
	/**
	 * 用户自定义配置项.
	 */
	private WebConfig 					webConfig;
	
	/**
	 * 构造方法.
	 */	
	public TokenProcess() {
		super();
	}
	

	/**
	 * 构造方法.
	 * 
	 * @param webConfig
	 */
	public TokenProcess(WebConfig webConfig) {
		super();
		this.webConfig = webConfig;
	}

	/**
	 * 生产令牌.
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public ResponseCommand generateToken(RequestCommand requestCommand,ResponseCommand responseCommand) throws AuthException, JSONException, JsonParseException, JsonMappingException, IOException {
		// 解析json为Token对象
		TokenCommand tokenCommand = new TokenCommand(requestCommand.getObject()
				.toString());
		Token token = tokenCommand.getToken();
		if (null == token) {
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
			responseCommand.setCode(ErrorCode.ERR_CODE_PARAMETER_EMPTY);
		} else {
			// TODO 需要判断生成的令牌类型
			token.setToken(new Uptoken(webConfig).generateUptoken());
			responseCommand.setObject(JsonConversion.writeEntityJSON(token));
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_TRUE);
			responseCommand.setCode(ErrorCode.ERR_CODE_SUCCESS);
		}		
		return responseCommand;
	}
	
	
	/**
	 * 获取空间名列表.
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public ResponseCommand getBuckets(RequestCommand requestCommand,ResponseCommand responseCommand) throws AuthException, JSONException, JsonParseException, JsonMappingException, IOException {
		// 解析json为Token对象
		TokenCommand tokenCommand = new TokenCommand(requestCommand.getObject()
				.toString());
		Token token = tokenCommand.getToken();
		if (null == token) {
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
			responseCommand.setCode(ErrorCode.ERR_CODE_PARAMETER_EMPTY);
		} else {
			
			Buckets buckets = new Buckets(webConfig);
			String[] str = buckets.getBucktes();
			responseCommand.setObject(JsonConversion.writeEntityJSON(str));
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_TRUE);
			responseCommand.setCode(ErrorCode.ERR_CODE_SUCCESS);
		}		
		return responseCommand;
	}
	
	/**
	 * 获取文件列表.
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public ResponseCommand getFileList(RequestCommand requestCommand,ResponseCommand responseCommand) throws AuthException, JSONException, JsonParseException, JsonMappingException, IOException {
		// 解析json为Token对象
		TokenCommand tokenCommand = new TokenCommand(requestCommand.getObject()
				.toString());
		Token token = tokenCommand.getToken();
		if (null == token) {
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
			responseCommand.setCode(ErrorCode.ERR_CODE_PARAMETER_EMPTY);
		} else {
			
			Buckets buckets = new Buckets(webConfig);
			List<FileInfo> list = buckets.fileList();
			
			responseCommand.setObject(JsonConversion.writeListJSON(list));
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_TRUE);
			responseCommand.setCode(ErrorCode.ERR_CODE_SUCCESS);
		}		
		return responseCommand;
	}
	
	public WebConfig getWebConfig() {
		return webConfig;
	}

	public void setWebConfig(WebConfig webConfig) {
		this.webConfig = webConfig;
	}

}
