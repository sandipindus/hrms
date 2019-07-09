package com.easybusiness.hrmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.service.HolidayMasterService;
import com.easybusiness.hrmanagement.service.LeaveMasterService;
import com.easybusiness.hrmanagement.service.LocationMasterService;
import com.easybusiness.hrmanagement.service.WeekendMasterService;

@RestController
@RequestMapping("/hrmanagement/leave")
public class LeaveMasterController {
	
	@Autowired
	LocationMasterService locationMasterService;
	
	@Autowired
	LeaveMasterService leaveMasterService;
	
	@Autowired
	HolidayMasterService holidayMasterService;
	
	@Autowired
	WeekendMasterService weekendMasterService;
	
	@GetMapping("/findAllMaster")
	public Map<String, List<Object>> getAllMasterData() throws Exception {
		
		Map<String, List<Object>> resultMap = new HashMap<>();
		
		List<Object> alllocMasterObj = new ArrayList<>();
		List<Object> allLeaveMasterObj = new ArrayList<>();
		List<Object> allHolidayMasterObj = new ArrayList<>();
		List<Object> allWeekendMasterObj = new ArrayList<>();
		
		locationMasterService.getAll().forEach(alllocMasterObj :: add);
		leaveMasterService.getAll().forEach(allLeaveMasterObj::add);
		holidayMasterService.getAll().forEach(allHolidayMasterObj :: add);
		weekendMasterService.getAll().forEach(allWeekendMasterObj :: add);
		
		resultMap.put("LocationMaster", alllocMasterObj);
		resultMap.put("LeaveMaster", allLeaveMasterObj);
		resultMap.put("HolidayMaster", allHolidayMasterObj);
		resultMap.put("WeekEndMaster", allWeekendMasterObj);
		
		return resultMap;
	}
}
