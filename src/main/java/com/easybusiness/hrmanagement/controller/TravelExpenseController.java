package com.easybusiness.hrmanagement.controller;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
import com.easybusiness.hrmanagement.domain.CostDocument;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.TravelExpense;
import com.easybusiness.hrmanagement.domain.TravelExpenseCostDetails;
import com.easybusiness.hrmanagement.domain.TravelExpenseDetails;
import com.easybusiness.hrmanagement.service.TravelExpenseCostDetailsService;
import com.easybusiness.hrmanagement.service.TravelExpenseService;

@RestController
@RequestMapping("/hrmanagement/expense")
public class TravelExpenseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TravelExpenseController.class);
	
	@Autowired
	TravelExpenseService travelExpenseService;
	
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
				
				billsUploadAndSetFileName(travelExpenseCostDetails, travelExpenseID);
				travelExpenseCostDetailsService.addTravelExpenseCostDetails(travelExpenseCostDetails);
			}
		}
		
		
		ReturnMessage returnMessage = new ReturnMessage("Travel Expense With ID : " + savedTravelExpense.getId() + " "+ HRManagementConstant.ADDED_SUCCESSFULLY);
		return returnMessage;
	}
	
	private void billsUploadAndSetFileName(TravelExpenseCostDetails travelExpenseCostDetails, Long travelExpenseID) throws Exception {
		if(null!= travelExpenseCostDetails.getFoodDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getFoodDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.FOOD;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
		if(null!= travelExpenseCostDetails.getClientEntertainmentDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getClientEntertainmentDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.CLIENT_ENT;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
		if(null!= travelExpenseCostDetails.getWaterDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getWaterDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.WATER;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
		if(null!= travelExpenseCostDetails.getLaundryDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getLaundryDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.LAUNDRY;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
		if(null!= travelExpenseCostDetails.getTelephoneDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getTelephoneDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.TELEPHONE;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
		if(null!= travelExpenseCostDetails.getDatacardDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getDatacardDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.DATACARD;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
		if(null!= travelExpenseCostDetails.getPrintOutDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getPrintOutDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.PRINT_OUT;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
		if(null!= travelExpenseCostDetails.getScanDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getScanDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.SCAN;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
		if(null!= travelExpenseCostDetails.getLocalTransDocument()) {
			CostDocument costDocument = travelExpenseCostDetails.getLocalTransDocument().getCostDocument();
			if(isDocPresent(costDocument)) {
				String name = HRManagementConstant.LOCAL_TRANS;
				String fileName = createBillName(travelExpenseID, travelExpenseCostDetails.getDay(), name, costDocument.getDocType());
				uploadBillDoc(costDocument.getEncodedDoc(), fileName, costDocument.getDocType());
				travelExpenseCostDetails.setFoodDocumentName(fileName);
			}
		}
		
	}
	
	private void uploadBillDoc(String base64Data, String fileName, String docType) throws Exception {
		//  Docloc this place holder we use for Encoded String
		String encodedString = base64Data.replaceAll("\n", "");
		
		
		FileOutputStream fileOP = null;
		byte[] imageByte;
        try {
            imageByte = Base64.getDecoder().decode(encodedString);
            fileOP= new FileOutputStream(HRManagementConstant.UPLOADEDPATH+fileName.toString());// Or PDF file
            fileOP.write(imageByte);
            
            LOGGER.debug("Successfully uploaded " + docType + " Doc: " + fileName.toString());
            
        } catch (Exception e) {
        	LOGGER.debug(e.getMessage());
            throw new Exception(e);
        }finally {
        	if(null != fileOP) {
        		fileOP.close();
        	}
		}
		
		
	}
	
	private String createBillName(Long travelExpenseID, Long day, String name, String docType) {
		StringBuffer fileName = new StringBuffer();
		fileName.append(travelExpenseID.toString()).append(HRManagementConstant.UNDERSCORE).append(day.toString()).append(name).append(docType);
		return fileName.toString();
	}

	private boolean isDocPresent(CostDocument costDocument) {
		if (costDocument.getEncodedDoc() != null && !costDocument.getEncodedDoc().isEmpty()
				&& costDocument.getDocType() != null && !costDocument.getDocType().isEmpty()) {
			return true;
		} else {
			return false;
		}
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
	}
	
}
