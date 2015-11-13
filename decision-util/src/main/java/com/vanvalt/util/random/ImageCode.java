package com.vanvalt.util.random;

import java.io.ByteArrayInputStream;
import java.util.Map.Entry;

public class ImageCode implements Entry<String, ByteArrayInputStream> {
	private String					key;
	private ByteArrayInputStream	value;

	public ImageCode(String key, ByteArrayInputStream byteArrayInputStream) {
		this.key = key;
		this.value = byteArrayInputStream;
	}

	public String getKey() {
		return key;
	}

	public ByteArrayInputStream getValue() {
		return value;
	}

	public ByteArrayInputStream setValue(ByteArrayInputStream value) {
		this.value = value;
		return value;
	}

}
