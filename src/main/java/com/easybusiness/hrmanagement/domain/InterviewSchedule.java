package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INTERVIEW_SCHEDULE")
public class InterviewSchedule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "INTRVW_SCHDL_ID")
    private Long intrSchdllID;
    
    @Column(name = "JD_ID")
    private String jdID;
    
    @Column(name = "RECRUITMENT_INTERVIEWEE_ID")
    private String intervieweeID;
    
    @Column(name = "EMPLOYEE_NUM")
    private Long empNum;
    
    @Column(name = "LEVEL_ID")
    private Long levelID;
    
	@Column(name = "SCHEDULE_DATE_TIME")
    private Date schdlDateTime;
	
	@Column(name = "SCORE")
    private float score;
	
	@Column(name = "FEEDBACK")
    private String feedback;
	
	@Column(name = "STATUS")
    private Long status;

	public Long getIntrSchdllID() {
		return intrSchdllID;
	}

	public void setIntrSchdllID(Long intrSchdllID) {
		this.intrSchdllID = intrSchdllID;
	}

	public String getJdID() {
		return jdID;
	}

	public void setJdID(String jdID) {
		this.jdID = jdID;
	}

	public String getIntervieweeID() {
		return intervieweeID;
	}

	public void setIntervieweeID(String intervieweeID) {
		this.intervieweeID = intervieweeID;
	}

	public Long getEmpNum() {
		return empNum;
	}

	public void setEmpNum(Long empNum) {
		this.empNum = empNum;
	}

	public Date getSchdlDateTime() {
		return schdlDateTime;
	}

	public void setSchdlDateTime(Date schdlDateTime) {
		this.schdlDateTime = schdlDateTime;
	}
	
	public Long getLevelID() {
		return levelID;
	}

	public void setLevelID(Long levelID) {
		this.levelID = levelID;
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

