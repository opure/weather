package com.vanvalt.web.command.impl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.vanvalt.util.json.ObjectMappingCustomer;
import com.vanvalt.web.command.ICommand;
import com.vanvalt.web.command.util.ErrorCode;

/**
 * 客户端API请求接口
 * 
 * @author chenbowang
 * 
 */
public class RequestCommand implements ICommand {
	/**
	 * 日志.
	 */
	private static Logger logger = Logger.getLogger(RequestCommand.class);
	/**
	 * 请求标识.
	 */
	String command =ErrorCode.ERR_CODE_UNKNOWN_COMMAND;
	/**
	 * 请求时间戳.
	 */
	long timestamp;
	/**
	 * 请求具体参数.
	 */
	Object object;
	/**
	 * 设备唯一标识符.
	 */
	String deviceId;
	/**
	 * 操作系统软件版本的设备,比如安卓2.3.3,ios7.
	 */
	String osVersion;
	/**
	 * 软件版本,如:移动医院v1.0.
	 */
	String softwareVersion;
	/**
	 * 客户端软件平台android和ios.
	 */
	String platformType;
	/**
	 * 手机或平板电脑类型.
	 */
	String mobileType;
	/**
	 * 令牌.
	 */
	String token;
	/**
	 * 构造器.
	 */
	public RequestCommand() {
		super();
	}

	/**
	 * 构造器.
	 * @param json
	 * @throws IOException 
	 * @throws JsonProcessingException 
	 */
	public RequestCommand(String json) throws JsonProcessingException, IOException {
		//ObjectMapper mapper = new ObjectMapper();
		ObjectMappingCustomer mapper = new ObjectMappingCustomer();
		// 读取Json
		
		//String jsonStr = Tools.replaceSpecialtyStr(json, null, null);
		JsonNode rootNode = mapper.readTree(json);

		try {
			this.command = rootNode.path("command").asText().trim();
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}		
//		
//		try {
//			this.timestamp = rootNode.path("timestamp").asLong();
//		} catch (Exception e) {
//			logger.debug(e.getMessage(), e);
//		}
		
		try {
			this.object = rootNode.path("object");
		}  catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}
		
//		try {
//			this.deviceId = rootNode.path("deviceId").asText();
//		}  catch (Exception e) {
//			logger.debug(e.getMessage(), e);
//		}
//		
//		
//		try {
//			this.osVersion = rootNode.path("osVersion").asText();
//		}  catch (Exception e) {
//			logger.debug(e.getMessage(), e);
//		}
//		
//		
//		try {
//			this.softwareVersion =  rootNode.path("softwareVersion").asText();
//		}  catch (Exception e) {
//			logger.debug(e.getMessage(), e);
//		}
//		
//		
//		try {
//			this.platformType =  rootNode.path("platformType").asText();
//		}  catch (Exception e) {
//			logger.debug(e.getMessage(), e);
//		}
//		
//		
//		try {
//			this.mobileType =  rootNode.path("mobileType").asText();
//		}  catch (Exception e) {
//			logger.debug(e.getMessage(), e);
//		}
		
		try {
			this.token = rootNode.path("token").asText().trim();
		}  catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}

	}

	/**
	 * 构造器.
	 * 
	 * @param command
	 * @param timestamp
	 * @param object
	 * @param deviceId
	 * @param osVersion
	 * @param softwareVersion
	 * @param platformType
	 * @param mobileType
	 */
	public RequestCommand(String command, long timestamp, Object object,
			String deviceId, String osVersion, String softwareVersion,
			String platformType, String mobileType) {
		this.command = command;
		this.timestamp = timestamp;
		this.object = object;
		this.deviceId = deviceId;
		this.osVersion = osVersion;
		this.softwareVersion = softwareVersion;
		this.platformType = platformType;
		this.mobileType = mobileType;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public String getMobileType() {
		return mobileType;
	}

	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toJson() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"command\":\"");
		builder.append(command);
//		builder.append("\", \"timestamp\":\"");
//		builder.append(timestamp);
		builder.append("\", \"object\":\"");
		builder.append(object);
//		builder.append("\", \"deviceId\":\"");
//		builder.append(deviceId);
//		builder.append("\", \"osVersion\":\"");
//		builder.append(osVersion);
//		builder.append("\", \"softwareVersion\":\"");
//		builder.append(softwareVersion);
//		builder.append("\", \"platformType\":\"");
//		builder.append(platformType);
//		builder.append("\", \"mobileType\":\"");
//		builder.append(mobileType);
		builder.append("\", \"token\":\"");
		builder.append(token);
		builder.append("\"}  ");
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestCommand [command=");
		builder.append(command);
//		builder.append(", timestamp=");
//		builder.append(timestamp);
		builder.append(", object=");
		builder.append(object);
//		builder.append(", deviceId=");
//		builder.append(deviceId);
//		builder.append(", osVersion=");
//		builder.append(osVersion);
//		builder.append(", softwareVersion=");
//		builder.append(softwareVersion);
//		builder.append(", platformType=");
//		builder.append(platformType);
//		builder.append(", mobileType=");
//		builder.append(mobileType);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}
	
	
}
