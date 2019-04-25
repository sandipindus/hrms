package com.easybusiness.hrmanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.ClaimStlmnt;

public interface ClaimStlmntRepository extends CrudRepository<ClaimStlmnt, Long>{

	@Query("select t from ClaimStlmnt t where t.createdBy=:createdId")
	public List<ClaimStlmnt> getClaimStlmntByCreatedId(@Param("createdId") Long createdId);
	
	@Transactional
	@Modifying
	@Query("update ClaimStlmnt u set u.finalStatus = :finalStatus, u.approver1Status = :approver1Status where u.id = :id and u.approver1 = :approver1")
	int updateApprover1(@Param("finalStatus") Long finalStatus, @Param("approver1Status") Long approver1Status,  @Param("id") Long id, @Param("approver1") Long approver1);
	
	@Transactional
	@Modifying
	@Query("update ClaimStlmnt u set u.finalStatus = :finalStatus, u.approver2Status = :approver2Status where u.id = :id and u.approver2 = :approver2")
	int updateApprover2(@Param("finalStatus") Long finalStatus, @Param("approver2Status") Long approver2Status,  @Param("id") Long id, @Param("approver2") Long approver2);

	public List<ClaimStlmnt> findByApprover2(Long approver2);

	public List<ClaimStlmnt> findByApprover1(Long approver1);
	
}
