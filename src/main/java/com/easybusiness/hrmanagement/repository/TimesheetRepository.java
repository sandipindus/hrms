package com.easybusiness.hrmanagement.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.Timesheet;

public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {
	
	@Query("select t from Timesheet t where t.dayRange =:dayRange and t.empId=:empId and t.year = :year")
	public List<Timesheet> getTimesheetByDayRangeEmpIdYear(@Param("dayRange") String dayRange, @Param("year") Long year, @Param("empId") Long empId);
	
	@Query("select t from Timesheet t where t.empId=:empId and t.year = :year")
	public List<Timesheet> getTimesheetByEmpIdYear(@Param("year") Long year, @Param("empId") Long empId);
	
	@Query("select t from Timesheet t where t.approverId=:approverId and t.approveStatus = 0")
	public List<Timesheet> getTimesheetByApproverId(@Param("approverId") Long approverId);

	@Transactional
	@Modifying
	@Query("update Timesheet t set t.approveStatus = :approveStatus, t.modifiedBy = :modifiedBy, t.modifiedDate=:modifiedDate where t.id = :id")
	int updateTimesheet(@Param("approveStatus") Long approveStatus, @Param("modifiedBy") Long modifiedBy, @Param("id") Long id, @Param("modifiedDate") Timestamp modifiedDate);
}
