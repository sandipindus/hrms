package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
	
	public List<TravelExpense> findByCreatedBy(Long createdBy) throws Exception {
		try {
			List<TravelExpense> travelExpenses = null;
			travelExpenses = travelExpenseRepository.findByCreatedBy(createdBy);
			
			if(CollectionUtils.isEmpty(travelExpenses)) {
				throw new Exception (createdBy +" Not Present in Database ");
			}
			
			LOGGER.debug("Successfully retrieve TravelExpense");
			return travelExpenses;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<TravelExpense> findByApprover1(Long approver1) throws Exception {
		try {
			List<TravelExpense> travelExpenses = null;
			travelExpenses = travelExpenseRepository.findByApprover1(approver1);
			
			if(CollectionUtils.isEmpty(travelExpenses)) {
				throw new Exception (approver1 +" Not Present in Database ");
			}
			
			LOGGER.debug("Successfully retrieve TravelExpense");
			return travelExpenses;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<TravelExpense> findByApprover2(Long approver2) throws Exception {
		try {
			List<TravelExpense> travelExpenses = null;
			travelExpenses = travelExpenseRepository.findByApprover2(approver2);
			
			if(CollectionUtils.isEmpty(travelExpenses)) {
				throw new Exception (approver2 +" Not Present in Database ");
			}
			
			LOGGER.debug("Successfully retrieve TravelExpense");
			return travelExpenses;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
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
	public List<TravelExpense> findAll() throws Exception {
		try {
			List<TravelExpense> travelExpenseList = null;
			travelExpenseList = (List<TravelExpense>) travelExpenseRepository.findAll();
			
			if(travelExpenseList == null) {
				throw new Exception ("Travel Expense is not Present in Database ");
			}
			
			LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest");
			return travelExpenseList;
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
