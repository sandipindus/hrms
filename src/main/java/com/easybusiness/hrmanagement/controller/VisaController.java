package com.easybusiness.hrmanagement.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.easybusiness.hrmanagement.domain.VisaDetails;

@RestController
@RequestMapping("/hrmanagement/visa")
public class VisaController {
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addVisaDetails")
	public String addTravelRequest(@RequestBody VisaDetails visaDetails, @RequestParam("files") MultipartFile[] files) throws Exception {
		return null;
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
	
	@RequestMapping(method=RequestMethod.POST, value="/addSingleVisaDetails")
	public String uploadFile(@RequestBody String file) throws IOException {
        byte[] imageByte;
        try {
            imageByte = Base64.getDecoder().decode(file);
            FileOutputStream fileOP= new FileOutputStream("C://Main/PIC/image.jpeg");// Or PDF file
            fileOP.write(imageByte);
            fileOP.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
		}
        return "Success";
        
    }
	
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
	
	public Resource loadFileAsResource(String fileName) {
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
