package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;*/
import javax.persistence.Table;

@Entity
@Table(name = "OMS_ACTIVITY_MASTER")

/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name="firstProcedure",
			procedureName="INSERTACTIVITYSP", 
			parameters={
		@StoredProcedureParameter(name="p_activtyid", type=Long.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="p_activty", type=String.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="p_modby", type=String.class, mode=ParameterMode.IN),
		@StoredProcedureParameter(name="p_moddate", type=Date.class, mode=ParameterMode.IN)}),
	
	@NamedStoredProcedureQuery(
			name="secondProcedure",
			procedureName="activitysp")
})*/

public class OmsActivityMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "ACTIVITY_NUM")
	/*@Column(name = "ACTIVITY_ID")*/
    private Long activityNum;  
	
    @Column(name = "ACTIVITY")
    private String activity;
    
    @Column(name = "MOD_BY")
    private String modBy;  
    
    @Column(name = "MOD_DATE")
    private Date modDate;

	public Long getActivityNum() {
		return activityNum;
	}

	public String getActivity() {
		return activity;
	}

	public String getModBy() {
		return modBy;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setActivityNum(Long activityNum) {
		this.activityNum = activityNum;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	
    
}

