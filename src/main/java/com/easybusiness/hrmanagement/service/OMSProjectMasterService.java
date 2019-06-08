package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.OMSProjectMaster;
import com.easybusiness.hrmanagement.repository.OMSProjectMasterRepository;

@Service
public class OMSProjectMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OMSProjectMasterService.class);
	
	@Autowired
	OMSProjectMasterRepository omsProjectMasterRepository;
	
	public List<OMSProjectMaster> getAll() throws Exception{
		List<OMSProjectMaster> omsProjectMasterList = new ArrayList<>();
		try {
			omsProjectMasterRepository.findAll().forEach(omsProjectMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table OMSProjectMaster");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return omsProjectMasterList;
	}
}
