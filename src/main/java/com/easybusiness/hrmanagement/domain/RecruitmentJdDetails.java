package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "RECRUITMENT_JD_DETAILS")
@DynamicUpdate
public class RecruitmentJdDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GenericGenerator(name="id_gen", strategy = "com.easybusiness.hrmanagement.id_generator.RecruitmentJdDetailsIdGenerator")
	@GeneratedValue(generator = "id_gen")
    @Column(name = "JD_ID")
    private String jdID;
    
    @Column(name = "POSITION")
    private String position; 
    
    @Column(name = "NO_OF_VACANCY")
    private Long numberOfVacancy; 
    
    @Column(name = "EDUCATIONAL_CRITERIA")
    private String educationalCriteria; 
    
    @Column(name = "STREAM")
    private String stream; 
    
    @Column(name = "EXPERIENCE_IN")
    private String experienceIn; 
    
    @Column(name = "YEARS_OF_EXPERIENCE")
    private Long yearsOfExperience; 
    
    @Column(name = "LOCATION")
    private String location; 
    
    @Column(name = "JOB_DETAILS")
    private String jobDetails; 
    
    @Column(name = "SALARY")
    private Long salary; 
    
    @Column(name = "SEVERITY")
    private String severity; 
    
    @Column(name = "TENTATIVE_DATE_OF_ONBOARDING")
    private Date tentativeDateOfOnboarding;
    
    @Column(name = "CERTIFICATIONS")
    private String certifications;
    
    @Column(name = "REMARKS")
    private String remarks;
    
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

	public String getJdID() {
		return jdID;
	}

	public void setJdID(String jdID) {
		this.jdID = jdID;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getNumberOfVacancy() {
		return numberOfVacancy;
	}

	public void setNumberOfVacancy(Long numberOfVacancy) {
		this.numberOfVacancy = numberOfVacancy;
	}

	public String getEducationalCriteria() {
		return educationalCriteria;
	}

	public void setEducationalCriteria(String educationalCriteria) {
		this.educationalCriteria = educationalCriteria;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getExperienceIn() {
		return experienceIn;
	}

	public void setExperienceIn(String experienceIn) {
		this.experienceIn = experienceIn;
	}

	public Long getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(Long yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Date getTentativeDateOfOnboarding() {
		return tentativeDateOfOnboarding;
	}

	public void setTentativeDateOfOnboarding(Date tentativeDateOfOnboarding) {
		this.tentativeDateOfOnboarding = tentativeDateOfOnboarding;
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
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
}