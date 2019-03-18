package com.easybusiness.hrmanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mainak
 *
 */
@Entity
@Table(name = "VISA_DOCUMENT_MASTER")
public class VisaDocumentMaster implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id()
    @Column(name = "ID")
    private Long id;
	
	@Column(name = "DOCUMENT_TYPE")
    private String documentType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
}
