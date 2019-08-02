package com.easybusiness.hrmanagement.domain;

import java.io.Serializable;

public class Base64String implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String base64Data;

	public String getBase64Data() {
		return base64Data;
	}

	public void setBase64Data(String base64Data) {
		this.base64Data = base64Data;
	}
}
