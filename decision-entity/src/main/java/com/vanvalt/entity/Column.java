package com.vanvalt.entity;

import java.io.Serializable;
import java.util.Date;

/** 
 * @author xy.li@vanvalt.com 
 * @version Created By：2015年11月12日 上午9:57:34 
 * 
 */
public class Column implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2789245722881416885L;
	
	private int id;
	private String name;
	private int appId;
	private int parentId;
	private String dataUrl;
	private int type;
	private String module;
	private int orderBy;
	private int addTime;
	private int editTime;
	private int adminId;
	private String listDataUrl;
	private String icon;
	// 首次显示列表
	private int firstShowList;
	private int typeProperty;
	// 子栏目的显示方式
	private int sonColumn;
	// 栏目更新状态
	private int updateStatus;
	// 栏目停止显示更新时间
	private Date updateTime;
	// 栏目样式模板
	private int columnStye;
	private String color;
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
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getDataUrl() {
		return dataUrl;
	}
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public int getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	public int getAddTime() {
		return addTime;
	}
	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}
	public int getEditTime() {
		return editTime;
	}
	public void setEditTime(int editTime) {
		this.editTime = editTime;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getListDataUrl() {
		return listDataUrl;
	}
	public void setListDataUrl(String listDataUrl) {
		this.listDataUrl = listDataUrl;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getFirstShowList() {
		return firstShowList;
	}
	public void setFirstShowList(int firstShowList) {
		this.firstShowList = firstShowList;
	}
	public int getTypeProperty() {
		return typeProperty;
	}
	public void setTypeProperty(int typeProperty) {
		this.typeProperty = typeProperty;
	}
	public int getSonColumn() {
		return sonColumn;
	}
	public void setSonColumn(int sonColumn) {
		this.sonColumn = sonColumn;
	}
	public int getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(int updateStatus) {
		this.updateStatus = updateStatus;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getColumnStye() {
		return columnStye;
	}
	public void setColumnStye(int columnStye) {
		this.columnStye = columnStye;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	

}
