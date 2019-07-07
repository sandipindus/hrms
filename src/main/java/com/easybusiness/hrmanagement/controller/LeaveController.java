package com.easybusiness.hrmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.LeaveBalanceDetails;
import com.easybusiness.hrmanagement.pojo.ApplyLeavePojo;
import com.easybusiness.hrmanagement.repository.ApplyLeaveStoredProcedure;
import com.easybusiness.hrmanagement.service.LeaveBalanceService;

@RestController
@RequestMapping("/hrmanagement/leave")
public class LeaveController {
	
	@Autowired
	ApplyLeaveStoredProcedure applyLeaveStoredProcedure;
	
	@Autowired
	LeaveBalanceService leaveBalanceService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/applyLeave")
	public void applyLeave(@RequestBody ApplyLeavePojo applyLeavePojo) {
		applyLeaveStoredProcedure.applyLeave(applyLeavePojo);
	}
	
	@GetMapping("/LeaveBalanceByUserId/{userId}")
	public List<LeaveBalanceDetails> getLeaveBalanceByUserId(@PathVariable("userId") Long userId) throws Exception {
		List<LeaveBalanceDetails> leaveBalanceDetailsList = leaveBalanceService.findByUserId(userId);
		return leaveBalanceDetailsList;
	}
	
}
