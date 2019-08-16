package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OMS_TIMESHEET")
public class Timesheet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "EMPLOYEE_ID")
    private Long empId;
    
    @Column(name = "PORJ_NUM")
    private Long projectNumber;
    
    @Column(name = "PROJ_TYPE_ID")
    private Long projectTypeID;
    
    @Column(name = "TASK_ID")
    private Long taskId;
    
    @Column(name = "YEAR")
    private Long year; 
    
    @Column(name = "DAY_RANGE")
    private String dayRange; 
    
	@Column(name = "HOUR_MON")
    private Double hourMon;
	
	@Column(name = "HOUR_TUE")
    private Double hourTue;
	
	@Column(name = "HOUR_WED")
    private Double hourWed;
	
	@Column(name = "HOUR_THU")
    private Double hourThu;
	
	@Column(name = "HOUR_FRI")
    private Double hourFri; 
	
	@Column(name = "HOUR_SAT")
    private Double hourSat; 
	
	@Column(name = "HOUR_SUN")
    private Double hourSun; 
	
	@Column(name = "PENDING_WITH")
    private Long pendingWith;
        
	@Column(name = "REQUEST_STATUS")
    private Long requestStatus;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;  
    
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;  
    
    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;  
    
    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;
    
    @Column(name = "IS_LEAVE_HOUR")
    private Long isLeaveHour;
    
    @Column(name = "BILLABLE")
    private String billable;
    
    @Column(name = "REASON")
    private String reason;

    @Column(name = "DIRECT_APPROVER")
    private Long directApprover;
    
	public Long getDirectApprover() {
		return directApprover;
	}

	public void setDirectApprover(Long directApprover) {
		this.directApprover = directApprover;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(Long projectNumber) {
		this.projectNumber = projectNumber;
	}

	public Long getProjectTypeID() {
		return projectTypeID;
	}

	public void setProjectTypeID(Long projectTypeID) {
		this.projectTypeID = projectTypeID;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getDayRange() {
		return dayRange;
	}

	public void setDayRange(String dayRange) {
		this.dayRange = dayRange;
	}

	public Double getHourMon() {
		return hourMon;
	}

	public void setHourMon(Double hourMon) {
		this.hourMon = hourMon;
	}

	public Double getHourTue() {
		return hourTue;
	}

	public void setHourTue(Double hourTue) {
		this.hourTue = hourTue;
	}

	public Double getHourWed() {
		return hourWed;
	}

	public void setHourWed(Double hourWed) {
		this.hourWed = hourWed;
	}

	public Double getHourThu() {
		return hourThu;
	}

	public void setHourThu(Double hourThu) {
		this.hourThu = hourThu;
	}

	public Double getHourFri() {
		return hourFri;
	}

	public void setHourFri(Double hourFri) {
		this.hourFri = hourFri;
	}

	public Double getHourSat() {
		return hourSat;
	}

	public void setHourSat(Double hourSat) {
		this.hourSat = hourSat;
	}

	public Double getHourSun() {
		return hourSun;
	}

	public void setHourSun(Double hourSun) {
		this.hourSun = hourSun;
	}

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

	public Long getIsLeaveHour() {
		return isLeaveHour;
	}

	public void setIsLeaveHour(Long isLeaveHour) {
		this.isLeaveHour = isLeaveHour;
	}

	public String getBillable() {
		return billable;
	}

	public void setBillable(String billable) {
		this.billable = billable;
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

