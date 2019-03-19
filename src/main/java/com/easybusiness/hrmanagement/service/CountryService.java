package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.Country;
import com.easybusiness.hrmanagement.repository.CountryRepository;

/**
 * @author MS
 *
 */
@Service
public class CountryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
	
	@Autowired
	CountryRepository countryRepository;
	
	public List<Country> getAll() throws Exception{
		List<Country> countryList = new ArrayList<>();
		try {
			countryRepository.findAll().forEach(countryList::add);
			LOGGER.debug("Successfully retrieve data from Table Countries");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return countryList;
	}
}
