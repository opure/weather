package com.vanvalt.web.command.impl;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.vanvalt.web.command.ICommand;


/**
 * 服务端API响应接口.
 * 
 * @author chenbowang
 * 
 */
public class ResponseCommand implements ICommand {
	/**
	 * 请求标识.
	 */
	String command;
	/**
	 * 标识状态.
	 */
	boolean status;
	/**
	 * 响应结果代码.
	 */
	String code;
	/**
	 * 服务器响应的详情.
	 */
	Object object;

	/**
	 * 
	 */
	public ResponseCommand() {
		super();
	}

	/**
	 * @param command
	 * @throws JSONException
	 */
	public ResponseCommand(String json) throws JSONException {
		super();
		JSONObject jsonObject = new JSONObject(json);
		this.command = jsonObject.getString("command");
		this.status = jsonObject.getBoolean("status");
		this.code = jsonObject.getString("code");
		this.object = jsonObject.get("object");
	}

	/**
	 * @param command
	 * @param status
	 * @param code
	 * @param object
	 */
	public ResponseCommand(String command, boolean status, String code,
			Object object) {
		super();
		this.command = command;
		this.status = status;
		this.code = code;
		this.object = object;
	}

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toJson() {

		StringBuilder builder = new StringBuilder();
		builder.append("{\"command\":\"");
		builder.append(command);
		builder.append("\", \"status\":\"");
		builder.append(status);
		builder.append("\", \"code\":\"");
		builder.append(code);
		builder.append("\", \"object\":");
		builder.append((null == object || "" == object) ?"{}":object);
		builder.append("}  ");
		return builder.toString();

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseCommand [command=");
		builder.append(command);
		builder.append(", status=");
		builder.append(status);
		builder.append(", code=");
		builder.append(code);
		builder.append(", object=");
		builder.append(object);
		builder.append("]");
		return builder.toString();
	}

	
}
