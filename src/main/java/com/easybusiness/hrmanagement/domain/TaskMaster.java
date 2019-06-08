package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOBJ_1045")
public class TaskMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "TASK_ID")
    private Long taskId;  
	
    @Column(name = "PROJ_TYPE_ID")
    private Long projTypeId;
    
    @Column(name = "TASK")
    private String task;
    
    @Column(name = "MOD_BY")
    private String modBy;
    
    @Column(name = "MOD_ON")
    private Date modOn;

	public Long getTaskId() {
		return taskId;
	}

	public Long getProjTypeId() {
		return projTypeId;
	}

	public String getTask() {
		return task;
	}

	public String getModBy() {
		return modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public void setProjTypeId(Long projTypeId) {
		this.projTypeId = projTypeId;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

}

