package com.vanvalt.web.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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

@Path("/")
@Controller
@Scope("prototype")
public class Service {
	/**
	 * 日志.
	 */
	private static Logger					logger				= Logger.getLogger(Service.class);
	private static final String				CONTENT_TYPE		= "Content-Type";
	private static final String				APPLICATION_CHARSET	= "application/json; charset=utf-8";
	private static final int				STATUS_200			= 200;
	
	/**
	 * 输出。
	 */
	private String							output;
	
	/** 
	 * 用户配置项
	 */
	@Autowired
	private WebConfig 						webConfig;
	
	@Autowired
	private AdminService 					adminService;
	
	@Autowired
	private AlarmInfoService				alarmInfoService;
	
	@Autowired
	private AppService						appService;
	
	@Autowired
	private ColumnService					columnService;
	
	@Autowired
	private FeedbookService					feedbookService;
	
	@Autowired
	private ProductService					productService;
	
	@Autowired
	private ProductCategoryService 			productCategoryService;
	
	@Autowired
	private TemplateService					templateService;
	
	@Autowired
	private ThemeService                    themeService;  
	
	/**
	 * 百度推送绑定接口
	 */
	@Autowired
	private PushMappingService 				pushMappingService;
	
	/**
	 * 百度推送接口
	 */
	@Autowired
	private BaiduPushService				baiduPushService;
	
	/**
	 * 百度推送配置项
	 */
	@Autowired
	private BaiduPushConfig					baiduPushConfig;
	
	@POST
	@Path("Json")
	public Response request(@Context HttpServletRequest request) {
		// 初始化
		RequestProcess requestProcess = new RequestProcess(request);

		if (null == output) {
			// 设置服务
			setService(requestProcess);
			// 执行处理
			requestProcess.ProcessCommand();
			// 输出json
			output = requestProcess.getResponseCommand().toJson();
		}

		// 输出到客户端
		return Response.status(STATUS_200).header(CONTENT_TYPE, APPLICATION_CHARSET).entity(output).build();
	}
	
	/**
	 * 设置服务
	 * 
	 * @param requestProcess
	 */
	private void setService(RequestProcess requestProcess) {
		// 设置服务接口
		requestProcess.setWebConfig(webConfig);
		requestProcess.setPushMappingService(pushMappingService);
		requestProcess.setBaiduPushService(baiduPushService);
		requestProcess.setBaiduPushConfig(baiduPushConfig);
		requestProcess.setAdminService(adminService);
		requestProcess.setAlarmInfoService(alarmInfoService);
		requestProcess.setAppService(appService);
		requestProcess.setColumnService(columnService);
		requestProcess.setFeedbookService(feedbookService);
		requestProcess.setProductCategoryService(productCategoryService);
		requestProcess.setProductService(productService);
		requestProcess.setTemplateService(templateService);
		requestProcess.setThemeService(themeService);
	}
	
	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}