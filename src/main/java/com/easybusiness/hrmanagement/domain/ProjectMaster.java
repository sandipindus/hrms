package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OMS_PROJECT_MASTER")
public class ProjectMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "PROJ_NUM")
    private Long prjId;
    
    @Column(name = "PROJ_NAME")
    private String prjName;   
    
    @Column(name = "PROJECT_TYPE")
    private String projType;  
    
    @Column(name = "PROJ_PLAN_STRT_DATE")
    private Date prjStartDate;
    
    @Column(name = "PROJ_PLAN_END_DATE")
    private Date prjEndDate;   
    
    @Column(name = "PROJ_PLAN_DURA")
    private Long plannedDuration;   
    
    @Column(name = "PROJ_PLAN_BDGT_IN_INR")
    private Long prjAllocBudget;  
    
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

	public String getProjType() {
		return projType;
	}

	public void setProjType(String projType) {
		this.projType = projType;
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

	public Long getPlannedDuration() {
		return plannedDuration;
	}

	public void setPlannedDuration(Long plannedDuration) {
		this.plannedDuration = plannedDuration;
	}

	public Long getPrjAllocBudget() {
		return prjAllocBudget;
	}

	public void setPrjAllocBudget(Long prjAllocBudget) {
		this.prjAllocBudget = prjAllocBudget;
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

