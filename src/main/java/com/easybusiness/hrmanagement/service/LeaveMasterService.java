package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.LeaveMaster;
import com.easybusiness.hrmanagement.repository.LeaveMasterRepository;

@Service
public class LeaveMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveMasterService.class);
	
	@Autowired
	LeaveMasterRepository leaveMasterRepository;
	
	public List<LeaveMaster> getAll() throws Exception{
		List<LeaveMaster> leaveMasterList = new ArrayList<>();
		try {
			leaveMasterRepository.findAll().forEach(leaveMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table OMS_LEAVE_MASTER");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return leaveMasterList;
	}
}
