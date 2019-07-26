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
	
	@Query("select t from LeaveTransactionDetails t where t.userId =:userId and t.leaveStartDate <= :startDate and t.leaveEndDate >=:endDate")
	public List<LeaveTransactionDetails> getLeaveTransactionDetailsByuserIdDateRange(@Param("userId") Long userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

	
}
