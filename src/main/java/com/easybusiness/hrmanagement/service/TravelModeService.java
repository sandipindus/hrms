package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelMode;
import com.easybusiness.hrmanagement.repository.TravelModeRepository;

@Service
public class TravelModeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelModeService.class);
	
	@Autowired
	TravelModeRepository travelModeRepository;
	
	public List<TravelMode> getAll() throws Exception{
		List<TravelMode> travelModeList = new ArrayList<>();
		try {
			travelModeRepository.findAll().forEach(travelModeList::add);
			LOGGER.debug("Successfully retrieve data from Table TravelMode");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelModeList;
	}
}
