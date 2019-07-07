package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.hrmanagement.domain.LeaveBalanceDetails;

public interface LeaveBalanceRepository extends CrudRepository<LeaveBalanceDetails, Long>{

	public List<LeaveBalanceDetails> findByUserId (Long userId);
	
}
