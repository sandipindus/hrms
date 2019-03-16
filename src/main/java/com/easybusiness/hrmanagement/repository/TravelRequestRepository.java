package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.TravelRequest;

public interface TravelRequestRepository extends CrudRepository<TravelRequest, Long>{
	public TravelRequest findByTravelRequestID(String travelReqId);

	@Query("select t from TravelRequest t where t.isDeleted = 0 and t.approver1=:approverid")
	public List<TravelRequest> getTravelRequestByApprover1(@Param("approverid") Long approverid);
	
	@Query("select t from TravelRequest t where t.isDeleted = 0 and t.approver2=:approverid")
	public List<TravelRequest> getTravelRequestByApprover2(@Param("approverid") Long approverid);
}
