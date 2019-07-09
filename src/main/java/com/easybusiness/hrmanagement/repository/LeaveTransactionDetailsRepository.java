package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.easybusiness.hrmanagement.domain.LeaveTransactionDetails;

public interface LeaveTransactionDetailsRepository extends CrudRepository<LeaveTransactionDetails, Long>{

	public List<LeaveTransactionDetails> findByUserId (Long userId);
	
}
