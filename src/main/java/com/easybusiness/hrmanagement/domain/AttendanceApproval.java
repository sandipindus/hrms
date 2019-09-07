package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "ATTENDENCE_APPROVAL")
public class AttendanceApproval implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "EMPCODE")
    private String empId;  
    
    @Column(name = "MONTH")
    private String month; 
    
    @Column(name = "ATTENDENCE_DATE")
    private String attendanceDate; 
    
	@Column(name = "INTIME")
    private String inTime;  
    
    @Column(name = "OUTTIME")
    private String outTime; 
    
    @Column(name = "REASON")
    private String reason; 

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
    
    @Column(name = "DIRECT_APPROVER")
    private Long directApprover;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "CREATED_BY", referencedColumnName = "EMPLOYEE_NUM", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private EmployeeMaster createdByDetails;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "MODIFIED_BY", referencedColumnName = "EMPLOYEE_NUM", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private EmployeeMaster modifiedByDetails;
    
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getInTime() {
		return inTime;
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

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	
	public Long getDirectApprover() {
		return directApprover;
	}

	public void setDirectApprover(Long directApprover) {
		this.directApprover = directApprover;
	}
}

