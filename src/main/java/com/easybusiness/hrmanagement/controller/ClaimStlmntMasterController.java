package com.easybusiness.hrmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.service.ClaimStlmntSubTypeService;
import com.easybusiness.hrmanagement.service.ClaimStlmntTypeService;
import com.easybusiness.hrmanagement.service.TravelRequestStatusService;

@RestController
@RequestMapping("/hrmanagement/claimStlmnt")
public class ClaimStlmntMasterController {
	
	@Autowired
	ClaimStlmntTypeService claimStlmntTypeService;
	
	@Autowired
	ClaimStlmntSubTypeService claimStlmntSubTypeService;
	
	@Autowired
	TravelRequestStatusService travelRequestStatusService;
	
	@GetMapping("/findAllMaster")
	public Map<String, List<Object>> getAllMasterData() throws Exception {
		
		Map<String, List<Object>> resultMap = new HashMap<>();
		
		List<Object> allClaimStlmntTypeObj = new ArrayList<>();
		List<Object> allClaimStlmntSubTypeObj = new ArrayList<>();
		List<Object> allTravelRequestStatus = new ArrayList<>();
		
		
		claimStlmntTypeService.getAll().forEach(allClaimStlmntTypeObj :: add);
		claimStlmntSubTypeService.getAll().forEach(allClaimStlmntSubTypeObj::add);
		travelRequestStatusService.getAll().forEach(allTravelRequestStatus :: add);
		
		resultMap.put("ClaimStlmntType", allClaimStlmntTypeObj);
		resultMap.put("ClaimStlmntSubType", allClaimStlmntSubTypeObj);
		resultMap.put("TravelRequestStatus", allTravelRequestStatus);
		
		return resultMap;
	}
}
