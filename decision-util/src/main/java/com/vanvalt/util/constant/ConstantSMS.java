package com.vanvalt.util.constant;

public class ConstantSMS {
	//////中国短信网
	/** 操作成功. */
	public final static int SMS_RESULT_SUCCEED							= 1;	
	/** 操作成功. */
	public final static int CHINA_SMS_RESULT_SUCCEED					= SMS_RESULT_SUCCEED;	
	/** 帐户格式不正确(正确的格式为:员工编号@企业编号). */
	public final static int CHINA_SMS_RESULT_ACCOUNT_ERROR 				= 0;
	/** -1	服务器拒绝(速度过快、限时或绑定IP不对等)如遇速度过快可延时再发 */
	public final static int CHINA_SMS_RESULT_SERVER_REJECTED 			= -1;
	/** -2	密钥不正确 */
	public final static int CHINA_SMS_RESULT_KEY_ERROR 					= -2;
	/** -3	密钥已锁定 */
	public final static int CHINA_SMS_RESULT_KEY_LOCKED 				= -3;
	/** -4	参数不正确(内容和号码不能为空，手机号码数过多，发送时间错误等) */
	public final static int CHINA_SMS_RESULT_PARAMETER_ERROR 			= -4;
	/** -5	无此帐户 */
	public final static int CHINA_SMS_RESULT_NO_SUCH_ACCOUNT 			= -5;
	/** -6	帐户已锁定或已过期 */
	public final static int CHINA_SMS_RESULT_ACCOUNT_LOCKED 			= -6;
	/** -7	帐户未开启接口发送 */
	public final static int CHINA_SMS_RESULT_ACCOUNT_SEND_UNOPENED		= -7;
	/** -8	不可使用该通道组 */
	public final static int CHINA_SMS_RESULT_CHANNEL_ERROR 				= -8;
	/** -9	帐户余额不足 */
	public final static int CHINA_SMS_RESULT_ACCOUNT_LACK_OF_BALANCE	= -9;
	/** -10	内部错误 */
	public final static int CHINA_SMS_RESULT_SERVR_ERROR 				= -10;
	/** -11	扣费失败 */
	public final static int CHINA_SMS_RESULT_CHARGEBACK_FAILURE			= -11;
	
	////////建周短信
	/**余额不足                                 */
	public final static int JIANZHOU_SMS_RESULT_ACCOUNT_LACK_OF_BALANCE				= -1	;
	/**帐号或密码错误                           */
	public final static int JIANZHOU_SMS_RESULT_ACCOUNT_OR_PASSWORD_ERROR			= -2	;
	/**连接服务商失败                           */
	public final static int JIANZHOU_SMS_RESULT_CONNECT_SERVICE_PROVIDER_FAILURE	= -3	;
	/**超时                                     */
	public final static int JIANZHOU_SMS_RESULT_TIMEOUT								= -4	;
	/**其他错误，一般为网络问题，IP受限等       */
	public final static int JIANZHOU_SMS_RESULT_OTHER								= -5	;
	/**短信内容为空                             */
	public final static int JIANZHOU_SMS_RESULT_SMS_CONTENT_EMPTY					= -6	;
	/**目标号码为空                             */
	public final static int JIANZHOU_SMS_RESULT_TARGET_PHONE_EMPTY					= -7	;
	/**用户通道设置不对，需要设置三个通道       */
	public final static int JIANZHOU_SMS_RESULT_CHANNEL_ERROR						= -8	;
	/**捕获未知异常                             */
	public final static int JIANZHOU_SMS_RESULT_UNKNOWN_EXCEPTION 					= -9	;
	/**超过最大定时时间限制                     */
	public final static int JIANZHOU_SMS_RESULT_MAX_TIME_LIMIT 						= -10	;
	/**目标号码在黑名单里                       */
	public final static int JIANZHOU_SMS_RESULT_TARGET_PHONE_IN_BLACKLIST			= -11	;
	/**消息内容包含禁用词语                     */
	public final static int JIANZHOU_SMS_RESULT_MESSAGE_CONTAINS_FORBIDDEN_WORDS	= -12	;
	/**没有权限使用该网关                       */
	public final static int JIANZHOU_SMS_RESULT_NO_PERMISSION_USE_GATEWAY			= -13	;
	/**找不到对应的Channel ID                   */
	public final static int JIANZHOU_SMS_RESULT_NOT_FIND_CHANNEL_ID					= -14	;
	/**没有提交权限，客户端帐号无法使用接口提交 */
	public final static int JIANZHOU_SMS_RESULT_NOT_SUBMIT_PERMISSION				= -17	;
	/**提交参数名称不正确或确实参数             */
	public final static int JIANZHOU_SMS_RESULT_PARAMETER_ERROR						= -18	;
	/**必须为POST提交                           */
	public final static int JIANZHOU_SMS_RESULT_MUST_POST							= -19	;
	/**超速提交(一般为每秒一次提交)             */
	public final static int JIANZHOU_SMS_RESULT_SPEEDING_SUBMITTED					= -20	;
	 


}
