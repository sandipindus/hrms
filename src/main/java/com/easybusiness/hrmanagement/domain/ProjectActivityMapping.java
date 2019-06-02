package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_ACTIVITY_MAPPING")
public class ProjectActivityMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "MAPPING_ID")
    private Long mappingId;  
	
    @Column(name = "PRJ_ID")
    private Long prjId;
    
    @Column(name = "ACTIVITY_ID")
    private Long activityId;   
    
    @Column(name = "MOD_BY")
    private String modBy;  
    
    @Column(name = "MOD_ON")
    private Date modOn;

	public Long getMappingId() {
		return mappingId;
	}

	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}

	public Long getPrjId() {
		return prjId;
	}

	public void setPrjId(Long prjId) {
		this.prjId = prjId;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
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

