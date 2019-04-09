package com.easybusiness.hrmanagement.domain;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public class VisaDownloadFile {
	private ResponseEntity<Resource> blob;
	
	public VisaDownloadFile(ResponseEntity<Resource> blob) {
		this.blob = blob;
	}

	public ResponseEntity<Resource> getBlob() {
		return blob;
	}

	public void setBlob(ResponseEntity<Resource> blob) {
		this.blob = blob;
	}
}
