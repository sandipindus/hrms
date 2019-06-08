package com.easybusiness.hrmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.service.OMSProjectMasterService;
import com.easybusiness.hrmanagement.service.ProjectActivityMappingService;
import com.easybusiness.hrmanagement.service.ProjectMasterService;

@RestController
@RequestMapping("/hrmanagement/timesheet")
public class TimeSheetMasterController {
	
	/*@Autowired
	ProjectMasterService projectMasterService;
	
	@Autowired
	ProjectActivityMappingService projectActivityMappingService;*/
	
	@Autowired
	OMSProjectMasterService omsProjectMasterService;
	
	/*@GetMapping("/findAllMaster")
	public Map<String, List<Object>> getAllMasterData() throws Exception {
		
		Map<String, List<Object>> resultMap = new HashMap<>();
		
		List<Object> allprojectMasterObj = new ArrayList<>();
		List<Object> allActivityMappingObj = new ArrayList<>();
		
		
		projectMasterService.getAll().forEach(allprojectMasterObj :: add);
		projectActivityMappingService.getAll().forEach(allActivityMappingObj::add);
		
		resultMap.put("ProjectMaster", allprojectMasterObj);
		resultMap.put("ProjectActivityMapping", allActivityMappingObj);
		
		return resultMap;
	}*/
	
	
	@GetMapping("/findAllMaster")
	public Map<String, List<Object>> getAllMasterData() throws Exception {
		
		Map<String, List<Object>> resultMap = new HashMap<>();
		
		List<Object> allomsProjectMasterServiceObj = new ArrayList<>();
		
		omsProjectMasterService.getAll().forEach(allomsProjectMasterServiceObj :: add);
		
		resultMap.put("OMSProjectMaster", allomsProjectMasterServiceObj);
		
		return resultMap;
	}
}
