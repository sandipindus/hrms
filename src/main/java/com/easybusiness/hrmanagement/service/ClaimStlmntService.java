package com.easybusiness.hrmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.ClaimStlmnt;
import com.easybusiness.hrmanagement.repository.ClaimStlmntRepository;

@Service
public class ClaimStlmntService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimStlmntService.class);
	
	@Autowired
	ClaimStlmntRepository claimStlmntRepository;
	
	public void addClaimStlmnt(ClaimStlmnt claimStlmnt) throws Exception {
		try {
			claimStlmntRepository.save(claimStlmnt);
			LOGGER.debug("Successfully saved data into Table ClaimStlmnt");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
}
