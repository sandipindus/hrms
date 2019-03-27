package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.ExpenseStlmntType;
import com.easybusiness.hrmanagement.repository.ExpenseStlmntRepository;

/**
 * @author MS
 *
 */
@Service
public class ExpenseStlmntService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseStlmntService.class);
	
	@Autowired
	ExpenseStlmntRepository expenseStlmntRepository;
	
	public List<ExpenseStlmntType> getAll() throws Exception{
		List<ExpenseStlmntType> expenseStlmntList = new ArrayList<>();
		try {
			expenseStlmntRepository.findAll().forEach(expenseStlmntList::add);
			LOGGER.debug("Successfully retrieve data from Table expenseStlmnt");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return expenseStlmntList;
	}
}
