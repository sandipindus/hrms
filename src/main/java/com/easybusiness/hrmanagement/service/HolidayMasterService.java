package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.HolidayMaster;
import com.easybusiness.hrmanagement.repository.HolidayMasterRepository;

@Service
public class HolidayMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(HolidayMasterService.class);
	
	@Autowired
	HolidayMasterRepository holidayMasterRepository;
	
	public List<HolidayMaster> getAll() throws Exception{
		List<HolidayMaster> holidayMasterList = new ArrayList<>();
		try {
			holidayMasterRepository.findAll().forEach(holidayMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table OMS_HOLIDAY_MASTER");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return holidayMasterList;
	}
	
	public List<HolidayMaster> getHolidaysLocationWise(Long locNum) throws Exception{
		List<HolidayMaster> holidayMasterList = new ArrayList<>();
		try {
			holidayMasterRepository.getHolidaysLocationWise(locNum, "MANDATORY").forEach(holidayMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table OMS_HOLIDAY_MASTER Location wise");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return holidayMasterList;
	}
}
