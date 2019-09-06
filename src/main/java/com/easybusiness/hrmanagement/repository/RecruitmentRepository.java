package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.RecruitmentJdDetails;

public interface RecruitmentRepository extends CrudRepository<RecruitmentJdDetails, Long> {

	public RecruitmentJdDetails findById(String recruitmentJDId);

	@Query("select r from RecruitmentJdDetails r where r.isExpired = 0")
	public List<RecruitmentJdDetails> findAllRecruitmentJdDetails();

	@Query("select r from RecruitmentJdDetails r where r.isExpired = 0 and r.pendingWith=:pendingWith and r.requestStatus=2")
	public List<RecruitmentJdDetails> findApprovedRecruitmentJdDetailsByPendingWith(@Param("pendingWith") Long pendingWith);

	@Query("select r from RecruitmentJdDetails r where r.isExpired = 0 and r.pendingWith=:pendingWith or r.directApprover=:directApprover")
	public List<RecruitmentJdDetails> findRecruitmentJdDetailsByDirectApprover(@Param("pendingWith") Long pendingWith,@Param("directApprover") Long directApprover);
}
