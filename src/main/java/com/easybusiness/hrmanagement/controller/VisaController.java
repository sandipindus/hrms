package com.easybusiness.hrmanagement.controller;

import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.Visa;
import com.easybusiness.hrmanagement.domain.VisaDetails;
import com.easybusiness.hrmanagement.domain.VisaDocument;
import com.easybusiness.hrmanagement.service.VisaDocumentService;
import com.easybusiness.hrmanagement.service.VisaService;
import com.easybusiness.hrmanagement.utils.GenericComparator;

@RestController
@RequestMapping("/hrmanagement/visa")
public class VisaController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VisaController.class);
	
	@Autowired
	VisaService visaService;
	
	@Autowired
	VisaDocumentService visaDocumentService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET, value="/getAllVisaDetails")
	public List<Visa> getAllVisa() throws Exception {
		List<Visa> visaList = visaService.getAll();
		Collections.sort(visaList, new GenericComparator("modifiedDate", false));
		return visaList;
	}
	
	@GetMapping("/findVisaDocuments/{id}")
	public VisaDetails getVisaDetails(@PathVariable("id") Long visaId) throws Exception {

		VisaDetails visaDetails = new VisaDetails();
		try {
			Visa visa = visaService.getVisaByID(visaId);

			List<VisaDocument> visaDocuments = visaDocumentService.getVisaDocuments(visaId);

			visaDetails.setVisa(visa);

			visaDetails.setVisaDocList(visaDocuments);

			LOGGER.debug("Successfully retrieve data from Table VisaDocumentMaster");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return visaDetails;
	}
	
	/**
	 * Employee is adding visa Details, 
	 * so Created by and Modified by is the employeeId
	 * Created date and modified date is initially same.
	 * @param visaDetails
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.POST, value="/addVisaDetails")
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public ReturnMessage addVisaDetails(@RequestBody VisaDetails visaDetails) throws Exception {
		
		validateVisaDetails(visaDetails);
		//To do random number 
		Random rand = new Random();
		visaDetails.getVisa().setVisaID(new Long(rand.nextInt(999999999)));
		for(VisaDocument visaDoc : visaDetails.getVisaDocList()) {
			
			uploadVisaDoc(visaDoc, visaDetails.getVisa().getVisaID());
			//Add Visa doc in DB
			visaDocumentService.addVisaDocument(visaDoc);
		}
		
		//Add Visa Details in DB
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		visaDetails.getVisa().setModifiedDate(timestamp);
		visaDetails.getVisa().setCreatedDate(timestamp);
		visaDetails.getVisa().setModifiedBy(visaDetails.getVisa().getEmpId());
		visaService.addVisa(visaDetails.getVisa());
		
		StringBuilder message = new StringBuilder();
		message.append(visaDetails.getVisa().getVisaID()).append(" ").append(HRManagementConstant.ADDED_SUCCESSFULLY);
		
		ReturnMessage returnMessage = new ReturnMessage(message.toString());
		return returnMessage;
	}
	
	/**
	 * This will update StatusId, Approver
	 * Internally Update modified date
	 * @param visaDetails
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/updateVisaDetails")
	public ReturnMessage updateVisaDetails(@RequestBody VisaDetails visaDetails) throws Exception {
		
		Long visaID = visaDetails.getVisa().getVisaID();
		
		Visa payloadVisa = visaDetails.getVisa();
		
		Visa visaFromDB = visaService.getVisaByID(visaID);
		
		visaFromDB.setModifiedBy(payloadVisa.getModifiedBy());
		
		visaFromDB.setStatusId(payloadVisa.getStatusId());
		visaFromDB.setDirectApprover(payloadVisa.getDirectApprover());
		visaFromDB.setPendingWith(payloadVisa.getPendingWith());
		visaFromDB.setRequestStatus(payloadVisa.getRequestStatus());
		visaFromDB.setReason(payloadVisa.getReason());
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		visaFromDB.setModifiedDate(timestamp);
		
		visaService.addVisa(visaFromDB);
		
		StringBuilder message = new StringBuilder();
		message.append(visaID).append(" ").append(HRManagementConstant.UPDATED_SUCCESSFULLY);
		
		ReturnMessage returnMessage = new ReturnMessage(message.toString());
		
		return returnMessage;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/findByApproverId/{pendingWith}/directApprover/{directApprover}")
	public List<Visa> getByApprover(@PathVariable("pendingWith") Long pendingWith,@PathVariable("directApprover") Long directApprover) throws Exception {
		List<Visa> visaList = visaService.getVisaByApprover(directApprover, pendingWith);
		Collections.sort(visaList, new GenericComparator("modifiedDate", false));
		return visaList;
	}
	 
	 
	
	private void uploadVisaDoc(VisaDocument visaDoc, Long visaID) throws Exception {
		//  Docloc this place holder we use for Encoded String
		String encodedString = visaDoc.getEncodedDoc().replaceAll("\n", "");
		StringBuilder fileName = new StringBuilder();
		
		// File name like 234567-1.png
		fileName.append(visaID).append("-").append(visaDoc.getDocId()).append(visaDoc.getDocType());
		
		FileOutputStream fileOP = null;
		byte[] imageByte;
        try {
            imageByte = Base64.getDecoder().decode(encodedString);
            fileOP= new FileOutputStream(HRManagementConstant.UPLOADEDPATH+fileName.toString());// Or PDF file
            fileOP.write(imageByte);
            
            visaDoc.setVisaID(visaID);
        //  Docloc this place holder we use for file name after Upload file
            visaDoc.setDocName(fileName.toString());
            
            LOGGER.debug("Successfully uploaded Visa Doc: " + fileName.toString());
            
        } catch (Exception e) {
        	LOGGER.debug(e.getMessage());
            throw new Exception(e);
        }finally {
        	if(null != fileOP) {
        		fileOP.close();
        	}
		}
		
		
	}

	private void validateVisaDetails(VisaDetails visaDetails) throws Exception {
		if(visaDetails == null || visaDetails.getVisa() == null || visaDetails.getVisaDocList().isEmpty()) {
			throw new Exception("VisaDetails is not valid");
		}
		
		if (null == visaDetails.getVisa().getEmpId()) {
			throw new Exception("Employee ID is required");
		}
		
		for(VisaDocument visaDoc : visaDetails.getVisaDocList()) {
			if(visaDoc.getEncodedDoc()== null || visaDoc.getDocType() == null) {
				throw new Exception("Visa Doc details is not valid");
			}
			if(visaDoc.getEncodedDoc().isEmpty()) {
				throw new Exception("Visa Doc encoded sting not provided");
			}
			if(visaDoc.getDocType().isEmpty()) {
				throw new Exception("Visa Doc type not provided");
			}
		}
	}
}
