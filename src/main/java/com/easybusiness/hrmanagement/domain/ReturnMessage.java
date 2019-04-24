package com.easybusiness.hrmanagement.domain;

import java.io.Serializable;

public class ReturnMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public ReturnMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}

