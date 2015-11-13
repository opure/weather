package com.vanvalt.util.exception;

public class InvalidParameterException extends WebException {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3030833216610116489L;

	public InvalidParameterException() {
		super();
	}

	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidParameterException(String message) {
		super(message);
	}

}
