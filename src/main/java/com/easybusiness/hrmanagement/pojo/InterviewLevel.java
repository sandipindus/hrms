package com.easybusiness.hrmanagement.pojo;

import java.util.Date;

public class InterviewLevel {
	
    private Long empNum;
    private Long levelID;
    private Date schdlDateTime;
    private float score;
    private String feedback;
    private Long status;
    
    public InterviewLevel(Long empNum, Long levelID, Date schdlDateTime, float score, String feedback, Long status) {
    	this.empNum = empNum;
    	this.levelID = levelID;
    	this.schdlDateTime = schdlDateTime;
    	this.score = score;
    	this.feedback = feedback;
    	this.status = status;
    }
    
	public Long getEmpNum() {
		return empNum;
	}
	public void setEmpNum(Long empNum) {
		this.empNum = empNum;
	}
	public Long getLevelID() {
		return levelID;
	}
	public void setLevelID(Long levelID) {
		this.levelID = levelID;
	}
	public Date getSchdlDateTime() {
		return schdlDateTime;
	}
	public void setSchdlDateTime(Date schdlDateTime) {
		this.schdlDateTime = schdlDateTime;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
    
    

}
