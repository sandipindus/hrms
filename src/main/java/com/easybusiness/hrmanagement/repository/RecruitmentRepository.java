package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.RecruitmentJdDetails;

public interface RecruitmentRepository extends CrudRepository<RecruitmentJdDetails, Long> {

	@Query("select r from RecruitmentJdDetails r where r.isExpired = 0")
	public List<RecruitmentJdDetails> findAllRecruitmentJdDetails();

	@Query("select r from RecruitmentJdDetails r where r.isExpired = 0 and r.pendingWith=:pendingWith and r.requestStatus=2")
	public List<RecruitmentJdDetails> findApprovedRecruitmentJdDetailsByPendingWith(@Param("pendingWith") Long pendingWith);

	@Query("select r from RecruitmentJdDetails r where r.isExpired = 0 and r.pendingWith=:pendingWith or r.directApprover=:directApprover")
	public List<RecruitmentJdDetails> findRecruitmentJdDetailsByDirectApprover(@Param("pendingWith") Long pendingWith,@Param("directApprover") Long directApprover);

	public RecruitmentJdDetails findByJdID(String recruitmentJDId);

	@Query("update RecruitmentIntervieweeData r set r.isExpired = 1 where r.jdID = :jdID")
	public void expireRecruitmentIntervieweeData(@Param("jdID") String jdID);

	@Query("update InterviewSchedule i set i.isExpired = 1 where i.jdID = :jdID")
	public void expireInterviewScheduleData(@Param("jdID") String jdID);
}
