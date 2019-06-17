package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLAIM_STLMNT")
public class ClaimStlmnt implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id()
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "CLM_STLMNT_TYPE_ID")
    private Long claimStlmntTypeId;
    
    @Column(name = "CLM_STLMNT_SUB_TYP_ID")
    private Long claimStlmntSubTypeId;
    
    @Column(name="MODE_OF_TRAVEL")
    private String modeOfTravel;
    
    @Column(name = "TRAVEL_DATE")
    private Date travelDate;
    
    @Column(name="DISTANCE")
    private String distance;
    
    @Column(name = "TRAVEL_FORM")
    private Long travelFrom;
    
    @Column(name = "TRAVEL_TO")
    private Long travelTo;
    
    @Column(name = "REASON")
    private String reason;
    
    @Column(name = "AMOUNT")
    private Long amount;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    
    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;
    
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    
    @Column(name = "APPROVER_1")
    private Long approver1;
    
    @Column(name = "APPROVER_2")
    private Long approver2;
    
    @Column(name = "APPROVER_1_STATUS")
    private Long approver1Status;
    
    @Column(name = "APPROVER_2_STATUS")
    private Long approver2Status;
    
    @Column(name = "FINAL_STATUS")
    private Long finalStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClaimStlmntTypeId() {
		return claimStlmntTypeId;
	}

	public void setClaimStlmntTypeId(Long claimStlmntTypeId) {
		this.claimStlmntTypeId = claimStlmntTypeId;
	}

	public Long getClaimStlmntSubTypeId() {
		return claimStlmntSubTypeId;
	}

	public void setClaimStlmntSubTypeId(Long claimStlmntSubTypeId) {
		this.claimStlmntSubTypeId = claimStlmntSubTypeId;
	}

	public String getModeOfTravel() {
		return modeOfTravel;
	}

	public void setModeOfTravel(String modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Long getTravelFrom() {
		return travelFrom;
	}

	public void setTravelFrom(Long travelFrom) {
		this.travelFrom = travelFrom;
	}

	public Long getTravelTo() {
		return travelTo;
	}

	public void setTravelTo(Long travelTo) {
		this.travelTo = travelTo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getApprover1() {
		return approver1;
	}

	public void setApprover1(Long approver1) {
		this.approver1 = approver1;
	}

	public Long getApprover2() {
		return approver2;
	}

	public void setApprover2(Long approver2) {
		this.approver2 = approver2;
	}

	public Long getApprover1Status() {
		return approver1Status;
	}

	public void setApprover1Status(Long approver1Status) {
		this.approver1Status = approver1Status;
	}

	public Long getApprover2Status() {
		return approver2Status;
	}

	public void setApprover2Status(Long approver2Status) {
		this.approver2Status = approver2Status;
	}

	public Long getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(Long finalStatus) {
		this.finalStatus = finalStatus;
	}
}

