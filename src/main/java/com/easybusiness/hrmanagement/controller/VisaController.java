package com.easybusiness.hrmanagement.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.groovy.classgen.ReturnAdder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.ReturnMessage;
import com.easybusiness.hrmanagement.domain.Visa;
import com.easybusiness.hrmanagement.domain.VisaDetails;
import com.easybusiness.hrmanagement.domain.VisaDocument;
import com.easybusiness.hrmanagement.domain.VisaDocumentType;
import com.easybusiness.hrmanagement.service.VisaDocumentService;
import com.easybusiness.hrmanagement.service.VisaService;

@RestController
@RequestMapping("/hrmanagement/visa")
public class VisaController {
	
	private static final String UPLOADEDPATH = "C://Main/PIC/";
	private static final Logger LOGGER = LoggerFactory.getLogger(VisaController.class);
	
	@Autowired
	VisaService visaService;
	
	@Autowired
	VisaDocumentService visaDocumentService;
	
	@RequestMapping(method=RequestMethod.GET, value="/getVisaDetails")
	public VisaDetails getVisa() throws Exception {
		Random rand = new Random();
		
		VisaDetails visaDetails = new VisaDetails();
		
		Visa visa = new Visa();
		visa.setVisaID(rand.nextLong());
		visa.setVisaType("Test");
		visa.setCountryTypeId(1);
		visa.setCreatedBy(new Long(111111));
		visa.setDuration(1);
		visa.setEmpId(new Long(110011));
		
		List<VisaDocument> visaDocList = new ArrayList<>();
		
		VisaDocument visaDoc = new VisaDocument();
		visaDoc.setVisaID(visa.getVisaID());
		visaDoc.setDocName("Doc1");
		visaDoc.setDocType(".png");
		visaDoc.setDocId(1);
		visaDocList.add(visaDoc);
		
		VisaDocument visaDoc1 = new VisaDocument();
		visaDoc1.setVisaID(visa.getVisaID());
		visaDoc1.setDocName("Doc2");
		visaDoc1.setDocType(".png");
		visaDoc1.setDocId(2);
		visaDocList.add(visaDoc1);
		
		visaDetails.setVisa(visa);
		visaDetails.setVisaDocList(visaDocList);
		
		
		
		return visaDetails;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllVisaDetails")
	public List<Visa> getAllVisa() throws Exception {
		List<Visa> visaList = visaService.getAll();
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
		//visaDetails.getVisa().setCreatedBy(visaDetails.getVisa().getEmpId());
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
		visaFromDB.setApprover(payloadVisa.getApprover());
		
		visaFromDB.setStatusId(payloadVisa.getStatusId());
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		visaFromDB.setModifiedDate(timestamp);
		
		visaService.addVisa(visaFromDB);
		
		StringBuilder message = new StringBuilder();
		message.append(visaID).append(" ").append(HRManagementConstant.UPDATED_SUCCESSFULLY);
		
		ReturnMessage returnMessage = new ReturnMessage(message.toString());
		
		return returnMessage;
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
            fileOP= new FileOutputStream(UPLOADEDPATH+fileName.toString());// Or PDF file
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
		
		if (null == visaDetails.getVisa().getApprover()) {
			throw new Exception("Visa Approver is required");
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

	/*@RequestMapping(method=RequestMethod.POST, value="/addSingleVisaDetails")
	public String uploadFile(@RequestBody String file) throws IOException {
		BufferedImage image = null;
        byte[] imageByte;
        ByteArrayInputStream bis = null;
        try {
            imageByte = Base64.getDecoder().decode(file);
            bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);

            ImageIO.write(image, "jpeg", new File("C://Main/PIC/image.jpeg"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	bis.close();
		}
        return "Success";
        
    }*/
	
	/*@RequestMapping(method=RequestMethod.POST, value="/addSingleVisaDetails")
	public String uploadFile(@RequestBody String file) throws IOException {
        byte[] imageByte;
        try {
            imageByte = Base64.getDecoder().decode(file);
            FileOutputStream fileOP= new FileOutputStream("C://Main/PIC/Test.pdf");// Or PDF file
            fileOP.write(imageByte);
            fileOP.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
		}
        return "Success";
        
    }*/
	
	@RequestMapping(method=RequestMethod.GET, value="/downloadFile/{fileName}/{extension}")
    public ReturnMessage downloadFile(@PathVariable String fileName, @PathVariable String extension) throws IOException {
		
		String fullFileName =  fileName + "." + extension;
		String encodeFileToBase64Binary = encodeFileToBase64Binary(fullFileName);
		
		ReturnMessage returnMessage = new ReturnMessage(encodeFileToBase64Binary);
		
		return returnMessage;
    }
	
	private String encodeFileToBase64Binary(String fileName)
	        throws IOException {
		String fullFlie = UPLOADEDPATH + fileName;
		
	    File file = new File(fullFlie);
	    byte[] bytes = loadFile(file);
	    byte[] encoded = Base64.getEncoder().encode(bytes);
	    String encodedString = new String(encoded,StandardCharsets.UTF_8);
	    
	    return encodedString;
	}
	private byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];

	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    is.close();
	    return bytes;
	}
}
