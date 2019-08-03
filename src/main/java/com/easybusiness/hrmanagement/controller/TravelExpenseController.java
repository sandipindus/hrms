package com.easybusiness.hrmanagement.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.TravelExpense;
import com.easybusiness.hrmanagement.domain.TravelExpenseBill;
import com.easybusiness.hrmanagement.domain.TravelExpenseCostDetails;
import com.easybusiness.hrmanagement.domain.TravelExpenseDay;
import com.easybusiness.hrmanagement.domain.TravelExpenseDetails;
import com.easybusiness.hrmanagement.domain.TravelExpense_N;
import com.easybusiness.hrmanagement.service.TravelExpenseCostDetailsService;
import com.easybusiness.hrmanagement.service.TravelExpenseNewService;
import com.easybusiness.hrmanagement.service.TravelExpenseService;

@RestController
@RequestMapping("/hrmanagement/expense")
public class TravelExpenseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelExpenseController.class);
	
	@Autowired
	TravelExpenseService travelExpenseService;
	
	@Autowired
	TravelExpenseNewService travelExpenseNewService;
	
	@Autowired
	TravelExpenseCostDetailsService travelExpenseCostDetailsService;
	
	@RequestMapping(method=RequestMethod.POST, value="/addTravelExpense")
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public ReturnMessage addTravelExpense(@RequestBody TravelExpenseDetails travelExpenseDetails) throws Exception {
		
		validateTravelExpenseDetails(travelExpenseDetails);
		
		TravelExpense travelExpense = travelExpenseDetails.getTravelExpense();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		travelExpense.setModifiedDate(timestamp);
		travelExpense.setCreatedDate(timestamp);
		
		TravelExpense savedTravelExpense = travelExpenseService.addTravelExpense(travelExpense);
		
		List<TravelExpenseCostDetails> travelExpenseCostDetailsList = travelExpenseDetails.getTravelExpenseCostDetailsList();
		
		if(travelExpenseCostDetailsList!= null && !travelExpenseCostDetailsList.isEmpty()) {
			Long travelExpenseID = savedTravelExpense.getId();
			for (TravelExpenseCostDetails travelExpenseCostDetails : travelExpenseCostDetailsList) {
				
				travelExpenseCostDetails.setTravelExpId(travelExpenseID);
				travelExpenseCostDetails.setDay(travelExpenseCostDetails.getDay());
				travelExpenseCostDetailsService.addTravelExpenseCostDetails(travelExpenseCostDetails);
			}
		}
		
		
		ReturnMessage returnMessage = new ReturnMessage("Travel Expense With ID : " + savedTravelExpense.getId() + " "+ HRManagementConstant.ADDED_SUCCESSFULLY);
		return returnMessage;
	}
	
	@GetMapping("/findTravelExpense/{id}")
	public TravelExpenseDetails getTravelExpense(@PathVariable("id") Long travelExpenseID) throws Exception {

		TravelExpenseDetails travelExpenseDetails = new TravelExpenseDetails();
		try {
			TravelExpense travelExpense = travelExpenseService.findById(travelExpenseID);
			travelExpenseDetails.setTravelExpense(travelExpense);

			List<TravelExpenseCostDetails> travelExpenseCostDetailsList = travelExpenseCostDetailsService.getTravelExpenseCostDetails(travelExpenseID);

			if(!travelExpenseCostDetailsList.isEmpty()) {
				travelExpenseDetails.setTravelExpenseCostDetailsList(travelExpenseCostDetailsList);
			} else {
				List<TravelExpenseCostDetails> travelExpenseCostDetailsListBlankObj = new ArrayList<>();
				travelExpenseDetails.setTravelExpenseCostDetailsList(travelExpenseCostDetailsListBlankObj);
			}

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelExpenseDetails;
	}
	
	@GetMapping("/findTravelExpenseByCreatedBy/{createdBy}")
	public List<TravelExpenseDetails> getTravelExpenseByCreatedBy(@PathVariable("createdBy") Long createdBy) throws Exception {

		List<TravelExpenseDetails> travelExpenseDetailsList = new ArrayList<>();
		
		try {
			List<TravelExpense> travelExpenseList = travelExpenseService.findByCreatedBy(createdBy);
			
			for (TravelExpense eachTravelExpense : travelExpenseList) {
				TravelExpenseDetails travelExpenseDetails = new TravelExpenseDetails();
				travelExpenseDetails.setTravelExpense(eachTravelExpense);
				
				List<TravelExpenseCostDetails> travelExpenseCostDetailsList = travelExpenseCostDetailsService.getTravelExpenseCostDetails(eachTravelExpense.getId());

				if(!travelExpenseCostDetailsList.isEmpty()) {
					travelExpenseDetails.setTravelExpenseCostDetailsList(travelExpenseCostDetailsList);
				}
				
				travelExpenseDetailsList.add(travelExpenseDetails);
			}

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelExpenseDetailsList;
	}
	
	@GetMapping("/findTravelExpenseByApprover/{approver}")
	public List<TravelExpenseDetails> getTravelExpenseByApprover(@PathVariable("approver") Long approverId,
			@RequestParam("APPROVER") String approver) throws Exception {
		
		List<TravelExpenseDetails> travelExpenseDetailsList = new ArrayList<>();
		
		try {
			
			List<TravelExpense> travelExpenseList = null;
			
			if (HRManagementConstant.APPROVER1.equals(approver)) {
				travelExpenseList = travelExpenseService.findByApprover1(approverId);
			} else {
				travelExpenseList = travelExpenseService.findByApprover2(approverId);
			}

			for (TravelExpense eachTravelExpense : travelExpenseList) {
				TravelExpenseDetails travelExpenseDetails = new TravelExpenseDetails();
				travelExpenseDetails.setTravelExpense(eachTravelExpense);
				
				List<TravelExpenseCostDetails> travelExpenseCostDetailsList = travelExpenseCostDetailsService.getTravelExpenseCostDetails(eachTravelExpense.getId());

				if(!travelExpenseCostDetailsList.isEmpty()) {
					travelExpenseDetails.setTravelExpenseCostDetailsList(travelExpenseCostDetailsList);
				}
				
				travelExpenseDetailsList.add(travelExpenseDetails);
			}

		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelExpenseDetailsList;
	}
	
	@GetMapping("/findAllTravelExpense")
	public List<TravelExpenseDetails> getAllTravelExpense() throws Exception {
		List<TravelExpense> travelExpenseList = null;
		
		List<TravelExpenseDetails> travelExpenseDetailsList = new ArrayList<>();
		try {
			travelExpenseList = travelExpenseService.findAll();
			
			if (!CollectionUtils.isEmpty(travelExpenseList)) {
				for (TravelExpense travelExpense : travelExpenseList) {
					TravelExpenseDetails travelExpenseDetails = new TravelExpenseDetails();
					travelExpenseDetails.setTravelExpense(travelExpense);
					travelExpenseDetailsList.add(travelExpenseDetails);
				}
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return travelExpenseDetailsList;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/UpdateByApprover1")
	public ReturnMessage UpdateByApprover1(@RequestBody TravelExpenseDetails travelExpenseDetails) throws Exception {
		TravelExpense travelExpense = travelExpenseDetails.getTravelExpense();
		validateTravelExpenseForUpdateApprover1(travelExpense);
		
		int updatedRow = travelExpenseService.updateApprover1(travelExpense);
		ReturnMessage returnMessage = new ReturnMessage("Successfully Updated Row: " + updatedRow);
		return returnMessage;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/UpdateByApprover2")
	public ReturnMessage UpdateByApprover2(@RequestBody TravelExpenseDetails travelExpenseDetails) throws Exception {
		TravelExpense travelExpense = travelExpenseDetails.getTravelExpense();
		validateTravelExpenseForUpdateApprover2(travelExpense);
		
		int updatedRow = travelExpenseService.updateApprover2(travelExpense);
		ReturnMessage returnMessage = new ReturnMessage("Successfully Updated Row: " + updatedRow);
		return returnMessage;
	}

	private void validateTravelExpenseForUpdateApprover1(TravelExpense travelExpense) throws Exception {
		if(travelExpense.getId() == null) {
			throw new Exception("ID is not present");
		}else if(travelExpense.getApprover1() == null) {
			throw new Exception("Approver1 is not present");
		}else if(travelExpense.getExpStatus() == null) {
			throw new Exception("ExpStatus is not present");
		}else if(travelExpense.getApprover1Status() == null) {
			throw new Exception("Approver1Status is not present");
		}
	}
	
	private void validateTravelExpenseForUpdateApprover2(TravelExpense travelExpense) throws Exception {
		if(travelExpense.getId() == null) {
			throw new Exception("ID is not present");
		}else if(travelExpense.getApprover2() == null) {
			throw new Exception("Approver2 is not present");
		}else if(travelExpense.getExpStatus() == null) {
			throw new Exception("ExpStatus is not present");
		}else if(travelExpense.getApprover2Status() == null) {
			throw new Exception("Approver2Status is not present");
		}
	}
	
	private void validateTravelExpenseDetails(TravelExpenseDetails travelExpenseDetails) throws Exception {

		if (travelExpenseDetails == null || travelExpenseDetails.getTravelExpense() == null) {
			throw new Exception("TravelExpenseDetails is not valid");
		} else {
			TravelExpense travelExpense = travelExpenseDetails.getTravelExpense();
			
			validateTravelExpense(travelExpense);
		}
	}

	
	private void validateTravelExpense(TravelExpense travelExpense) throws Exception {
		if (travelExpense.getExpStlmntTypeId() == null) {
			throw new Exception("ExpStlmntTypeId is not present");
		} else if (travelExpense.getJourneyDate() == null) {
			throw new Exception("JourneyDate is not present");
		} else if (travelExpense.getApprover1() == null) {
			throw new Exception("Approver1 is not present");
		} else if (travelExpense.getApprover1Status() == null) {
			throw new Exception("Approver1Status is not present");
		} else if (travelExpense.getApprover2() == null) {
			throw new Exception("Approver2 is not present");
		} else if (travelExpense.getApprover2Status() == null) {
			throw new Exception("Approver2Status is not present");
		} else if (travelExpense.getCreatedBy() == null) {
			throw new Exception("CreatedBy is not present");
		} else if (travelExpense.getModifiedBy() == null) {
			throw new Exception("ModifiedBy is not present");
		}
	}
	
	
	//**************************  ALL BELOW CODE RELATED TO TRAVELEXPENSE NEW ******************************
	@GetMapping("/findAllTravelExpenseNew")
	public List<TravelExpense_N> getAllTravelExpenseNew() throws Exception {

		List<TravelExpense_N> travelExpenseList = travelExpenseNewService.findAll();

		return travelExpenseList;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addTravelExpenseNew")
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public ReturnMessage addTravelExpenseNew(@RequestBody TravelExpense_N travelExpense) throws Exception {
		
		validateTravelExpenseNew(travelExpense);
		Long travelExpenseID = getAndSetTravelExpenseID(travelExpense);
		setModifiedAndCreatedDate(travelExpense);
		setExpenseDayID(travelExpense, travelExpenseID);
		
		travelExpenseNewService.addTravelExpense(travelExpense);
		
		ReturnMessage returnMessage = new ReturnMessage("Travel Expense With ID : " + travelExpenseID.toString()+ " "+ HRManagementConstant.ADDED_SUCCESSFULLY);
		return returnMessage;
	}
	
	private void validateTravelExpenseNew(TravelExpense_N travelExpense) throws Exception {
		if (travelExpense.getExpStlmntTypeId() == null) {
			throw new Exception("ExpStlmntTypeId is not present");
		} else if (travelExpense.getJourneyDate() == null) {
			throw new Exception("JourneyDate is not present");
		} else if (travelExpense.getApprover1() == null) {
			throw new Exception("Approver1 is not present");
		} else if (travelExpense.getApprover1Status() == null) {
			throw new Exception("Approver1Status is not present");
		} else if (travelExpense.getApprover2() == null) {
			throw new Exception("Approver2 is not present");
		} else if (travelExpense.getApprover2Status() == null) {
			throw new Exception("Approver2Status is not present");
		} else if (travelExpense.getCreatedBy() == null) {
			throw new Exception("CreatedBy is not present");
		} else if (travelExpense.getModifiedBy() == null) {
			throw new Exception("ModifiedBy is not present");
		}
	}
	
	private Long getAndSetTravelExpenseID(TravelExpense_N travelExpense) {
		Random rand = new Random();
		Long randamtravelExpID = rand.nextLong();
		travelExpense.setTravelExpID(randamtravelExpID);
		return randamtravelExpID;
	}
	
	private void setModifiedAndCreatedDate(TravelExpense_N travelExpense) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		travelExpense.setModifiedDate(timestamp);
		travelExpense.setCreatedDate(timestamp);
	}
	
	/**
	 * set expDayId
	 * expDayId should be : <travelExpID>_<Day>
	 * i.e: 4530_1
	 * @param travelExpense
	 * @param travelExpenseID
	 */
	private void setExpenseDayID(TravelExpense_N travelExpense, Long travelExpenseID) {
		for(TravelExpenseDay travelExpenseDay : travelExpense.getTravelExpenseDay()) {
			Long day = travelExpenseDay.getDay();
			StringBuffer expDayId = new StringBuffer();
			expDayId.append(travelExpenseID.toString()).append(HRManagementConstant.UNDERSCORE).append(day);
			travelExpenseDay.setExpDayId(expDayId.toString());
			
			setBillId(travelExpenseDay, expDayId);
		}
	}

	/**
	 * set BillId
	 * BillId should be : <expDayId>_<billType>
	 * i.e: 4530_1_WATER
	 * @param travelExpenseDay
	 * @param expDayId
	 */
	private void setBillId(TravelExpenseDay travelExpenseDay, StringBuffer expDayId) {
		for(TravelExpenseBill travelExpenseBill : travelExpenseDay.getTravelExpenseBill()) {
			StringBuffer billID = new StringBuffer();
			billID.append(expDayId).append(HRManagementConstant.UNDERSCORE).append(travelExpenseBill.getBillType());
			travelExpenseBill.setBillID(billID.toString());
		}
	}
	
}
