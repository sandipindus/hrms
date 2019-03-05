package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_REQUEST")
public class TravelRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "TRAVEL_TYPE_ID")
    private Long travelTypeId;
    
    @Column(name = "TRAVEL_MODE_ID")
    private Long travelModeId;
    
    @Column(name = "TRAVEL_PURPOSE_ID")
    private Long travelPurposeId;
    
    @Column(name = "TRAVEL_FORM")
    private String travelFrom;
    
    @Column(name = "TRAVEL_TO")
    private String travelTo;
    
    @Column(name = "TRAVEL_DATE_OF_JOURNEY")
    private Date travelDateOfJourney;
    
    @Column(name = "TRAVEL_DATE_OF_RETURN")
    private Date travelDateOfReturn;
    
    @Column(name = "TRAVEL_TICKET_CATEGORY_ID")
    private Long travelTicketCategoryId;
    
    @Column(name = "TRAVEL_TICKET_SUB_CATEGORY_ID")
    private Long travelTicketSubCategoryId;
    
    @Column(name = "TRAVEL_TICKET_BOOKING_TPE_ID")
    private Long travelTicketBookingTypeId;
    
    @Column(name = "COLUMN1")
    private Long projectId;
    
    @Column(name = "TRAVEL_ACCOM_TYPE_ID")
    private Long travelAccomTypeId;
    
    @Column(name = "TRAVEL_ADVANCE")
    private String travelAdvance;
	
    
    public Long getTravelTypeId() {
		return travelTypeId;
	}

	public void setTravelTypeId(Long travelTypeId) {
		this.travelTypeId = travelTypeId;
	}


	public Long getTravelModeId() {
		return travelModeId;
	}


	public void setTravelModeId(Long travelModeId) {
		this.travelModeId = travelModeId;
	}


	public Long getTravelPurposeId() {
		return travelPurposeId;
	}


	public void setTravelPurposeId(Long travelPurposeId) {
		this.travelPurposeId = travelPurposeId;
	}


	public String getTravelFrom() {
		return travelFrom;
	}


	public void setTravelFrom(String travelFrom) {
		this.travelFrom = travelFrom;
	}


	public String getTravelTo() {
		return travelTo;
	}


	public void setTravelTo(String travelTo) {
		this.travelTo = travelTo;
	}


	public Date getTravelDateOfJourney() {
		return travelDateOfJourney;
	}


	public void setTravelDateOfJourney(Date travelDateOfJourney) {
		this.travelDateOfJourney = travelDateOfJourney;
	}


	public Date getTravelDateOfReturn() {
		return travelDateOfReturn;
	}


	public void setTravelDateOfReturn(Date travelDateOfReturn) {
		this.travelDateOfReturn = travelDateOfReturn;
	}


	public Long getTravelTicketCategoryId() {
		return travelTicketCategoryId;
	}


	public void setTravelTicketCategoryId(Long travelTicketCategoryId) {
		this.travelTicketCategoryId = travelTicketCategoryId;
	}


	public Long getTravelTicketSubCategoryId() {
		return travelTicketSubCategoryId;
	}


	public void setTravelTicketSubCategoryId(Long travelTicketSubCategoryId) {
		this.travelTicketSubCategoryId = travelTicketSubCategoryId;
	}


	public Long getTravelTicketBookingTypeId() {
		return travelTicketBookingTypeId;
	}


	public void setTravelTicketBookingTypeId(Long travelTicketBookingTypeId) {
		this.travelTicketBookingTypeId = travelTicketBookingTypeId;
	}


	public Long getProjectId() {
		return projectId;
	}


	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}


	public Long getTravelAccomTypeId() {
		return travelAccomTypeId;
	}


	public void setTravelAccomTypeId(Long travelAccomTypeId) {
		this.travelAccomTypeId = travelAccomTypeId;
	}


	public String getTravelAdvance() {
		return travelAdvance;
	}


	public void setTravelAdvance(String travelAdvance) {
		this.travelAdvance = travelAdvance;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
    public String toString() {
	return "TRAVEL_Mode [id=" + id + ", modeOfTravel=" +  "]";
    }
}

