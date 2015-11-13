package com.vanvalt.util.qiniu;

import java.util.List;

import com.google.common.collect.Lists;
import com.qiniu.api.config.Config;
import com.qiniu.common.QiniuException;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.vanvalt.util.random.RandomUtils;
import com.vanvalt.util.command.WebConfig;

public class Buckets {

	/**
	 * 参数配置.
	 */
	WebConfig webConfig;
	BucketManager bucketManager;
	OperationManager operator;
	
	private String bucket;
	
	
	public Buckets(WebConfig webConfig){
		this.webConfig = webConfig;
		Config.ACCESS_KEY = webConfig.getQiuniuConfigAccesskey();
		Config.SECRET_KEY = webConfig.getQiuniuConfigSecretkey();
		this.bucket = webConfig.getQiniuBucketName();
		Auth auth = Auth.create(Config.ACCESS_KEY, Config.SECRET_KEY);
		bucketManager = new BucketManager(auth);
		
	}
	
	/**
	 * 获取空间名列表
	 * @return
	 * @throws QiniuException
	 */
	public String[] getBucktes() throws QiniuException{
		return bucketManager.buckets();
	}
	
	/**
	* 根据前缀获取文件列表的迭代器
	*
	* @param bucket    空间名
	* @param prefix    文件名前缀
	* @param limit     每次迭代的长度限制，最大1000，推荐值 100
	* @param delimiter 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
	* @return FileInfo迭代器
	*/
	public List<FileInfo> fileList(){
		
		List<FileInfo> list = Lists.newArrayList();
		
		//String bucket = this.webConfig.getQiniuBucketName();
		String prefix = "";
		BucketManager.FileListIterator it = bucketManager.createFileListIterator(bucket, prefix, 100, null);
		
		while (it.hasNext()) {
		    FileInfo[] items = it.next();
		    for(int i=0;i<items.length;i++){
		    	list.add(items[i]);
		    }
		}
		
		return list;
	}
	
	/**
	 * 随机获取用户头像
	 * @param prefix
	 * @param limit
	 * @return
	 */
	public String getHeadImageRomand(String prefix, Integer limit){
		String url = "";
		List<FileInfo> fileList = this.fileList(prefix, limit);
		String defaultDomain = this.webConfig.getQiniuBucketDefaultDomain();
		
		int r = RandomUtils.generateRandom(0, 9);
		if(fileList != null && fileList.size()>0){
			FileInfo file = null;
			if(r <= fileList.size()){
				file = fileList.get(r);
				String key = file.key;
				
				url = "http://"+ defaultDomain + "/" + key;
			}
			
		}
		
		return url;
				
	}
	/**
	* 根据前缀获取文件列表的迭代器
	*
	* @param bucket    空间名
	* @param prefix    文件名前缀
	* @param limit     每次迭代的长度限制，最大1000，推荐值 100
	* @param delimiter 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
	* @return FileInfo迭代器
	*/
	public List<FileInfo> fileList(String prefix, Integer limit){
		
		List<FileInfo> list = Lists.newArrayList();
		
		BucketManager.FileListIterator it = bucketManager.createFileListIterator(bucket, prefix, 100, null);
		
		while (it.hasNext()) {
		    FileInfo[] items = it.next();
		    for(int i=0;i<items.length;i++){
		    	list.add(items[i]);
		    }
		}
		
		return list;
	}
	
	/**
	 * 查看文件属性
	 * @param key
	 * @return
	 * @throws QiniuException
	 */
	public FileInfo getFileInfo(String key) throws QiniuException{
		FileInfo info = new FileInfo();
		
		info = bucketManager.stat(bucket, key);
		
		return info;
	}

	/**
	 * 复制文件
	 * @param key
	 * @param targetBucket
	 * @param targetKey
	 * @throws QiniuException
	 */
	public void copyFile(String key, String targetBucket, String targetKey) throws QiniuException{
		
		bucketManager.copy(bucket, key, targetBucket, targetKey);
	}
	
	/**
	 * 重命名文件
	 * @param oldKey
	 * @param newKey
	 * @throws QiniuException
	 */
	public void renameFile(String oldKey, String newKey) throws QiniuException{
		bucketManager.rename(bucket, oldKey, newKey);
	}
	
	/**
	 * 移动文件
	 * @param key
	 * @param targetBucket
	 * @param targetKey
	 * @throws QiniuException
	 */
	public void moveFile(String key, String targetBucket, String targetKey) throws QiniuException{
		bucketManager.move(bucket, key, targetBucket, targetKey);
	}
	
	/**
	 * 删除文件
	 * @param bucket
	 * @param key
	 * @throws QiniuException
	 */
	public void deleteFile(String key) throws QiniuException{
		bucketManager.delete(bucket, key);
	}
	
	/**
	 * 抓取资源
	 * 要求url可公网正常访问，不指定 key 时以文件的 hash 值为 key
	 * @param url
	 * @return
	 * @throws QiniuException
	 */
	public DefaultPutRet fetch(String url) throws QiniuException{
		return bucketManager.fetch(url, bucket);
	}
	
	/**
	 * 抓取资源
	 * 要求url可公网正常访问
	 * @param url
	 * @return
	 * @throws QiniuException
	 */
	public DefaultPutRet fetch(String url, String key) throws QiniuException{
		return bucketManager.fetch(url, bucket, key);
	}
	
	/**
	 * 批量操作
	 */
	/*public batchOps(){
		
		BucketManager.Batch ops = new BucketManager.Batch()
							        .copy(TestConfig.bucket, TestConfig.key, TestConfig.bucket, key)
							        .move(TestConfig.bucket, key1, TestConfig.bucket, key2)
							        .rename(TestConfig.bucket, key3, key4)
							        .stat(TestConfig.bucket, array)
							        .stat(TestConfig.bucket, array[0])
							        .stat(TestConfig.bucket, array[1], array[2])
							        .delete(TestConfig.bucket, array1)
							        .delete(TestConfig.bucket, array1[0])
							        .delete(TestConfig.bucket, array1[1], array1[2]);
		try {
		    Response r = bucketManager.batch(ops);
		    BatchStatus[] bs = r.jsonToObject(BatchStatus[].class);
		    for (BatchStatus b : bs) {
		        assertEquals(200, b.code);
		    }
		} catch (QiniuException e) {
		    Response r = e.response;
		    // 请求失败时简单状态信息
		    log.error(r.toString());
		    try {
		        // 响应的文本信息
		        log.error(r.bodyString());
		    } catch (QiniuException e1) {
		        //ignore
		    }
		}
	}*/
	
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

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public OperationManager getOperator() {
		return operator;
	}

	public void setOperator(OperationManager operator) {
		this.operator = operator;
	}
	
	
	
}
