package com.easybusiness.hrmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybusiness.hrmanagement.domain.VisaDocumentMaster;
import com.easybusiness.hrmanagement.repository.VisaDocumentMasterRepository;

@Service
public class VisaDocumentMasterService {
private static final Logger LOGGER = LoggerFactory.getLogger(VisaDocumentMasterService.class);
	
	@Autowired
	VisaDocumentMasterRepository visaDocumentMasterRepository;
	
	public List<VisaDocumentMaster> getAll() throws Exception{
		List<VisaDocumentMaster> visaDocumentMasterList = new ArrayList<>();
		try {
			visaDocumentMasterRepository.findAll().forEach(visaDocumentMasterList::add);
			LOGGER.debug("Successfully retrieve data from Table VisaDocumentMaster");
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			throw new Exception(e);
		}
		return visaDocumentMasterList;
	}
}
