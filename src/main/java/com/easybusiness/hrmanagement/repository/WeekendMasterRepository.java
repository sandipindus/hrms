package com.easybusiness.hrmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.easybusiness.hrmanagement.domain.WeekendMaster;

public interface WeekendMasterRepository extends CrudRepository<WeekendMaster, Long>{
	
	public WeekendMaster findByLocationId(Long locationId);

	@Query("select w from WeekendMaster w where w.locationId = :locationId and w.unitId=:unitId")
	public WeekendMaster findByLocNumUnitId(@Param("locationId")Long locationId, @Param("unitId")Long unitId);
}
