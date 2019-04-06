package com.easybusiness.hrmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.TravelExpense;
import com.easybusiness.hrmanagement.domain.TravelExpenseCostDetails;
import com.easybusiness.hrmanagement.domain.TravelExpenseDetails;
import com.easybusiness.hrmanagement.service.TravelExpenseCostDetailsService;
import com.easybusiness.hrmanagement.service.TravelExpenseService;

@RestController
@RequestMapping("/hrmanagement/expense")
public class TravelExpenseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelExpenseController.class);
	
	@Autowired
	TravelExpenseService travelExpenseService;
	
	@Autowired
	TravelExpenseCostDetailsService travelExpenseCostDetailsService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addTravelExpense")
	public ReturnMessage addTravelExpense(@RequestBody TravelExpenseDetails travelExpenseDetails) throws Exception {
		
		validateTravelExpenseDetails(travelExpenseDetails);
		
		TravelExpense travelExpense = travelExpenseDetails.getTravelExpense();
		
		TravelExpense savedTravelExpense = travelExpenseService.addTravelExpense(travelExpense);
		
		List<TravelExpenseCostDetails> travelExpenseCostDetailsList = travelExpenseDetails.getTravelExpenseCostDetailsList();
		
		if(travelExpenseCostDetailsList!= null && !travelExpenseCostDetailsList.isEmpty()) {
			Long travelExpenseID = savedTravelExpense.getId();
			for (TravelExpenseCostDetails travelExpenseCostDetails : travelExpenseCostDetailsList) {
				
				travelExpenseCostDetails.setTravelExpId(travelExpenseID);
				travelExpenseCostDetailsService.addTravelExpenseCostDetails(travelExpenseCostDetails);
			}
		}
		
		
		ReturnMessage returnMessage = new ReturnMessage("Travel Expense With ID : " + savedTravelExpense.getId() + " "+ HRManagementConstant.ADDED_SUCCESSFULLY);
		return returnMessage;
	}
	
	@GetMapping("/findTravelExpense/{id}")
	public TravelExpenseDetails getTravelExpense(@PathVariable("id") Long travelExpenseID) throws Exception {

		TravelExpenseDetails travelExpenseDetails = new TravelExpenseDetails();
		try {
			TravelExpense travelExpense = travelExpenseService.findById(travelExpenseID);
			travelExpenseDetails.setTravelExpense(travelExpense);

			List<TravelExpenseCostDetails> travelExpenseCostDetailsList = travelExpenseCostDetailsService.getTravelExpenseCostDetails(travelExpenseID);

			if(!travelExpenseCostDetailsList.isEmpty()) {
				travelExpenseDetails.setTravelExpenseCostDetailsList(travelExpenseCostDetailsList);
			}

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelExpenseDetails;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/UpdateByApprover1")
	public ReturnMessage UpdateByApprover1(@RequestBody TravelExpense travelExpense) throws Exception {
		validateTravelExpenseForUpdateApprover1(travelExpense);
		
		int updatedRow = travelExpenseService.updateApprover1(travelExpense);
		ReturnMessage returnMessage = new ReturnMessage("Successfully Updated Row: " + updatedRow);
		return returnMessage;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/UpdateByApprover2")
	public ReturnMessage UpdateByApprover2(@RequestBody TravelExpense travelExpense) throws Exception {
		validateTravelExpenseForUpdateApprover2(travelExpense);
		
		int updatedRow = travelExpenseService.updateApprover2(travelExpense);
		ReturnMessage returnMessage = new ReturnMessage("Successfully Updated Row: " + updatedRow);
		return returnMessage;
	}

	private void validateTravelExpenseForUpdateApprover1(TravelExpense travelExpense) throws Exception {
		if(travelExpense.getId() == null) {
			throw new Exception("ID is not present");
		}else if(travelExpense.getApprover1() == null) {
			throw new Exception("Approver1 is not present");
		}else if(travelExpense.getExpStatus() == null) {
			throw new Exception("ExpStatus is not present");
		}else if(travelExpense.getApprover1Status() == null) {
			throw new Exception("Approver1Status is not present");
		}
	}
	
	private void validateTravelExpenseForUpdateApprover2(TravelExpense travelExpense) throws Exception {
		if(travelExpense.getId() == null) {
			throw new Exception("ID is not present");
		}else if(travelExpense.getApprover2() == null) {
			throw new Exception("Approver2 is not present");
		}else if(travelExpense.getExpStatus() == null) {
			throw new Exception("ExpStatus is not present");
		}else if(travelExpense.getApprover2Status() == null) {
			throw new Exception("Approver2Status is not present");
		}
	}
	
	private void validateTravelExpenseDetails(TravelExpenseDetails travelExpenseDetails) throws Exception {

		if (travelExpenseDetails == null || travelExpenseDetails.getTravelExpense() == null) {
			throw new Exception("TravelExpenseDetails is not valid");
		}
	}
	
}
