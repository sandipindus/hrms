package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelPurpose;
import com.easybusiness.hrmanagement.repository.TravelPurposeRepository;

@Service
public class TravelPurposeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelPurposeService.class);
	
	@Autowired
	TravelPurposeRepository travelPurposeRepository;
	
	public List<TravelPurpose> getAll() throws Exception{
		List<TravelPurpose> travelPurposeList = new ArrayList<>();
		try {
			travelPurposeRepository.findAll().forEach(travelPurposeList::add);
			LOGGER.debug("Successfully retrieve data from Table TravelPurpose");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelPurposeList;
	}
}
