package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelTicketBookingType;
import com.easybusiness.hrmanagement.repository.TravelTicketBookingTypeRepository;

@Service
public class TravelTicketBookingTypeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelTicketBookingTypeService.class);
	
	@Autowired
	TravelTicketBookingTypeRepository travelTicketBookingTypeRepository;
	
	public List<TravelTicketBookingType> getAll() throws Exception{
		List<TravelTicketBookingType> travelTicketBookingTypeList = new ArrayList<>();
		try {
			travelTicketBookingTypeRepository.findAll().forEach(travelTicketBookingTypeList::add);
			LOGGER.debug("Successfully retrieve data from Table TravelTicketBooking");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelTicketBookingTypeList;
	}
}
