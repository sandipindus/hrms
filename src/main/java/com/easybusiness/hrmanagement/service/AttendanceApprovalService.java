package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.AttendanceApproval;
import com.easybusiness.hrmanagement.repository.AttendanceApprovalRepository;

@Service
public class AttendanceApprovalService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceApprovalService.class);
	
	@Autowired
	AttendanceApprovalRepository attendanceApprovalRepository;
	
	public AttendanceApproval createAttandanceApproval(AttendanceApproval attendanceApproval) throws Exception {
		AttendanceApproval save = null;
		try {
			checkRequestBody(attendanceApproval);
			save = attendanceApprovalRepository.save(attendanceApproval);
			LOGGER.debug("Successfully saved data into Table ATTENDENCE_APPROVAL");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return save;
	}
	
	public AttendanceApproval updateAttandanceApproval(AttendanceApproval attendanceApproval) throws Exception {
		AttendanceApproval save = null;
		try {
			checkRequestBody(attendanceApproval);
			save = attendanceApprovalRepository.save(attendanceApproval);
			LOGGER.debug("Successfully saved data into Table ATTENDENCE_APPROVAL");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return save;
	}
	
	public List<AttendanceApproval> getAttendanceApprovalByCreatedID(Long createdId) throws Exception {
		try {
			List<AttendanceApproval> listAttendanceApproval = attendanceApprovalRepository.findByCreatedBy(createdId);
			
			if (CollectionUtils.isEmpty(listAttendanceApproval)) {
				throw new Exception("AttendanceApproval is not present with this cretaed id  " +createdId);
			}
			
			LOGGER.debug("Successfully retrieve AttendanceApproval from Table AttendanceApproval");
			return listAttendanceApproval;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<AttendanceApproval> getAttendanceApprovalByApproverID(Long approverId) throws Exception {
		try {
			
			List<AttendanceApproval> listAttendanceApproval = attendanceApprovalRepository.findByApproverId(approverId);
			
			if (CollectionUtils.isEmpty(listAttendanceApproval)) {
				LOGGER.debug("AttendanceApproval is not present with this approver id  " +approverId);
			}
			
			LOGGER.debug("Successfully retrieve AttendanceApproval from Table AttendanceApproval");
			return listAttendanceApproval;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<AttendanceApproval> findByMonthEmpId(String month, String empId) throws Exception {
		List<AttendanceApproval> attendanceApprovalList = null;

		try {
			attendanceApprovalList = attendanceApprovalRepository.getAttendanceDetailsByMonthEmpId(month, empId);
			LOGGER.debug("Successfully retrieve ATTENDENCE_DETAILS from Table ATTENDENCE_DETAILS by Month " + month + " And empId " + empId);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}

		return attendanceApprovalList;
	}
	
	public List<AttendanceApproval> findByMonthEmpIdWithDateRange(String month, String empId, String startDate, String endDate) throws Exception {
		List<AttendanceApproval> attendanceApprovalList = null;

		try {
			attendanceApprovalList = attendanceApprovalRepository.getAttendanceDetailsByMonthEmpIdWithDaterange(month, empId, startDate, endDate);
			LOGGER.debug("Successfully retrieve ATTENDENCE_DETAILS from Table ATTENDENCE_DETAILS by Month " + month + " And empId " + empId +  "Start date: " + startDate + "End Date: " + endDate);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}

		return attendanceApprovalList;
	}
	
	
	/**
	 * This method check required field for AttendanceApproval
	 * @param attendanceApproval
	 * @throws Exception 
	 */
	private void checkRequestBody(AttendanceApproval attendanceApproval) throws Exception {
		if(attendanceApproval.getInTime() == null || attendanceApproval.getOutTime() == null || attendanceApproval.getReason() == null || attendanceApproval.getReason().isEmpty() || attendanceApproval.getApproverId() == null || attendanceApproval.getApproverStatus() == null || attendanceApproval.getApproverId() == null) {
			throw new Exception(HRManagementConstant.REQ_DOESNOT_HAVE_ALL_REQUIRE_FIELD);
		}
		
	}
}
