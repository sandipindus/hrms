package com.easybusiness.hrmanagement.controller;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.RecruitmentIntervieweeDetails;
import com.easybusiness.hrmanagement.domain.RecruitmentJdDetails;
import com.easybusiness.hrmanagement.domain.Resume;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.service.RecruitmentService;
import com.easybusiness.hrmanagement.utils.GenericComparator;

@RestController
@RequestMapping("/hrmanagement/recruitment")
public class RecruitmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RecruitmentController.class);
	
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
	
	@RequestMapping(method=RequestMethod.POST, value="/addRecruitmentIntervieweeDetails")
	public ReturnMessage addRecruitmentIntervieweeDetails(@RequestBody RecruitmentIntervieweeDetails recruitmentIntervieweeDetails) throws Exception {
		String id = "INTERVIEWEE" + new Date().getTime();
		recruitmentIntervieweeDetails.setRecruitmentIntervieweeID(id);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		recruitmentIntervieweeDetails.setModifiedDate(timestamp);
		recruitmentIntervieweeDetails.setCreatedDate(timestamp);
		
		uploadResume(recruitmentIntervieweeDetails.getResume(), id);
		recruitmentService.addOrUpdateRecruitmentIntervieweeDetails(recruitmentIntervieweeDetails, false);
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
	@GetMapping("/findRecruitmentIntervieweeDetails")
	public List<RecruitmentIntervieweeDetails> getAllRecruitmentIntervieweeDetails() throws Exception {
		List<RecruitmentIntervieweeDetails> recruitmentJdDetailsList = recruitmentService.getAllRecruitmentIntervieweeDetails();
		Collections.sort(recruitmentJdDetailsList, new GenericComparator("modifiedDate", false));
		return recruitmentJdDetailsList;
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
	
	private void uploadResume(Resume resume, String recruitmentIntervieweeId) throws Exception {
			//  Docloc this place holder we use for Encoded String
			String encodedString = resume.getEncodedDoc().replaceAll("\n", "");
			StringBuilder fileName = new StringBuilder();
			
			// File name like 234567-1.png
			fileName.append(recruitmentIntervieweeId).append(HRManagementConstant.DASH).append(HRManagementConstant.RESUME).append(resume.getDocType());
			
			FileOutputStream fileOP = null;
			byte[] imageByte;
	        try {
	            imageByte = Base64.getDecoder().decode(encodedString);
	            fileOP= new FileOutputStream(HRManagementConstant.UPLOADEDPATH+fileName.toString());
	            fileOP.write(imageByte);
	            
	        //  Docloc this place holder we use for file name after Upload file
	            resume.setResumeName(fileName.toString());
	            
	            LOGGER.debug("Successfully uploaded Visa Doc: " + fileName.toString());
	            
	        } catch (Exception e) {
	        	LOGGER.debug(e.getMessage());
	            throw new Exception(e);
	        }finally {
	        	if(null != fileOP) {
	        		fileOP.close();
	        	}
			}
	}
}
