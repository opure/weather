package com.vanvalt.service;

import java.util.List;

import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.model.BindInfo;
import com.baidu.yun.channel.model.ChannelMessage;
import com.baidu.yun.channel.model.PushBroadcastMessageResponse;
import com.baidu.yun.channel.model.PushTagMessageResponse;
import com.baidu.yun.channel.model.PushUnicastMessageResponse;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToTagResponse;

/**
 * 百度推送服务
 * @author chenbowang
 *
 */
public interface BaiduPushService {
	/**
	 * 查询用户的绑定列表.
	 * @param apiKey
	 * @param secretKey
	 * @param userId
	 * @return List<BindInfo> 
	 */
	List<BindInfo> queryBindList(String apiKey, String secretKey,String userId);
	/**
	 * 推送单播消息(消息类型为透传，由开发方应用自己来解析消息内容)
	 * @param apiKey
	 * @param secretKey
	 * @param channelId
	 * @param userId
	 * @param message 
	 * @return
	 */
	public PushUnicastMessageResponse pushUnicastMessage(String apiKey, String secretKey,
			Long channelId,String userId,String message) ;
	/**
	 * 向Android端设备推送单播消息
	 * @param apiKey
	 * @param secretKey
	 * @param channelId
	 * @param userId
	 * @param message {"title":"Notify_title_danbo","description":"Notify_description_content"}
	 * @return
	 */
	public PushUnicastMessageResponse pushUnicastAndroidNotification(String apiKey, String secretKey,
			Long channelId,String userId,String message);
	/**
	 * 推送单播消息(IOS APNS)
	 * @param apiKey
	 * @param secretKey
	 * @param userId
	 * @param message {aps}
	 * @return
	 */
	public PushUnicastMessageResponse pushUnicastIosNotification(String apiKey, String secretKey,
			Long channelId,String userId,String message);
	/**
	 * 向tag推送消息
	 * @param apiKey
	 * @param secretKey
	 * @param tag
	 * @param message {"title":"标题","description":"hw推荐内容xxx"}
	 * @return
	 */
	public PushTagMessageResponse pushTagMessage(String apiKey, String secretKey,
			String tag,String message) ;
	/**
	 * * 推送广播消息
	 * @param apiKey
	 * @param secretKey
	 * @param message {"title":"标题","description":"hw推荐内容xxx"}
	 * @return
	 */
	public PushBroadcastMessageResponse pushBroadcastMessage(String apiKey, String secretKey,
			String message);
	/**
	 * 绑定验证
	 * @param apiKey
	 * @param secretKey
	 * @param channelId
	 * @param userId
	 * @return
	 */
	public boolean bindVerify(String apiKey, String secretKey,
			Long channelId,String userId) ;
	/**
	 * 获取历史消息列表
	 * apiKey
	 * secretKey
	 * userId
	 * @param params
	 */
	public List<ChannelMessage> fetchMessage(String apiKey, String secretKey,
			String userId);
	/**
	 * 设置tag
	 * @param apiKey
	 * @param secretKey
	 * @param tag
	 * @param userId
	 * @return
	 */
	public boolean setTag(String apiKey, String secretKey,
			String tag,String userId);
	/**
	 * 删除tag
	 * @param apiKey
	 * @param secretKey
	 * @param tag
	 * @param userId
	 * @return
	 */
	public boolean deleteTag(String apiKey, String secretKey,
			String tag,String userId);
	/**
	 * 初始化ios证书
	 * apiKey
	 * secretKey
	 * name
	 * description
	 * dev_cert
	 * release_cert
	 * @param params
	 */
	public BaiduChannelClient initIosCert(String apiKey, String secretKey,
			String name,String description,String devCert,String releaseCert);
	
	/**
	 * 自动生成tag
	 * @param apiKey
	 * @param secretKey
	 * @param channelIds
	 * @param prefixTag
	 * @return
	 * @throws PushClientException 
	 * @throws PushServerException 
	 */
	public String generatorTag(String apiKey, String secretKey, String prefixTag) throws PushClientException, PushServerException;
	
	/**
	 * 自动生成tag
	 * @param apiKey
	 * @param secretKey
	 * @param channelIds
	 * @param prefixTag
	 * @param deviceType
	 * @return
	 * @throws PushClientException 
	 * @throws PushServerException 
	 */
	public String generatorTag(String apiKey, String secretKey, String prefixTag, int deviceType) throws PushClientException, PushServerException;
	
	/**
	 * 添加设备到tag
	 * @param tagName
	 * @param channelIds
	 * @throws PushClientException 
	 * @throws PushServerException 
	 */
	public void addDevicesToTag(String apiKey, String secretKey, String tagName, String[] channelIds) throws PushClientException, PushServerException;
	
	/**
	 * 向tag推送消息
	 * @param apiKey
	 * @param secretKey
	 * @param tag
	 * @param message
	 * @param timing
	 * @return
	 * @throws PushClientException
	 * @throws PushServerException
	 */
	public PushMsgToTagResponse pushMsgToTag(String apiKey, String secretKey,
			String tag, String message, int timing) throws PushClientException, PushServerException;
	/**
	 * 向tag推送消息
	 * @param apiKey
	 * @param secretKey
	 * @param tag
	 * @param message
	 * @param timing
	 * @param deviceType
	 * @param deployStatus
	 * @return
	 * @throws PushClientException
	 * @throws PushServerException
	 */
	public PushMsgToTagResponse pushMsgToTag(String apiKey, String secretKey,
			String tag, String message, int timing, int deviceType, int deployStatus) throws PushClientException, PushServerException;
	/**
	 * 向所有用户推送信息
	 * @param apiKey
	 * @param secretKey
	 * @param message
	 * @param timing
	 * @return
	 * @throws PushClientException
	 * @throws PushServerException
	 */
	public PushMsgToAllResponse pushMsgToAll(String apiKey, String secretKey,
			String message, int timing) throws PushClientException, PushServerException;
	
	/**
	 * 添加设备到tag
	 * @param apiKey
	 * @param secretKey
	 * @param tagName
	 * @param channelIds
	 * @param deviceType
	 * @throws PushClientException
	 * @throws PushServerException
	 */
	public void addDevicesToTag(String apiKey, String secretKey, String tagName, 
			String[] channelIds, int deviceType) throws PushClientException, PushServerException;
	
	/**
	 * 向所有用户推送
	 * @param apiKey
	 * @param secretKey
	 * @param message
	 * @param timing
	 * @param deviceType
	 * @param deployStatus
	 * @return
	 * @throws PushClientException
	 * @throws PushServerException
	 */
	public PushMsgToAllResponse pushMsgToAll(String apiKey, String secretKey, 
			String message, int timing, int deviceType, int deployStatus) throws PushClientException, PushServerException;
	
}
