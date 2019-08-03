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
import com.easybusiness.hrmanagement.domain.ReturnMessage;
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


	@GetMapping("/findByEmployeeId/{employeeId}")
	public List<TravelRequest> getTravelRequestByCreatedId(@PathVariable("employeeId") Long employeeId) throws Exception {
		List<TravelRequest> travelRequestList = travelRequestService.findByEmployeeId(employeeId);
		return travelRequestList;
	}
	
	@GetMapping("/findByCreatedIdPendingStlment/{createdid}")
	public List<TravelRequest> getTravelRequestByCreatedIdPendingStlment(@PathVariable("createdid") Long createdid) throws Exception {
		List<TravelRequest> travelRequestList = travelRequestService.findByCreatedIdForPendingStlmnt(createdid);
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
	public ReturnMessage updateTravelRequest(@RequestBody TravelRequest travelRequest, @RequestParam("UPDATE_FLOW") String updateFlow) throws Exception {
		
		// Normal update along with full form details
		if(updateFlow.equalsIgnoreCase(HRManagementConstant.TRAVEL_REQUEST_UPDATE)) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			travelRequest.setModifiedDate(timestamp);
			travelRequest.setIsStlmntPending(0);
			travelRequestService.updateTravelRequest(travelRequest);
			return new ReturnMessage(travelRequest.getTravelRequestID() + " " +HRManagementConstant.UPDATED_SUCCESSFULLY);
		}else if(updateFlow.equalsIgnoreCase(HRManagementConstant.TRAVEL_REQUEST_APPROVE)){
			
			TravelRequest travelRequestDB = travelRequestService.findByTravelRequestID(travelRequest.getTravelRequestID());
			if(null!= travelRequest.getPendingWith()) {
				travelRequestDB.setPendingWith(travelRequest.getPendingWith());
			}
			
			travelRequestDB.setIsStlmntPending(0);
			
			travelRequestDB.setTravelRequestStatus(travelRequest.getTravelRequestStatus());
			travelRequestDB.setModifiedBy(travelRequest.getModifiedBy());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			travelRequestDB.setModifiedDate(timestamp);
			travelRequestDB.setIsDeleted(travelRequest.getIsDeleted());
			
			travelRequestService.updateTravelRequest(travelRequestDB);
			
			return new ReturnMessage(travelRequest.getTravelRequestID() + " " +HRManagementConstant.UPDATED_SUCCESSFULLY);
			
		}else if(updateFlow.equalsIgnoreCase(HRManagementConstant.TRAVEL_REQUEST_DELETE)) {
			
			TravelRequest travelRequestDB = travelRequestService.findByTravelRequestID(travelRequest.getTravelRequestID());
			
			travelRequestDB.setTravelRequestStatus(travelRequest.getTravelRequestStatus());
			travelRequestDB.setModifiedBy(travelRequest.getModifiedBy());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			travelRequestDB.setModifiedDate(timestamp);
			travelRequestDB.setIsDeleted(1);
			
			travelRequestService.updateTravelRequest(travelRequestDB);
			
			return new ReturnMessage(travelRequest.getTravelRequestID() + " " +HRManagementConstant.DELETED_SUCCESSFULLY);
		}
		
		return null;
	}
	
	/*@RequestMapping(method=RequestMethod.DELETE, value="/deleteTravelRequest/{id}")
	public void deleteTravelRequest(@PathVariable("id") Long id) throws Exception {
		travelRequestService.deleteTravelRequest(id);
	}*/
}
