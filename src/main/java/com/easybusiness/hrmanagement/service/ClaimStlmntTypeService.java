package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.ClaimStlmntTypeMaster;
import com.easybusiness.hrmanagement.repository.ClaimStlmntTypeRepository;

@Service
public class ClaimStlmntTypeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimStlmntTypeService.class);
	
	@Autowired
	ClaimStlmntTypeRepository claimStlmntTypeRepository;
	
	public List<ClaimStlmntTypeMaster> getAll() throws Exception{
		List<ClaimStlmntTypeMaster> claimStlmntTypeMasterList = new ArrayList<>();
		try {
			claimStlmntTypeRepository.findAll().forEach(claimStlmntTypeMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table ClaimStlmntType");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return claimStlmntTypeMasterList;
	}
}
