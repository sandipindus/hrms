package com.easybusiness.hrmanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.TravelExpense;

public interface TravelExpenseRepository extends CrudRepository<TravelExpense, Long>{

	@Transactional
	@Modifying
	@Query("update TravelExpense u set u.requestStatus = :requestStatus, u.pendingWith = :pendingWith where u.id = :id")
	int expenseApprover(@Param("requestStatus") Long requestStatus, @Param("pendingWith") Long pendingWith,  @Param("id") Long id);
	
	/*@Transactional
	@Modifying
	@Query("update TravelExpense u set u.expStatus = :expStatus, u.approver2Status = :approver2Status where u.id = :id and u.approver2 = :approver2")
	int updateApprover2(@Param("expStatus") Long ExpStatus, @Param("approver2Status") Long approver2Status,  @Param("id") Long id, @Param("approver2") Long approver2);*/
	
	public List<TravelExpense> findByCreatedBy(Long createdBy);
	
	@Query("select t from TravelExpense t where t.pendingWith=:pendingWith or t.directApprover=:directApprover")
	public List<TravelExpense> getByPendingWithDirectApprover(@Param("pendingWith") Long pendingWith, @Param("directApprover") Long directApprover);
	
	//public List<TravelExpense> findByApprover2(Long approver2);
	
	
}
