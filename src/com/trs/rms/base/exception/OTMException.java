package com.trs.rms.base.exception;


public class OTMException extends UserFriendlyException {

	private static final long serialVersionUID = -4228075028371397252L;

	public OTMException(String message) {
		super(message);
	}

	public OTMException(String message, Throwable cause) {
		super(message, cause);
	}

}
