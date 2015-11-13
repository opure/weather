package com.vanvalt.web.buisness;

import java.io.IOException;
import java.util.Date;
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
import com.vanvalt.entity.Admin;
import com.vanvalt.entity.PushMapping;
import com.vanvalt.service.AdminService;
import com.vanvalt.service.PushMappingService;
import com.vanvalt.web.command.impl.BaiduPushMappingCommand;
import com.vanvalt.web.command.impl.RequestCommand;
import com.vanvalt.web.command.impl.ResponseCommand;
import com.vanvalt.web.command.util.ErrorCode;

/**
 * 百度推送绑定处理接口
 * @author Xiaoyang
 *
 */
public class PushMappingProcess extends BaseProcess {
	/**
	 *日志.
	 */
	@SuppressWarnings("unused")
	private static Logger 		logger = Logger.getLogger(PushMappingProcess.class);
	private static HttpServletRequest	httpServletRequest	= ((ServletRequestAttributes) RequestContextHolder
			.getRequestAttributes()).getRequest();
	
	private AdminService 				adminService;
	private PushMappingService			pushMappingService;
	
	/**
	 * 构造方法.
	 */	
	public PushMappingProcess() {
		super();
	}

	/**
	 * 构造方法.
	 * 
	 * @param webConfig
	 */
	public PushMappingProcess(AdminService adminService, PushMappingService pushMappingService) {
		super();
		this.adminService = adminService;
		this.pushMappingService = pushMappingService;
	}

	/**
	 * 百度推送绑定
	 * @param requestCommand
	 * @param responseCommand
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws JSONException
	 */
	public ResponseCommand baiduPushMapping(RequestCommand requestCommand,
			ResponseCommand responseCommand) throws JsonParseException, JsonMappingException, IOException, JSONException {
	
		BaiduPushMappingCommand baiduPushMappingCommand = initBaiduPushMappingCommand(requestCommand);
		
		Map<String,Object> map = baiduPushMappingCommand.getMap();
		if(map.isEmpty()){
			return returnResult(ErrorCode.ERR_CODE_STATUS_FALSE, ErrorCode.ERR_CODE_PARAMETER_EMPTY, responseCommand);
		} else {
			String uid = (String) map.get("uid");
			if(StringUtils.isEmpty(uid)){
				return returnResult(ErrorCode.ERR_CODE_STATUS_FALSE, ErrorCode.ERR_CODE_PARAMETER_EMPTY, responseCommand);
			} else {
				String bdUserId = (String) map.get("userId");
				String channelId = (String) map.get("channelId");
				String deviceType = (String) map.get("deviceType");
				
				if(StringUtils.isEmpty(bdUserId)){
					return returnResult(ErrorCode.ERR_CODE_STATUS_FALSE, ErrorCode.ERR_CODE_PARAMETER_EMPTY, responseCommand);
				}
				
				if(StringUtils.isEmpty(channelId)){
					return returnResult(ErrorCode.ERR_CODE_STATUS_FALSE, ErrorCode.ERR_CODE_PARAMETER_EMPTY, responseCommand);
				}
				
				Admin admin = this.adminService.load(Admin.class, uid);
				if(admin != null){ 
					
					Map<String,Object> params = new HashMap<String,Object>();
					params.put("userId", uid);
					
					List<PushMapping> pushMappingList = this.pushMappingService.list(PushMapping.class, params);
					
					PushMapping pushMapping = null;
					
					if(pushMappingList != null && pushMappingList.size()>0){ // 已存在百度绑定信息
						
						for(PushMapping pm:pushMappingList){
							pushMapping = pm;
						}
						
						if(!channelId.equals(pushMapping.getChannelId())){ // 该用户的百度channelId与原来不一致，则修改
							pushMapping.setChannelId(channelId);
							pushMapping.setBdUserId(bdUserId);
							pushMapping.setDeviceType(deviceType);
							pushMapping.setUpdateTime(new Date());
							
							this.pushMappingService.update(pushMapping);
						}
						
					} else { // 该用户暂无百度绑定信息
						
						// 添加百度推送绑定
						PushMapping newPushMapping = new PushMapping();
						newPushMapping.setUserId(uid); // 系统uid
						newPushMapping.setBdUserId(bdUserId); // 百度userId
						newPushMapping.setChannelId(channelId);
						newPushMapping.setDeviceType(deviceType);
						newPushMapping.setCreateTime(new Date());
						
						this.pushMappingService.add(newPushMapping);
					}
					
				} else {
					
					return returnResult(ErrorCode.ERR_CODE_STATUS_FALSE, ErrorCode.ERR_CODE_DATA_EXCEPTION, responseCommand);
				}
				
			}
		}
		
		return returnResult(ErrorCode.ERR_CODE_STATUS_TRUE, ErrorCode.ERR_CODE_SUCCESS, 
				 responseCommand);
	}
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public PushMappingService getPushMappingService() {
		return pushMappingService;
	}


	public void setPushMappingService(PushMappingService pushMappingService) {
		this.pushMappingService = pushMappingService;
	}
	
}
