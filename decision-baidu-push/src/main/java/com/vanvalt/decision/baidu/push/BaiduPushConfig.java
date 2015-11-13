package com.vanvalt.decision.baidu.push;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("baiduPushConfig")
public class BaiduPushConfig {
	
	/**
	 * 百度云推送分配给开发者app的apiKey
	 */
	private String	baiduPushConfigApiKey;
	/**
	 * 百度云推送分配给开发者app的secretKey
	 */
	private String	baiduPushConfigSecretKey;
	/**
	 * 百度云推送分配给开发者app的appId
	 */
	private String	baiduPushConfigAppid;
	
	/**
	 * 百度云推送分配给开发者app的apiKey-家长版
	 */
	private String	baiduPushConfigApiParentKey;
	/**
	 * 百度云推送分配给开发者app的secretKey-家长版
	 */
	private String	baiduPushConfigSecretParentKey;
	/**
	 * 百度云推送分配给开发者app的appId-家长版
	 */
	private String	baiduPushConfigParentAppid;

	/**
	 * 百度云推送分配给开发者app的apiKey
	 */
	private String	baiduPushConfigApiIOSKey;
	/**
	 * 百度云推送分配给开发者app的secretKey
	 */
	private String	baiduPushConfigSecretIOSKey;
	/**
	 * 百度云推送分配给开发者app的appId
	 */
	private String	baiduPushConfigIOSAppid;
	
	/**
	 * 百度云推送分配给开发者app的apiKey-家长版
	 */
	private String	baiduPushConfigApiIOSParentKey;
	/**
	 * 百度云推送分配给开发者app的secretKey-家长版
	 */
	private String	baiduPushConfigSecretIOSParentKey;
	/**
	 * 百度云推送分配给开发者app的appId-家长版
	 */
	private String	baiduPushConfigIOSParentAppid;
	/**
	 * 仅IOS应用推送时使用，默认值为null，取值如下：1：开发状态 2：生产状态
	 */
	private int  deployStatus;
	
	/**
	 * 构造方法.
	 */
	public BaiduPushConfig() {
		
	}
	
	public String getBaiduPushConfigApiKey() {
		return baiduPushConfigApiKey;
	}
	@Value("#{propertiesReader['baidu.push.config.api.key']}")
	public void setBaiduPushConfigApiKey(String baiduPushConfigApiKey) {
		this.baiduPushConfigApiKey = baiduPushConfigApiKey;
	}

	public String getBaiduPushConfigSecretKey() {
		return baiduPushConfigSecretKey;
	}
	@Value("#{propertiesReader['baidu.push.config.secret.key']}")
	public void setBaiduPushConfigSecretKey(String baiduPushConfigSecretKey) {
		this.baiduPushConfigSecretKey = baiduPushConfigSecretKey;
	}

	public String getBaiduPushConfigAppid() {
		return baiduPushConfigAppid;
	}
	@Value("#{propertiesReader['baidu.push.config.appid']}")
	public void setBaiduPushConfigAppid(String baiduPushConfigAppid) {
		this.baiduPushConfigAppid = baiduPushConfigAppid;
	}

	public String getBaiduPushConfigApiParentKey() {
		return baiduPushConfigApiParentKey;
	}
	@Value("#{propertiesReader['baidu.push.config.api.parent.key']}")
	public void setBaiduPushConfigApiParentKey(String baiduPushConfigApiParentKey) {
		this.baiduPushConfigApiParentKey = baiduPushConfigApiParentKey;
	}

	public String getBaiduPushConfigSecretParentKey() {
		return baiduPushConfigSecretParentKey;
	}
	@Value("#{propertiesReader['baidu.push.config.secret.parent.key']}")
	public void setBaiduPushConfigSecretParentKey(
			String baiduPushConfigSecretParentKey) {
		this.baiduPushConfigSecretParentKey = baiduPushConfigSecretParentKey;
	}

	public String getBaiduPushConfigParentAppid() {
		return baiduPushConfigParentAppid;
	}
	@Value("#{propertiesReader['baidu.push.config.parent.appid']}")
	public void setBaiduPushConfigParentAppid(String baiduPushConfigParentAppid) {
		this.baiduPushConfigParentAppid = baiduPushConfigParentAppid;
	}

	public String getBaiduPushConfigApiIOSKey() {
		return baiduPushConfigApiIOSKey;
	}
	@Value("#{propertiesReader['baidu.push.config.api.ios.key']}")
	public void setBaiduPushConfigApiIOSKey(String baiduPushConfigApiIOSKey) {
		this.baiduPushConfigApiIOSKey = baiduPushConfigApiIOSKey;
	}

	public String getBaiduPushConfigSecretIOSKey() {
		return baiduPushConfigSecretIOSKey;
	}
	@Value("#{propertiesReader['baidu.push.config.secret.ios.key']}")
	public void setBaiduPushConfigSecretIOSKey(String baiduPushConfigSecretIOSKey) {
		this.baiduPushConfigSecretIOSKey = baiduPushConfigSecretIOSKey;
	}

	public String getBaiduPushConfigIOSAppid() {
		return baiduPushConfigIOSAppid;
	}
	@Value("#{propertiesReader['baidu.push.config.ios.appid']}")
	public void setBaiduPushConfigIOSAppid(String baiduPushConfigIOSAppid) {
		this.baiduPushConfigIOSAppid = baiduPushConfigIOSAppid;
	}

	public String getBaiduPushConfigApiIOSParentKey() {
		return baiduPushConfigApiIOSParentKey;
	}
	@Value("#{propertiesReader['baidu.push.config.api.ios.parent.key']}")
	public void setBaiduPushConfigApiIOSParentKey(
			String baiduPushConfigApiIOSParentKey) {
		this.baiduPushConfigApiIOSParentKey = baiduPushConfigApiIOSParentKey;
	}

	public String getBaiduPushConfigSecretIOSParentKey() {
		return baiduPushConfigSecretIOSParentKey;
	}
	@Value("#{propertiesReader['baidu.push.config.secret.ios.parent.key']}")
	public void setBaiduPushConfigSecretIOSParentKey(
			String baiduPushConfigSecretIOSParentKey) {
		this.baiduPushConfigSecretIOSParentKey = baiduPushConfigSecretIOSParentKey;
	}

	public String getBaiduPushConfigIOSParentAppid() {
		return baiduPushConfigIOSParentAppid;
	}
	@Value("#{propertiesReader['baidu.push.config.ios.parent.appid']}")
	public void setBaiduPushConfigIOSParentAppid(
			String baiduPushConfigIOSParentAppid) {
		this.baiduPushConfigIOSParentAppid = baiduPushConfigIOSParentAppid;
	}

	public int getDeployStatus() {
		return deployStatus;
	}
	@Value("#{propertiesReader['baidu.push.config.ios.deploystatus']}")
	public void setDeployStatus(int deployStatus) {
		this.deployStatus = deployStatus;
	}


}
