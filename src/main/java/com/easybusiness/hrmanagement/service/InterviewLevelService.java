package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.InterviewLevel;
import com.easybusiness.hrmanagement.repository.InterviewLevelRepository;

@Service
public class InterviewLevelService {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterviewLevelService.class);
	
	@Autowired
	InterviewLevelRepository interviewLevelRepository;
	
	public List<InterviewLevel> getAll() throws Exception{
		List<InterviewLevel> interviewLevelList = new ArrayList<>();
		try {
			interviewLevelRepository.findAll().forEach(interviewLevelList::add);
			LOGGER.debug("Successfully retrieve data from Table INTERVIEW_LEVEL");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return interviewLevelList;
	}
}
