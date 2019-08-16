package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.AttendanceApproval;

public interface AttendanceApprovalRepository extends CrudRepository<AttendanceApproval, Long>{

	public List<AttendanceApproval> findByCreatedBy(Long createdBy);
	
	@Query("select t from AttendanceApproval t where t.pendingWith=:pendingWith or t.directApprover=:directApprover")
	public List<AttendanceApproval> findByPendingWithAndDirectApprover(@Param("pendingWith") Long pendingWith,@Param("directApprover") Long directApprover);
	
	@Query("select t from AttendanceApproval t where upper(t.month) =:month and t.empId=:empId and t.requestStatus != 3")
	public List<AttendanceApproval> getAttendanceDetailsByMonthEmpId(@Param("month") String month, @Param("empId") String empId);
	
	@Query("select t from AttendanceApproval t where upper(t.month) =:month and t.empId=:empId and t.requestStatus != 3 and t.attendanceDate >= :startDate and t.attendanceDate <=:endDate")
	public List<AttendanceApproval> getAttendanceDetailsByMonthEmpIdWithDaterange(@Param("month") String month, @Param("empId") String empId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
