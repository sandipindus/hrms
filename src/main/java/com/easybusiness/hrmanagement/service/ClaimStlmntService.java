package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.easybusiness.hrmanagement.domain.ClaimStlmnt;
import com.easybusiness.hrmanagement.repository.ClaimStlmntRepository;

@Service
public class ClaimStlmntService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimStlmntService.class);
	
	@Autowired
	ClaimStlmntRepository claimStlmntRepository;
	
	public ClaimStlmnt addClaimStlmnt(ClaimStlmnt claimStlmnt) throws Exception {
		ClaimStlmnt save = null;
		try {
			save = claimStlmntRepository.save(claimStlmnt);
			LOGGER.debug("Successfully saved data into Table ClaimStlmnt");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return save;
	}
	
	public List<ClaimStlmnt> findByCreatedId(Long createdid) throws Exception {
		List<ClaimStlmnt> claimStlmntList = null;

		try {
			claimStlmntList = claimStlmntRepository.getClaimStlmntByCreatedId(createdid);
			LOGGER.debug("Successfully retrieve claimStlmnt from Table CLAIM_STLMNT by " + createdid);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}

		return claimStlmntList;
	}
	
	public int update(ClaimStlmnt claimStlmnt) throws Exception {
		try {
			int updatedRow = claimStlmntRepository.update(claimStlmnt.getRequestStatus(), claimStlmnt.getId(),claimStlmnt.getPendingWith());
			LOGGER.debug("Successfully updated Table ClaimStlmnt Row Count: " + updatedRow);
			return updatedRow;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}

	public List<ClaimStlmnt> findByPendingWith(Long pendingWith) throws Exception {
		try {
			List<ClaimStlmnt> claimStlmntList = null;
			claimStlmntList = claimStlmntRepository.findByPendingWith(pendingWith);
			
			if(CollectionUtils.isEmpty(claimStlmntList)) {
				LOGGER.debug("Approver 2 Not Present in Database");
			}
			
			LOGGER.debug("Successfully retrieve data");
			return claimStlmntList;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
}
