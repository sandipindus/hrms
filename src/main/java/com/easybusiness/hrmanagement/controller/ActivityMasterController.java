package com.easybusiness.hrmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.domain.OmsActivityMaster;
import com.easybusiness.hrmanagement.repository.GetFromStoredProcedure;

@RestController
@RequestMapping("/test")
public class ActivityMasterController {
	
	@Autowired
	GetFromStoredProcedure getFromStoredProcedure;
	
	/*@GetMapping("/get")
	public List<OmsActivityMaster> getActivityMaster() {
		return getFromStoredProcedure.getActivityMaster();
	}*/
	
	@GetMapping("/get")
	public void add() {
		OmsActivityMaster o = new OmsActivityMaster();
		o.setActivityNum(new Long(345));
		o.setActivity("data");
		o.setModBy("Mainak");
		
		long time = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(time);
		
		o.setModDate(date);
		 getFromStoredProcedure.add(o);
	}
}
