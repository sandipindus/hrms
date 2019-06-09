package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.OmsActivityMaster;
import com.easybusiness.hrmanagement.repository.OmsActivityMasterRepository;

@Service
public class OmsActivityMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OmsActivityMasterService.class);
	
	@Autowired
	OmsActivityMasterRepository projectActivityMappingRepository;
	
	public List<OmsActivityMaster> getAll() throws Exception{
		List<OmsActivityMaster> projectActivityMappingList = new ArrayList<>();
		try {
			projectActivityMappingRepository.findAll().forEach(projectActivityMappingList::add);
			LOGGER.debug("Successfully retrieve data from Table PROJECT_ACTIVITY_MAPPING");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return projectActivityMappingList;
	}
}
