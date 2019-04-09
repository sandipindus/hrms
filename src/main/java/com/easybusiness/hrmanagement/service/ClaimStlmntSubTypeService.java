package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.ClaimStlmntSubTypeMaster;
import com.easybusiness.hrmanagement.repository.ClaimStlmntSubTypeRepository;

@Service
public class ClaimStlmntSubTypeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimStlmntSubTypeService.class);
	
	@Autowired
	ClaimStlmntSubTypeRepository claimStlmntSubTypeRepository;
	
	public List<ClaimStlmntSubTypeMaster> getAll() throws Exception{
		List<ClaimStlmntSubTypeMaster> claimStlmntSubTypeMasterList = new ArrayList<>();
		try {
			claimStlmntSubTypeRepository.findAll().forEach(claimStlmntSubTypeMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table ClaimStlmntSubType");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return claimStlmntSubTypeMasterList;
	}
}
