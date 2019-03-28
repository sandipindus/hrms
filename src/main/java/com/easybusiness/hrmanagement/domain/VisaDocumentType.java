package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

/**
 * @author sandip
 *
 */

public class VisaDocumentType implements Serializable {

	private static final long serialVersionUID = 1L;

    private String docType;

    private String encodedDoc;
    
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getEncodedDoc() {
		return encodedDoc;
	}

	public void setEncodedDoc(String encodedDoc) {
		this.encodedDoc = encodedDoc;
	}
}

