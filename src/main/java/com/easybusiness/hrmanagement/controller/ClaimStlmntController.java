package com.easybusiness.hrmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.ClaimStlmnt;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.service.ClaimStlmntService;

@RestController
@RequestMapping("/hrmanagement/claimStlmnt")
public class ClaimStlmntController {
	
	@Autowired
	ClaimStlmntService claimStlmntService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addClaimstlmnt")
	public ReturnMessage addClaimStlmnt(@RequestBody ClaimStlmnt claimStlmnt) throws Exception {
		
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
	
	@RequestMapping(method=RequestMethod.PUT, value="/UpdateByApprover1")
	public ReturnMessage UpdateByApprover1(@RequestBody ClaimStlmnt claimStlmnt) throws Exception {
		validateClaimStlmntForUpdateApprover1(claimStlmnt);
		
		int updatedRow = claimStlmntService.updateApprover1(claimStlmnt);
		ReturnMessage returnMessage = new ReturnMessage("Successfully Updated Row: " + updatedRow);
		return returnMessage;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/UpdateByApprover2")
	public ReturnMessage UpdateByApprover2(@RequestBody ClaimStlmnt claimStlmnt) throws Exception {
		validateClaimStlmntForUpdateApprover2(claimStlmnt);
		
		int updatedRow = claimStlmntService.updateApprover2(claimStlmnt);
		ReturnMessage returnMessage = new ReturnMessage("Successfully Updated Row: " + updatedRow);
		return returnMessage;
	}
	
	private void validateClaimStlmntForUpdateApprover1 (ClaimStlmnt claimStlmnt) throws Exception {
		if(claimStlmnt.getId() == null) {
			throw new Exception("ID is not present");
		} else if(claimStlmnt.getApprover1() == null) {
			throw new Exception("Approver1 is not present");
		} else if(claimStlmnt.getFinalStatus() == null) {
			throw new Exception("ExpStatus is not present");
		} else if(claimStlmnt.getApprover1Status() == null) {
			throw new Exception("Approver1Status is not present");
		}
	}
	
	private void validateClaimStlmntForUpdateApprover2(ClaimStlmnt claimStlmnt) throws Exception {
		if(claimStlmnt.getId() == null) {
			throw new Exception("ID is not present");
		}else if(claimStlmnt.getApprover2() == null) {
			throw new Exception("Approver2 is not present");
		}else if(claimStlmnt.getFinalStatus() == null) {
			throw new Exception("ExpStatus is not present");
		}else if(claimStlmnt.getApprover2Status() == null) {
			throw new Exception("Approver2Status is not present");
		}
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
		}else if(claimStlmnt.getApprover1() == null) {
			throw new Exception("Approver1 is not present");
		}else if(claimStlmnt.getApprover2() == null) {
			throw new Exception("Approver2 is not present");
		}
	}

}
