package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.LocationMaster;
import com.easybusiness.hrmanagement.repository.LocationMasterRepository;

@Service
public class LocationMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocationMasterService.class);
	
	@Autowired
	LocationMasterRepository locationMasterRepository;
		
	public List<LocationMaster> findByLocNum(Long locNum) throws Exception{
		List<LocationMaster> locationMasterList = new ArrayList<>();
		try {
			locationMasterRepository.findByLocNum(locNum).forEach(locationMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table OMS_LOCATION_MASTER");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return locationMasterList;
	}
}
