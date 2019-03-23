package com.easybusiness.hrmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.Visa;
import com.easybusiness.hrmanagement.domain.VisaDetails;
import com.easybusiness.hrmanagement.domain.VisaDocument;
import com.easybusiness.hrmanagement.repository.VisaDocumentRepository;
import com.easybusiness.hrmanagement.repository.VisaRepository;

@Service
public class VisaAndVisaDocumentService {
private static final Logger LOGGER = LoggerFactory.getLogger(VisaAndVisaDocumentService.class);
	
	@Autowired
	VisaRepository visaRepository;
	
	@Autowired
	VisaDocumentRepository visaDocumentRepository;
	
	public VisaDetails getByVisaId(Long id) throws Exception {
		VisaDetails visaDetails = new VisaDetails();
		try {
			Visa visa = visaRepository.findByVisaID(id);
			
			List<VisaDocument> visaDocuments = visaDocumentRepository.findByvisaID(id);

			visaDetails.setVisa(visa);

			visaDetails.setVisaDocList(visaDocuments);
			
			LOGGER.debug("Successfully retrieve data from Table VisaDocumentMaster");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return visaDetails;
	}
}
