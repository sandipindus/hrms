package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.TaskMaster;
import com.easybusiness.hrmanagement.repository.TaskMasterRepository;

/**
 * @author MS
 *
 */
@Service
public class TaskMasterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskMasterService.class);
	
	@Autowired
	TaskMasterRepository taskMasterRepository;
	
	public List<TaskMaster> getAll() throws Exception{
		List<TaskMaster> taskMasterList = new ArrayList<>();
		try {
			taskMasterRepository.findAll().forEach(taskMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table TaskMaster MOBJ_1045");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return taskMasterList;
	}
}
