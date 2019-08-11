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
	@Query("update ClaimStlmnt u set u.requestStatus = :requestStatus, u.pendingWith = :pendingWith where u.id = :id")
	int update(@Param("requestStatus") Long requestStatus, @Param("pendingWith") Long pendingWith,  @Param("id") Long id);

	public List<ClaimStlmnt> findByPendingWith(Long pendingWith);

}
