package com.easybusiness.hrmanagement.pojo;

import java.util.List;

import com.easybusiness.hrmanagement.domain.RecruitmentJdDetails;

public class JDDetail {

	private String jdID;
	private List<CandidateDetail> candidateList;
	private RecruitmentJdDetails jdDetails;
	
	public JDDetail(String jdID, List<CandidateDetail> candidateList, RecruitmentJdDetails jdDetails) {
		this.jdID = jdID;
		this.candidateList = candidateList;
		this.jdDetails = jdDetails;
	}
	
	public String getJdID() {
		return jdID;
	}
	public void setJdID(String jdID) {
		this.jdID = jdID;
	}
	public List<CandidateDetail> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(List<CandidateDetail> candidateList) {
		this.candidateList = candidateList;
	}

	public RecruitmentJdDetails getJdDetails() {
		return jdDetails;
	}

	public void setJdDetails(RecruitmentJdDetails jdDetails) {
		this.jdDetails = jdDetails;
	}
}
