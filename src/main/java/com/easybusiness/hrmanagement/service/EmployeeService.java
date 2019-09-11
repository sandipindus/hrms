package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.EmployeeMaster;
import com.easybusiness.hrmanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<EmployeeMaster> getAll() throws Exception{
		List<EmployeeMaster> empList = new ArrayList<>();
		try {
			employeeRepository.findAll().forEach(empList::add);
			LOGGER.debug("Successfully retrieve data from Table OMS_EMPLOYEE_MASTER");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return empList;
	}
}
