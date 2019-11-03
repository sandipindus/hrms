package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.InterviewSchedule;
import com.easybusiness.hrmanagement.domain.LeaveTransactionDetails;
import com.easybusiness.hrmanagement.repository.InterviewScheduleRepository;

@Service
public class InterviewScheduleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterviewScheduleService.class);
	
	@Autowired
	InterviewScheduleRepository interviewScheduleRepository;
	
	public Long addOrUpdateInterviewSchedule(InterviewSchedule interviewSchedule, boolean isUpdateFlow) throws Exception {
		try {
			InterviewSchedule savedDetails = interviewScheduleRepository.save(interviewSchedule);
			
			if (isUpdateFlow) {
				LOGGER.debug("Successfully updated data into Table INTERVIEW_SCHEDULE");
			} else {
				LOGGER.debug("Successfully saved data into Table INTERVIEW_SCHEDULE");
			}
			
			return savedDetails.getIntrSchdllID();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<InterviewSchedule> getInterviewScheduleDetailsByJdIdAndCandidateID(String jdID, String intervieweeID) throws Exception{
		try {
			List<InterviewSchedule> interviewScheduleList = interviewScheduleRepository.findByJdIDAndIntervieweeID(jdID, intervieweeID);
			LOGGER.debug("Successfully retrieve InterviewSchedule from Table INTERVIEW_SCHEDULE against jdID : " + jdID + "And intervieweeID: " + intervieweeID);
			
			return interviewScheduleList;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
}
