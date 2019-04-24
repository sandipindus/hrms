package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.AttendenceMaster;
import com.easybusiness.hrmanagement.repository.AttendenceMasterRepository;

@Service
public class AttendenceMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AttendenceMasterService.class);
	
	@Autowired
	AttendenceMasterRepository attendenceRepository;
	
	public List<AttendenceMaster> getAll() throws Exception{
		List<AttendenceMaster> attendenceMasterList = new ArrayList<>();
		try {
			attendenceRepository.findAll().forEach(attendenceMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table AttendenceMaster");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return attendenceMasterList;
	}
}
