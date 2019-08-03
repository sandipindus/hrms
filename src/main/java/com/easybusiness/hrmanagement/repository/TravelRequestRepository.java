package com.easybusiness.hrmanagement.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.TravelRequest;

public interface TravelRequestRepository extends CrudRepository<TravelRequest, Long>{
	public TravelRequest findByTravelRequestID(String travelReqId);

	@Query("select t from TravelRequest t where t.isDeleted = 0")
	public List<TravelRequest> getTravelRequestByApprover1(@Param("approverid") Long approverid);
	
	@Query("select t from TravelRequest t where t.isDeleted = 0")
	public List<TravelRequest> getTravelRequestByApprover2(@Param("approverid") Long approverid);
	
	@Query("select t from TravelRequest t where t.isDeleted = 0 and t.createdBy=:createdid")
	public List<TravelRequest> getTravelRequestByCreatedID(@Param("createdid") Long createdid);
	
	@Query("select t from TravelRequest t where t.isDeleted = 0 and t.isStlmntPending = 0 and t.createdBy=:createdid and t.travelDateOfReturn < :currentDate")
	public List<TravelRequest> getTravelRequestByCreatedIDStlmntPending(@Param("createdid") Long createdid, @Param("currentDate") Date currentDate);
}
