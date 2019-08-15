package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISA_APPLICATION")
public class Visa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "VISAID")
    private Long visaID;
    
    @Column(name = "VISATYPE")
    private String visaType;
    
    @Column(name = "COUNTRYTYPEID")
    private int countryTypeId;
    
    @Column(name = "TRAVEL_DATE")
    private Date travelDate;
    
    @Column(name = "DURATION")
    private int duration;
    
    @Column(name = "PROJECTID")
    private Long projectId;
    
    @Column(name = "EMPID")
    private Long empId;
    
    @Column(name = "STATUSID")
    private int statusId;
    
    @Column(name = "CREATEDDATE")
    private Timestamp createdDate;
    
    @Column(name = "CREATEDBY")
    private Long createdBy;
    
    @Column(name = "MODIFIEDDATE")
    private Timestamp modifiedDate;
    
    @Column(name = "MODIFIEDBY")
    private Long modifiedBy;

    @Column(name="APPROVER")
    private Long approver;
    
    @Column(name="PASSPORT_NUMBER")
    private String passportNumber;
    
    @Column(name="PASSPORT_EXP_DATE")
    private Date passportExpiryDate;
    
    @Column(name = "DIRECTAPPROVER")
    private Long directApprover;
	
	@Column(name = "PENDING_WITH")
    private Long pendingWith;
        
	@Column(name = "REQUEST_STATUS")
    private Long requestStatus;
    
	public Long getApprover() {
		return approver;
	}

	public void setApprover(Long approver) {
		this.approver = approver;
	}

	public Long getVisaID() {
		return visaID;
	}

	public void setVisaID(Long visaID) {
		this.visaID = visaID;
	}

	public String getVisaType() {
		return visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	public int getCountryTypeId() {
		return countryTypeId;
	}

	public void setCountryTypeId(int countryTypeId) {
		this.countryTypeId = countryTypeId;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(Date passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public Long getDirectApprover() {
		return directApprover;
	}

	public void setDirectApprover(Long directApprover) {
		this.directApprover = directApprover;
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
    
	
}

