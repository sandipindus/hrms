package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.ProjTypeMaster;
import com.easybusiness.hrmanagement.repository.ProjTypeMasterRepository;

@Service
public class ProjTypeMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjTypeMasterService.class);
	
	@Autowired
	ProjTypeMasterRepository projTypeMasterRepository;
	
	public List<ProjTypeMaster> getAll() throws Exception{
		List<ProjTypeMaster> projTypeMasterList = new ArrayList<>();
		try {
			projTypeMasterRepository.findAll().forEach(projTypeMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table Proj_Type_master MOBJ_1044");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return projTypeMasterList;
	}
}
