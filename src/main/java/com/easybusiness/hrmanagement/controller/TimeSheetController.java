package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.Timesheet;
import com.easybusiness.hrmanagement.service.TimesheetService;

@RestController
@RequestMapping("/hrmanagement/timesheet")
public class TimeSheetController {
	
	@Autowired
	TimesheetService timesheetService;

	@RequestMapping(method=RequestMethod.POST, value="/addTimesheet")
	public ReturnMessage addTimeSheet(@RequestBody List<Timesheet> timesheetList) throws Exception {
		
		for (Timesheet eachTimesheet : timesheetList) {
			validateTimeSheet(eachTimesheet);
		}
		
		for (Timesheet eachTimesheet : timesheetList) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			eachTimesheet.setCreatedDate(timestamp);
			eachTimesheet.setModifiedDate(timestamp);
			timesheetService.addTimesheet(eachTimesheet);
		}
		
		return new ReturnMessage("Timesheet details added successfully");
		
	}

	@GetMapping("/findTimesheet/empId/{empId}/year/{year}/dayRange/{dayRange}")
	public List<Timesheet> getTimesheetByDayRangeEmpIdYear(@PathVariable("empId") Long empId,
			@PathVariable("dayRange") String dayRange, @PathVariable("year") Long year) throws Exception {
		List<Timesheet> timesheetList = timesheetService.getTimesheetByDayRangeEmpIdYear(dayRange, year, empId);
		return timesheetList;
	}
	
	@GetMapping("/findTimesheet/empId/{empId}/year/{year}")
	public List<Timesheet> getTimesheetByEmpId(@PathVariable("empId") Long empId, @PathVariable("year") Long year) throws Exception {
		List<Timesheet> timesheetList = timesheetService.getTimesheetByDayRangeEmpIdYear(null, year, empId);
		return timesheetList;
	}

	@GetMapping("/findTimesheet/approverId/{pendingWith}/directApprover/{directApprover}")
	public List<Timesheet> getTimesheetByPendingWith(@PathVariable("pendingWith") Long pendingWith, @PathVariable("directApprover") Long directApprover) throws Exception {
		
		List<Timesheet> timesheetList = timesheetService.getTimesheetByPendingWithOrDirectApprover(pendingWith, directApprover);
		return timesheetList;
	}
	
	/**
	 * @param timesheetList
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/updateTimesheet")
	public ReturnMessage updateTimesheetApproval(@RequestBody List<Timesheet> timesheetList) throws Exception {
		
		for (Timesheet eachTimesheet : timesheetList) {
			
			//If isDeleted flag is true for any timesheet. then we will hard delete this row from db.
			if (Boolean.TRUE.equals(eachTimesheet.getIsDeleted())) {
				timesheetService.deleteTimesheet(eachTimesheet);
				continue;
			}
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			eachTimesheet.setModifiedDate(timestamp);
			timesheetService.updateTimesheet(eachTimesheet);
		}
		
		ReturnMessage msg = new ReturnMessage("Timesheet " + HRManagementConstant.UPDATED_SUCCESSFULLY);
		return msg;
	}
	
	private void validateTimeSheet(Timesheet timesheet) throws Exception {

		if (timesheet == null || timesheet.getEmpId() == null) {
			throw new Exception("EmpId is not present in timesheet");
		} else if (timesheet.getYear() == null) {
			throw new Exception("YEAR is not present in timesheet");
		} else if (timesheet.getDayRange() == null) {
			throw new Exception("DayRange is not present in timesheet");
		} else if (timesheet.getPendingWith() == null) {
			throw new Exception("PendingWith is not present in timesheet");
		} else if (timesheet.getRequestStatus() == null) {
			throw new Exception("RequestStatus is not present in timesheet");
		}
	}
}
