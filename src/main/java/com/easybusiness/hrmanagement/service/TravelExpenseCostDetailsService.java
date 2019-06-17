package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelExpenseCostDetails;
import com.easybusiness.hrmanagement.repository.TravelExpenseCostDetailsRepository;

@Service
public class TravelExpenseCostDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelExpenseCostDetailsService.class);
	
	@Autowired
	TravelExpenseCostDetailsRepository travelExpenseCostDetailsRepository;
	
	public void addTravelExpenseCostDetails(TravelExpenseCostDetails travelExpenseCostDetails) throws Exception {
		try {
			travelExpenseCostDetailsRepository.save(travelExpenseCostDetails);
			LOGGER.debug("Successfully saved data into Table TRAVEL_EXPENSE_COST_DETAILS");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception("Error Occurred While adding travelExpenseCostDetails " + e.getMessage());
		}
	}
	
	public List<TravelExpenseCostDetails> getTravelExpenseCostDetails(Long id) throws Exception {
		List<TravelExpenseCostDetails> travelExpenseCostDetailsList = null;
		try {
			travelExpenseCostDetailsList = travelExpenseCostDetailsRepository.findByTravelExpId(id);

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelExpenseCostDetailsList;
	}
}
