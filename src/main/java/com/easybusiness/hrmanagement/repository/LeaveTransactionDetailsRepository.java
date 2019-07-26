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

	/*
	 * 15-07-19 to 22-07-19 SELECT * FROM LEAVE_TRANSACTION_DETAILS WHERE
	 * USER_ID=100 AND ((LEAVE_START_DATE <= '15-07-19' and LEAVE_END_DATE
	 * >='22-07-19') OR (LEAVE_START_DATE >= '15-07-19' and LEAVE_END_DATE
	 * <='22-07-19') OR (LEAVE_START_DATE <= '22-07-19' and LEAVE_END_DATE
	 * >='15-07-19') );
	 */
}
