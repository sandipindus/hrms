package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.Visa;
import com.easybusiness.hrmanagement.domain.VisaDocument;
import com.easybusiness.hrmanagement.repository.VisaDocumentRepository;

@Service
public class VisaDocumentService {
private static final Logger LOGGER = LoggerFactory.getLogger(VisaDocumentService.class);
	
	@Autowired
	VisaDocumentRepository visaDocumentRepository;
	
	public List<VisaDocument> getAll() throws Exception{
		List<VisaDocument> visaDocumentList = new ArrayList<>();
		try {
			visaDocumentRepository.findAll().forEach(visaDocumentList::add);
			LOGGER.debug("Successfully retrieve data from Table VisaDocument");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return visaDocumentList;
	}
	
	public void addVisaDocument(VisaDocument visaDoc) throws Exception{
		try {
			visaDocumentRepository.save(visaDoc);
			LOGGER.debug("Successfully saved data into Table VisaDocument");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
	}
}
