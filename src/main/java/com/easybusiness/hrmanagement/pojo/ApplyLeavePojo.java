package com.easybusiness.hrmanagement.pojo;

import java.sql.Date;

public class ApplyLeavePojo {
	private Long userId;
	private Long leaveTypeId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private Long locId;
	private Long unitId;
	private String dayType;
	private Long directApprover;
	private Long pendingWith;
	private Long requestStatus;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(Long leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
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
	public Long getLocId() {
		return locId;
	}
	public void setLocId(Long locId) {
		this.locId = locId;
	}
	public Long getUnitId() {
		return unitId;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	public String getDayType() {
		return dayType;
	}
	public void setDayType(String dayType) {
		this.dayType = dayType;
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
