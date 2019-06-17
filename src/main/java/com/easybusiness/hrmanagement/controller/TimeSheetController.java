package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@GetMapping("/findTimesheet/approverId/{approverId}")
	public List<Timesheet>/*Map<Long, List<Timesheet>>*/ getTimesheetByApproverID(@PathVariable("approverId") Long approverId) throws Exception {
		
		Map<Long, List<Timesheet>> timesheetApprovalWiseMap = new HashMap<>();
		List<Timesheet> timesheetList = timesheetService.getTimesheetByApproverId(approverId);
		
		/*for (Timesheet eachTimesheet : timesheetList) {
			
			if (null == timesheetApprovalWiseMap.get(eachTimesheet.getEmpId())) {
				List<Timesheet> timesheetListEmpWise = new ArrayList<>();
				timesheetListEmpWise.add(eachTimesheet);
				timesheetApprovalWiseMap.put(eachTimesheet.getEmpId(), timesheetListEmpWise);
			} else {
				timesheetApprovalWiseMap.get(eachTimesheet.getEmpId()).add(eachTimesheet);
			}
		}*/
		
		return timesheetList;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateTimesheet")
	public ReturnMessage updateTimesheetApproval(@RequestBody List<Timesheet> timesheetList) throws Exception {
		
		for (Timesheet eachTimesheet : timesheetList) {
			timesheetService.updateTimesheet(eachTimesheet);
		}
		
		ReturnMessage msg = new ReturnMessage("Timesheet " + HRManagementConstant.UPDATED_SUCCESSFULLY);
		return msg;
	}
	
	@GetMapping("/f")
	public List<Timesheet> getTimesheetFirst() {
		List<Timesheet> list = new ArrayList<>();
		
		Timesheet ts = new Timesheet();
		ts.setId(new Long(1));
		ts.setEmpId(new Long(100));
		ts.setProjectNumber(new Long(1));
		ts.setProjectTypeID(new Long(2));
		ts.setTaskId(new Long(2));
		ts.setYear(new Long(19));
		ts.setDayRange("JUNE-10-14");
		ts.setHourMon(new Long(8));
		ts.setHourTue(new Long(8));
		ts.setApproverId(new Long(200));
		ts.setApproveStatus(new Long(0));
		ts.setCreatedBy(new Long(100));
		ts.setModifiedBy(new Long(100));
		ts.setIsLeaveHour(new Long(0));
		ts.setBillable("Billable");
		
		Timesheet ts1 = new Timesheet();
		ts1.setId(new Long(2));
		ts1.setEmpId(new Long(100));
		ts1.setProjectNumber(new Long(1));
		ts1.setProjectTypeID(new Long(3));
		ts1.setTaskId(new Long(3));
		ts1.setYear(new Long(19));
		ts1.setDayRange("JUNE-10-14");
		ts1.setHourWed(new Long(8));
		ts1.setHourThu(new Long(8));
		ts1.setHourFri(new Long(8));
		ts1.setApproverId(new Long(200));
		ts1.setApproveStatus(new Long(0));
		ts1.setCreatedBy(new Long(100));
		ts1.setModifiedBy(new Long(100));
		ts1.setIsLeaveHour(new Long(0));
		ts1.setBillable("Billable");
		
		Timesheet ts2 = new Timesheet();
		ts2.setId(new Long(3));
		ts2.setEmpId(new Long(100));
		ts2.setYear(new Long(19));
		ts2.setDayRange("JUNE-10-14");
		ts2.setHourSat(new Long(8));
		ts2.setApproverId(new Long(200));
		ts2.setApproveStatus(new Long(0));
		ts2.setCreatedBy(new Long(100));
		ts2.setModifiedBy(new Long(100));
		ts2.setIsLeaveHour(new Long(1));
		ts2.setBillable("Billable");
		
		list.add(ts);
		list.add(ts1);
		list.add(ts2);
		return list;
	}
	
	private void validateTimeSheet(Timesheet timesheet) throws Exception {

		if (timesheet == null || timesheet.getEmpId() == null) {
			throw new Exception("EmpId is not present in timesheet");
		} else if (timesheet.getYear() == null) {
			throw new Exception("YEAR is not present in timesheet");
		} else if (timesheet.getDayRange() == null) {
			throw new Exception("DayRange is not present in timesheet");
		} else if (timesheet.getApproverId() == null) {
			throw new Exception("APPROVERID is not present in timesheet");
		} else if (timesheet.getApproveStatus() == null) {
			throw new Exception("ApproverStatus is not present in timesheet");
		}
	}
}
