package com.easybusiness.hrmanagement.repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.easybusiness.hrmanagement.domain.OmsActivityMaster;
import com.easybusiness.hrmanagement.pojo.ApplyLeavePojo;

@Repository
public class ApplyLeaveStoredProcedure {

	@Autowired
	private EntityManager em;

	public void applyLeave(ApplyLeavePojo applyLeavePojo) {
		
		em.createNamedStoredProcedureQuery("leaveApplyProcedure")
		.setParameter("IN_USER_ID", applyLeavePojo.getUserId())
		.setParameter("IN_LEAVE_TYPE_ID", applyLeavePojo.getLeaveTypeId())
		.setParameter("IN_LEAVE_START_DATE", applyLeavePojo.getLeaveStartDate())
		.setParameter("IN_LEAVE_END_DATE", applyLeavePojo.getLeaveEndDate())
		.setParameter("IN_LOCATION_ID", applyLeavePojo.getLocId())
		.setParameter("IN_UNIT_ID", applyLeavePojo.getUnitId())
		.setParameter("IN_DAY_TYPE", applyLeavePojo.getDayType()).execute();
		
	}
}
