package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISADOCUMENT")
public class Resume extends VisaDocumentType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id()
    @Column(name = "RESUME_NAME")
    private String resumeName;
	
	@Column(name = "RECRUITMENT_INTERVIEWEE_ID")
    private String recruitmentIntervieweeID;

}

