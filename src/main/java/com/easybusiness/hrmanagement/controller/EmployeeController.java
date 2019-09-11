package com.easybusiness.hrmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.EmployeeMaster;
import com.easybusiness.hrmanagement.service.EmployeeService;

@RestController
@RequestMapping("/hrmanagement/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/findAllEmployee")
	public List<EmployeeMaster> getAllEmployee() throws Exception {
		List<EmployeeMaster> empList = empService.getAll();
		return empList;
	}
	
}
