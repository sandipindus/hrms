package com.easybusiness.hrmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.repository.AttendanceFileDetailsRepository;

@Service
public class AttendanceFileDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceFileDetailsService.class);
	
	@Autowired
	AttendanceFileDetailsRepository attendanceFileDetailsRepository;
	
	public Long getFileId (String month, String year) throws Exception {
		Long fileId = null;
		try {
			fileId = attendanceFileDetailsRepository.getFileId(month, year);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return fileId;
	}
}
