package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.hrmanagement.domain.LocationMaster;

public interface LocationMasterRepository extends CrudRepository<LocationMaster, Long>{
	public List<LocationMaster> findByLocNum(Long locNum);
}
