package com.easybusiness.hrmanagement.pojo;

import java.util.List;

public class JDDetail {

	private String jdID;
	private List<CandidateDetail> candidateList;
	
	public JDDetail(String jdID, List<CandidateDetail> candidateList) {
		this.jdID = jdID;
		this.candidateList = candidateList;
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
}
