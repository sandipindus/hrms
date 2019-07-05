package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_BALANCE_DETAILS")

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name="leaveApplyProcedure",
			procedureName="USER_LEAVE_APPLY_PROC", 
			parameters={
		@StoredProcedureParameter(name="IN_USER_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_TYPE_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_START_DATE", type=Date.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LEAVE_END_DATE", type=Date.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_LOCATION_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_UNIT_ID", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="IN_DAY_TYPE", type=String.class, mode=ParameterMode.IN)}),
})

public class LeaveBalanceDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "USER_ID")
    private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}  
	
}

