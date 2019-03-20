package com.easybusiness.hrmanagement.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.domain.VisaDetails;
import com.easybusiness.hrmanagement.domain.VisaDocument;
import com.easybusiness.hrmanagement.service.TravelRequestService;
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
	
	@RequestMapping(method=RequestMethod.POST, value="/addVisaDetails")
	public String addTravelRequest(@RequestBody VisaDetails visaDetails) throws Exception {
		
		validateVisaDetails(visaDetails);
		//To do random number 
		Random rand = new Random();
		visaDetails.getVisa().setVisaID(rand.nextLong());
		for(VisaDocument visaDoc : visaDetails.getVisaDocList()) {
			
			uploadVisaDoc(visaDoc, visaDetails.getVisa().getVisaID());
			//Add Visa doc in DB
			visaDocumentService.addVisaDocument(visaDoc);
		}
		
		//Add Visa Details in DB
		visaService.addVisa(visaDetails.getVisa());
		
		StringBuilder message = new StringBuilder();
		message.append(visaDetails.getVisa().getVisaID()).append(" ").append(HRManagementConstant.ADDED_SUCCESSFULLY);
		
		return message.toString();
	}
	
	private void uploadVisaDoc(VisaDocument visaDoc, Long visaID) throws Exception {
		//  Docloc this place holder we use for Encoded String
		String encodedString = visaDoc.getDocloc();
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
            visaDoc.setDocloc(fileName.toString());
            
            LOGGER.debug("Successfully uploaded Visa Doc: " + fileName.toString());
            
        } catch (Exception e) {
        	LOGGER.debug(e.getMessage());
            throw new Exception(e);
        }finally {
        	fileOP.close();
		}
		
		
	}

	private void validateVisaDetails(VisaDetails visaDetails) throws Exception {
		if(visaDetails == null || visaDetails.getVisa() == null || visaDetails.getVisaDocList().isEmpty()) {
			throw new Exception("VisaDetails is not valid");
		}
		
		for(VisaDocument visaDoc : visaDetails.getVisaDocList()) {
			if(visaDoc.getDocloc().isEmpty()) {
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
	
	@GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
	private Resource loadFileAsResource(String fileName) {
        try {
        	Path fileStorageLocation = Paths.get("C://Main/PIC/")
            .toAbsolutePath().normalize();
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
            }
        } catch (MalformedURLException ex) {
        }
		return null;
    }
	
	
}
