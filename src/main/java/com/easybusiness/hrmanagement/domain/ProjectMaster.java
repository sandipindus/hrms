package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_MASTER")
public class ProjectMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "PRJ_ID")
    private Long prjId;
    
    @Column(name = "PRJ_NAME")
    private String prjName;   
    
    @Column(name = "PRJ_DESC")
    private String prjDesc;  
    
    @Column(name = "PRJ_START_DT")
    private Date prjStartDate;
    
    @Column(name = "PRJ_END_DT")
    private Date prjEndDate;   
    
    @Column(name = "PRJ_ACTUAL_START_DT")
    private Date prjActualStartDate;  
    
    @Column(name = "PRJ_ACTUAL_END_DT")
    private Date prjActualEndDate;
    
    @Column(name = "PLANNED_DURATION")
    private Long plannedDuration;   
    
    @Column(name = "ACTUAL_DURATION")
    private Long actualDuration;  
    
    @Column(name = "PRJ_ALLOC_BUDGET")
    private Long prjAllocBudget;  
    
    @Column(name = "PRJ_AVL_BUDGET")
    private Long prjAvailableBudget;
    
    @Column(name = "PRJ_STATUS")
    private String prjStatus;   
    
    @Column(name = "MOD_BY")
    private String modBy;  
    
    @Column(name = "MOD_ON")
    private Date modOn;

	public Long getPrjId() {
		return prjId;
	}

	public void setPrjId(Long prjId) {
		this.prjId = prjId;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjDesc() {
		return prjDesc;
	}

	public void setPrjDesc(String prjDesc) {
		this.prjDesc = prjDesc;
	}

	public Date getPrjStartDate() {
		return prjStartDate;
	}

	public void setPrjStartDate(Date prjStartDate) {
		this.prjStartDate = prjStartDate;
	}

	public Date getPrjEndDate() {
		return prjEndDate;
	}

	public void setPrjEndDate(Date prjEndDate) {
		this.prjEndDate = prjEndDate;
	}

	public Date getPrjActualStartDate() {
		return prjActualStartDate;
	}

	public void setPrjActualStartDate(Date prjActualStartDate) {
		this.prjActualStartDate = prjActualStartDate;
	}

	public Date getPrjActualEndDate() {
		return prjActualEndDate;
	}

	public void setPrjActualEndDate(Date prjActualEndDate) {
		this.prjActualEndDate = prjActualEndDate;
	}

	public Long getPlannedDuration() {
		return plannedDuration;
	}

	public void setPlannedDuration(Long plannedDuration) {
		this.plannedDuration = plannedDuration;
	}

	public Long getActualDuration() {
		return actualDuration;
	}

	public void setActualDuration(Long actualDuration) {
		this.actualDuration = actualDuration;
	}

	public Long getPrjAllocBudget() {
		return prjAllocBudget;
	}

	public void setPrjAllocBudget(Long prjAllocBudget) {
		this.prjAllocBudget = prjAllocBudget;
	}

	public Long getPrjAvailableBudget() {
		return prjAvailableBudget;
	}

	public void setPrjAvailableBudget(Long prjAvailableBudget) {
		this.prjAvailableBudget = prjAvailableBudget;
	}

	public String getPrjStatus() {
		return prjStatus;
	}

	public void setPrjStatus(String prjStatus) {
		this.prjStatus = prjStatus;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}
    
	
}

