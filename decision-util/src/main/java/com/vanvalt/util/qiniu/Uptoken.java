package com.vanvalt.util.qiniu;

import org.json.JSONException;
import org.springframework.stereotype.Component;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;
import com.vanvalt.util.command.WebConfig;

/**
 * uptoken是一个字符串，作为http协议Header的一部分（Authorization字段）发送到我们七牛的服务端，
 * 表示这个http请求是经过用户授权的。
 * 
 */
@Component
public class Uptoken {
	/**
	 * 参数配置.
	 */
	WebConfig webConfig;
	/**
	 * 验证
	 */
	Mac mac;
	/**
	 * 用于生成上传令牌。
	 */
	PutPolicy putPolicy;

	/**
	 * 构造方法.	
	 */
	public Uptoken(WebConfig webConfig) {
		this.webConfig = webConfig;
		Config.ACCESS_KEY = webConfig.getQiuniuConfigAccesskey();
		Config.SECRET_KEY = webConfig.getQiuniuConfigSecretkey();
		mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		putPolicy = new PutPolicy(webConfig.getQiniuBucketName());
		putPolicy.expires=webConfig.getQiniuexpires();
	}
	/**
	 * 生成上传令牌。
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 * @throws org.json.JSONException 
	 */
	public String generateUptoken() throws AuthException, JSONException{
		return putPolicy.token(mac);
	}
	public Uptoken() {
		// TODO Auto-generated constructor stub
	}
	public WebConfig getWebConfig() {
		return webConfig;
	}
	public void setWebConfig(WebConfig webConfig) {
		this.webConfig = webConfig;
	}
	public Mac getMac() {
		return mac;
	}

	public void setMac(Mac mac) {
		this.mac = mac;
	}

	public PutPolicy getPutPolicy() {
		return putPolicy;
	}

	public void setPutPolicy(PutPolicy putPolicy) {
		this.putPolicy = putPolicy;
	}
	
}
