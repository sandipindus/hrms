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
		TravelExpense savedTravelExpense = null;
		try {
			savedTravelExpense = travelExpenseRepository.save(travelExpense);
			LOGGER.debug("Successfully saved data into Table TRAVEL_EXPENSE");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception("Error occurred while saving TRAVEL_EXPENSE " + e.getMessage());
		}
		return savedTravelExpense;
	}
	
	public TravelExpense findById(Long id) throws Exception {
		try {
			TravelExpense travelExpense = null;
			travelExpense = travelExpenseRepository.findOne(id);
			
			if(travelExpense == null) {
				throw new Exception (id +" Not Present in Database ");
			}
			
			LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest");
			return travelExpense;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public int updateApprover1(TravelExpense travelExpense) throws Exception {
		try {
			int updatedRow = travelExpenseRepository.updateApprover1(travelExpense.getApprover1Status(), travelExpense.getExpStatus(), travelExpense.getId(),travelExpense.getApprover1());
			LOGGER.debug("Successfully updated Table TravelExpense Row Count: " + updatedRow);
			return updatedRow;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public int updateApprover2(TravelExpense travelExpense) throws Exception {
		try {
			int updatedRow = travelExpenseRepository.updateApprover2(travelExpense.getApprover2Status(), travelExpense.getExpStatus(), travelExpense.getId(), travelExpense.getApprover2());
			LOGGER.debug("Successfully updated Table TravelExpense Row Count: " + updatedRow);
			return updatedRow;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
}
