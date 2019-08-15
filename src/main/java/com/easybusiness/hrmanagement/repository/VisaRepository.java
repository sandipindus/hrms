package com.easybusiness.hrmanagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.Visa;

public interface VisaRepository extends CrudRepository<Visa, Long>{
	public Visa findByVisaID (Long id);
	
	@Query("select t from Visa t where t.directApprover =:directApprover or t.pendingWith =:pendingWith")
	public List<Visa> getVisaByApprover(@Param("directApprover") Long directApprover, @Param("pendingWith") Long pendingWith);


}