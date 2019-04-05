package com.easybusiness.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.TravelExpense;
import com.easybusiness.hrmanagement.service.TravelExpenseService;

@RestController
@RequestMapping("/hrmanagement/expense")
public class TravelExpenseController {
	
	@Autowired
	TravelExpenseService travelExpenseService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addTravelExpense")
	public ReturnMessage addTravelExpense(@RequestBody TravelExpense travelExpense) throws Exception {
		//travelExpense.setId(new Long(1111));
		TravelExpense savedTravelExpense = travelExpenseService.addTravelExpense(travelExpense);
		
		ReturnMessage returnMessage = new ReturnMessage(savedTravelExpense.getId().toString());
		return returnMessage;
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
	
}
