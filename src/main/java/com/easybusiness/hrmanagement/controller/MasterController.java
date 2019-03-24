package com.easybusiness.hrmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;
import com.easybusiness.hrmanagement.service.CityService;
import com.easybusiness.hrmanagement.service.CountryService;
import com.easybusiness.hrmanagement.service.TravelAccomTypeService;
import com.easybusiness.hrmanagement.service.TravelPurposeService;
import com.easybusiness.hrmanagement.service.TravelRequestStatusService;
import com.easybusiness.hrmanagement.service.TravelTicketBookingTypeService;
import com.easybusiness.hrmanagement.service.TravelTicketCategoryService;
import com.easybusiness.hrmanagement.service.TravelTicketSubCategoryService;
import com.easybusiness.hrmanagement.service.TravelTypeService;
import com.easybusiness.hrmanagement.service.VisaDocumentMasterService;

@RestController
@RequestMapping("/hrmanagement")
public class MasterController {
	
	@Autowired
	TravelTypeService travelTypeService;

//	@Autowired
//	TravelModeService travelModeService;
	
	@Autowired
	TravelAccomTypeService travelAccomTypeService;
	
	@Autowired
	TravelPurposeService travelPurposeService;
	
	@Autowired
	TravelTicketBookingTypeService travelTicketBookingTypeService;
	
	@Autowired
	TravelTicketCategoryService travelTicketCategoryService;
	
	@Autowired
	TravelTicketSubCategoryService travelTicketSubCategoryService;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	TravelRequestStatusService travelRequestStatusService;
	
	@Autowired
	VisaDocumentMasterService visaDocumentMasterService;
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/findAll")
	public Map<String, List<Object>> getAllMasterData() throws Exception {
		
		Map<String, List<Object>> resultMap = new HashMap<>();
		
		List<Object> allTravelersObj = new ArrayList<>();
//		List<Object> allTravelModesObj = new ArrayList<>();
		List<Object> allTravelAccomTypesObj = new ArrayList<>();
		List<Object> allTravelPurposeTypesObj = new ArrayList<>();
		List<Object> allTravelTicketBookingTypesObj = new ArrayList<>();
		List<Object> allTravelTicketCategoryObj = new ArrayList<>();
		List<Object> allTravelTicketSubCategoryObj = new ArrayList<>();
		List<Object> allCitiesObj = new ArrayList<>();
		List<Object> allTravelRequestStatus = new ArrayList<>();
		
		travelTypeService.getAll().forEach(allTravelersObj :: add);
		
//		travelModeService.getAll().forEach(allTravelModesObj :: add);
		
		travelAccomTypeService.getAll().forEach(allTravelAccomTypesObj :: add);
		
		travelPurposeService.getAll().forEach(allTravelPurposeTypesObj :: add);
		
		travelTicketBookingTypeService.getAll().forEach(allTravelTicketBookingTypesObj :: add);
		
		travelTicketCategoryService.getAll().forEach(allTravelTicketCategoryObj :: add);
		
		travelTicketSubCategoryService.getAll().forEach(allTravelTicketSubCategoryObj :: add);
		
		cityService.getAll().forEach(allCitiesObj :: add);
		
		travelRequestStatusService.getAll().forEach(allTravelRequestStatus :: add);
		
		resultMap.put("TravelerType", allTravelersObj);
//		resultMap.put("TravelMode", allTravelModesObj);
		resultMap.put("TravelAccomType", allTravelAccomTypesObj);
		resultMap.put("TravelPurpose", allTravelPurposeTypesObj);
		resultMap.put("TravelTicketBookingType", allTravelTicketBookingTypesObj);
		resultMap.put("TravelTicketCategory", allTravelTicketCategoryObj);
		resultMap.put("TravelTicketSubCategory", allTravelTicketSubCategoryObj);
		resultMap.put("Cities", allCitiesObj);
		resultMap.put("TravelRequestStatus", allTravelRequestStatus);
		
		return resultMap;
	}
	
	@GetMapping("/findEachMaster")
	public Map<String, List<Object>> getSpecificMasterData(@RequestParam("MASTER_TABLE") String tableType) throws Exception {
		
		Map<String, List<Object>> resultMap = null;
		
		if (HRManagementConstant.VISA_DOCUMENT.equals(tableType)) {
			resultMap = new HashMap<>();
			List<Object> visaDocumentObj = new ArrayList<>();
			visaDocumentMasterService.getAll().forEach(visaDocumentObj :: add);
			resultMap.put("VisaDocumentTypes", visaDocumentObj);
		} else if (HRManagementConstant.COUNTRY.equals(tableType)) {
			resultMap = new HashMap<>();
			List<Object> countryObj = new ArrayList<>();
			countryService.getAll().forEach(countryObj :: add);
			resultMap.put("Countries", countryObj);
		}
		
		return resultMap;
	}
}
