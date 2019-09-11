package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INTERVIEW_LEVEL")
public class InterviewLevel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "LEVEL_ID")
    private Long levelID;
    
    @Column(name = "LEVEL_NAME")
    private String levelName;

	public Long getLevelID() {
		return levelID;
	}

	public void setLevelID(Long levelID) {
		this.levelID = levelID;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}    
    
}

