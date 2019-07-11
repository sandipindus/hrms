package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.HolidayMaster;

public interface HolidayMasterRepository extends CrudRepository<HolidayMaster, Long>{
	@Query("select a from HolidayMaster a where a.locNum = :locNum or a.holidayType = :holidayType")
	public List<HolidayMaster> getHolidaysLocationWise(@Param("locNum") Long locNum, @Param("holidayType") String holidayType);
}
