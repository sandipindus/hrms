package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.ProjectMaster;
import com.easybusiness.hrmanagement.repository.ProjectMasterRepository;

@Service
public class ProjectMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectMasterService.class);
	
	@Autowired
	ProjectMasterRepository projectMasterRepository;
	
	public List<ProjectMaster> getAll() throws Exception{
		List<ProjectMaster> projectMasterList = new ArrayList<>();
		try {
			projectMasterRepository.findAll().forEach(projectMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table PROJECT_MASTER");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return projectMasterList;
	}
}
