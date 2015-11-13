package com.vanvalt.web.command.util;

import org.apache.commons.io.monitor.FileAlterationListener;

/**
 * 命令码.
 * @author Xiaoyang
 *
 */
public class CommandCode {
	/** 6000 命令参考值. */
	public static final int	DEFAULT_CODE						= 6000;

	/** 用户登录. */
	public static final int	CMD_LOGIN					= DEFAULT_CODE + 1;
	
	/** 修改密码 */
	public static final int CMD_CHANGE_PASSWORD 		= DEFAULT_CODE + 2;
	
	/** 个人中心 */
	public static final int CMD_PERSONAL_CENTER 		= DEFAULT_CODE + 3;
	
	/** 找回密码 */
	public static final int CMD_RETRIEVE_PASSWORD 		= DEFAULT_CODE + 4;
	
	/** 发布信息 */
	public static final int CMD_PUBLISH_MESSAGE 		= DEFAULT_CODE + 5;
	
	/** 信息详情 */
	public static final int CMD_MESSAGE_DETAIL			= DEFAULT_CODE + 6;
	
	/** 阅读反馈 */
	public static final int CMD_READ_FEEDBACK			= DEFAULT_CODE + 7;
	
	/** 信息通知列表 */
	public static final int CMD_MESSAGE_LIST			= DEFAULT_CODE + 8;
	
	/** 已发送信息列表 */
	public static final int CMD_SENT_MESSAGE_LIST		= DEFAULT_CODE + 9;
	
	/** 新增信息模板 */
	public static final int CMD_ADD_MESSAGE_TEMPLATE		= DEFAULT_CODE + 10;
	
	/** 编辑信息模板 */
	public static final int CMD_EDIT_MESSAGE_TEMPLATE		= DEFAULT_CODE + 11;
	
	/** 删除信息模板 */
	public static final int CMD_DELETE_MESSAGE_TEMPLATE		= DEFAULT_CODE + 12;
	
	/** 信息模板列表 */
	public static final int CMD_MESSAGE_TEMPLATE_LIST		= DEFAULT_CODE + 13;
	
	/** 通讯录列表 */
	public static final int CMD_CONTACTS_LIST				= DEFAULT_CODE + 14;
	
	/** 宝贝列表 */
	public static final int CMD_CHILDREN_LIST				= DEFAULT_CODE + 15;
	
	/** 宝贝详情 */
	public static final int CMD_CHILDREN_DETAIL				= DEFAULT_CODE + 16;
	
	/** 学生家长登录 */
	public static final int CMD_STUDENT_LOGIN				= DEFAULT_CODE + 17;
	
	/** 生成令牌 */
	public static final int CMD_TOKEN_GENERATE				= DEFAULT_CODE + 18;
	
	/** 命名空间列表 */
	public static final int CMD_QINIU_BUCKETS_LIST			= DEFAULT_CODE + 19;
	
	/** 文件列表 */
	public static final int CMD_QINIU_FILE_LIST				= DEFAULT_CODE + 20;
	
	/** 信息模板统计 */
	public static final int CMD_MESSAGE_TEMPLATE_COUNT		= DEFAULT_CODE + 21;
	
	/** 百度推送绑定 */
	public static final int CMD_BAIDU_PUSH_MAPPING			= DEFAULT_CODE + 22;
	
	/** 家长版-信息列表 */
	public static final int CMD_MESSAGE_LIST_PARENT			= DEFAULT_CODE + 23;
	
	/** 家长版-信息阅读反馈 */
	public static final int CMD_READ_FEEDBACK_PARENT		= DEFAULT_CODE + 24;
	
	/** 更新头像 */
	public static final int CMD_UPDATE_HEAD_IMAGE			= DEFAULT_CODE + 25;
	
	/** 更新宝贝头像 */
	public static final int CMD_UPDATE_CHILD_HEAD_IMAGE		= DEFAULT_CODE + 26;
	/**获取问卷地址*/
	public static final int CMD_GET_SURVEY                   =DEFAULT_CODE  +27;
	
	
	
}