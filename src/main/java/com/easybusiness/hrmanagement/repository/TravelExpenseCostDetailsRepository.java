package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.hrmanagement.domain.TravelExpenseCostDetails;

public interface TravelExpenseCostDetailsRepository extends CrudRepository<TravelExpenseCostDetails, Long>{
	public List<TravelExpenseCostDetails> findByTravelExpId(Long travelExpId);
}
