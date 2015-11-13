package com.vanvalt.util.qiniu;

import com.qiniu.api.config.Config;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.BucketManager;
import com.qiniu.util.Auth;
import com.vanvalt.util.command.WebConfig;

public class QiniuUtils {

	
	/**
	 * 参数配置.
	 */
	WebConfig webConfig;
	BucketManager bucketManager;
	OperationManager operator;
	Auth auth;
	
	private String bucket;
	
	public QiniuUtils(WebConfig webConfig){
		this.webConfig = webConfig;
		Config.ACCESS_KEY = webConfig.getQiuniuConfigAccesskey();
		Config.SECRET_KEY = webConfig.getQiuniuConfigSecretkey();
		this.bucket = webConfig.getQiniuBucketName();
		this.auth = Auth.create(Config.ACCESS_KEY, Config.SECRET_KEY);
		bucketManager = new BucketManager(auth);
		
	}
	
	/**
	 * 私有资源下载
	 * @return
	 */
	public static String downloadToken(){
		
		String url = "http://7xiwdw.com2.z0.glb.qiniucdn.com/head_head_pic3.png";
		String url2 = "http://7xiwdw.com2.z0.glb.qiniucdn.com/head_head_pic3.png?imageView2/1/w/100";
		Auth tempAuth = Auth.create(Config.ACCESS_KEY, Config.SECRET_KEY);
		//默认有效时长：3600秒
		String urlSigned = tempAuth.privateDownloadUrl(url2);
		//指定时长
		String urlSigned2 = tempAuth.privateDownloadUrl(url, 3600 * 24);
		System.out.println(urlSigned);
		System.out.println(urlSigned2);
		
		return urlSigned+", "+urlSigned2;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		downloadToken();
	}

	public WebConfig getWebConfig() {
		return webConfig;
	}

	public void setWebConfig(WebConfig webConfig) {
		this.webConfig = webConfig;
	}

	public BucketManager getBucketManager() {
		return bucketManager;
	}

	public void setBucketManager(BucketManager bucketManager) {
		this.bucketManager = bucketManager;
	}

	public OperationManager getOperator() {
		return operator;
	}

	public void setOperator(OperationManager operator) {
		this.operator = operator;
	}

	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

}
