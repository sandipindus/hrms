package com.easybusiness.hrmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.AttendanceDetails;
import com.easybusiness.hrmanagement.service.AttendanceDetailsService;
import com.easybusiness.hrmanagement.service.AttendanceFileDetailsService;

@RestController
@RequestMapping("/hrmanagement/Attendence")
public class AttendanceController {

	@Autowired
	AttendanceDetailsService attendanceDetailsService;

	@Autowired
	AttendanceFileDetailsService attendanceFileDetailsService;

	@GetMapping("/findAllAttendanceDetails/emp/{empId}/month/{month}/year/{year}")
	public List<AttendanceDetails> getAttendanceDetailsList(@PathVariable("empId") Long empId,
			@PathVariable("month") String month, @PathVariable("year") String year) throws Exception {
		
		List<AttendanceDetails> attendanceDetailsList = null;
		Long fileId = attendanceFileDetailsService.getFileId(month, year);
		
		if (null != fileId) {
			attendanceDetailsList = getAttendanceDetailsByFileIdEmpId(fileId, empId);
		}
		
		if (CollectionUtils.isEmpty(attendanceDetailsList)) {
			throw new Exception("Attendance Details Not found");
		}
		return attendanceDetailsList;
	}

	private List<AttendanceDetails> getAttendanceDetailsByFileIdEmpId(Long fileId, Long empId) throws Exception {

		return attendanceDetailsService.findByFileIdEmpId(fileId, empId);

	}

}
