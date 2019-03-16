package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.TravelRequest;
import com.easybusiness.hrmanagement.service.TravelRequestService;
import com.easybusiness.hrmanagement.utils.HRManagementUtils;

@RestController
@RequestMapping("/hrmanagement/travelRequest")
public class TravelRequestController {
	
	@Autowired
	TravelRequestService travelRequestService;
	
	@GetMapping("/findAll")
	public List<TravelRequest> getAllTravelRequests() throws Exception {
		List<TravelRequest> travelRequestList = travelRequestService.getAll();
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
	public String addTravelRequest(@RequestBody TravelRequest travelRequest) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		travelRequest.setModifiedDate(timestamp);
		travelRequest.setCreatedDate(timestamp);
		String travelReqId = HRManagementUtils.randomAlphaNumeric();
		travelRequest.setTravelRequestID(travelReqId);
		
		travelRequestService.addTravelRequest(travelRequest);
		
		return travelReqId;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateTravelRequest")
	public void updateTravelRequest(@RequestBody TravelRequest travelRequest, @RequestParam("UPDATE_FLOW") String updateFlow) throws Exception {
		
		// Normal update along with full form details
		if(updateFlow.equalsIgnoreCase(HRManagementConstant.TRAVEL_REQUEST_UPDATE)) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			travelRequest.setModifiedDate(timestamp);
			travelRequestService.updateTravelRequest(travelRequest);
		}else if(updateFlow.equalsIgnoreCase(HRManagementConstant.TRAVEL_REQUEST_APPROVE)){
			
			TravelRequest travelRequestDB = travelRequestService.findById(travelRequest.getId());
			
			travelRequestDB.setApprover1(travelRequest.getApprover1());
			travelRequestDB.setApprover1Status(travelRequest.getApprover1Status());
			travelRequestDB.setApprover2(travelRequest.getApprover2());
			travelRequestDB.setApprover2Status(travelRequest.getApprover2Status());
			travelRequestDB.setTravelRequestStatus(travelRequest.getTravelRequestStatus());
			travelRequestDB.setModifiedBy(travelRequest.getModifiedBy());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			travelRequestDB.setModifiedDate(timestamp);
			travelRequestDB.setIsDeleted(travelRequest.getIsDeleted());
			
			travelRequestService.updateTravelRequest(travelRequestDB);
			
		}else if(updateFlow.equalsIgnoreCase(HRManagementConstant.TRAVEL_REQUEST_DELETE)) {
			
			TravelRequest travelRequestDB = travelRequestService.findById(travelRequest.getId());
			
			travelRequestDB.setTravelRequestStatus(travelRequest.getTravelRequestStatus());
			travelRequestDB.setModifiedBy(travelRequest.getModifiedBy());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			travelRequestDB.setModifiedDate(timestamp);
			travelRequestDB.setIsDeleted(1);
			
			travelRequestService.updateTravelRequest(travelRequestDB);
		}
	}
	
	/*@RequestMapping(method=RequestMethod.DELETE, value="/deleteTravelRequest/{id}")
	public void deleteTravelRequest(@PathVariable("id") Long id) throws Exception {
		travelRequestService.deleteTravelRequest(id);
	}*/
}
