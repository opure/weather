package com.vanvalt.util.exception;

public class WebException extends RuntimeException {

	private static final long serialVersionUID = 1465191015391787906L;

	public WebException() {
		super();
	}

	public WebException(String message, Throwable cause) {
		super(message, cause);
	}

	public WebException(String message) {
		super(message);
	}

	public WebException(Throwable cause) {
		super(cause);
	}

}
