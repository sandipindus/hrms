package com.easybusiness.hrmanagement.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.TravelExpense;

public interface TravelExpenseRepository extends CrudRepository<TravelExpense, Long>{

	@Modifying
	@Query("update TravelExpense u set u.approver1Status = :approver1Status and u.ExpStatus = :ExpStatus where u.id = :id and u.approver1 = :approver1")
	int updateApprover1(@Param("approver1Status") Long approver1Status, 
	  @Param("ExpStatus") Long ExpStatus, @Param("id") Long id, @Param("approver1") Long approver1);
	
	/*@Modifying
	@Query("update TravelExpense u set u.approver2Status = :approver2Status and u.ExpStatus = :ExpStatus where u.id = :id and u.approver2 = :approver2")
	int updateApprover2(@Param("approver2Status") Long approver2Status, 
	  @Param("ExpStatus") Long ExpStatus, @Param("id") Long id, @Param("approver2") Long approver2);*/
}
