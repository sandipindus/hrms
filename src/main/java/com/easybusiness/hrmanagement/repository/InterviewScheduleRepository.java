package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.hrmanagement.domain.InterviewSchedule;

public interface InterviewScheduleRepository extends CrudRepository<InterviewSchedule, Long>{

	public List<InterviewSchedule> findByJdIDAndIntervieweeID(String jdID, String intervieweeID);
}
