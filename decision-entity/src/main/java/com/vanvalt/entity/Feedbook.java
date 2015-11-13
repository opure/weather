package com.vanvalt.entity;

import java.io.Serializable;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 上午10:05:29 
 * 
 */
public class Feedbook implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8030474731054348353L;
	
	private int id;
	private String filePath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
