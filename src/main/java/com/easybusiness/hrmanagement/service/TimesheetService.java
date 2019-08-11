package com.easybusiness.hrmanagement.service;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.easybusiness.hrmanagement.domain.Timesheet;
import com.easybusiness.hrmanagement.repository.TimesheetRepository;

@Service
public class TimesheetService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TimesheetService.class);
	
	@Autowired
	TimesheetRepository timesheetRepository;
	
	public void addTimesheet(Timesheet timesheet) throws Exception {
		try {
			timesheetRepository.save(timesheet);
			LOGGER.debug("Successfully saved data into Table TIMESHEET");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception("Error occurred while saving TIMESHEET " + e.getMessage());
		}
	}
	
	public void updateTimesheet(Timesheet timesheet) throws Exception {
		try {
			Timestamp modifiedDate = new Timestamp(System.currentTimeMillis());
			timesheet.setModifiedDate(modifiedDate);
			timesheetRepository.save(timesheet);
			LOGGER.debug("Successfully updated data into Table TIMESHEET");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception("Error occurred while updating TIMESHEET " + e.getMessage());
		}
	}
	
	public List<Timesheet> getTimesheetByDayRangeEmpIdYear(String dayRange, Long year, Long empId) throws Exception {
		try {
			List<Timesheet> listTimesheet = null;
			if (null != dayRange) {
				listTimesheet = timesheetRepository.getTimesheetByDayRangeEmpIdYear(dayRange, year, empId);
			} else {
				listTimesheet = timesheetRepository.getTimesheetByEmpIdYear(year, empId);
			}

			if (CollectionUtils.isEmpty(listTimesheet)) {
				LOGGER.debug("Timesheet is not present with the given range");
			}

			LOGGER.debug("Successfully retrieve Timesheet details from Table Timesheet");
			return listTimesheet;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<Timesheet> getTimesheetByPendingWith(Long pendingWith) throws Exception {
		try {
			List<Timesheet> listTimesheet = null;
			listTimesheet = timesheetRepository.getTimesheetByPendingWith(pendingWith);
			if (CollectionUtils.isEmpty(listTimesheet)) {
				LOGGER.debug("Timesheet is not present with the given range");
			}

			LOGGER.debug("Successfully retrieve Timesheet details from Table Timesheet");
			return listTimesheet;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
}
