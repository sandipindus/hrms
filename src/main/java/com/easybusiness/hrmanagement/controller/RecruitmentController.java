package com.easybusiness.hrmanagement.controller;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
import com.easybusiness.hrmanagement.domain.InterviewSchedule;
import com.easybusiness.hrmanagement.domain.RecruitmentIntervieweeData;
import com.easybusiness.hrmanagement.domain.RecruitmentIntervieweeDetails;
import com.easybusiness.hrmanagement.domain.RecruitmentJdDetails;
import com.easybusiness.hrmanagement.domain.Resume;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.service.InterviewScheduleService;
import com.easybusiness.hrmanagement.service.RecruitmentService;
import com.easybusiness.hrmanagement.utils.GenericComparator;
import com.easybusiness.hrmanagement.utils.HRManagementUtils;

@RestController
@RequestMapping("/hrmanagement/recruitment")
public class RecruitmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RecruitmentController.class);
	
	@Autowired
	RecruitmentService recruitmentService;
	
	@Autowired
	InterviewScheduleService interviewScheduleService;
	
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
		
		RecruitmentIntervieweeData intervieweeData = recruitmentIntervieweeDetails.getIntervieweeData();
		String id = HRManagementUtils.primaryKeyGenrator(HRManagementConstant.INTERVIEWEE);
		intervieweeData.setRecruitmentIntervieweeID(id);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		intervieweeData.setModifiedDate(timestamp);
		intervieweeData.setCreatedDate(timestamp);
		
		if (null != recruitmentIntervieweeDetails.getResume()) {
			String resumeName = uploadResume(recruitmentIntervieweeDetails.getResume(), id);
			intervieweeData.setResumeName(resumeName);
		}
		
		recruitmentService.addOrUpdateRecruitmentIntervieweeDetails(intervieweeData, false);
		return new ReturnMessage("RecruitmentJdDetails with id " + id + " created successfully");
	}

	@RequestMapping(method=RequestMethod.POST, value="/addInterviewSchedule")
	public ReturnMessage addInterviewSchedule(@RequestBody List<InterviewSchedule> interviewScheduleList) throws Exception {
		
		interviewScheduleList.stream().filter(Objects::nonNull).forEach(eachInterViewSchedule -> {
			Long id = null;
			try {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				eachInterViewSchedule.setModifiedDate(timestamp);
				eachInterViewSchedule.setCreatedDate(timestamp);
				id = interviewScheduleService.addOrUpdateInterviewSchedule(eachInterViewSchedule, false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			LOGGER.debug("InterviewSchedule with INTRVW_SCHDL_ID " + id + " created successfully");
		});
		
		return new ReturnMessage("INTRVW_SCHDL created successfully");
	}
	
	@GetMapping("/find")
	public RecruitmentIntervieweeDetails getX() throws Exception {
		RecruitmentIntervieweeDetails d = new RecruitmentIntervieweeDetails();
		RecruitmentIntervieweeData r = new RecruitmentIntervieweeData();
			r.setJdID("JD1567780467405");
			r.setIntervieweeName("Sunil");
			r.setYearsOfExperience(new Long(5));
			r.setInstituteName("SRKS");
			r.setDegree("B.TECH");
			r.setEmail("abc@gmail.com");
			r.setPhone("08981017837");
			Resume resume = new Resume ();
			resume.setDocType(".txt");
			resume.setEncodedDoc("SGVsbG8=");
			d.setIntervieweeData(r);
			d.setResume(resume);
			return d;
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
	public List<RecruitmentIntervieweeData> getAllRecruitmentIntervieweeDetails() throws Exception {
		List<RecruitmentIntervieweeData> recruitmentJdDetailsList = recruitmentService.getAllRecruitmentIntervieweeDetails();
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
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateInterviewSchedule")
	public ReturnMessage updateInterviewSchedule(@RequestBody List<InterviewSchedule> interviewScheduleList) throws Exception {
		for(InterviewSchedule interviewSchedule : interviewScheduleList) {
			Long id = interviewScheduleService.addOrUpdateInterviewSchedule(interviewSchedule, true);
			LOGGER.debug("InterviewSchedule with INTRVW_SCHDL_ID " + id + " updated successfully");
		}
		return new ReturnMessage("InterviewSchedule" + HRManagementConstant.UPDATED_SUCCESSFULLY);

	}
	
	/**
	 * getInterviewScheduleList By JDid and CandidateID
	 * @param recruitmentJDId
	 * @param candidateId
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/getInterviewScheduleListByJDidCandidateID/{recruitmentJDId}/{candidateId}")
	public List<InterviewSchedule> getInterviewScheduleList(@PathVariable("recruitmentJDId") String recruitmentJDId, @PathVariable("candidateId") String candidateId) throws Exception{
		return interviewScheduleService.getInterviewScheduleDetailsByJdIdAndCandidateID(recruitmentJDId, candidateId);
	}
	
	private String uploadResume(Resume resume, String recruitmentIntervieweeId) throws Exception {
		// Docloc this place holder we use for Encoded String
		String encodedString = resume.getEncodedDoc().replaceAll("\n", "");
		StringBuilder fileName = new StringBuilder();

		// File name like 234567-1.png
		fileName.append(recruitmentIntervieweeId).append(HRManagementConstant.DASH).append(HRManagementConstant.RESUME)
				.append(resume.getDocType());

		FileOutputStream fileOP = null;
		byte[] imageByte;
		try {
			imageByte = Base64.getDecoder().decode(encodedString);
			fileOP = new FileOutputStream(HRManagementConstant.UPLOADEDPATH + fileName.toString());
			fileOP.write(imageByte);

			LOGGER.debug("Successfully uploaded Resume Doc: " + fileName.toString());

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		} finally {
			if (null != fileOP) {
				fileOP.close();
			}
		}
		return fileName.toString();
	}
}
