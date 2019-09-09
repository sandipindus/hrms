package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.easybusiness.hrmanagement.utils.GenericComparator;

@RestController
@RequestMapping("/hrmanagement/Attendence")
public class AttendanceController {

	
	@Autowired
	AttendanceDetailsService attendanceDetailsService;

	@Autowired
	AttendanceFileDetailsService attendanceFileDetailsService;
	
	@Autowired
	AttendanceApprovalService attendanceApprovalService;

	@SuppressWarnings("unchecked")
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
	public ReturnMessage createAttendanceApproval(@RequestBody AttendanceApproval attendanceApproval) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		attendanceApproval.setModifiedDate(timestamp);
		attendanceApproval.setCreatedDate(timestamp);
		AttendanceApproval createAttandanceApproval = attendanceApprovalService.createAttandanceApproval(attendanceApproval);
		ReturnMessage msg = new ReturnMessage("AttendanceApproval with id: " + createAttandanceApproval.getId() + HRManagementConstant.ADDED_SUCCESSFULLY);
		return msg;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateAttendanceApproval")
	public ReturnMessage updateAttendanceApproval(@RequestBody AttendanceApproval attendanceApproval) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		attendanceApproval.setModifiedDate(timestamp);
		AttendanceApproval createAttandanceApproval = attendanceApprovalService.updateAttandanceApproval(attendanceApproval);
		ReturnMessage msg = new ReturnMessage("AttendanceApproval with id: " + createAttandanceApproval.getId() + HRManagementConstant.UPDATED_SUCCESSFULLY);
		return msg;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/findByCreatedId/{createdid}")
	public List<AttendanceApproval> getAttendanceApprovalByCreatedId(@PathVariable("createdid") Long createdid) throws Exception {
		List<AttendanceApproval> listAttendanceApproval = attendanceApprovalService.getAttendanceApprovalByCreatedID(createdid);
		Collections.sort(listAttendanceApproval, new GenericComparator("modifiedDate", false));
		return listAttendanceApproval;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/findByApproverId/{pendingWith}/directApprover/{directApprover}")
	public List<AttendanceApproval> getAttendanceApprovalByApproverId(@PathVariable("pendingWith") Long pendingWith, @PathVariable("directApprover") Long directApprover) throws Exception {
		List<AttendanceApproval> listAttendanceApproval = attendanceApprovalService.getAttendanceApprovalByPendingWith(pendingWith, directApprover);
		Collections.sort(listAttendanceApproval, new GenericComparator("modifiedDate", false));
		return listAttendanceApproval;
	}
	
	
	/**
	 * startDate endDate should be in dd-Month-yyyy 07-JULY-2019 format
	 * @param empId
	 * @param month
	 * @param year
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/findAllAttendanceDetailsForTimeSheet/emp/{empId}/startDate/{startDate}/endDate/{endDate}")
	public List<AttendanceDetails> getAttendanceDetailsListForTimeSheet(@PathVariable("empId") String empId,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws Exception {
		
		String startDateDay = startDate.split("-")[0];
		String startDateMonth = startDate.split("-")[1];
		String startDateYear = startDate.split("-")[2];
		
		String endDateDay = endDate.split("-")[0];
		String endDateMonth = endDate.split("-")[1];
		String endDateYear = endDate.split("-")[2];
		
		String endMonthDate = null;
		List<AttendanceApproval> attendanceApprovalList = null;		
		List<Long> fileIds = new ArrayList<>();
		
		//If both months are same then years are also same.
		if (startDateMonth.equals(endDateMonth)) {
			fileIds.add(attendanceFileDetailsService.getFileId(startDateMonth.toUpperCase(), startDateYear));
		} else {
			fileIds.add(attendanceFileDetailsService.getFileId(startDateMonth.toUpperCase(), startDateYear));
			fileIds.add(attendanceFileDetailsService.getFileId(endDateMonth.toUpperCase(), endDateYear));
		}
		
		List<AttendanceDetails> attendanceDetailsList = null;
		
		if (null != fileIds && !fileIds.isEmpty()) {
			
			if (fileIds.size() ==1) {
				attendanceDetailsList = attendanceDetailsService.findByFileIdEmpIdDateRange(fileIds.get(0), empId, startDate, endDate);
			} else {
				endMonthDate = getEndMonthDate(startDate);
				attendanceDetailsList = attendanceDetailsService.findByFileIdEmpIdDateRange(fileIds.get(0), empId, startDateDay, endMonthDate);
				attendanceDetailsList.addAll(attendanceDetailsService.findByFileIdEmpIdDateRange(fileIds.get(1), empId, "1", endDateDay));
			}
			
		} else {
			throw new Exception("FileID Not found in ATTENDENCE_FILE_DETAILS for month: " + startDateMonth + " Year: " + startDateYear + " and given Date Range startDate:" + startDate +" endDate:" + endDate );
		}
		
		if (CollectionUtils.isEmpty(attendanceDetailsList)) {
			throw new Exception("Attendance Details Not found");
		}
		
		if (!StringUtils.isEmpty(endMonthDate)) {
			attendanceApprovalList = attendanceApprovalService.findByMonthEmpIdWithDateRange(startDateMonth, empId, startDateDay, endMonthDate);
			attendanceApprovalList.addAll(attendanceApprovalService.findByMonthEmpIdWithDateRange(endDateMonth, empId, "1", endDateDay));
		} else {
			attendanceApprovalList = attendanceApprovalService.findByMonthEmpIdWithDateRange(startDateMonth, empId, startDateDay, endDateDay);
		}
		
		
		if(!CollectionUtils.isEmpty(attendanceApprovalList)) {
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
		Collections.sort(attendanceDetailsList, new GenericComparator("modifiedDate", false));
		return attendanceDetailsList;
	}


	private String getEndMonthDate(String startDate) {
		Date today = new Date(startDate);  

        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(today);  

        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        Date lastDayOfMonth = calendar.getTime();

        DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");  
        return sdf.format(lastDayOfMonth).split("-")[0];
	}

	private List<AttendanceDetails> getAttendanceDetailsByFileIdEmpId(Long fileId, String empId) throws Exception {

		return attendanceDetailsService.findByFileIdEmpId(fileId, empId);

	}
	
	private List<AttendanceApproval> getAttendanceDetailsByMonthEmpId(String month, String empId) throws Exception {

		return attendanceApprovalService.findByMonthEmpId(month, empId);

	}

}
