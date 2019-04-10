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
import com.easybusiness.hrmanagement.domain.ClaimStlmnt;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.TravelExpense;
import com.easybusiness.hrmanagement.domain.TravelExpenseCostDetails;
import com.easybusiness.hrmanagement.domain.TravelExpenseDetails;
import com.easybusiness.hrmanagement.domain.TravelRequest;
import com.easybusiness.hrmanagement.service.ClaimStlmntService;
import com.easybusiness.hrmanagement.service.TravelExpenseCostDetailsService;
import com.easybusiness.hrmanagement.service.TravelExpenseService;

@RestController
@RequestMapping("/hrmanagement/claimstlmnt")
public class ClaimStlmntController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimStlmntController.class);
	
	@Autowired
	ClaimStlmntService claimStlmntService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addClaimstlmnt")
	public ReturnMessage addTravelExpense(@RequestBody ClaimStlmnt claimStlmnt) throws Exception {
		
		validateClaimStlmntDetails(claimStlmnt);
		
		ClaimStlmnt savedclaimStlmnt = claimStlmntService.addClaimStlmnt(claimStlmnt);
		
		ReturnMessage returnMessage = new ReturnMessage("ClaimStlmnt With ID : " + savedclaimStlmnt.getId() + " "+ HRManagementConstant.ADDED_SUCCESSFULLY);
		return returnMessage;
	}
	
	@GetMapping("/findByCreatedId/{createdid}")
	public List<ClaimStlmnt> getClaimStlmntByCreatedId(@PathVariable("createdid") Long createdid) throws Exception {
		List<ClaimStlmnt> claimStlmntList = claimStlmntService.findByCreatedId(createdid);
		return claimStlmntList;
	}
	
	private void validateClaimStlmntDetails(ClaimStlmnt claimStlmnt) throws Exception {
		if(claimStlmnt.getClaimStlmntTypeId() == null) {
			throw new Exception("CLM_STLMNT_TYPE_ID is not present");
		}else if(claimStlmnt.getClaimStlmntSubTypeId() == null) {
			throw new Exception("CLM_STLMNT_SUB_TYP_ID is not present");
		}else if(claimStlmnt.getTravelDate() == null) {
			throw new Exception("TRAVEL_DATE is not present");
		}else if(claimStlmnt.getDistance() == null) {
			throw new Exception("DISTANCE is not present");
		}else if(claimStlmnt.getTravelFrom() == null) {
			throw new Exception("TRAVEL_FORM is not present");
		}else if(claimStlmnt.getTravelTo() == null) {
			throw new Exception("TRAVEL_TO is not present");
		}else if(claimStlmnt.getDistance() == null) {
			throw new Exception("DISTANCE is not present");
		}else if(claimStlmnt.getAmount()== null) {
			throw new Exception("AMOUNT is not present");
		}else if(claimStlmnt.getCreatedBy() == null) {
			throw new Exception("CREATED_BY is not present");
		}else if(claimStlmnt.getModifiedBy() == null) {
			throw new Exception("MODIFIED_BY is not present");
		}
	}

}
