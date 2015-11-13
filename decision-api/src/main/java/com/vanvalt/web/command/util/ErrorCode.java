package com.vanvalt.web.command.util;
/**
 * 错误码.
 * @author chenbowang
 *
 */
public class ErrorCode {

	
	/** 布尔值：真.*/
	public static final boolean ERR_CODE_STATUS_TRUE 							= true;
	/** 布尔值：假。 */
	public static final boolean ERR_CODE_STATUS_FALSE 							= false;
	/** 204 （无内容） 服务器成功处理了请求，但没有返回任何内容。 */
	/** 400 （错误请求） 服务器不理解请求的语法。 */
	public static final String ERR_CODE_UNKNOWN_COMMAND 						= "400";
	/** 401 （未授权） 未授权客户机访问数据。 */
	public static final String ERR_CODE_NOT_AUTHORIZE 							= "401";
	/** 4011 （未授权） 登录失败。 */
	public static final String ERR_CODE_NOT_AUTHORIZE_LOGIN_FAILURE 			= "4011";
	/** 404 （未找到）	未找到资源.*/
	public static final String ERR_CODE_NOT_FOUND 								= "404";
	/** 500 （服务器内部错误） 服务器遇到错误，无法完成请求。 */
	public static final String ERR_CODE_EXCEPTION 								= "500";
	/** 530 数据读写异常. */
	public static final String ERR_CODE_EXCEPTION_IO 							= "530";

	/****************************  拇指校园（家校通）  **************************************/
	
	/** 0000（成功） 服务器已成功处理了请求。 */
	public static final String ERR_CODE_SUCCESS 								= "0000";
	/** 参数为空 */
	public static final String ERR_CODE_PARAMETER_EMPTY 						= "3001";
	/** 数据异常 */
	public static final String ERR_CODE_DATA_EXCEPTION							= "3002";
	/** 无返回结果 */
	public static final String ERR_CODE_NO_DATA 								= "3003";
	/** 账号不存在 */
	public static final String ERR_CODE_ACCOUNT_NOT_EXISTS						= "4001";
	/** 密码错误 */
	public static final String ERR_CODE_INCORRECT_PASSWORD						= "4002";
	/** 旧密码错误 */
	public static final String ERR_CODE_INCORRECT_OLD_PASSWORD					= "4003";
	/** SMS 服务器内部错误 */
	public static final String ERR_CODE_SMS_INTERNAL_SERVER_ERROR 				= "4004";
	/** SMS 短信验证失败 */
	public static final String ERR_CODE_SMS_CODE_VERIFY_FAILED					= "4005";
	/** 账户类型错误 */
	public static final String ERR_CODE_INCORRECT_ACCOUNT_TYPE					= "4006";
		
}
