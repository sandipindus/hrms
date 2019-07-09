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
import com.easybusiness.hrmanagement.domain.LeaveTransactionDetails;
import com.easybusiness.hrmanagement.pojo.ApplyLeavePojo;
import com.easybusiness.hrmanagement.repository.ApplyLeaveStoredProcedure;
import com.easybusiness.hrmanagement.service.LeaveBalanceService;
import com.easybusiness.hrmanagement.service.LeaveTransactionDetailsService;

@RestController
@RequestMapping("/hrmanagement/leave")
public class LeaveController {
	
	@Autowired
	ApplyLeaveStoredProcedure applyLeaveStoredProcedure;
	
	@Autowired
	LeaveBalanceService leaveBalanceService;
	
	@Autowired
	LeaveTransactionDetailsService leaveTransactionDetailsService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/applyLeave")
	public void applyLeave(@RequestBody ApplyLeavePojo applyLeavePojo) {
		applyLeaveStoredProcedure.applyLeave(applyLeavePojo);
	}
	
	@GetMapping("/leaveBalanceByUserId/{userId}")
	public List<LeaveBalanceDetails> getLeaveBalanceByUserId(@PathVariable("userId") Long userId) throws Exception {
		List<LeaveBalanceDetails> leaveBalanceDetailsList = leaveBalanceService.findByUserId(userId);
		return leaveBalanceDetailsList;
	}
	
	@GetMapping("/leaveTransactionDetailsByUserId/{userId}")
	public List<LeaveTransactionDetails> getLeaveTransactionDetailsByUserId(@PathVariable("userId") Long userId) throws Exception {
		List<LeaveTransactionDetails> leaveTransactionDetailsList = leaveTransactionDetailsService.findByUserId(userId);
		return leaveTransactionDetailsList;
	}
	
}
