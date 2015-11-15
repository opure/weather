package com.vanvalt.util.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	
	/** 状态：1,表示布尔值 TRUE、YES. */
	public final static int		STATE_YES								= 1;
	/** 状态：0,表示布尔值 FALSE、NO. */
	public final static int		STATE_NO								= 0;
	
	/** |是一个文件在服务器存储的文件和本地文件名称的分隔符. */
	public final static String	SPLIT_FILE_NAME							= "|";
	/** :是两个文件的分隔符. */
	public final static String	SPLIT_FILE								= ":";
	/** 空格' '或逗号','是两个标签的分隔符. */
	public final static String	SPLIT_TAG								= " ,，";
	
	/** 排序，升序. */
	public final static String	SQL_ORDER_BY_ASC						= "1";
	/** 排序，降序. */
	public final static String	SQL_ORDER_BY_DESC						= "2";
	/** 起始索引 */
	public final static int 	LIST_START_INDEX						= 0;
	
	/** 教师 */
	public final static String TEACHER									= "1";
	/** 家长 */
	public final static String PARENT									= "2";
	
	/** 未读 */
	public final static String UNREAD									= "0";
	/** 已读 */
	public final static String READ										= "1";
	/** 群组 */
	public final static String GROUP									= "Y";
	/** 非群组 */
	public final static String UNGROUP									= "N";
	
	/** 正常标识 */
	public final static String NORMAL									= "0";
	/** 删除标识 */
	public final static String DELETE									= "1";
	
	/** 每页数量*/
	public final static int PAGE_SIZE									= 10;
	/** 默认密码 */
	public final static String DEFAULT_PASSWORD							= "111111";
	/** 通讯录类型：教师 */
	public final static String CONTACT_TYPE_TEACHER						= "1";
	/** 通讯录类型：家长 */
	public final static String CONTACT_TYPE_PARENT 						= "2";
	/** 通讯录类型：个人 */
	public final static String CONTACT_TYPE_PERSON						= "3";
	/** 可见 */
	public final static String VISIBLE									= "Y";
	/** 不可见 */
	public final static String INVISIBLE								= "N";
	
	/** 空格*/
	public final static String STRING_SPACE								= " ";
	/** 横线*/
	public final static String STRING_LINE								= "-";
	/** 冒号*/
	public final static String STRING_COLON								= ":";
	/** 空白*/
	public final static String STRING_BLANK								= "";
	
	// 短信息验证码校验
	public static final Map<Integer,Object> SMS_VERIFY_CODE_STATUS_MAP = new HashMap<Integer,Object>();
	
	static {
		// 源自 http://wiki.mob.com/smssdk-service-verify/
		SMS_VERIFY_CODE_STATUS_MAP.put(200, "发送短信成功");
		SMS_VERIFY_CODE_STATUS_MAP.put(512, "服务器拒绝访问，或者拒绝操作");
		SMS_VERIFY_CODE_STATUS_MAP.put(513, "求AppKey不存在或被禁用");
		SMS_VERIFY_CODE_STATUS_MAP.put(514, "权限不足");
		SMS_VERIFY_CODE_STATUS_MAP.put(515, "服务器内部错误");
		SMS_VERIFY_CODE_STATUS_MAP.put(517, "缺少必要的请求参数");
		SMS_VERIFY_CODE_STATUS_MAP.put(518, "请求中用户的手机号格式不正确（包括手机的区号）");
		SMS_VERIFY_CODE_STATUS_MAP.put(519, "请求发送验证码次数超出限制");
		SMS_VERIFY_CODE_STATUS_MAP.put(520, "无效验证码");
		SMS_VERIFY_CODE_STATUS_MAP.put(526, "余额不足");
	}
	
	// 不同平台对应的AppKey
	public static final Map<String,Object> APP_KEY_MAP = new HashMap<String,Object>();
	
	static {
		// 源自 http://dashboard.mob.com/Sms/#/
		//APP_KEY_MAP.put("1", "6048822345e1"); // Android
		//APP_KEY_MAP.put("2", "607267eec434"); // IOS
		
		APP_KEY_MAP.put("1", "7c175d781ead"); // Android
		APP_KEY_MAP.put("2", "86da1f8e1200"); // IOS
	}
	
	
}
