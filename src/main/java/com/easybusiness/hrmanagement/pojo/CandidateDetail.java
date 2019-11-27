package com.easybusiness.hrmanagement.pojo;

import java.util.ArrayList;
import java.util.List;

import com.easybusiness.hrmanagement.domain.RecruitmentIntervieweeData;

public class CandidateDetail {

	private String candidateId;
	private RecruitmentIntervieweeData IntervieweeData;
	private List<InterviewLevel> interviewLevel;
	
	public CandidateDetail(RecruitmentIntervieweeData IntervieweeData, List<InterviewLevel> interviewLevel, String candidateId) {
		this.IntervieweeData = IntervieweeData;
		this.interviewLevel = interviewLevel;
		this.candidateId = candidateId;
	}
	
	public RecruitmentIntervieweeData getIntervieweeData() {
		return IntervieweeData;
	}
	public void setIntervieweeData(RecruitmentIntervieweeData intervieweeData) {
		IntervieweeData = intervieweeData;
	}
	public List<InterviewLevel> getInterviewLevel() {
		if(interviewLevel == null) {
			return new ArrayList<InterviewLevel>();
		}
		return interviewLevel;
	}
	public void setInterviewLevel(List<InterviewLevel> interviewLevel) {
		this.interviewLevel = interviewLevel;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	
}
