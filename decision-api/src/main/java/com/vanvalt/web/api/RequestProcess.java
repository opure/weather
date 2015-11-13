package com.vanvalt.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.vanvalt.decision.baidu.push.BaiduPushConfig;
import com.vanvalt.service.AdminService;
import com.vanvalt.service.AlarmInfoService;
import com.vanvalt.service.AppService;
import com.vanvalt.service.BaiduPushService;
import com.vanvalt.service.ColumnService;
import com.vanvalt.service.FeedbookService;
import com.vanvalt.service.ProductCategoryService;
import com.vanvalt.service.ProductService;
import com.vanvalt.service.PushMappingService;
import com.vanvalt.service.TemplateService;
import com.vanvalt.service.ThemeService;
import com.vanvalt.util.command.WebConfig;
import com.vanvalt.util.constant.Constant;
import com.vanvalt.util.http.RequestBody;
import com.vanvalt.util.json.JsonConversion;
import com.vanvalt.util.token.TokenUtils;
import com.vanvalt.web.buisness.AdminProcess;
import com.vanvalt.web.buisness.PushMappingProcess;
import com.vanvalt.web.buisness.TokenProcess;
import com.vanvalt.web.command.impl.PageCommand;
import com.vanvalt.web.command.impl.RequestCommand;
import com.vanvalt.web.command.impl.ResponseCommand;
import com.vanvalt.web.command.util.CommandCode;
import com.vanvalt.web.command.util.ErrorCode;


public class RequestProcess {
	
	/**
	 * 日志.
	 */
	private static Logger					logger	= Logger.getLogger(RequestProcess.class);
	
	/**
	 * 客户端请求命令.
	 */
	private RequestCommand					requestCommand;
	
	/**
	 * 服务端响应命令.
	 */
	private ResponseCommand					responseCommand;
	
	/**
	 * 请求命令内容.
	 */
	private String							reqBody;
	/** 
	 * 用户配置项
	 */
	private WebConfig 						webConfig;
	/**
	 * 分页.
	 */
	private PageCommand						pageCommand;
	
	private AdminService					adminService;
	
	private AlarmInfoService 				alarmInfoService;
	
	private AppService 						appService;
	
	private ColumnService 				    columnService;
	
	private FeedbookService 				feedbookService;
	
	private ProductService 				    productService;
	
	private ProductCategoryService			productCategoryService;
	
	private TemplateService                 templateService;
	
	private ThemeService 					themeService;
	
	/**
	 * 百度推送接口
	 */
	private BaiduPushService				baiduPushService;
	
	/**
	 * 推送绑定接口
	 */
	private PushMappingService 				pushMappingService;
	
	/**
	 * 百度推送配置
	 */
	private BaiduPushConfig 				baiduPushConfig;
	
	/**
	 * 构造方法.
	 */
	public RequestProcess() {
		this.requestCommand = new RequestCommand();
		this.responseCommand = new ResponseCommand();
	}

	/**
	 * 构造方法.
	 * 
	 * @param request
	 *            请求对象
	 */
	public RequestProcess(HttpServletRequest request) {
		responseCommand = new ResponseCommand();
		try {
			request.setCharacterEncoding("UTF-8");
			reqBody = RequestBody.getBodyRequest(request);
			requestCommand = new RequestCommand(reqBody);
		}
		catch (Exception e) {
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 * 处理请求命令.
	 */
	public void ProcessCommand() {

		if (null == responseCommand) {

			responseCommand = new ResponseCommand();
		}

		if (null == requestCommand) {
			requestCommand = new RequestCommand();
		}
		
		// 用户
		AdminProcess adminProcess;
		TokenProcess tokenProcess;
		PushMappingProcess pushMappingProcess;

		try {
			
			
			responseCommand.setCommand(requestCommand.getCommand());
			
			final int commandKey = Integer.valueOf(requestCommand.getCommand());
			
			/*// token验证,登录跳过
			if(CommandCode.CMD_USER_LOGIN != commandKey && !checkToken()) {
				return;			
			}*/
			
			switch (commandKey) {
			
				case CommandCode.CMD_LOGIN:
					// 6001 用户登录.
					adminProcess = new AdminProcess(adminService, webConfig);
					adminProcess.login(requestCommand,responseCommand);
					break;
				
					
				case CommandCode.CMD_TOKEN_GENERATE:
					// 6018 生成令牌.
					tokenProcess = new TokenProcess(webConfig);
					tokenProcess.generateToken(requestCommand, responseCommand);
					break;
					
				case CommandCode.CMD_QINIU_BUCKETS_LIST:
					// 6019 获取命名空间列表.
					tokenProcess = new TokenProcess(webConfig);
					tokenProcess.getBuckets(requestCommand, responseCommand);
					break;
					
				case CommandCode.CMD_QINIU_FILE_LIST:
					// 6020 获取文件列表.
					tokenProcess = new TokenProcess(webConfig);
					tokenProcess.getFileList(requestCommand, responseCommand);
					break;
					
				
				case CommandCode.CMD_BAIDU_PUSH_MAPPING:
					// 6022 百度推送绑定.
					pushMappingProcess = new PushMappingProcess(adminService, pushMappingService);
					pushMappingProcess.baiduPushMapping(requestCommand, responseCommand);
					break;
					
				default:
					responseCommand.setCode(ErrorCode.ERR_CODE_UNKNOWN_COMMAND);
					responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
					break;
			}
			
		} catch (Exception e) {

			String reqBody = requestCommand.getCommand() + " " + requestCommand.getObject();

			Map<String, String> map = new HashMap<String, String>();
			map.put("requetBody", reqBody);
			map.put("class", e.getClass().toString());
			map.put("message", e.getMessage());
			responseCommand.setObject(JsonConversion.writeMapJSON(map));

			responseCommand.setCode(ErrorCode.ERR_CODE_EXCEPTION);
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
			logger.error(reqBody + " " + e.getMessage(), e);
		}

	}

	/**
	 * 校验令牌合法
	 */
	private boolean checkToken() {
		if (StringUtils.isEmpty(requestCommand.getToken())) {
			responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
			responseCommand.setCode(ErrorCode.ERR_CODE_NOT_AUTHORIZE_LOGIN_FAILURE);
			return ErrorCode.ERR_CODE_STATUS_FALSE;
		}else {
			// [0]是密码，[1]是token,[2]是nextToken
			String token[] = StringUtils.split(requestCommand.getToken(), Constant.SPLIT_FILE);
			if (null == token || token.length != 3) {
				responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
				responseCommand.setCode(ErrorCode.ERR_CODE_NOT_AUTHORIZE_LOGIN_FAILURE);
				return ErrorCode.ERR_CODE_STATUS_FALSE;
			}
			if (!TokenUtils.validToken(token[1], token[0]) 
					&& !TokenUtils.validToken(token[2], token[0])) {
				// 登录失败，未授权，token非法
				responseCommand.setStatus(ErrorCode.ERR_CODE_STATUS_FALSE);
				responseCommand.setCode(ErrorCode.ERR_CODE_NOT_AUTHORIZE_LOGIN_FAILURE);
				return ErrorCode.ERR_CODE_STATUS_FALSE;
			}
		}
		
		return ErrorCode.ERR_CODE_STATUS_TRUE;
	}

	public RequestCommand getRequestCommand() {
		return requestCommand;
	}

	public void setRequestCommand(RequestCommand requestCommand) {
		this.requestCommand = requestCommand;
	}

	public ResponseCommand getResponseCommand() {
		return responseCommand;
	}

	public void setResponseCommand(ResponseCommand responseCommand) {
		this.responseCommand = responseCommand;
	}

	public String getReqBody() {
		return reqBody;
	}

	public void setReqBody(String reqBody) {
		this.reqBody = reqBody;
	}

	public WebConfig getWebConfig() {
		return webConfig;
	}

	public void setWebConfig(WebConfig webConfig) {
		this.webConfig = webConfig;
	}

	public PageCommand getPageCommand() {
		return pageCommand;
	}

	public void setPageCommand(PageCommand pageCommand) {
		this.pageCommand = pageCommand;
	}

	public BaiduPushService getBaiduPushService() {
		return baiduPushService;
	}

	public void setBaiduPushService(BaiduPushService baiduPushService) {
		this.baiduPushService = baiduPushService;
	}

	public PushMappingService getPushMappingService() {
		return pushMappingService;
	}

	public void setPushMappingService(PushMappingService pushMappingService) {
		this.pushMappingService = pushMappingService;
	}

	public BaiduPushConfig getBaiduPushConfig() {
		return baiduPushConfig;
	}

	public void setBaiduPushConfig(BaiduPushConfig baiduPushConfig) {
		this.baiduPushConfig = baiduPushConfig;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public AlarmInfoService getAlarmInfoService() {
		return alarmInfoService;
	}

	public void setAlarmInfoService(AlarmInfoService alarmInfoService) {
		this.alarmInfoService = alarmInfoService;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public ColumnService getColumnService() {
		return columnService;
	}

	public void setColumnService(ColumnService columnService) {
		this.columnService = columnService;
	}

	public FeedbookService getFeedbookService() {
		return feedbookService;
	}

	public void setFeedbookService(FeedbookService feedbookService) {
		this.feedbookService = feedbookService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductCategoryService getProductCategoryService() {
		return productCategoryService;
	}

	public void setProductCategoryService(
			ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	public TemplateService getTemplateService() {
		return templateService;
	}

	public void setTemplateService(TemplateService templateService) {
		this.templateService = templateService;
	}

	public ThemeService getThemeService() {
		return themeService;
	}

	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}


}
