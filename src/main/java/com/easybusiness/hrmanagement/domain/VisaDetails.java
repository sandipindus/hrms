package com.easybusiness.hrmanagement.domain;

import java.util.List;

public class VisaDetails {

	private Visa visa;
	private List<VisaDocument> visaDocList;
	
	public Visa getVisa() {
		return visa;
	}
	public void setVisa(Visa visa) {
		this.visa = visa;
	}
	public List<VisaDocument> getVisaDocList() {
		return visaDocList;
	}
	public void setVisaDocList(List<VisaDocument> visaDocList) {
		this.visaDocList = visaDocList;
	}
}
