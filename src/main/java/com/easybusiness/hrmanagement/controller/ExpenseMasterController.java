package com.easybusiness.hrmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.service.ExpenseStlmntService;
import com.easybusiness.hrmanagement.service.TravelAllowanceLimitService;
import com.easybusiness.hrmanagement.service.TravelRequestStatusService;

@RestController
@RequestMapping("/hrmanagement/expense")
public class ExpenseMasterController {
	
	@Autowired
	ExpenseStlmntService expenseStlmntTypeService;
	
	@Autowired
	TravelAllowanceLimitService travelAllowanceLimitService;
	
	@Autowired
	TravelRequestStatusService travelRequestStatusService;
	
	@GetMapping("/findAllMaster")
	public Map<String, List<Object>> getAllMasterData() throws Exception {
		
		Map<String, List<Object>> resultMap = new HashMap<>();
		
		List<Object> allStlmntTypeObj = new ArrayList<>();
		List<Object> allAllowanceLimitObj = new ArrayList<>();
		List<Object> allTravelRequestStatus = new ArrayList<>();
		
		
		expenseStlmntTypeService.getAll().forEach(allStlmntTypeObj :: add);
		travelAllowanceLimitService.getAll().forEach(allAllowanceLimitObj::add);
		travelRequestStatusService.getAll().forEach(allTravelRequestStatus :: add);
		
		resultMap.put("ExpenseStlmntType", allStlmntTypeObj);
		resultMap.put("TravelAllowanceLimit", allAllowanceLimitObj);
		resultMap.put("TravelRequestStatus", allTravelRequestStatus);
		
		return resultMap;
	}
}
