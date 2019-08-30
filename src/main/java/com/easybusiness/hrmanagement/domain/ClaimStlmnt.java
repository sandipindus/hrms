package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "CLAIM_STLMNT")
public class ClaimStlmnt implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    
    @Column(name = "PENDING_WITH")
    private Long pendingWith;
        
	@Column(name = "REQUEST_STATUS")
    private Long requestStatus;
	
	@Column(name = "DIRECTAPPROVER")
    private Long directApprover;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "CREATED_BY", referencedColumnName = "EMPLOYEE_NUM", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private EmployeeMaster createdByDetails;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MODIFIED_BY", referencedColumnName = "EMPLOYEE_NUM", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private EmployeeMaster modifiedByDetails;

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
}

