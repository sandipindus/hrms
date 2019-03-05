package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelType;
import com.easybusiness.hrmanagement.repository.TravelTypeRepository;

@Service
public class TravelTypeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelTypeService.class);
	
	@Autowired
	TravelTypeRepository travelTypeRepository;
	
	public List<TravelType> getAll() throws Exception{
		List<TravelType> travelTypeList = new ArrayList<>();
		try {
			travelTypeRepository.findAll().forEach(travelTypeList::add);
			LOGGER.debug("Successfully retrieve data from Table TravelType");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelTypeList;
	}
}
