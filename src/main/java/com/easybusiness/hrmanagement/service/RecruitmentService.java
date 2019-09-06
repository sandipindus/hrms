package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.RecruitmentJdDetails;
import com.easybusiness.hrmanagement.repository.RecruitmentRepository;

@Service
public class RecruitmentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RecruitmentService.class);
	
	@Autowired
	RecruitmentRepository recruitmentRepository;
	
	public String addOrUpdateRecruitmentJdDetails(RecruitmentJdDetails recruitmentJdDetails, boolean isUpdateFlow) throws Exception {
		try {
			RecruitmentJdDetails savedDetails = recruitmentRepository.save(recruitmentJdDetails);
			
			if (isUpdateFlow) {
				LOGGER.debug("Successfully updated data into Table RECRUITMENT_JD_DETAILS");
			} else {
				LOGGER.debug("Successfully saved data into Table RECRUITMENT_JD_DETAILS");
			}
			
			return savedDetails.getId();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<RecruitmentJdDetails> getAll() throws Exception {
		return recruitmentRepository.findAllRecruitmentJdDetails();
	}
	
	public RecruitmentJdDetails findByRecruitmentJdDetailsID(String recruitmentJDId) throws Exception {
		try {
			RecruitmentJdDetails recruitmentJdDetails = recruitmentRepository.findById(recruitmentJDId);
			
			if (recruitmentJdDetails.getIsExpired() == 1) {
				throw new Exception("RecruitmentJdDetails already deleted");
			}
			
			LOGGER.debug("Successfully retrieve RecruitmentJdDetails from Table RECRUITMENT_JD_DETAILS");
			return recruitmentJdDetails;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}

	public List<RecruitmentJdDetails> findApprovedRecruitmentJdDetailsByPendingWith(Long pendingWith) throws Exception {
		try {
			return recruitmentRepository.findApprovedRecruitmentJdDetailsByPendingWith(pendingWith);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<RecruitmentJdDetails> findRecruitmentJdDetailsByDirectApprover(Long pendingWith, Long directApprover) throws Exception {
		try {
			return recruitmentRepository.findRecruitmentJdDetailsByDirectApprover(pendingWith, directApprover);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
}
