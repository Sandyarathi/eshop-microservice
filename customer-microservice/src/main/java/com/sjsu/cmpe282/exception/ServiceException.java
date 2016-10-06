package com.sjsu.cmpe282.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Exception in CustomerService!")
public class ServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7818568339305130997L;

	public ServiceException(String msg) {
		super(msg);
	}

}
