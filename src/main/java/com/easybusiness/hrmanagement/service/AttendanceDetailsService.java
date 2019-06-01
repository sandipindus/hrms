package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.AttendanceDetails;
import com.easybusiness.hrmanagement.repository.AttendanceDetailsRepository;

@Service
public class AttendanceDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceDetailsService.class);
	
	@Autowired
	AttendanceDetailsRepository attendanceDetailsRepository;
	
	public List<AttendanceDetails> findByFileIdEmpId(Long fileId, String empId) throws Exception {
		List<AttendanceDetails> attnDetailsList = null;

		try {
			attnDetailsList = attendanceDetailsRepository.getAttendanceDetailsByFileIdEmpId(fileId, empId);
			LOGGER.debug("Successfully retrieve Attendance Details from Table ATTENDENCE_DETAILS by fileId " + fileId + " And empId " + empId);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}

		return attnDetailsList;
	}
	
	public List<AttendanceDetails> findByFileIdEmpIdDateRange(Long fileId, String empId, String startDate, String endDate) throws Exception {
		List<AttendanceDetails> attnDetailsList = null;

		try {
			attnDetailsList = attendanceDetailsRepository.getAttendanceDetailsByFileIdEmpIdDateRange(fileId, empId, startDate, endDate);
			LOGGER.debug("Successfully retrieve Attendance Details from Table ATTENDENCE_DETAILS by fileId " + fileId + " And empId " + empId + "Start date: " + startDate + "End Date: " + endDate);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}

		return attnDetailsList;
	}
}
