package com.easybusiness.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.pojo.ApplyLeavePojo;
import com.easybusiness.hrmanagement.repository.ApplyLeaveStoredProcedure;

@RestController
@RequestMapping("/hrmanagement/leave")
public class LeaveController {
	
	@Autowired
	ApplyLeaveStoredProcedure applyLeaveStoredProcedure;
	
	@RequestMapping(method = RequestMethod.POST, value = "/applyLeave")
	public void applyLeave(@RequestBody ApplyLeavePojo applyLeavePojo) {
		applyLeaveStoredProcedure.applyLeave(applyLeavePojo);
	}
	
	
}
