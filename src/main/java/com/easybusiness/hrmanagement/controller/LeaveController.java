package com.easybusiness.hrmanagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.HolidayMaster;
import com.easybusiness.hrmanagement.domain.LeaveBalanceDetails;
import com.easybusiness.hrmanagement.domain.LeaveTransactionDetails;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.WeekendMaster;
import com.easybusiness.hrmanagement.pojo.ApplyLeavePojo;
import com.easybusiness.hrmanagement.pojo.ModifyLeavePojo;
import com.easybusiness.hrmanagement.repository.ApplyLeaveStoredProcedure;
import com.easybusiness.hrmanagement.service.HolidayMasterService;
import com.easybusiness.hrmanagement.service.LeaveBalanceService;
import com.easybusiness.hrmanagement.service.LeaveTransactionDetailsService;
import com.easybusiness.hrmanagement.service.WeekendMasterService;
import com.easybusiness.hrmanagement.utils.HRManagementClass;

@RestController
@RequestMapping("/hrmanagement/leave")
public class LeaveController {
	
	@Autowired
	ApplyLeaveStoredProcedure applyLeaveStoredProcedure;
	
	@Autowired
	LeaveBalanceService leaveBalanceService;
	
	@Autowired
	LeaveTransactionDetailsService leaveTransactionDetailsService;
	
	@Autowired
	HolidayMasterService holidayMasterService;
	
	@Autowired
	WeekendMasterService weekendMasterService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/applyLeave")
	public ReturnMessage applyLeave(@RequestBody ApplyLeavePojo applyLeavePojo) throws Exception {
		verifyApplyLeaveData(applyLeavePojo);
		applyLeaveStoredProcedure.applyLeave(applyLeavePojo);
		ReturnMessage returnMessage = new ReturnMessage("Leave applied successfully");
		return returnMessage;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/modifyLeave")
	public ReturnMessage modifyLeave(@RequestBody ModifyLeavePojo modifyLeavePojo) throws Exception {
		verifyModifyLeaveData(modifyLeavePojo);
		applyLeaveStoredProcedure.modifyLeave(modifyLeavePojo);
		ReturnMessage returnMessage = new ReturnMessage("Leave modified successfully");
		return returnMessage;
	}
	
	@GetMapping("/leaveBalanceByUserId/{userId}")
	public List<LeaveBalanceDetails> getLeaveBalanceByUserId(@PathVariable("userId") Long userId) throws Exception {
		List<LeaveBalanceDetails> leaveBalanceDetailsList = leaveBalanceService.findByUserId(userId);
		return leaveBalanceDetailsList;
	}
	
	@GetMapping("/leaveTransactionDetailsByUserId/{userId}")
	public List<LeaveTransactionDetails> getLeaveTransactionDetailsByUserId(@PathVariable("userId") Long userId) throws Exception {
		List<LeaveTransactionDetails> leaveTransactionDetailsList = leaveTransactionDetailsService.findByUserId(userId);
		return leaveTransactionDetailsList;
	}
	
	@GetMapping("/leaveTransactionByLeaveTranId/{leaveTranId}/Location/{locNum}")
	public LeaveTransactionDetails getLeaveTransactionDetailsByLeaveTranId(@PathVariable("leaveTranId") Long leaveTranId, @PathVariable("locNum") Long locNum) throws Exception {
		
		LeaveTransactionDetails leaveTransactionDetails = leaveTransactionDetailsService.findByLeaveTranId(leaveTranId);
		
		Date startDate =leaveTransactionDetails.getLeaveStartDate();
		Date endDate = leaveTransactionDetails.getLeaveEndDate();
		Long nubberOfDays = ChronoUnit.DAYS.between(startDate.toLocalDate(), endDate.toLocalDate()) + 1;
		
		List<HolidayMaster> holidaysLocationWise = holidayMasterService.getHolidaysLocationWise(locNum);
		
		for (HolidayMaster holiday : holidaysLocationWise) {
			Date dateOnCal = holiday.getDateOnCal();
			
			if (dateOnCal.after(startDate) && dateOnCal.before(endDate)) 
			{
				nubberOfDays = nubberOfDays - 1;
			}
		}
		
		nubberOfDays = numberOfLeaveExcludingWeekEnd(nubberOfDays, startDate, endDate, locNum);
		
		if (leaveTransactionDetails.getLeaveNo() < nubberOfDays) {
			leaveTransactionDetails.setDayType("Half");
		}
		
		return leaveTransactionDetails;
	}

	private Long numberOfLeaveExcludingWeekEnd(Long numberOfDays, Date startDate, Date endDate, Long locNum) throws Exception {
		WeekendMaster weekendMaster = weekendMasterService.findByLocationId(locNum);
		String firstWeekEnd = null;
		String secondWeekEnd = null;
		if (null != weekendMaster) {
			firstWeekEnd = weekendMaster.getWeekend1();
			secondWeekEnd = weekendMaster.getWeekend2();
		}
		
		List<LocalDate> datesBetweenStartEndDate = getDateListBetweenStartEndDate(startDate, endDate);
		
		for (LocalDate eachDate : datesBetweenStartEndDate) {
			if (isWeekEnd(eachDate, firstWeekEnd, secondWeekEnd)) {
				numberOfDays = numberOfDays - 1;
			}
		}
		return numberOfDays;
	}

	private boolean isWeekEnd(LocalDate eachDate, String firstWeekEnd, String secondWeekEnd) {
		boolean isWeekEnd = false;
		
		Date date = Date.valueOf(eachDate);
		
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		
		String dateString = simpleDateformat.format(date);
		
		if (firstWeekEnd.equalsIgnoreCase(dateString) || secondWeekEnd.equalsIgnoreCase(dateString)) {
			isWeekEnd = true;
		}
		return isWeekEnd;
	}

	private List<LocalDate> getDateListBetweenStartEndDate(Date startDate, Date endDate) {
		LocalDate start = LocalDate.parse(startDate.toString());
		LocalDate end = LocalDate.parse(endDate.toString());
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
		    totalDates.add(start);
		    start = start.plusDays(1);
		}
		return totalDates;
	}
	
	private void verifyApplyLeaveData(ApplyLeavePojo applyLeavePojo) throws Exception {
		if (applyLeavePojo == null || applyLeavePojo.getUserId() == null || applyLeavePojo.getLeaveTypeId() == null
				|| applyLeavePojo.getLeaveStartDate() == null || applyLeavePojo.getLeaveEndDate() == null
				|| applyLeavePojo.getLocId() == null || applyLeavePojo.getUnitId() == null
				|| applyLeavePojo.getDayType().isEmpty()) {

			throw new Exception(HRManagementClass.PAYLOAD_EROR_MSG);
		}
	}
	
	private void verifyModifyLeaveData(ModifyLeavePojo modifyLeavePojo) throws Exception {
		if (modifyLeavePojo == null || modifyLeavePojo.getUserId() == null || modifyLeavePojo.getLeaveTypeId() == null
				|| modifyLeavePojo.getLeaveStartDate() == null || modifyLeavePojo.getLeaveEndDate() == null
				|| modifyLeavePojo.getLocId() == null || modifyLeavePojo.getUnitId() == null
				|| modifyLeavePojo.getDayType().isEmpty() || modifyLeavePojo.getLeaveTranId() == null
				|| modifyLeavePojo.getOperationType().isEmpty()) {

			throw new Exception(HRManagementClass.PAYLOAD_EROR_MSG);
		}
	}
	
}
