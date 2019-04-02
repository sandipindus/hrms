package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelAllowanceLimit;
import com.easybusiness.hrmanagement.repository.TravelAllowanceLimitRepository;

@Service
public class TravelAllowanceLimitService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelAllowanceLimitService.class);
	
	@Autowired
	TravelAllowanceLimitRepository travelAllowanceLimitRepository;
	
	public List<TravelAllowanceLimit> getAll() throws Exception{
		List<TravelAllowanceLimit> travelAllowanceList = new ArrayList<>();
		try {
			travelAllowanceLimitRepository.findAll().forEach(travelAllowanceList::add);
			LOGGER.debug("Successfully retrieve data from Table TRAVEL_ALLOWANCE_LIMIT");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelAllowanceList;
	}
}
