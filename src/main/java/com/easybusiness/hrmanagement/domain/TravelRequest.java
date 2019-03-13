package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

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
    
    @Column(name = "PROJECT_ID")
    private Long projectId;
    
    @Column(name = "TRAVEL_ACCOM_TYPE_ID")
    private Long travelAccomTypeId;
    
    @Column(name = "TRAVEL_ADVANCE")
    private String travelAdvance;
    
    @Column(name = "PENDINGWITH_APPROVER1")
    private Long approver1;
    
    @Column(name = "APPROVER1_STATUS")
    private String approver1Status;
    
    @Column(name = "PENDINGWITH_APPROVER2")
    private Long approver2;
    
    @Column(name = "APPROVER2_STATUS")
    private String approver2Status;
    
    @Column(name = "TRAVEL_REQEST_STATUS")
    private String travelRequestStatus;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    
    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;
    
    @Column(name = "MIDIFIED_DATE")
    private Timestamp modifiedDate;
    
    @Column(name = "ISDELETED")
    private int isDeleted;
    
    @Column(name="TRAVEL_REQUEST_ID")
    private String travelRequestID;
    
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


	public Long getApprover1() {
		return approver1;
	}

	public void setApprover1(Long approver1) {
		this.approver1 = approver1;
	}

	public String getApprover1Status() {
		return approver1Status;
	}

	public void setApprover1Status(String approver1Status) {
		this.approver1Status = approver1Status;
	}

	public Long getApprover2() {
		return approver2;
	}

	public void setApprover2(Long approver2) {
		this.approver2 = approver2;
	}

	public String getApprover2Status() {
		return approver2Status;
	}

	public void setApprover2Status(String approver2Status) {
		this.approver2Status = approver2Status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public String getTravelRequestStatus() {
		return travelRequestStatus;
	}

	public void setTravelRequestStatus(String travelRequestStatus) {
		this.travelRequestStatus = travelRequestStatus;
	}

	public String getTravelRequestID() {
		return travelRequestID;
	}

	public void setTravelRequestID(String travelRequestID) {
		this.travelRequestID = travelRequestID;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
    public String toString() {
	return "TRAVEL_Request [id=" + id +  "]";
    }
}

