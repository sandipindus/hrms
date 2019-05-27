package com.easybusiness.hrmanagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.AttendanceFileDetails;

@SuppressWarnings("unused")
public interface AttendanceFileDetailsRepository extends CrudRepository<AttendanceFileDetails, Long>{

	@Query("select a.id from AttendanceFileDetails a where a.isDeleted = 0 and upper(a.month)=:month and a.year=:year")
	public Long getFileId(@Param("month") String month, @Param("year") String year);
}
