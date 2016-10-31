package com.trs.rms.base.exception;

public class UserFriendlyException extends RuntimeException {

	private static final long serialVersionUID = 2962018330974678847L;

	public UserFriendlyException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserFriendlyException(String message) {
		super(message);
	}

}
