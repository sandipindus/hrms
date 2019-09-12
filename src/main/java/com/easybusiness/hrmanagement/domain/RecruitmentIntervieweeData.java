package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "RECRUITMENT_INTERVIEWEE_DATA")
@DynamicUpdate
public class RecruitmentIntervieweeData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "RECRUITMENT_INTERVIEWEE_ID")
    private String recruitmentIntervieweeID;
    
	@Column(name = "JD_ID")
    private String jdID;
	
    @Column(name = "INTERVIEWEE_NAME")
    private String intervieweeName; 
    
    @Column(name = "YEARS_OF_EXPERIENCE")
    private Long yearsOfExperience;
    
    @Column(name = "INSTITUTE_NAME")
    private String instituteName; 
    
    @Column(name = "DEGREE")
    private String degree;
 
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PHONE")
    private String phone;
    
    @Column(name = "IDENTIFICATION_NUMBER")
    private String identificationNumber;
    
    @Column(name = "REMARKS")
    private String remarks;
    
    @Column(name = "RESUME_NAME")
    private String resumeName;
    
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;
    
    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;
    
    @Column(name = "DIRECTAPPROVER")
    private Long directApprover;
    
    @Column(name = "PENDING_WITH")
    private Long pendingWith;
        
	@Column(name = "REQUEST_STATUS")
    private Long requestStatus;
	
	@Column(name = "IS_EXPIRED")
	private int isExpired;
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "CREATED_BY", referencedColumnName = "EMPLOYEE_NUM", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private EmployeeMaster createdByDetails;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MODIFIED_BY", referencedColumnName = "EMPLOYEE_NUM", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private EmployeeMaster modifiedByDetails;
    
    public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getPendingWith() {
		return pendingWith;
	}

	public void setPendingWith(Long pendingWith) {
		this.pendingWith = pendingWith;
	}

	public Long getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(Long requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Long getDirectApprover() {
		return directApprover;
	}

	public void setDirectApprover(Long directApprover) {
		this.directApprover = directApprover;
	}
	
	public EmployeeMaster getCreatedByDetails() {
		return createdByDetails;
	}

	public void setCreatedByDetails(EmployeeMaster createdByDetails) {
		this.createdByDetails = createdByDetails;
	}

	public EmployeeMaster getModifiedByDetails() {
		return modifiedByDetails;
	}

	public void setModifiedByDetails(EmployeeMaster modifiedByDetails) {
		this.modifiedByDetails = modifiedByDetails;
	}

	public Long getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Long yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(int isExpired) {
		this.isExpired = isExpired;
	}

	public String getRecruitmentIntervieweeID() {
		return recruitmentIntervieweeID;
	}

	public void setRecruitmentIntervieweeID(String recruitmentIntervieweeID) {
		this.recruitmentIntervieweeID = recruitmentIntervieweeID;
	}

	public String getJdID() {
		return jdID;
	}

	public void setJdID(String jdID) {
		this.jdID = jdID;
	}

	public String getIntervieweeName() {
		return intervieweeName;
	}

	public void setIntervieweeName(String intervieweeName) {
		this.intervieweeName = intervieweeName;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
}