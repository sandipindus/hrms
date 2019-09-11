package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.easybusiness.hrmanagement.domain.RecruitmentIntervieweeDetails;

public interface RecruitmentIntervieweeDetailsRepository extends CrudRepository<RecruitmentIntervieweeDetails, Long> {
	
	@Query("select r from RecruitmentIntervieweeDetails r where r.isExpired = 0")
	List<RecruitmentIntervieweeDetails> findAllRecruitmentIntervieweeDetails();
}
