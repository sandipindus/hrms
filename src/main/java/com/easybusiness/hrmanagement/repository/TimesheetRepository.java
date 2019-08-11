package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.Timesheet;

public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {
	
	@Query("select t from Timesheet t where t.dayRange =:dayRange and t.empId=:empId and t.year = :year")
	public List<Timesheet> getTimesheetByDayRangeEmpIdYear(@Param("dayRange") String dayRange, @Param("year") Long year, @Param("empId") Long empId);
	
	@Query("select t from Timesheet t where t.empId=:empId and t.year = :year")
	public List<Timesheet> getTimesheetByEmpIdYear(@Param("year") Long year, @Param("empId") Long empId);
	
	@Query("select t from Timesheet t where t.pendingWith=:pendingWith")
	public List<Timesheet> getTimesheetByPendingWith(@Param("pendingWith") Long pendingWith);
}
