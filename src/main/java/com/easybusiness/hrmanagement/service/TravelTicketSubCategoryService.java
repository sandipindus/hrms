package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelTicketSubCategory;
import com.easybusiness.hrmanagement.repository.TravelTicketSubCategoryRepository;

@Service
public class TravelTicketSubCategoryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelTicketSubCategoryService.class);
	
	@Autowired
	TravelTicketSubCategoryRepository travelTicketSubCategoryRepository;
	
	public List<TravelTicketSubCategory> getAll() throws Exception{
		List<TravelTicketSubCategory> travelTicketSubCategoryList = new ArrayList<>();
		try {
			travelTicketSubCategoryRepository.findAll().forEach(travelTicketSubCategoryList::add);
			LOGGER.debug("Successfully retrieve data from Table TravelTicketSubCategory");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelTicketSubCategoryList;
	}
}
