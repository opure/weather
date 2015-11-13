package com.vanvalt.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 上午10:07:31 
 * 
 */
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8371737275958437255L;
	
	private String id;
	private String sourceFile;
	private String title;
	private int isPush;
	private Date createTime;
	private int conStatus;
	private int categoryId;
	private Date publicTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIsPush() {
		return isPush;
	}
	public void setIsPush(int isPush) {
		this.isPush = isPush;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getConStatus() {
		return conStatus;
	}
	public void setConStatus(int conStatus) {
		this.conStatus = conStatus;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Date getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}
	

}
