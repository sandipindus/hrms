package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelTicketCategory;
import com.easybusiness.hrmanagement.repository.TravelTicketCategoryRepository;

@Service
public class TravelTicketCategoryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelTicketCategoryService.class);
	
	@Autowired
	TravelTicketCategoryRepository travelTicketCategoryRepository;
	
	public List<TravelTicketCategory> getAll() throws Exception{
		List<TravelTicketCategory> travelTicketCategoryList = new ArrayList<>();
		try {
			travelTicketCategoryRepository.findAll().forEach(travelTicketCategoryList::add);
			LOGGER.debug("Successfully retrieve data from Table TravelTicketCategory");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelTicketCategoryList;
	}
}
