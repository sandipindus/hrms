package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.AttendanceApproval;
import com.easybusiness.hrmanagement.domain.AttendanceDetails;

public interface AttendanceApprovalRepository extends CrudRepository<AttendanceApproval, Long>{

	public List<AttendanceApproval> findByCreatedBy(Long createdBy);
	
	public List<AttendanceApproval> findByApproverId(Long approverId);
	
	@Query("select t from AttendanceApproval t where t.month =:month and t.empId=:empId")
	public List<AttendanceApproval> getAttendanceDetailsByMonthEmpId(@Param("month") String month, @Param("empId") Long empId);
}
