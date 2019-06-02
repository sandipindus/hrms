package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.ProjectActivityMapping;
import com.easybusiness.hrmanagement.repository.ProjectActivityMappingRepository;

@Service
public class ProjectActivityMappingService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectActivityMappingService.class);
	
	@Autowired
	ProjectActivityMappingRepository projectActivityMappingRepository;
	
	public List<ProjectActivityMapping> getAll() throws Exception{
		List<ProjectActivityMapping> projectActivityMappingList = new ArrayList<>();
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
