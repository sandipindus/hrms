package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.Visa;
import com.easybusiness.hrmanagement.repository.VisaRepository;

@Service
public class VisaService {
private static final Logger LOGGER = LoggerFactory.getLogger(VisaService.class);
	
	@Autowired
	VisaRepository visaRepository;
	
	public List<Visa> getAll() throws Exception{
		List<Visa> visaList = new ArrayList<>();
		try {
			visaRepository.findAll().forEach(visaList::add);
			LOGGER.debug("Successfully retrieve data from Table Visa");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return visaList;
	}
	
	public void addVisa(Visa visa) throws Exception{
		try {
			visaRepository.save(visa);
			LOGGER.debug("Successfully saved data into Table Visa");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
}
