package com.easybusiness.hrmanagement.repository;

import java.util.Locale;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.easybusiness.hrmanagement.pojo.ApplyLeavePojo;
import com.easybusiness.hrmanagement.pojo.ModifyLeavePojo;

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
	
	public void modifyLeave(ModifyLeavePojo modifyLeavePojo) {

		em.createNamedStoredProcedureQuery("leaveUpdateProcedure")
				.setParameter("IN_OPERATION_TYPE", modifyLeavePojo.getOperationType().toUpperCase(Locale.ENGLISH))
				.setParameter("IN_USER_ID", modifyLeavePojo.getUserId())
				.setParameter("IN_LEAVE_TYPE_ID", modifyLeavePojo.getLeaveTypeId())
				.setParameter("IN_LEAVE_TRAN_ID", modifyLeavePojo.getLeaveTranId())
				.setParameter("IN_LEAVE_START_DATE", modifyLeavePojo.getLeaveStartDate())
				.setParameter("IN_LEAVE_END_DATE", modifyLeavePojo.getLeaveEndDate())
				.setParameter("IN_LOCATION_ID", modifyLeavePojo.getLocId())
				.setParameter("IN_UNIT_ID", modifyLeavePojo.getUnitId())
				.setParameter("IN_DAY_TYPE", modifyLeavePojo.getDayType().toUpperCase(Locale.ENGLISH)).execute();

	}
}
