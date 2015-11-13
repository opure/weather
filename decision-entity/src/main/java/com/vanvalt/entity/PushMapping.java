package com.vanvalt.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 百度推送绑定
 */
public class PushMapping implements Serializable {

	
	private static final long serialVersionUID = 3686883105344358983L;

	private int id;
	// 系统用户ID
	private String userId;
	// 百度用户ID
	private String bdUserId;
	// 通道ID
	private String channelId;
	// 设备类型
	private String deviceType;
	
	private Date createTime;
	private Date updateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getBdUserId() {
		return bdUserId;
	}
	public void setBdUserId(String bdUserId) {
		this.bdUserId = bdUserId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	
}
