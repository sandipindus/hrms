package com.easybusiness.hrmanagement.service;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easybusiness.hrmanagement.domain.LeaveTransactionDetails;
import com.easybusiness.hrmanagement.repository.LeaveTransactionDetailsRepository;

@Service
public class LeaveTransactionDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LeaveTransactionDetailsService.class);
	
	@Autowired
	LeaveTransactionDetailsRepository leaveTransactionDetailsRepository;
	
	/**
	 * @param userID
	 * @return
	 * @throws Exception
	 */
	public List<LeaveTransactionDetails> findByUserId(Long userID) throws Exception {
		try {
			List<LeaveTransactionDetails> listLeaveTransactionDetails = leaveTransactionDetailsRepository.findByUserId(userID);
			
			LOGGER.debug("Successfully retrieve LeaveTransactionDetails from Table LEAVE_TRANSACTION_DETAILS against userId : " + userID);
			return listLeaveTransactionDetails;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public LeaveTransactionDetails findByLeaveTranId(Long leaveTranId) throws Exception {
		try {
			LeaveTransactionDetails listLeaveTransactionDetails = leaveTransactionDetailsRepository.findByLeaveTranId(leaveTranId);
			
			LOGGER.debug("Successfully retrieve LeaveTransactionDetails from Table LEAVE_TRANSACTION_DETAILS against leaveTranId : " + leaveTranId);
			return listLeaveTransactionDetails;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
	public List<LeaveTransactionDetails> getLeaveTransactionDetailsByuserIdDateRange(Long userId, Date startDate, Date endDate) throws Exception {
		try {
			List<LeaveTransactionDetails> listLeaveTransactionDetails = leaveTransactionDetailsRepository.getLeaveTransactionDetailsByuserIdDateRange(userId, startDate, endDate);
			
			LOGGER.debug("Successfully retrieve LeaveTransactionDetails from Table LEAVE_TRANSACTION_DETAILS against userId : " + userId + " Startdate: " + startDate + " endDate: " + endDate);
			return listLeaveTransactionDetails;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception(e);
		}
	}
	
}
