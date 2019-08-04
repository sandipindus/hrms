package com.easybusiness.hrmanagement.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.TravelRequest;

public interface TravelRequestRepository extends CrudRepository<TravelRequest, Long>{
	public TravelRequest findByTravelRequestID(String travelReqId);

	@Query("select t from TravelRequest t where t.isDeleted = 0 and t.pendingWith=:pendingWith")
	public List<TravelRequest> getTravelRequestByApprover(@Param("pendingWith") Long pendingWith);
	
	@Query("select t from TravelRequest t where t.isDeleted = 0 and t.employeeId=:employeeId")
	public List<TravelRequest> getTravelRequestByEmployeeId(@Param("employeeId") Long employeeId);
	
	@Query("select t from TravelRequest t where t.isDeleted = 0 and t.pendingWith=:pendingWith")
	public List<TravelRequest> getTravelRequestByPendingWith(@Param("pendingWith") Long pendingWith);
	
	@Query("select t from TravelRequest t where t.isDeleted = 0 and t.isStlmntPending = 0 and t.createdBy=:createdid and t.travelDateOfReturn < :currentDate")
	public List<TravelRequest> getTravelRequestByCreatedIDStlmntPending(@Param("createdid") Long createdid, @Param("currentDate") Date currentDate);
}
