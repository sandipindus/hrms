package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.AttendanceDetails;

public interface AttendanceDetailsRepository extends CrudRepository<AttendanceDetails, Long>{

	
	@Query("select t from AttendanceDetails t where t.fileId =:fileId and t.empId=:empId")
	public List<AttendanceDetails> getAttendanceDetailsByFileIdEmpId(@Param("fileId") Long fileId, @Param("empId") Long empId);
}
