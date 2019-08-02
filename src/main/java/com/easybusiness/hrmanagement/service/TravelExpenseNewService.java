package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelExpense_N;
import com.easybusiness.hrmanagement.repository.TravelExpenseNewRepository;

@Service
public class TravelExpenseNewService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelExpenseNewService.class);
	
	@Autowired
	TravelExpenseNewRepository travelExpenseNewRepository;
	
	
	public List<TravelExpense_N> findAll() throws Exception {
		try {
			List<TravelExpense_N> travelExpenseList = null;
			travelExpenseList = (List<TravelExpense_N>) travelExpenseNewRepository.findAll();
			
			if(travelExpenseList == null) {
				LOGGER.debug ("Travel Expense is not Present in Database ");
			}
			
			LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest");
			return travelExpenseList;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
}
