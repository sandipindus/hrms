package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easybusiness.hrmanagement.domain.WeekendMaster;
import com.easybusiness.hrmanagement.repository.WeekendMasterRepository;

@Service
public class WeekendMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeekendMasterService.class);
	
	@Autowired
	WeekendMasterRepository weekendMasterRepository;
	
	public List<WeekendMaster> getAll() throws Exception{
		List<WeekendMaster> weekendMasterList = new ArrayList<>();
		try {
			weekendMasterRepository.findAll().forEach(weekendMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table weekendMasterList");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return weekendMasterList;
	}
}
