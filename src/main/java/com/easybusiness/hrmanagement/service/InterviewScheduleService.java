package com.easybusiness.hrmanagement.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.InterviewSchedule;
import com.easybusiness.hrmanagement.pojo.CandidateDetail;
import com.easybusiness.hrmanagement.pojo.InterviewLevel;
import com.easybusiness.hrmanagement.pojo.JDDetail;
import com.easybusiness.hrmanagement.repository.InterviewScheduleRepository;
import com.google.common.collect.Multimap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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
	
	public List<JDDetail> getAllValueFromInterviewSchedule(Long empID) {
		
		List<InterviewSchedule> interviewScheduleList = new ArrayList();
		if(empID!= null) {
			interviewScheduleList = interviewScheduleRepository.findByEmpNum(empID);
		}else {
			interviewScheduleRepository.findAll().forEach(interviewScheduleList::add);
			LOGGER.debug("Successfully retrieve All data from Table INTERVIEW_SCHEDULE");
		}
		
		return stucturedJDDetail(interviewScheduleList);
	}
	
	
	/**
	 * using this map we will get Key JdID , next CandidateID and their multiple level of interview status
	 * @param interviewScheduleList
	 * @return
	 */
//	private Map<String, Map<String, List<InterviewSchedule>>> getInterviewScheduleMap(List<InterviewSchedule> interviewScheduleList){
//		// Key JDid value List<InterviewSchedule>
//		Map<String, List<InterviewSchedule>> jdKeyMap = new HashMap<String, List<InterviewSchedule>>();
//		List<InterviewSchedule> intrList = null;
//		
//		for(InterviewSchedule interviewSchedule : interviewScheduleList){
//			String jdID = interviewSchedule.getJdID();
//			if(jdKeyMap.containsKey(jdID)) {
//				jdKeyMap.get(jdID).add(interviewSchedule);
//			}else {
//				intrList = new ArrayList<InterviewSchedule>();
//				intrList.add(interviewSchedule);
//			}
//			jdKeyMap.put(jdID, intrList);
//		}
//		
//		
//		// First multimap key JDid next multimap key candidateID
//		Map<String, Map<String, List<InterviewSchedule>>> finalMap = new HashMap<>();
//		
//		for(Entry<String, List<InterviewSchedule>> entry : jdKeyMap.entrySet()){
//			List<InterviewSchedule> interviewScheduleListSpecificJdID = entry.getValue();
//			Map<String, List<InterviewSchedule>> statusKeyMap = new HashMap<>();
//			List<InterviewSchedule> filteredList = null;
//			for(InterviewSchedule jdModel : interviewScheduleListSpecificJdID){
//				String candidateID = jdModel.getIntervieweeID();
//				if(statusKeyMap.containsKey(candidateID)) {
//					statusKeyMap.get(candidateID).add(jdModel);
//				}else {
//					filteredList = new ArrayList<InterviewSchedule>();
//					filteredList.add(jdModel);
//				}
//				statusKeyMap.put(candidateID, filteredList);
//			}
//			finalMap.put(entry.getKey(), statusKeyMap);
//			
//		}
//		return finalMap;
//	}
	
	private List<JDDetail> stucturedJDDetail(List<InterviewSchedule> interviewScheduleList) {

		List<JDDetail> jdidList = new ArrayList<>();

		for (InterviewSchedule intrSchdl : interviewScheduleList) {

			boolean f = true;

			for (JDDetail jdDetail : jdidList) {

				if (jdDetail.getJdID().equals(intrSchdl.getJdID())){
					boolean flag = true;
					List<InterviewLevel> levelOfInterviewList = new ArrayList<>();
					InterviewLevel levelOfInterview = new InterviewLevel(intrSchdl.getEmpNum(), intrSchdl.getLevelID(),
							intrSchdl.getSchdlDateTime(), intrSchdl.getScore(), intrSchdl.getFeedback(),
							intrSchdl.getStatus());
					levelOfInterviewList.add(levelOfInterview);

					for (CandidateDetail candidateDetail : jdDetail.getCandidateList()) {

						if (candidateDetail.getCandidateId().equals(intrSchdl.getIntervieweeID())) {

							candidateDetail.getInterviewLevel().add(levelOfInterview);

							flag = false;

						}

					}

					if (flag == true) {

						CandidateDetail candidateId = new CandidateDetail(intrSchdl.getCandidateData(),
								levelOfInterviewList, intrSchdl.getIntervieweeID());

						jdDetail.getCandidateList().add(candidateId);

					}

					f = false;

				}

			}

			if (f == true) {

				List<InterviewLevel> levelOfInterviewList = new ArrayList<>();

				InterviewLevel levelOfInterview = new InterviewLevel(intrSchdl.getEmpNum(), intrSchdl.getLevelID(),
						intrSchdl.getSchdlDateTime(), intrSchdl.getScore(), intrSchdl.getFeedback(), intrSchdl.getStatus());

				levelOfInterviewList.add(levelOfInterview);

				List<CandidateDetail> candidateIdList = new ArrayList<>();

				CandidateDetail candidateId = new CandidateDetail(null,
						levelOfInterviewList, intrSchdl.getIntervieweeID());

				candidateIdList.add(candidateId);

				JDDetail jdid = new JDDetail(intrSchdl.getJdID(), candidateIdList);

				jdidList.add(jdid);

			}

		}
		return jdidList;

	}
	
}
