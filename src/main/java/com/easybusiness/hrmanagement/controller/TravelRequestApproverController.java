package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.TravelRequest;
import com.easybusiness.hrmanagement.service.TravelRequestService;

@RestController
@RequestMapping("/hrmanagement")
public class TravelRequestApproverController {
	
	@Autowired
	TravelRequestService travelRequestService;
	
	/**
	 * Update by approver, modified fields to be provided
	 * TravelRequestStatus, PendingWith
	 * 
	 * Fields modified internally
	 * ModifiedDate, ModifiedBy
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/travelApprover")
	public ReturnMessage updateTravelRequestStatus(@RequestBody TravelRequest reqToBeUpdated) throws Exception {
		
		String travelRequestID = reqToBeUpdated.getTravelRequestID();
		
		TravelRequest travelRequestFromDB = travelRequestService.
				findByTravelRequestID(travelRequestID);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		travelRequestFromDB.setModifiedDate(timestamp);
		
		travelRequestFromDB.setTravelRequestStatus
		(reqToBeUpdated.getTravelRequestStatus());
		
		travelRequestFromDB.setIsStlmntPending(0);
		
		travelRequestFromDB.setPendingWith(reqToBeUpdated.getPendingWith());
			
		travelRequestService.updateTravelRequest(travelRequestFromDB);
		
		ReturnMessage returnMessage = new ReturnMessage(travelRequestID + " Updated Successfully");
		return returnMessage;
	}
	
	@GetMapping("/findByApproverId/{pendingWith}")
	public List<TravelRequest> getTravelRequestByApproverId(@PathVariable("pendingWith") Long pendingWith) throws Exception {
		List<TravelRequest> travelRequestList = travelRequestService.findByApproverId(pendingWith);
		return travelRequestList;
	}

}
