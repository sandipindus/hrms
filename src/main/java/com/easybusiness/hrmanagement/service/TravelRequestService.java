package com.easybusiness.hrmanagement.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public void updateTravelRequest(TravelRequest travelRequest) throws Exception {
		try {
			travelRequestRepository.save(travelRequest);
			LOGGER.debug("Successfully updated data into Table TravelRequest");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<TravelRequest> getAll() throws Exception {
		List<TravelRequest> travelRequestList = new ArrayList<>();
		try {
			((Collection<TravelRequest>) travelRequestRepository.findAll()).stream().
			filter(travelRequest -> travelRequest.getIsDeleted() == 0).collect(Collectors.toList()).forEach(travelRequestList::add);
			LOGGER.debug("Successfully retrieve all Travel Requests from Table TravelRequest");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
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
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public void deleteTravelRequest(Long id) throws Exception {
		try {
			travelRequestRepository.delete(id);
			LOGGER.debug("Successfully deleted Travel Requests from Table TravelRequest: travel ReqId : " + id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public TravelRequest findByTravelRequestID(String travelReqID) throws Exception {
		try {
			TravelRequest travelRequest = travelRequestRepository.findByTravelRequestID(travelReqID);
			
			if (travelRequest.getIsDeleted() == 1) {
				throw new Exception("Traveler with Traveler_ID " + travelReqID + " already deleted");
			}
			
			LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest");
			return travelRequest;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}

	public List<TravelRequest> findByApproverId(Long pendingWith, Long directApprover) throws Exception {
		List<TravelRequest> travReqList = null;

		try {
			travReqList = travelRequestRepository.getTravelRequestByApprover(pendingWith, directApprover);
			LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest by approverId " + pendingWith +  " directApprover " + directApprover);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}

		return travReqList;
	}
	
	public List<TravelRequest> findByEmployeeIdOrPendingWith(Long employeeId) throws Exception {
		List<TravelRequest> travReqList = null;

		try {
			travReqList = travelRequestRepository.getTravelRequestByEmployeeId(employeeId);
			LOGGER.debug("Successfully retrieve Travel Requests from " + "Table TravelRequest by Employee id : "
					+ employeeId);

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}

		return travReqList;
	}
	
	public List<TravelRequest> findByCreatedIdForPendingStlmnt(Long createdid) throws Exception {
		List<TravelRequest> travReqList = null;

		try {
			long currentTimeMillis = System.currentTimeMillis();
			Date date = new Date(currentTimeMillis);
			travReqList = travelRequestRepository.getTravelRequestByCreatedIDStlmntPending(createdid, date);
			LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest where StlmntPending by " + createdid);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}

		return travReqList;
	}
}
