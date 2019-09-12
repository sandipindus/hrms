package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.easybusiness.hrmanagement.domain.RecruitmentIntervieweeData;

public interface RecruitmentIntervieweeDetailsRepository extends CrudRepository<RecruitmentIntervieweeData, Long> {
	
	@Query("select r from RecruitmentIntervieweeData r where r.isExpired = 0")
	List<RecruitmentIntervieweeData> findAllRecruitmentIntervieweeDetails();
}
