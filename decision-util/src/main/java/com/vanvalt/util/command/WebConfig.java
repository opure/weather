package com.vanvalt.util.command;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebConfig {

	/**
	 * Web项目名称.
	 */
	private String webProjectName;
	/**
	 * 默认SQL分页大小.
	 */
	private int webSqlPageSize;
	/**
	 * SQL最小分页大小
	 */
	private int webSqlPageSizeMin;
	/**
	 * SQL最大分页大小
	 */
	private int webSqlPageSizeMax;
	/**
	 * SQL分页从第n条开始
	 */
	private int webSqlPageOffset;
	/**
	 * SQL分页起始页
	 */
	private int webSqlPageCurrent;
	/**
	 * 文件上传保存目录
	 */
	private String webFileUploadDirectory;
	
	private int webNextTokenDay;
	
	
	
	/**
	 * 接入七牛云存储，您需要拥有有效的 Access Key 用来进行签名认证
	 */
	private String	qiuniuConfigAccesskey;
	/**
	 * 接入七牛云存储，您需要拥有有效的 Secret Key 用来进行签名认证
	 */
	private String	qiuniuConfigSecretkey;
	/**
	 * 接入七牛云存储空间名称，bucketName.
	 */
	private String	qiniuBucketName;

	/**
	 * 接入七牛云存储sns空间名称，snsimgname.
	 */
	private String	snsimgname;

	/**
	 * 七牛云存储上传地址.
	 */
	private String	qiniuUploadWebsite;
	/**
	 * 七牛云存储下载地址.
	 */
	private String	qiniuDownloadWebsite;
	/**
	 * 七牛token过期时间
	 */
	private long qiniuexpires;

	/**
	 * 七牛云存储sns图片下载地址.
	 */
	private String	qiniuDownloadSnswebsite;

	/**
	 * 七牛云存储缩放图片参数.
	 */
	private String	qiniuDownloadThumbnailImage;

	/**
	 * 七牛云存储缩放sns图片参数.
	 */
	private String	qiniuDownloadThumbnailSnsImage;
	
	private String qiniuBucketDefaultDomain;

	/**
	 * 构造方法.
	 */
	public WebConfig() {
		
	}
	
	
	public String getWebProjectName() {
		return webProjectName;
	}
	
	@Value("#{propertiesReader['web.project.name']}")
	public void setWebProjectName(String webProjectName) {
		this.webProjectName = webProjectName;
	}

	public int getWebSqlPageSize() {
		return webSqlPageSize;
	}
	
	@Value("#{propertiesReader['web.sql.pagesize']}")
	public void setWebSqlPageSize(int webSqlPageSize) {
		this.webSqlPageSize = webSqlPageSize;
	}

	public int getWebSqlPageSizeMin() {
		return webSqlPageSizeMin;
	}

	@Value("#{propertiesReader['web.sql.page.size.min']}")
	public void setWebSqlPageSizeMin(int webSqlPageSizeMin) {
		this.webSqlPageSizeMin = webSqlPageSizeMin;
	}

	public int getWebSqlPageSizeMax() {
		return webSqlPageSizeMax;
	}
	
	@Value("#{propertiesReader['web.sql.page.size.max']}")
	public void setWebSqlPageSizeMax(int webSqlPageSizeMax) {
		this.webSqlPageSizeMax = webSqlPageSizeMax;
	}

	public int getWebSqlPageOffset() {
		return webSqlPageOffset;
	}
	
	@Value("#{propertiesReader['web.sql.page.offset']}")
	public void setWebSqlPageOffset(int webSqlPageOffset) {
		this.webSqlPageOffset = webSqlPageOffset;
	}

	public int getWebSqlPageCurrent() {
		return webSqlPageCurrent;
	}
	
	@Value("#{propertiesReader['web.sql.page.current']}")
	public void setWebSqlPageCurrent(int webSqlPageCurrent) {
		this.webSqlPageCurrent = webSqlPageCurrent;
	}
	public long getQiniuexpires() {
		return qiniuexpires;
	}
	@Value("#{propertiesReader['web.qiniu.expires']}")
	public void setQiniuexpires(long qiniuexpires) {
		this.qiniuexpires = qiniuexpires;
	}

	public String getWebFileUploadDirectory() {
		return webFileUploadDirectory;
	}
	
	@Value("#{propertiesReader['web.file.upload.directory']}")
	public void setWebFileUploadDirectory(String webFileUploadDirectory) {
		this.webFileUploadDirectory = webFileUploadDirectory;
	}

	public int getWebNextTokenDay() {
		return webNextTokenDay;
	}
	
	@Value("#{propertiesReader['web.next.token.day']}")
	public void setWebNextTokenDay(int webNextTokenDay) {
		this.webNextTokenDay = webNextTokenDay;
	}
	
	public String getQiuniuConfigAccesskey() {
		return qiuniuConfigAccesskey;
	}

	@Value("#{propertiesReader['qiniu.config.access.key']}")
	public void setQiuniuConfigAccesskey(String qiuniuConfigAccesskey) {
		this.qiuniuConfigAccesskey = qiuniuConfigAccesskey;
	}

	public String getQiuniuConfigSecretkey() {
		return qiuniuConfigSecretkey;
	}

	@Value("#{propertiesReader['qiniu.config.secret.key']}")
	public void setQiuniuConfigSecretkey(String qiuniuConfigSecretkey) {
		this.qiuniuConfigSecretkey = qiuniuConfigSecretkey;
	}

	public String getQiniuBucketName() {
		return qiniuBucketName;
	}

	@Value("#{propertiesReader['qiniu.bucket.name']}")
	public void setQiniuBucketName(String qiniuBucketName) {
		this.qiniuBucketName = qiniuBucketName;
	}

	public String getQiniuUploadWebsite() {
		return qiniuUploadWebsite;
	}

	@Value("#{propertiesReader['qiniu.upload.website']}")
	public void setQiniuUploadWebsite(String qiniuUploadWebsite) {
		this.qiniuUploadWebsite = qiniuUploadWebsite;
	}

	public String getQiniuDownloadWebsite() {
		return qiniuDownloadWebsite;
	}

	@Value("#{propertiesReader['qiniu.download.website']}")
	public void setQiniuDownloadWebsite(String qiniuDownloadWebsite) {
		this.qiniuDownloadWebsite = qiniuDownloadWebsite;
	}

	public String getQiniuDownloadThumbnailImage() {
		return qiniuDownloadThumbnailImage;
	}

	@Value("#{propertiesReader['qiniu.download.thumbnail.image']}")
	public void setQiniuDownloadThumbnailImage(String qiniuDownloadThumbnailImage) {
		this.qiniuDownloadThumbnailImage = qiniuDownloadThumbnailImage;
	}

	public String getSnsimgname() {
		return snsimgname;
	}

	@Value("#{propertiesReader['qiniu.snsimg.name']}")
	public void setSnsimgname(String snsimgname) {
		this.snsimgname = snsimgname;
	}

	public String getQiniuDownloadSnswebsite() {
		return qiniuDownloadSnswebsite;
	}

	@Value("#{propertiesReader['qiniu.download.snswebsite']}")
	public void setQiniuDownloadSnswebsite(String qiniuDownloadSnswebsite) {
		this.qiniuDownloadSnswebsite = qiniuDownloadSnswebsite;
	}

	public String getQiniuDownloadThumbnailSnsImage() {
		return qiniuDownloadThumbnailSnsImage;
	}

	@Value("#{propertiesReader['qiniu.download.thumbnail.snsimage']}")
	public void setQiniuDownloadThumbnailSnsImage(String qiniuDownloadThumbnailSnsImage) {
		this.qiniuDownloadThumbnailSnsImage = qiniuDownloadThumbnailSnsImage;
	}

	public String getQiniuBucketDefaultDomain() {
		return qiniuBucketDefaultDomain;
	}

	@Value("#{propertiesReader['qiniu.bucket.defaultDomain']}")
	public void setQiniuBucketDefaultDomain(String qiniuBucketDefaultDomain) {
		this.qiniuBucketDefaultDomain = qiniuBucketDefaultDomain;
	}

}
