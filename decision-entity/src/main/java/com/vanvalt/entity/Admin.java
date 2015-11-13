package com.vanvalt.entity;

import java.io.Serializable;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 上午9:28:54 
 * 
 */
public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7089675992667509970L;
	
	private int id;
	private String name;
	private String password;
	private int addtime;
	private int logintime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAddtime() {
		return addtime;
	}
	public void setAddtime(int addtime) {
		this.addtime = addtime;
	}
	public int getLogintime() {
		return logintime;
	}
	public void setLogintime(int logintime) {
		this.logintime = logintime;
	}
	
	
}
