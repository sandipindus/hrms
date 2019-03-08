package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.City;
import com.easybusiness.hrmanagement.repository.CityRepository;

@Service
public class CityService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityService.class);
	
	@Autowired
	CityRepository cityRepository;
	
	public List<City> getAll() throws Exception{
		List<City> cityList = new ArrayList<>();
		try {
			cityRepository.findAll().forEach(cityList::add);
			LOGGER.debug("Successfully retrieve data from Table Cities");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return cityList;
	}
}
