package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
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
			((Collection<TravelRequest>) travelRequestRepository.findAll()).stream().
			filter(travelRequest -> travelRequest.getIsDeleted() == 0).collect(Collectors.toList()).forEach(travelRequestList::add);
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
	
	public TravelRequest findByTravelRequestID(String travelReqID) throws Exception {
		try {
			TravelRequest travelRequest = travelRequestRepository.findByTravelRequestID(travelReqID);
			
			if (travelRequest.getIsDeleted() == 1) {
				throw new Exception("Traveler with Traveler_ID " + travelReqID + " already deleted");
			}
			
			LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest");
			return travelRequest;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}

	public List<TravelRequest> findByApproverId(Long approverid, String approver) throws Exception {
		List<TravelRequest> travReqList = null;

		try {
			if (HRManagementConstant.APPROVER1.equals(approver)) {
				travReqList = travelRequestRepository.getTravelRequestByApprover1(approverid);
				LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest by " + approverid);
			} else if (HRManagementConstant.APPROVER2.equals(approver)) {
				travReqList = travelRequestRepository.getTravelRequestByApprover2(approverid);
				LOGGER.debug("Successfully retrieve Travel Requests from Table TravelRequest by " + approverid);
			}

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}

		return travReqList;
	}
}
