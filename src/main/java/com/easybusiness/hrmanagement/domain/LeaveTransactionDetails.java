package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_TRANSACTION_DETAILS")
public class LeaveTransactionDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "LEAVE_TRAN_ID")
    private Long leaveTranId;
	
	
	@Column(name = "LEAVE_TYPE_ID")
    private Long leaveTypeId;
	
	@Column(name = "USER_ID")
    private Long userId;
	
	@Column(name = "APPLIED_ON")
    private Date appliedOn;
	
	@Column(name = "APPLIED_BY")
    private Long appliedBy;
	
	@Column(name = "APPROVED_BY")
    private Long approvedBy;
	
	@Column(name = "APPROVED_ON")
    private Date approvedOn;
	
	@Column(name = "LEAVE_START_DATE")
    private Date leaveStartDate;
	
	@Column(name = "LEAVE_END_DATE")
    private Date leaveEndDate;
	
	@Column(name = "CANCELED_ON")
    private Date cancelledOn;
	
	@Column(name = "AVAILED_ON")
    private Date availedOn;
	
	@Column(name = "RAISED_ON")
    private Date raisedOn;
	
	@Column(name = "RAISED_FOR")
    private Date raisedFor;
	
	@Column(name = "STATUS")
    private String status;
	
	@Column(name = "MOD_BY")
    private Long modBy;
	
	@Column(name = "MOD_ON")
    private Date modOn;

	@Column(name = "LEAVE_NO")
    private Long leaveNo;
	
	@Column(name = "CREATED_ON")
    private Date createdOn;
	
	@Column(name = "CREATED_BY")
    private Long createdBy;

	public Long getLeaveTranId() {
		return leaveTranId;
	}

	public void setLeaveTranId(Long leaveTranId) {
		this.leaveTranId = leaveTranId;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
	}

	public Long getAppliedBy() {
		return appliedBy;
	}

	public void setAppliedBy(Long appliedBy) {
		this.appliedBy = appliedBy;
	}

	public Long getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	public Date getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public Date getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public Date getCancelledOn() {
		return cancelledOn;
	}

	public void setCancelledOn(Date cancelledOn) {
		this.cancelledOn = cancelledOn;
	}

	public Date getAvailedOn() {
		return availedOn;
	}

	public void setAvailedOn(Date availedOn) {
		this.availedOn = availedOn;
	}

	public Date getRaisedOn() {
		return raisedOn;
	}

	public void setRaisedOn(Date raisedOn) {
		this.raisedOn = raisedOn;
	}

	public Date getRaisedFor() {
		return raisedFor;
	}

	public void setRaisedFor(Date raisedFor) {
		this.raisedFor = raisedFor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getModBy() {
		return modBy;
	}

	public void setModBy(Long modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public Long getLeaveNo() {
		return leaveNo;
	}

	public void setLeaveNo(Long leaveNo) {
		this.leaveNo = leaveNo;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
}

