package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.LeaveBalanceDetails;
import com.easybusiness.hrmanagement.repository.LeaveBalanceRepository;

@Service
public class LeaveBalanceService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveBalanceService.class);
	
	@Autowired
	LeaveBalanceRepository leaveBalanceRepository;
	
	/**
	 * method will return List of LeaveBalanceDetails excepting BALANCE_ID is primary. If not then out put will change
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	public List<LeaveBalanceDetails> findByUserId(Long userID) throws Exception {
		try {
			List<LeaveBalanceDetails> listLeaveBalanceByUserId = leaveBalanceRepository.findByUserId(userID);
			
			LOGGER.debug("Successfully retrieve LeaveBalanceDetails from Table LEAVE_BALANCE_DETAILS against userId : " + userID);
			return listLeaveBalanceByUserId;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
	
}
