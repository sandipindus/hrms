package com.easybusiness.hrmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.TravelRequest;
import com.easybusiness.hrmanagement.service.TravelRequestService;

@RestController
@RequestMapping("/hrmanagement")
public class TravelRequestApproverController {
	
	@Autowired
	TravelRequestService travelRequestService;
	
	@GetMapping("/findByApproverId/{pendingWith}/directApprover/{directApprover}")
	public List<TravelRequest> getTravelRequestByApproverId(@PathVariable("pendingWith") Long pendingWith, @PathVariable("directApprover") Long directApprover) throws Exception {
		List<TravelRequest> travelRequestList = travelRequestService.findByApproverId(pendingWith, directApprover);
		return travelRequestList;
	}

}
