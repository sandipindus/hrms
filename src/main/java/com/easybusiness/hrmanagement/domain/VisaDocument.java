package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sandip
 *
 */
@Entity
@Table(name = "VISADOCUMENT")
public class VisaDocument extends DocumentType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id()
    @Column(name = "DOCNAME")
    private String docName;
	
    @Column(name = "VISAID")
    private Long visaID;
    
    @Column(name = "DOCID")
    private int docId;

	public Long getVisaID() {
		return visaID;
	}

	public void setVisaID(Long visaID) {
		this.visaID = visaID;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}
	
}

