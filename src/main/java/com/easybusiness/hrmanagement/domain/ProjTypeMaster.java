package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "MOBJ_1044")
public class ProjTypeMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "PROJ_TYPE_ID")
    private Long projTypeId;
    
    @Column(name = "PROJ_TYPE")
    private String projType;  
    
    @Column(name = "MOD_BY")
    private String modBy;
    
    @Column(name = "MOD_ON")
    private Date modOn;
    
    @OneToMany(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name= "PROJ_TYPE_ID", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private List<TaskMaster> taskMaster;

	public Long getProjTypeId() {
		return projTypeId;
	}

	public String getProjType() {
		return projType;
	}

	public String getModBy() {
		return modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setProjTypeId(Long projTypeId) {
		this.projTypeId = projTypeId;
	}

	public void setProjType(String projType) {
		this.projType = projType;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public List<TaskMaster> getTaskMaster() {
		return taskMaster;
	}

	public void setTaskMaster(List<TaskMaster> taskMaster) {
		this.taskMaster = taskMaster;
	}    
    

    
}

