package com.andreguitti.services.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -3390531619428744994L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
