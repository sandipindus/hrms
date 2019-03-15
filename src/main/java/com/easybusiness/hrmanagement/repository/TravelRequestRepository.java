package com.easybusiness.hrmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.hrmanagement.domain.TravelRequest;

public interface TravelRequestRepository extends CrudRepository<TravelRequest, Long>{
	public TravelRequest findByTravelRequestID(String travelReqId);
}
