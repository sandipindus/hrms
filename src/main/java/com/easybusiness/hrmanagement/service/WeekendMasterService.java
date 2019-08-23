package com.easybusiness.hrmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.WeekendMaster;
import com.easybusiness.hrmanagement.repository.WeekendMasterRepository;

@Service
public class WeekendMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeekendMasterService.class);
	
	@Autowired
	WeekendMasterRepository weekendMasterRepository;
	
	public WeekendMaster findByLocNumUnitId(Long locationId, Long unitId) throws Exception{
		WeekendMaster weekendMaster = null;
		try {
			weekendMaster = weekendMasterRepository.findByLocNumUnitId(locationId, unitId);
			LOGGER.debug("Successfully retrieve data from Table weekendMaster by locationId");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return weekendMaster;
	}
}
