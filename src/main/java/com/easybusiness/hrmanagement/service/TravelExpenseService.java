package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.easybusiness.hrmanagement.domain.TravelExpense;
import com.easybusiness.hrmanagement.domain.TravelRequest;
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
			LOGGER.error(e.getMessage());
			throw new Exception("Error occurred while saving TRAVEL_EXPENSE " + e.getMessage());
		}
		return savedTravelExpense;
	}
	
	public List<TravelExpense> findByCreatedBy(Long createdBy) throws Exception {
		try {
			List<TravelExpense> travelExpenses = null;
			travelExpenses = travelExpenseRepository.findByCreatedBy(createdBy);
			
			if(CollectionUtils.isEmpty(travelExpenses)) {
				LOGGER.error(createdBy +" Not Present in Database ");
			} else {
				LOGGER.debug("Successfully retrieve TravelExpense");
			}
			
			return travelExpenses;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<TravelExpense> findByApprover(Long pendingWith, Long directApprover) throws Exception {
		try {
			List<TravelExpense> travelExpenses = null;
			travelExpenses = travelExpenseRepository.getByPendingWithDirectApprover(pendingWith, directApprover);
			
			if(CollectionUtils.isEmpty(travelExpenses)) {
				LOGGER.error("pendingWith OR  directApprover Not Present in Database");
			} else {
				LOGGER.debug("Successfully retrieve TravelExpense");
			}
			
			return travelExpenses;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}

	public TravelExpense findById(Long id) throws Exception {
		try {
			TravelExpense travelExpense = null;
			travelExpense = travelExpenseRepository.findOne(id);
			
			if(travelExpense == null) {
				LOGGER.error(id +" Not Present in Database ");
			} else {
				LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest");
			}
			
			return travelExpense;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	public List<TravelExpense> findAll() throws Exception {
		try {
			List<TravelExpense> travelExpenseList = null;
			travelExpenseList = (List<TravelExpense>) travelExpenseRepository.findAll();
			
			if(travelExpenseList == null) {
				LOGGER.error ("Travel Expense is not Present in Database ");
			} else {
				LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest");
			}
			
			return travelExpenseList;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
//	public int expenseApprover(TravelExpense travelExpense) throws Exception {
//		try {
//			int updatedRow = travelExpenseRepository.expenseApprover(travelExpense.getRequestStatus(), travelExpense.getPendingWith(), travelExpense.getId(), travelExpense.getDirectApprover());
//			LOGGER.debug("Successfully updated Table TravelExpense Row Count: " + updatedRow);
//			return updatedRow;
//		} catch (Exception e) {
//			LOGGER.debug(e.getMessage());
//			throw new Exception(e);
//		}
//	}
	
	public void updateTravelExpense(TravelExpense travelExpense) throws Exception {
		try {
			travelExpenseRepository.save(travelExpense);
			LOGGER.debug("Successfully updated data into Table TravelExpense");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
}
