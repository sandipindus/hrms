package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelRequestStatus;
import com.easybusiness.hrmanagement.repository.TravelRequestStatusRepository;

@Service
public class TravelRequestStatusService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelRequestStatusService.class);
	
	@Autowired
	TravelRequestStatusRepository travelRequestStatusRepository;
	
	public List<TravelRequestStatus> getAll() throws Exception{
		List<TravelRequestStatus> travelRequestStatusList = new ArrayList<>();
		try {
			travelRequestStatusRepository.findAll().forEach(travelRequestStatusList::add);
			LOGGER.debug("Successfully retrieve data from Table TravelRequestStatus");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelRequestStatusList;
	}
}
