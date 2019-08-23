package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Table(name = "TRAVEL_EXPENSE")
public class TravelExpense implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "TRAVEL_REQ_ID")
    private String travelReqId; 
    
    @Column(name = "EXPENSE_STLMNT_TYPE_ID")
    private Long expStlmntTypeId; 
    
    @Column(name = "TICKETNUM")
    private String ticketNumber; 
    
    @Column(name = "JOURNEYDATE")
    private Date journeyDate; 
    
    @Column(name = "PRICE")
    private Long price; 
    
    @Column(name = "HOTELNAME")
    private String hotelName; 
    
    @Column(name = "BILLNUMEBR")
    private Long billingNumber; 
    
    @Column(name = "BILLINGDATE")
    private Date billingDate; 
    
    @Column(name = "DURATIONOFSTAY")
    private Long durationStay; 
    
    @Column(name = "PERDAYCOST")
    private Long perdayCost; 
    
    @Column(name = "PENDING_WITH")
    private Long pendingWith;
        
	@Column(name = "REQUEST_STATUS")
    private Long requestStatus;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;
    
    @Column(name = "DIRECTAPPROVER")
    private Long directApprover;
    
    public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
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

	@Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTravelReqId() {
		return travelReqId;
	}

	public void setTravelReqId(String travelReqId) {
		this.travelReqId = travelReqId;
	}

	public Long getExpStlmntTypeId() {
		return expStlmntTypeId;
	}

	public void setExpStlmntTypeId(Long expStlmntTypeId) {
		this.expStlmntTypeId = expStlmntTypeId;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Long getBillingNumber() {
		return billingNumber;
	}

	public void setBillingNumber(Long billingNumber) {
		this.billingNumber = billingNumber;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public Long getDurationStay() {
		return durationStay;
	}

	public void setDurationStay(Long durationStay) {
		this.durationStay = durationStay;
	}

	public Long getPerdayCost() {
		return perdayCost;
	}

	public void setPerdayCost(Long perdayCost) {
		this.perdayCost = perdayCost;
	}

	public Long getPendingWith() {
		return pendingWith;
	}

	public void setPendingWith(Long pendingWith) {
		this.pendingWith = pendingWith;
	}

	public Long getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(Long requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Long getDirectApprover() {
		return directApprover;
	}

	public void setDirectApprover(Long directApprover) {
		this.directApprover = directApprover;
	}

	
}

