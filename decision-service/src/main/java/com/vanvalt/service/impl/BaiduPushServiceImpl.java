package com.vanvalt.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.BindInfo;
import com.baidu.yun.channel.model.ChannelMessage;
import com.baidu.yun.channel.model.DeleteTagRequest;
import com.baidu.yun.channel.model.FetchMessageRequest;
import com.baidu.yun.channel.model.FetchMessageResponse;
import com.baidu.yun.channel.model.InitAppIoscertRequest;
import com.baidu.yun.channel.model.PushBroadcastMessageRequest;
import com.baidu.yun.channel.model.PushBroadcastMessageResponse;
import com.baidu.yun.channel.model.PushTagMessageRequest;
import com.baidu.yun.channel.model.PushTagMessageResponse;
import com.baidu.yun.channel.model.PushUnicastMessageRequest;
import com.baidu.yun.channel.model.PushUnicastMessageResponse;
import com.baidu.yun.channel.model.QueryBindListRequest;
import com.baidu.yun.channel.model.QueryBindListResponse;
import com.baidu.yun.channel.model.SetTagRequest;
import com.baidu.yun.channel.model.VerifyBindRequest;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.AddDevicesToTagRequest;
import com.baidu.yun.push.model.AddDevicesToTagResponse;
import com.baidu.yun.push.model.CreateTagRequest;
import com.baidu.yun.push.model.CreateTagResponse;
import com.baidu.yun.push.model.DeviceInfo;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToTagRequest;
import com.baidu.yun.push.model.PushMsgToTagResponse;
import com.vanvalt.service.BaiduPushService;
import com.vanvalt.util.random.UUIDGenerator;

@Service
public class BaiduPushServiceImpl implements BaiduPushService {

	private static Logger logger = Logger.getLogger(BaiduPushServiceImpl.class);
	
	@Override
	public  List<BindInfo> queryBindList(String apiKey, String secretKey,String userId) {
		// 1. 设置developer平台的ApiKey/SecretKey
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);

        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                //System.out.println(event.getMessage());
            }
        });
        List<BindInfo> bindInfos = null;
        try {
            // 4. 创建请求类对象
            QueryBindListRequest request = new QueryBindListRequest();
            request.setUserId(userId);

            // 5. 调用queryBindList接口
            QueryBindListResponse response = channelClient
                    .queryBindList(request);

            // 6. 对返回的结果对象进行操作
            bindInfos = response.getBinds();
            

        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
            e.printStackTrace();
        }
        
        return bindInfos;
	}

	@Override
	public PushUnicastMessageResponse pushUnicastMessage(String apiKey, String secretKey,
			Long channelId,String userId,String message) {
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);

        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
               // System.out.println(event.getMessage());
            }
        });
        PushUnicastMessageResponse response = null;
        try {

            // 4. 创建请求类对象
            PushUnicastMessageRequest request = new PushUnicastMessageRequest();
            request.setDeviceType(3);
            request.setChannelId(channelId);
            request.setUserId(userId);
            
            request.setMessage(message);

            // 5. 调用pushMessage接口
            response = channelClient
                    .pushUnicastMessage(request);


        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
           e.printStackTrace();
        }
		
        return response;
	}

	@Override
	public PushUnicastMessageResponse pushUnicastAndroidNotification(String apiKey, String secretKey,
			Long channelId,String userId,String message) {

        // 1. 设置developer平台的ApiKey/SecretKey
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);

        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                //System.out.println(event.getMessage());
            }
        });
        PushUnicastMessageResponse response = null;
        try {

            // 4. 创建请求类对象
            PushUnicastMessageRequest request = new PushUnicastMessageRequest();
            request.setDeviceType(3);
            request.setChannelId(channelId);
            request.setUserId(userId);

            request.setMessageType(1);
            request.setMessage(message);

            // 5. 调用pushMessage接口
            response = channelClient
                    .pushUnicastMessage(request);


        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
           e.printStackTrace();
        }
        
        return response;
		
	}

	@Override
	public PushUnicastMessageResponse pushUnicastIosNotification(String apiKey, String secretKey,
			Long channelId,String userId,String message) {
		
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);

        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                // System.out.println(event.getMessage());
            }
        });
        PushUnicastMessageResponse response = null;
        try {

            // 4. 创建请求类对象
            PushUnicastMessageRequest request = new PushUnicastMessageRequest();
            request.setDeviceType(4);
            // request.setChannelId(channelId);
            request.setUserId(userId);

            request.setMessageType(1);
            request.setMessage(message);

            // 5. 调用pushMessage接口
            response = channelClient.pushUnicastMessage(request);

        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
            e.printStackTrace();
        }
        
        return response;
		
	}

	/**
	 * 向tag推送信息
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
			String tag, String message, int timing) throws PushClientException, PushServerException{
		
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});
		PushMsgToTagResponse response = null;
		try {
			// 4. specify request arguments
			// pushTagTpye = 1 for common tag pushing
			PushMsgToTagRequest request = null;
			if(timing == 0){
				request = new PushMsgToTagRequest()
					.addTagName(tag)
					.addMsgExpires(new Integer(3600))
					//.addMessageType(0)  // 添加透传消息
					.addMessageType(1)
					// .addSendTime(System.currentTimeMillis() / 1000 + 120) //设置定时任务
					.addMessage(message)
					.addDeviceType(3);
			} else { // 定时任务
				request = new PushMsgToTagRequest()
				.addTagName(tag)
				.addMsgExpires(new Integer(3600))
				//.addMessageType(0)  // 添加透传消息
				.addMessageType(1)
				.addSendTime(System.currentTimeMillis() / 1000 + timing) //设置定时任务
				.addMessage(message)
				.addDeviceType(3);
			}
			
			// 5. http request
			response = pushClient.pushMsgToTag(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
		
		return response;
	}
	
	/**
	 * 向tag推送信息
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
			String tag, String message, int timing, int deviceType, int deployStatus) throws PushClientException, PushServerException{
		
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});
		PushMsgToTagResponse response = null;
		try {
			// 4. specify request arguments
			// pushTagTpye = 1 for common tag pushing
			PushMsgToTagRequest request = null;
			if(timing == 0){
				
				if(deviceType == 3){ // Android
					request = new PushMsgToTagRequest()
						.addTagName(tag)
						.addMsgExpires(new Integer(3600))
						//.addMessageType(0)  // 添加透传消息
						.addMessageType(1)
						// .addSendTime(System.currentTimeMillis() / 1000 + 120) //设置定时任务
						.addMessage(message.toString())
						.addDeviceType(deviceType);
				} else if(deviceType == 4){ // IOS
					request = new PushMsgToTagRequest()
						.addTagName(tag)
						.addMsgExpires(new Integer(3600))
						//.addMessageType(0)  // 添加透传消息
						.addMessageType(1)
						// .addSendTime(System.currentTimeMillis() / 1000 + 120) //设置定时任务
						.addMessage(message.toString())
						.addDeployStatus(deployStatus) //仅IOS应用推送时使用，默认值为null，取值如下：1：开发状态 2：生产状态
						.addDeviceType(deviceType);
				}
				
			} else { // 定时任务
				
				if(deviceType == 3){ // Android
					request = new PushMsgToTagRequest()
						.addTagName(tag)
						.addMsgExpires(new Integer(3600))
						//.addMessageType(0)  // 添加透传消息
						.addMessageType(1)
						.addSendTime(System.currentTimeMillis() / 1000 + timing) //设置定时任务
						.addMessage(message.toString())
						.addDeviceType(deviceType);
				} else if(deviceType == 4){ // IOS
					request = new PushMsgToTagRequest()
						.addTagName(tag)
						.addMsgExpires(new Integer(3600))
						//.addMessageType(0)  // 添加透传消息
						.addMessageType(1)
						.addSendTime(System.currentTimeMillis() / 1000 + timing) //设置定时任务
						.addMessage(message.toString())
						.addDeployStatus(deployStatus) //仅IOS应用推送时使用，默认值为null，取值如下：1：开发状态 2：生产状态
						.addDeviceType(deviceType);
				}
				
			}
			
			// 5. http request
			response = pushClient.pushMsgToTag(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());
			logger.info("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
		
		return response;
	}
	
	@Override
	public PushTagMessageResponse pushTagMessage(String apiKey, String secretKey,
			String tag,String message) {
		// 1. 设置developer平台的ApiKey/SecretKey
      ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

      // 2. 创建BaiduChannelClient对象实例
      BaiduChannelClient channelClient = new BaiduChannelClient(pair);

      // 3. 若要了解交互细节，请注册YunLogHandler类
      channelClient.setChannelLogHandler(new YunLogHandler() {
          @Override
          public void onHandle(YunLogEvent event) {
              //System.out.println(event.getMessage());
          }
      });

      PushTagMessageResponse response = null;
      try {

          // 4. 创建请求类对象
          PushTagMessageRequest request = new PushTagMessageRequest();
          request.setMessageType(0);
          request.setDeviceType(3);
          request.setTagName(tag);
          request.setMessage(message);
          

          // 5. 调用pushMessage接口
          response = channelClient
                  .pushTagMessage(request);
          if (response.getSuccessAmount() == 1) {
              // TODO
          }

      } catch (ChannelClientException e) {
          // 处理客户端错误异常
          e.printStackTrace();
      } catch (ChannelServerException e) {
    	  
    	  // 处理服务端错误异常
          System.out.println(String.format(
                  "request_id: %d, error_code: %d, error_message: %s",
                  e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
      }
      
      return response;
		
	}

	@Override
	public PushBroadcastMessageResponse pushBroadcastMessage(String apiKey, String secretKey,
			String message) {
		 // 1. 设置developer平台的ApiKey/SecretKey
      ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

      // 2. 创建BaiduChannelClient对象实例
      BaiduChannelClient channelClient = new BaiduChannelClient(pair);

      // 3. 若要了解交互细节，请注册YunLogHandler类
      channelClient.setChannelLogHandler(new YunLogHandler() {
          @Override
          public void onHandle(YunLogEvent event) {
              //System.out.println(event.getMessage());
          }
      });
      
      PushBroadcastMessageResponse response = null;
      try {

          // 4. 创建请求类对象
          PushBroadcastMessageRequest request = new PushBroadcastMessageRequest();
          request.setMessageType(0);
          request.setDeviceType(3);
          request.setMessage(message);

          // 5. 调用pushMessage接口
          response = channelClient
                  .pushBroadcastMessage(request);
          if (response.getSuccessAmount() == 1) {
              // TODO
          }

      } catch (ChannelClientException e) {
          // 处理客户端错误异常
          e.printStackTrace();
      } catch (ChannelServerException e) {
          // 处理服务端错误异常
          e.printStackTrace();;
      }
		
      return response;
	}

	@Override
	public boolean bindVerify(String apiKey, String secretKey,
			Long channelId,String userId) {
		// 1. 设置developer平台的ApiKey/SecretKey
      ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

      // 2. 创建BaiduChannelClient对象实例
      BaiduChannelClient channelClient = new BaiduChannelClient(pair);

      // 3. 若要了解交互细节，请注册YunLogHandler类
      channelClient.setChannelLogHandler(new YunLogHandler() {
          @Override
          public void onHandle(YunLogEvent event) {
              //System.out.println(event.getMessage());
          }
      });
      boolean isBind = false;
      try {

          // 4. 创建请求类对象
          VerifyBindRequest request = new VerifyBindRequest();
          request.setChannelId(channelId);
          request.setUserId(userId);

          // 5. 调用 verifyBind 接口
          channelClient.verifyBind(request);
          isBind = true;
          
      } catch (ChannelClientException e) {
    	  isBind = false;
          // 处理客户端错误异常
          e.printStackTrace();
      } catch (ChannelServerException e) {
    	  isBind = false;
          // 处理服务端错误异常
          e.printStackTrace();
      }
		
      return isBind;
	}

	@Override
	public List<ChannelMessage> fetchMessage(String apiKey, String secretKey,
			String userId) {
	  
	  // 1. 设置developer平台的ApiKey/SecretKey
      ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

      // 2. 创建BaiduChannelClient对象实例
      BaiduChannelClient channelClient = new BaiduChannelClient(pair);

      // 3. 若要了解交互细节，请注册YunLogHandler类
      channelClient.setChannelLogHandler(new YunLogHandler() {
          @Override
          public void onHandle(YunLogEvent event) {
             // System.out.println(event.getMessage());
          }
      });
      List<ChannelMessage> messages = null;
      try {

          // 4. 创建请求类对象
          FetchMessageRequest request = new FetchMessageRequest();
          request.setUserId(userId);

          // 5. 调用 fetchMessage 接口
          FetchMessageResponse resp = channelClient.fetchMessage(request);
          messages = resp.getMessages();

      } catch (ChannelClientException e) {
          // 处理客户端错误异常
          e.printStackTrace();
      } catch (ChannelServerException e) {
          // 处理服务端错误异常
          e.printStackTrace();
      }
      
      return messages;
		
	}

	@Override
	public boolean setTag(String apiKey, String secretKey,
			String tag,String userId) {
		
	  // 1. 设置developer平台的ApiKey/SecretKey
      ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

      // 2. 创建BaiduChannelClient对象实例
      BaiduChannelClient channelClient = new BaiduChannelClient(pair);

      // 3. 若要了解交互细节，请注册YunLogHandler类
      channelClient.setChannelLogHandler(new YunLogHandler() {
          @Override
          public void onHandle(YunLogEvent event) {
              //System.out.println(event.getMessage());
          }
      });
      
      boolean isSuccess = true;

      try {

          // 4. 创建请求类对象
      	
      	SetTagRequest request = new SetTagRequest();
      	request.setTag(tag);
        request.setUserId(userId);

          // 5. 调用 setTag 接口
        channelClient.setTag(request);
        
      } catch (ChannelClientException e) {
          // 处理客户端错误异常
          e.printStackTrace();
          isSuccess = false;
      } catch (ChannelServerException e) {
          // 处理服务端错误异常
          e.printStackTrace();
          isSuccess = false;
      }
      
      return isSuccess;
		
	}
	
	@Override
	public boolean deleteTag(String apiKey, String secretKey,
			String tag,String userId) {
		
	  // 1. 设置developer平台的ApiKey/SecretKey
      ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

      // 2. 创建BaiduChannelClient对象实例
      BaiduChannelClient channelClient = new BaiduChannelClient(pair);

      // 3. 若要了解交互细节，请注册YunLogHandler类
      channelClient.setChannelLogHandler(new YunLogHandler() {
          @Override
          public void onHandle(YunLogEvent event) {
              //System.out.println(event.getMessage());
          }
      });
      
      boolean isSuccess = true;

      try {

          // 4. 创建请求类对象
      	
      	DeleteTagRequest request = new DeleteTagRequest();
      	request.setTag(tag);
        request.setUserId(userId);

          // 5. 调用 deleteTag 接口
        channelClient.deleteTag(request);
        
      } catch (ChannelClientException e) {
          // 处理客户端错误异常
          e.printStackTrace();
          isSuccess = false;
      } catch (ChannelServerException e) {
          // 处理服务端错误异常
          e.printStackTrace();
          isSuccess = false;
      }
      
      return isSuccess;
		
	}

	@Override
	public BaiduChannelClient initIosCert(String apiKey, String secretKey,
			String name,String description,String devCert,String releaseCert) {
	
	  // 1. 设置developer平台的ApiKey/SecretKey
      ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

      // 2. 创建BaiduChannelClient对象实例
      BaiduChannelClient channelClient = new BaiduChannelClient(pair);

      // 3. 若要了解交互细节，请注册YunLogHandler类
      channelClient.setChannelLogHandler(new YunLogHandler() {
          @Override
          public void onHandle(YunLogEvent event) {
              //System.out.println(event.getMessage());
          }
      });

      try {

          // 4. 创建请求类对象
          InitAppIoscertRequest request = new InitAppIoscertRequest();
          request.setName(name);
          request.setDescription(description);

          request.setDevCert(devCert);
          request.setReleaseCert(releaseCert);

          // 5. 调用 initAppIoscert 接口
          channelClient.initAppIoscert(request);

      } catch (ChannelClientException e) {
          e.printStackTrace();
          // 处理客户端错误异常
      } catch (ChannelServerException e) {
          // 处理服务端错误异常
          System.out.println(String.format(
                  "request_id: %d, error_code: %d, error_message: %s",
                  e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
      }
      
      return channelClient;
		
	}

	@Override
	public String generatorTag(String apiKey, String secretKey,
			 String prefixTag) throws PushClientException, PushServerException {
		
		String generatorTag = null;
		// 1. get apiKey and secretKey 
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
		String tagName = prefixTag.concat(UUIDGenerator.getUUID());
		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			CreateTagRequest request = new CreateTagRequest().addTagName(
					tagName).addDeviceType(3);
			// 5. http request
			CreateTagResponse response = pushClient.createTag(request);
			
			generatorTag = response.getTagName();
			
			System.out.println(String.format("tagName: %s, result: %d",
					response.getTagName(), response.getResult()));
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
		
		return generatorTag;
	}
	
	@Override
	public String generatorTag(String apiKey, String secretKey,
			 String prefixTag, int deviceType) throws PushClientException, PushServerException {
		
		String generatorTag = null;
		// 1. get apiKey and secretKey 
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
		String tagName = prefixTag.concat(UUIDGenerator.getUUID());
		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			CreateTagRequest request = new CreateTagRequest().addTagName(
					tagName).addDeviceType(deviceType);
			// 5. http request
			CreateTagResponse response = pushClient.createTag(request);
			
			generatorTag = response.getTagName();
			
			System.out.println(String.format("tagName: %s, result: %d",
					response.getTagName(), response.getResult()));
			logger.info(String.format("tagName: %s, result: %d",
					response.getTagName(), response.getResult()));
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
		
		return generatorTag;
	}

	@Override
	public void addDevicesToTag(String apiKey, String secretKey, String tagName, String[] channelIds) throws PushClientException, PushServerException {
		
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacted information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			AddDevicesToTagRequest request = new AddDevicesToTagRequest()
					.addTagName(tagName).addChannelIds(channelIds)
					.addDeviceType(3);
		
			// 5. http request
			AddDevicesToTagResponse response = pushClient
					.addDevicesToTag(request);
			// Http请求结果解析打印
			if (null != response) {
				StringBuilder strBuilder = new StringBuilder();
				strBuilder.append("devicesInTag：{");
				List<?> devicesInfo = response.getDevicesInfoAfterAdded();
				for (int i = 0; i < devicesInfo.size(); i++) {
					Object object = devicesInfo.get(i);
					if (i != 0) {
						strBuilder.append(",");
					}
					if (object instanceof DeviceInfo) {
						DeviceInfo deviceInfo = (DeviceInfo) object;
						strBuilder.append("{channelId:"
								+ deviceInfo.getChannelId() + ",result:"
								+ deviceInfo.getResult() + "}");
					}
				}
				strBuilder.append("}");
				System.out.println(strBuilder.toString());
			}
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
		
	}
	
	@Override
	public void addDevicesToTag(String apiKey, String secretKey, String tagName, String[] channelIds, int deviceType) throws PushClientException, PushServerException {
		
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);
		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacted information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});

		try {
			// 4. specify request arguments
			AddDevicesToTagRequest request = new AddDevicesToTagRequest()
					.addTagName(tagName).addChannelIds(channelIds)
					.addDeviceType(deviceType);
		
			// 5. http request
			AddDevicesToTagResponse response = pushClient
					.addDevicesToTag(request);
			// Http请求结果解析打印
			if (null != response) {
				StringBuilder strBuilder = new StringBuilder();
				strBuilder.append("devicesInTag：{");
				List<?> devicesInfo = response.getDevicesInfoAfterAdded();
				for (int i = 0; i < devicesInfo.size(); i++) {
					Object object = devicesInfo.get(i);
					if (i != 0) {
						strBuilder.append(",");
					}
					if (object instanceof DeviceInfo) {
						DeviceInfo deviceInfo = (DeviceInfo) object;
						strBuilder.append("{channelId:"
								+ deviceInfo.getChannelId() + ",result:"
								+ deviceInfo.getResult() + "}");
					}
				}
				strBuilder.append("}");
				System.out.println(strBuilder.toString());
				logger.info(strBuilder.toString());
			}
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
		
	}
	
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
	public PushMsgToAllResponse pushMsgToAll(String apiKey, String secretKey, String message, int timing) throws PushClientException, PushServerException{
		
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});
		
		PushMsgToAllResponse response = null;
		
		try {
			// 4. specify request arguments
			PushMsgToAllRequest request = null;
			if(timing == 0){ // 立即发送
				request = new PushMsgToAllRequest()
				.addMsgExpires(new Integer(3600)).addMessageType(1)
				.addMessage(message) 
				.addDeviceType(3);
			} else { // 定时发送
				request = new PushMsgToAllRequest()
				.addMsgExpires(new Integer(3600)).addMessageType(1)
				.addMessage(message) //添加透传消息
				.addSendTime(System.currentTimeMillis() / 1000 + timing) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
				.addDeviceType(3);
			}
			
			// 5. http request
			response = pushClient.pushMsgToAll(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
		
		return response;
	}
	
	/**
	 * 向所有用户推送信息
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
	public PushMsgToAllResponse pushMsgToAll(String apiKey, String secretKey, String message, int timing, int deviceType, int deployStatus) throws PushClientException, PushServerException{
		
		PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

		// 2. build a BaidupushClient object to access released interfaces
		BaiduPushClient pushClient = new BaiduPushClient(pair,
				BaiduPushConstants.CHANNEL_REST_URL);

		// 3. register a YunLogHandler to get detail interacting information
		// in this request.
		pushClient.setChannelLogHandler(new YunLogHandler() {
			@Override
			public void onHandle(YunLogEvent event) {
				System.out.println(event.getMessage());
			}
		});
		
		PushMsgToAllResponse response = null;
		
		try {
			// 4. specify request arguments
			PushMsgToAllRequest request = null;
			if(timing == 0){ // 立即发送
				
				if(deviceType == 3){ // Android
					
					request = new PushMsgToAllRequest()
						.addMsgExpires(new Integer(3600)).addMessageType(1)
						.addMessage(message) 
						.addDeviceType(deviceType);
				} else if(deviceType == 4){ // IOS
					 
					request = new PushMsgToAllRequest()
						.addMsgExpires(new Integer(3600)).addMessageType(1)
						.addMessage(message) 
						.addDeviceType(deviceType)
						.addDepolyStatus(deployStatus);// 仅IOS应用推送时使用，默认值为null，取值如下：1：开发状态 2：生产状态
				}
				
			} else { // 定时发送
				
				if(deviceType == 3){
					
					request = new PushMsgToAllRequest()
						.addMsgExpires(new Integer(3600)).addMessageType(1)
						.addMessage(message) //添加透传消息
						.addSendTime(System.currentTimeMillis() / 1000 + timing) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
						.addDeviceType(deviceType);
				} else if(deviceType == 4){
					
					request = new PushMsgToAllRequest()
						.addMsgExpires(new Integer(3600)).addMessageType(1)
						.addMessage(message) //添加透传消息
						.addSendTime(System.currentTimeMillis() / 1000 + timing) // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例2分钟后推送
						.addDeviceType(deviceType)
						.addDepolyStatus(deployStatus); // 仅IOS应用推送时使用，默认值为null，取值如下：1：开发状态 2：生产状态
				}
			}
			
			// 5. http request
			response = pushClient.pushMsgToAll(request);
			// Http请求结果解析打印
			System.out.println("msgId: " + response.getMsgId() + ",sendTime: "
					+ response.getSendTime() + ",timerId: "
					+ response.getTimerId());
		} catch (PushClientException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				e.printStackTrace();
			}
		} catch (PushServerException e) {
			if (BaiduPushConstants.ERROROPTTYPE) {
				throw e;
			} else {
				System.out.println(String.format(
						"requestId: %d, errorCode: %d, errorMessage: %s",
						e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
			}
		}
		
		return response;
	}

}
