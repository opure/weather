package com.vanvalt.entity;

import java.io.Serializable;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 上午10:19:16 
 * 
 */
public class Theme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4254903034851462050L;
	
	private int id;
	private int templateId;
	private String picture;
	private String name;
	private String dirName;
	private int addTime;
	private int adminId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	public int getAddTime() {
		return addTime;
	}
	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	

}
