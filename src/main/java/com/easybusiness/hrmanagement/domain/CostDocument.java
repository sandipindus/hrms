package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

public class CostDocument implements Serializable {

	private static final long serialVersionUID = 1L;

    private String docType;
    private String base64String;

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getBase64String() {
		return base64String;
	}

	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}
    
}

