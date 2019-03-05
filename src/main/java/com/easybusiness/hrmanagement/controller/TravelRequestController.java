package com.easybusiness.hrmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.TravelRequest;
import com.easybusiness.hrmanagement.service.TravelRequestService;

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
	
	@RequestMapping(method=RequestMethod.POST, value="/addTravelRequest")
	public void addTravelRequest(@RequestBody TravelRequest travelRequest) throws Exception {
		travelRequestService.addTravelRequest(travelRequest);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateTravelRequest")
	public void updateTravelRequest(@RequestBody TravelRequest travelRequest) throws Exception {
		travelRequestService.updateTravelRequest(travelRequest);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteTravelRequest/{id}")
	public void deleteTravelRequest(@PathVariable("id") Long id) throws Exception {
		travelRequestService.deleteTravelRequest(id);
	}
}
