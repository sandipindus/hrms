package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelAccomType;
import com.easybusiness.hrmanagement.repository.TravelAccomTypeRepository;

@Service
public class TravelAccomTypeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelAccomTypeService.class);
	
	@Autowired
	TravelAccomTypeRepository travelAccomTypeRepository;
	
	public List<TravelAccomType> getAll() throws Exception{
		List<TravelAccomType> travelAccomTypeList = new ArrayList<>();
		try {
			travelAccomTypeRepository.findAll().forEach(travelAccomTypeList::add);
			LOGGER.debug("Successfully retrieve data from Table TravelAccomType");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelAccomTypeList;
	}
}
