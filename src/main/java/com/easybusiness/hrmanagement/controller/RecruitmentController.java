package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.RecruitmentJdDetails;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.service.RecruitmentService;
import com.easybusiness.hrmanagement.utils.GenericComparator;

@RestController
@RequestMapping("/hrmanagement/recruitment")
public class RecruitmentController {
	
	@Autowired
	RecruitmentService recruitmentService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addRecruitmentJdDetails")
	public ReturnMessage addRecruitmentJdDetails(@RequestBody RecruitmentJdDetails recruitmentJdDetails) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		recruitmentJdDetails.setModifiedDate(timestamp);
		recruitmentJdDetails.setCreatedDate(timestamp);
		String id = recruitmentService.addOrUpdateRecruitmentJdDetails(recruitmentJdDetails, false);
		return new ReturnMessage("RecruitmentJdDetails with id " + id + " created successfully");
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateRecruitmentJdDetails")
	public ReturnMessage updateRecruitmentJdDetails(@RequestBody RecruitmentJdDetails recruitmentJdDetails) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		recruitmentJdDetails.setModifiedDate(timestamp);
		String id = recruitmentService.addOrUpdateRecruitmentJdDetails(recruitmentJdDetails, false);
		return new ReturnMessage("RecruitmentJdDetails with id " + id + HRManagementConstant.UPDATED_SUCCESSFULLY);

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/findAllRecruitmentJD")
	public List<RecruitmentJdDetails> getAllRecruitmentJdDetails() throws Exception {
		List<RecruitmentJdDetails> recruitmentJdDetailsList = recruitmentService.getAll();
		Collections.sort(recruitmentJdDetailsList, new GenericComparator("modifiedDate", false));
		return recruitmentJdDetailsList;
	}
	
	@GetMapping("/findByRecruitmentJDId/{recruitmentJDId}")
	public RecruitmentJdDetails getRecruitmentJdDetailsByJdDetailsId(@PathVariable("recruitmentJDId") String recruitmentJDId)
			throws Exception {
		RecruitmentJdDetails travelRequest = recruitmentService.findByRecruitmentJdDetailsID(recruitmentJDId);
		return travelRequest;
	}
	
	@GetMapping("/approvedRecruitmentJdDetails/{pendingWith}")
	public List<RecruitmentJdDetails> getApprovedRecruitmentJdDetailsByPendingWith(@PathVariable("pendingWith") Long pendingWith)
			throws Exception {
		return recruitmentService.findApprovedRecruitmentJdDetailsByPendingWith(pendingWith);
	}
	
	@GetMapping("/findByApproverId/{pendingWith}/directApprover/{directApprover}")
	public List<RecruitmentJdDetails> findRecruitmentJdDetailsByDirectApprover(@PathVariable("pendingWith") Long pendingWith, @PathVariable("directApprover") Long directApprover) throws Exception {
		return recruitmentService.findRecruitmentJdDetailsByDirectApprover(pendingWith, directApprover);
	}
}
