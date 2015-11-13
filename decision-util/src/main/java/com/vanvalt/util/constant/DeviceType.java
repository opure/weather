package com.vanvalt.util.constant;

import com.vanvalt.util.exception.InvalidParameterException;

public enum DeviceType {

	all, android, ios;

	public static DeviceType getDeviceType(String type) {
		if (DeviceType.android.name().equalsIgnoreCase(type)) {
			return DeviceType.android;
		}
		else if (DeviceType.ios.name().equalsIgnoreCase(type)) {
			return DeviceType.ios;
		}

		throw new InvalidParameterException("无效的设备操作系统类型！");
	}
}
