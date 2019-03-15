package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.TravelRequest;
import com.easybusiness.hrmanagement.service.TravelRequestService;

@RestController
@RequestMapping("/hrmanagement")
public class TravelRequestApproverController {
	
	@Autowired
	TravelRequestService travelRequestService;
	
	/**
	 * Update by approver, modified fields to be provided
	 * TravelRequestStatus, Approver1Status
	 * 
	 * Fields modified internally
	 * ModifiedDate, ModifiedBy
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/travelApprover")
	public String updateTravelRequestStatus(@RequestBody TravelRequest reqToBeUpdated,
			@RequestParam("APPROVER") String approver) throws Exception {
		
		String travelRequestID = reqToBeUpdated.getTravelRequestID();
		
		TravelRequest travelRequestFromDB = travelRequestService.
				findByTravelRequestID(travelRequestID);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		travelRequestFromDB.setModifiedDate(timestamp);
		
		travelRequestFromDB.setTravelRequestStatus
		(reqToBeUpdated.getTravelRequestStatus());
		
		if(HRManagementConstant.APPROVER1.equals(approver)) {
			travelRequestFromDB.setApprover1Status(reqToBeUpdated.getApprover1Status());
			travelRequestFromDB.setModifiedBy(travelRequestFromDB.getApprover1());
		} else {
			travelRequestFromDB.setApprover2Status(reqToBeUpdated.getApprover2Status());
			travelRequestFromDB.setModifiedBy(travelRequestFromDB.getApprover2());
		}
		
		travelRequestService.updateTravelRequest(travelRequestFromDB);
		
		return travelRequestID + " Updated Successfully";
	}

}
