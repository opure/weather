package com.vanvalt.entity;

import java.io.Serializable;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 上午10:11:28 
 * 
 */
public class ProductCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -417627961039032969L;
	
	private int id;
	private String code;
	private String name;
	private String sourceDir;
	private String descDir;
	private int isPuch;
	private String titleColor;
	private String timeFormat;
	private int titleLine;
	private String titleProc;
	private String httpPre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSourceDir() {
		return sourceDir;
	}
	public void setSourceDir(String sourceDir) {
		this.sourceDir = sourceDir;
	}
	public String getDescDir() {
		return descDir;
	}
	public void setDescDir(String descDir) {
		this.descDir = descDir;
	}
	public int getIsPuch() {
		return isPuch;
	}
	public void setIsPuch(int isPuch) {
		this.isPuch = isPuch;
	}
	public String getTitleColor() {
		return titleColor;
	}
	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}
	public String getTimeFormat() {
		return timeFormat;
	}
	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}
	public int getTitleLine() {
		return titleLine;
	}
	public void setTitleLine(int titleLine) {
		this.titleLine = titleLine;
	}
	public String getTitleProc() {
		return titleProc;
	}
	public void setTitleProc(String titleProc) {
		this.titleProc = titleProc;
	}
	public String getHttpPre() {
		return httpPre;
	}
	public void setHttpPre(String httpPre) {
		this.httpPre = httpPre;
	}
	
	
}
