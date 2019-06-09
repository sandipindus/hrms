package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "OMS_PROJECT_MASTER")
public class OMSProjectMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "PROJ_NUM")
    private Long projNum;
    
    @Column(name = "ORG_NUM")
    private Long orgNum;  
    
    @Column(name = "PROJ_NAME")
    private String projName;  
    
    @Column(name = "PROJECT_TYPE")
    private Long projType;
    
    @Column(name = "CUSTOMER_ID")
    private Long customerId;    
    
    @Column(name = "PROJ_MNGR")
    private Long projMngr;
    
    @Column(name = "PROJ_PLAN_STRT_DATE")
    private Date projPlanStartDate;    
    
    @Column(name = "PROJ_PLAN_END_DATE")
    private Date projPlanEndDate;
    
    @Column(name = "PROJ_PLAN_DURA")
    private Long projPlanDuration;    
    
    @Column(name = "PROJ_ORIG_VAL")
    private Long projOrigVal;
    
    @Column(name = "PROJ_ORIG_CURR")
    private String projOrigCurr;    
    
    @Column(name = "PROJ_VAL_IN_INR	")
    private Long projValInInr;
    
    @Column(name = "PROJ_PLAN_BDGT_IN_INR")
    private Long projPlanBdgtInInr;    
    
    @Column(name = "MOD_BY")
    private String modBy;
    
    @Column(name = "MOD_DATE")
    private Date modDate; 
    
    @OneToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name= "PROJECT_TYPE", referencedColumnName = "PROJ_TYPE_ID", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private ProjTypeMaster projTypeMaster;
    
    public Long getProjNum() {
		return projNum;
	}

	public Long getOrgNum() {
		return orgNum;
	}

	public String getProjName() {
		return projName;
	}

	public Long getProjType() {
		return projType;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public Long getProjMngr() {
		return projMngr;
	}

	public Date getProjPlanStartDate() {
		return projPlanStartDate;
	}

	public Date getProjPlanEndDate() {
		return projPlanEndDate;
	}

	public Long getProjPlanDuration() {
		return projPlanDuration;
	}

	public Long getProjOrigVal() {
		return projOrigVal;
	}

	public String getProjOrigCurr() {
		return projOrigCurr;
	}

	public Long getProjValInInr() {
		return projValInInr;
	}

	public Long getProjPlanBdgtInInr() {
		return projPlanBdgtInInr;
	}

	public String getModBy() {
		return modBy;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setProjNum(Long projNum) {
		this.projNum = projNum;
	}

	public void setOrgNum(Long orgNum) {
		this.orgNum = orgNum;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public void setProjType(Long projType) {
		this.projType = projType;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setProjMngr(Long projMngr) {
		this.projMngr = projMngr;
	}

	public void setProjPlanStartDate(Date projPlanStartDate) {
		this.projPlanStartDate = projPlanStartDate;
	}

	public void setProjPlanEndDate(Date projPlanEndDate) {
		this.projPlanEndDate = projPlanEndDate;
	}

	public void setProjPlanDuration(Long projPlanDuration) {
		this.projPlanDuration = projPlanDuration;
	}

	public void setProjOrigVal(Long projOrigVal) {
		this.projOrigVal = projOrigVal;
	}

	public void setProjOrigCurr(String projOrigCurr) {
		this.projOrigCurr = projOrigCurr;
	}

	public void setProjValInInr(Long projValInInr) {
		this.projValInInr = projValInInr;
	}

	public void setProjPlanBdgtInInr(Long projPlanBdgtInInr) {
		this.projPlanBdgtInInr = projPlanBdgtInInr;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public ProjTypeMaster getProjTypeMaster() {
		return projTypeMaster;
	}

	public void setProjTypeMaster(ProjTypeMaster projTypeMaster) {
		this.projTypeMaster = projTypeMaster;
	}

}

