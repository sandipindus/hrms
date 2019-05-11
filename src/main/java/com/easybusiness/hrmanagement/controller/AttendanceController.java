package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.AttendanceApproval;
import com.easybusiness.hrmanagement.domain.AttendanceDetails;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.service.AttendanceApprovalService;
import com.easybusiness.hrmanagement.service.AttendanceDetailsService;
import com.easybusiness.hrmanagement.service.AttendanceFileDetailsService;

@RestController
@RequestMapping("/hrmanagement/Attendence")
public class AttendanceController {

	
	@Autowired
	AttendanceDetailsService attendanceDetailsService;

	@Autowired
	AttendanceFileDetailsService attendanceFileDetailsService;
	
	@Autowired
	AttendanceApprovalService attendanceApprovalService;

	@GetMapping("/findAllAttendanceDetails/emp/{empId}/month/{month}/year/{year}")
	public List<AttendanceDetails> getAttendanceDetailsList(@PathVariable("empId") String empId,
			@PathVariable("month") String month, @PathVariable("year") String year) throws Exception {
		
		List<AttendanceDetails> attendanceDetailsList = null;
		Long fileId = attendanceFileDetailsService.getFileId(month, year);
		
		if (null != fileId) {
			attendanceDetailsList = getAttendanceDetailsByFileIdEmpId(fileId, empId);
		} else {
			throw new Exception("FileID Not found in ATTENDENCE_FILE_DETAILS for month: " + month + " Year: " + year);
		}
		
		if (CollectionUtils.isEmpty(attendanceDetailsList)) {
			throw new Exception("Attendance Details Not found");
		}
		
		
		List<AttendanceApproval> attendanceApprovalList = getAttendanceDetailsByMonthEmpId(month, empId);
		
		if(!CollectionUtils.isEmpty(attendanceApprovalList)) {
			//To do compare 2 list
			Map<String, AttendanceDetails> dateAttendanceDetailsMap = new HashMap<>();
			
			for (AttendanceDetails eachAttendanceDetails : attendanceDetailsList) {
				dateAttendanceDetailsMap.put(eachAttendanceDetails.getAttendanceDate(), eachAttendanceDetails);
			}
			
			for (AttendanceApproval eachAttendanceApproval : attendanceApprovalList) {
				AttendanceDetails attendanceDetailsToBeUpdated = dateAttendanceDetailsMap.get(eachAttendanceApproval.getAttendanceDate());
				
				attendanceDetailsToBeUpdated.setInTime(eachAttendanceApproval.getInTime());
				attendanceDetailsToBeUpdated.setOutTime(eachAttendanceApproval.getOutTime());
			}
		}
		
		return attendanceDetailsList;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/createAttendanceApproval")
	public ReturnMessage createAttendanceApproval(AttendanceApproval attendanceApproval) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		attendanceApproval.setModifiedDate(timestamp);
		attendanceApproval.setCreatedDate(timestamp);
		AttendanceApproval createAttandanceApproval = attendanceApprovalService.createAttandanceApproval(attendanceApproval);
		ReturnMessage msg = new ReturnMessage("AttendanceApproval with id: " + createAttandanceApproval.getId() + HRManagementConstant.ADDED_SUCCESSFULLY);
		return msg;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateAttendanceApproval")
	public ReturnMessage updateAttendanceApproval(AttendanceApproval attendanceApproval) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		attendanceApproval.setModifiedDate(timestamp);
		AttendanceApproval createAttandanceApproval = attendanceApprovalService.updateAttandanceApproval(attendanceApproval);
		ReturnMessage msg = new ReturnMessage("AttendanceApproval with id: " + createAttandanceApproval.getId() + HRManagementConstant.UPDATED_SUCCESSFULLY);
		return msg;
	}
	
	@GetMapping("/findByCreatedId/{createdid}")
	public List<AttendanceApproval> getAttendanceApprovalByCreatedId(@PathVariable("createdid") Long createdid) throws Exception {
		List<AttendanceApproval> listAttendanceApproval = attendanceApprovalService.getAttendanceApprovalByCreatedID(createdid);
		return listAttendanceApproval;
	}
	
	@GetMapping("/findByApproverId/{approverId}")
	public List<AttendanceApproval> getAttendanceApprovalByApproverId(@PathVariable("approverId") Long approverId) throws Exception {
		List<AttendanceApproval> listAttendanceApproval = attendanceApprovalService.getAttendanceApprovalByApproverID(approverId);
		return listAttendanceApproval;
	}


	private List<AttendanceDetails> getAttendanceDetailsByFileIdEmpId(Long fileId, String empId) throws Exception {

		return attendanceDetailsService.findByFileIdEmpId(fileId, empId);

	}
	
	private List<AttendanceApproval> getAttendanceDetailsByMonthEmpId(String month, String empId) throws Exception {

		return attendanceApprovalService.findByMonthEmpId(month, empId);

	}

}
