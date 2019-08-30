package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.TravelRequest;
import com.easybusiness.hrmanagement.service.TravelRequestService;
import com.easybusiness.hrmanagement.utils.GenericComparator;
import com.easybusiness.hrmanagement.utils.HRManagementUtils;

@RestController
@RequestMapping("/hrmanagement/travelRequest")
public class TravelRequestController {
	
	@Autowired
	TravelRequestService travelRequestService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/findAll")
	public List<TravelRequest> getAllTravelRequests() throws Exception {
		List<TravelRequest> travelRequestList = travelRequestService.getAll();
		Collections.sort(travelRequestList, new GenericComparator("modifiedDate", false));
		return travelRequestList;
	}


	/**
	 * employeeId is the user for whom request is added. createdBy and employeeId is same.
	 * @param employeeId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/findByEmployeeId/{employeeId}")
	public List<TravelRequest> getTravelRequestByCreatedId(@PathVariable("employeeId") Long employeeId) throws Exception {
		List<TravelRequest> travelRequestList = travelRequestService.findByEmployeeIdOrPendingWith(employeeId);
		Collections.sort(travelRequestList, new GenericComparator("modifiedDate", false));
		return travelRequestList;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/findByCreatedIdPendingStlment/{createdid}")
	public List<TravelRequest> getTravelRequestByCreatedIdPendingStlment(@PathVariable("createdid") Long createdid) throws Exception {
		List<TravelRequest> travelRequestList = travelRequestService.findByCreatedIdForPendingStlmnt(createdid);
		Collections.sort(travelRequestList, new GenericComparator("modifiedDate", false));
		return travelRequestList;
	}
	
	@GetMapping("/findById/{id}")
	public TravelRequest getTravelRequestById(@PathVariable("id") Long id) throws Exception {
		TravelRequest travelRequest = travelRequestService.findById(id);
		return travelRequest;
	}
	
	@GetMapping("/findByTravReqId/{travelReqId}")
	public TravelRequest getTravelRequestByTravelReqId(@PathVariable("travelReqId") String travelReqId) throws Exception {
		TravelRequest travelRequest = travelRequestService.findByTravelRequestID(travelReqId);
		return travelRequest;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTravelRequest")
	public ReturnMessage addTravelRequest(@RequestBody TravelRequest travelRequest) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		travelRequest.setModifiedDate(timestamp);
		travelRequest.setCreatedDate(timestamp);
		String travelReqId = HRManagementUtils.randomAlphaNumeric();
		travelRequest.setTravelRequestID(travelReqId);
		travelRequest.setIsStlmntPending(0);
		travelRequestService.addTravelRequest(travelRequest);
		
		ReturnMessage returnMessage = new ReturnMessage("Travel Request of id " + travelReqId + "created successfully");
		return returnMessage;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateTravelRequest")
	public ReturnMessage updateTravelRequest(@RequestBody TravelRequest travelRequest) throws Exception {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			travelRequest.setModifiedDate(timestamp);
			travelRequest.setIsStlmntPending(0);
			travelRequestService.updateTravelRequest(travelRequest);
			return new ReturnMessage(travelRequest.getTravelRequestID() + " " +HRManagementConstant.UPDATED_SUCCESSFULLY);
	}
}
