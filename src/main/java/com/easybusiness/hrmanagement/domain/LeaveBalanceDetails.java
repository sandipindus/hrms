package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_BALANCE_DETAILS")

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name="leaveApplyProcedure",
			procedureName="USER_LEAVE_APPLY_PROC", 
			parameters={
		@StoredProcedureParameter(name="IN_USER_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_TYPE_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_START_DATE", type=Date.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_END_DATE", type=Date.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LOCATION_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_UNIT_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_DAY_TYPE", type=String.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_PENDING_WITH", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_REQUEST_STATUS", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_IMDT_APPROVERID", type=Long.class, mode=ParameterMode.IN)}),
	
	
	@NamedStoredProcedureQuery(
			name="leaveUpdateProcedure",
			procedureName="USER_LEAVE_MODORCAN_PROC", 
			parameters={
		@StoredProcedureParameter(name="IN_OPERATION_TYPE", type=String.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_USER_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_TYPE_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_TRAN_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_START_DATE", type=Date.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_END_DATE", type=Date.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LOCATION_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_UNIT_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_DAY_TYPE", type=String.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_PENDING_WITH", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_REQUEST_STATUS", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_IMDT_APPROVERID", type=Long.class, mode=ParameterMode.IN)}),
})

public class LeaveBalanceDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Column(name = "USER_ID")
    private Long userId;
	
	@Id()
	@Column(name = "BALANCE_ID")
    private Long balanceId;
	
	@Column(name = "LEAVE_TYPE_ID")
    private Long leaveTypeId;
	
	@Column(name = "OPENING_BALANCE")
    private Long openingBalance;
	
	@Column(name = "LEAVE_EARNED")
    private Long leaveEarned;
	
	@Column(name = "TOTAL_LEAVE")
    private Long totalLeave;
	
	@Column(name = "LEAVE_APPLIED")
    private Long leaveApplied;
	
	@Column(name = "LEAVE_LAPSED")
    private Long leaveLapsed;
	
	@Column(name = "LEAVE_BALANCE")
    private Long leaveBalance;
	
	@Column(name = "LOCATION_ID")
    private Long locID;
	
	@Column(name = "VALID_FROM")
    private Date validForm;
	
	@Column(name = "VALID_TO")
    private Date validTo;
	
	@Column(name = "MOD_BY")
    private Long modBy;
	
	@Column(name = "MOD_ON")
    private Date modOn;
	
	@Column(name = "CREATED_BY")
    private Long createdBy;
	
	@Column(name = "CREATED_ON")
    private Date createdOn;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBalanceId() {
		return balanceId;
	}

	public Long getLeaveTypeId() {
		return leaveTypeId;
	}

	public Long getOpeningBalance() {
		return openingBalance;
	}

	public Long getLeaveEarned() {
		return leaveEarned;
	}

	public Long getTotalLeave() {
		return totalLeave;
	}

	public Long getLeaveApplied() {
		return leaveApplied;
	}

	public Long getLeaveLapsed() {
		return leaveLapsed;
	}

	public Long getLeaveBalance() {
		return leaveBalance;
	}

	public Long getLocID() {
		return locID;
	}

	public Date getValidForm() {
		return validForm;
	}

	public Date getValidTo() {
		return validTo;
	}

	public Long getModBy() {
		return modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
	}

	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public void setOpeningBalance(Long openingBalance) {
		this.openingBalance = openingBalance;
	}

	public void setLeaveEarned(Long leaveEarned) {
		this.leaveEarned = leaveEarned;
	}

	public void setTotalLeave(Long totalLeave) {
		this.totalLeave = totalLeave;
	}

	public void setLeaveApplied(Long leaveApplied) {
		this.leaveApplied = leaveApplied;
	}

	public void setLeaveLapsed(Long leaveLapsed) {
		this.leaveLapsed = leaveLapsed;
	}

	public void setLeaveBalance(Long leaveBalance) {
		this.leaveBalance = leaveBalance;
	}

	public void setLocID(Long locID) {
		this.locID = locID;
	}

	public void setValidForm(Date validForm) {
		this.validForm = validForm;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public void setModBy(Long modBy) {
		this.modBy = modBy;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}  
	
}

