package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INTERVIEWEE_RESUME")
public class Resume extends VisaDocumentType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//IDENTITY takes hibernate auto increment feature
	@Id()
	@Column(name = "RESUME_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resumeId;
	
    @Column(name = "RESUME_NAME")
    private String resumeName;

	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
}

