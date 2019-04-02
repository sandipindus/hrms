package com.easybusiness.hrmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelExpense;
import com.easybusiness.hrmanagement.repository.TravelExpenseRepository;

@Service
public class TravelExpenseService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelExpenseService.class);
	
	@Autowired
	TravelExpenseRepository travelExpenseRepository;
	
	public TravelExpense addTravelExpense(TravelExpense travelExpense) throws Exception {
		try {
			TravelExpense saveValue = travelExpenseRepository.save(travelExpense);
			LOGGER.debug("Successfully saved data into Table TRAVEL_EXPENSE");
			return saveValue;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
}
