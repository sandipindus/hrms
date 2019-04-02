package com.easybusiness.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
}
