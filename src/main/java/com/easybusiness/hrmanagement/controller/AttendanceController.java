package com.easybusiness.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.service.AttendanceDetailsService;

@RestController
@RequestMapping("/hrmanagement/Attendence")
public class AttendanceController {
	
	
	@Autowired
	AttendanceDetailsService attendanceDetailsService;
	
	private void getAttendanceDetailsByFileIdEmpId(Long fileId, Long empId) throws Exception {
		
		attendanceDetailsService.findByFileIdEmpId(fileId, empId);
		
	}
	
}
