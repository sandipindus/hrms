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
    
}

