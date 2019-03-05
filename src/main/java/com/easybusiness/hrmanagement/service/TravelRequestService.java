package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TravelRequest;
import com.easybusiness.hrmanagement.repository.TravelRequestRepository;

@Service
public class TravelRequestService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelRequestService.class);
	
	@Autowired
	TravelRequestRepository travelRequestRepository;
	
	public void addTravelRequest(TravelRequest travelRequest) throws Exception {
		try {
			travelRequestRepository.save(travelRequest);
			LOGGER.debug("Successfully saved data into Table TravelRequest");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public void updateTravelRequest(TravelRequest travelRequest) throws Exception {
		try {
			travelRequestRepository.save(travelRequest);
			LOGGER.debug("Successfully updated data into Table TravelRequest");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<TravelRequest> getAll() throws Exception {
		List<TravelRequest> travelRequestList = new ArrayList<>();
		try {
			travelRequestRepository.findAll().forEach(travelRequestList::add);
			LOGGER.debug("Successfully retrieve all Travel Requests from Table TravelRequest");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelRequestList;
	}
	
	public TravelRequest findById(Long id) throws Exception {
		try {
			TravelRequest travelRequest = travelRequestRepository.findOne(id);
			LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest");
			return travelRequest;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public void deleteTravelRequest(Long id) throws Exception {
		try {
			travelRequestRepository.delete(id);
			LOGGER.debug("Successfully deleted Travel Requests from Table TravelRequest: travel ReqId : " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
}
