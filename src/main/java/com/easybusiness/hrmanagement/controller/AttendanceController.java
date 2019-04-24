package com.easybusiness.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.service.AttendanceDetailsService;

@RestController
@RequestMapping("/hrmanagement/Attendence")
public class AttendanceController {
	
	
	@Autowired
	AttendanceDetailsService attendanceDetailsService;
	
	@GetMapping("/findByFileIdEmpId/file/{fileId}/emp/{empId}")
	public void getAttendanceDetailsByFileIdEmpId(@PathVariable("fileId") Long fileId, @PathVariable("empId") Long empId) throws Exception {
		attendanceDetailsService.findByFileIdEmpId(fileId, empId);
		
	}
	
}
