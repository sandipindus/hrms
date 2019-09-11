package com.easybusiness.hrmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.service.InterviewLevelService;

@RestController
@RequestMapping("/hrmanagement/recruitment")
public class RecruitmentMasterController {
	
	
	@Autowired
	InterviewLevelService interviewLevelService;
	
	@GetMapping("/findAllMaster")
	public Map<String, List<Object>> getAllMasterData() throws Exception {
		
		Map<String, List<Object>> resultMap = new HashMap<>();
		
		List<Object> allInterviewLevelObj = new ArrayList<>();
		
		interviewLevelService.getAll().forEach(allInterviewLevelObj :: add);
		
		resultMap.put("InterviewLevel", allInterviewLevelObj);
		
		return resultMap;
	}
	
}
