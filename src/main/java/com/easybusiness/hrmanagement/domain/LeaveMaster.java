package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OMS_LEAVE_MASTER")
public class LeaveMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "LEAVE_TYPE_NUM")
    private Long leaveTypeNum;
    
    @Column(name = "LEAVE_TYPE")
    private String leaveType;   
    
    @Column(name = "IS_CARRY_FWD")
    private String isCarryFwd;  
    
    @Column(name = "MAX_NUM_IN_A_YEAR")
    private Long maxNumInaYear;  
    
    @Column(name = "CARRY_FWD_LIMIT")
    private Long carryFwdLimit;  
    
    @Column(name = "MOD_BY")
    private String modBy;  
    
    @Column(name = "MOD_DATE")
    private Date modDate;

	public Long getLeaveTypeNum() {
		return leaveTypeNum;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public String getIsCarryFwd() {
		return isCarryFwd;
	}

	public Long getMaxNumInaYear() {
		return maxNumInaYear;
	}

	public Long getCarryFwdLimit() {
		return carryFwdLimit;
	}

	public String getModBy() {
		return modBy;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setLeaveTypeNum(Long leaveTypeNum) {
		this.leaveTypeNum = leaveTypeNum;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public void setIsCarryFwd(String isCarryFwd) {
		this.isCarryFwd = isCarryFwd;
	}

	public void setMaxNumInaYear(Long maxNumInaYear) {
		this.maxNumInaYear = maxNumInaYear;
	}

	public void setCarryFwdLimit(Long carryFwdLimit) {
		this.carryFwdLimit = carryFwdLimit;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}  
    
}

