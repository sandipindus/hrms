package com.easybusiness.hrmanagement.domain;

import java.io.Serializable;

public class TimesheetDeleteFieldPojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean isDeleted = false;

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


}
