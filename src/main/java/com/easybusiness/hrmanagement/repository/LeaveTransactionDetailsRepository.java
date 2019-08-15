package com.easybusiness.hrmanagement.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.LeaveTransactionDetails;

public interface LeaveTransactionDetailsRepository extends CrudRepository<LeaveTransactionDetails, Long>{

	public List<LeaveTransactionDetails> findByUserId (Long userId);
	
	public LeaveTransactionDetails findByLeaveTranId(Long leaveTranId);
	
	@Query("select t from LeaveTransactionDetails t where t.userId =:userId and ((t.leaveStartDate <= :startDate and t.leaveEndDate >=:endDate) or (t.leaveStartDate >= :startDate and t.leaveEndDate <=:endDate) or (t.leaveStartDate <= :endDate and t.leaveEndDate >=:startDate))")
	public List<LeaveTransactionDetails> getLeaveTransactionDetailsByuserIdDateRange(@Param("userId") Long userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Query("select t from LeaveTransactionDetails t where t.directApprover =:directApprover or t.pendingWith =:pendingWith")
	public List<LeaveTransactionDetails> getLeaveTransactionDetailsByApprover(@Param("directApprover") Long directApprover, @Param("pendingWith") Long pendingWith);

	  
	 
}
