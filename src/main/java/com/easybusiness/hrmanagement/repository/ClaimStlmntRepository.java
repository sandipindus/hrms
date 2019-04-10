package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.ClaimStlmnt;

public interface ClaimStlmntRepository extends CrudRepository<ClaimStlmnt, Long>{

	@Query("select t from ClaimStlmnt t where t.createdBy=:createdId")
	public List<ClaimStlmnt> getClaimStlmntByCreatedId(@Param("createdId") Long createdId);
}
