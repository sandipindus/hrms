package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
    private Long travelReqId; 
    
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
    
    @Column(name = "EXPENSE_STATUS")
    private Long expStatus; 
    
    @Column(name = "PERDAYCOST")
    private Long perdayCost; 
    
    @Column(name = "PENDINGWITH_APPROVER1")
    private Long approver1;
    
    @Column(name = "APPROVER1_STATUS")
    private Long approver1Status;
    
    @Column(name = "PENDINGWITH_APPROVER2")
    private Long approver2;
    
    @Column(name = "APPROVER2_STATUS")
    private Long approver2Status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTravelReqId() {
		return travelReqId;
	}

	public void setTravelReqId(Long travelReqId) {
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

	public Long getExpStatus() {
		return expStatus;
	}

	public void setExpStatus(Long expStatus) {
		this.expStatus = expStatus;
	}

	public Long getPerdayCost() {
		return perdayCost;
	}

	public void setPerdayCost(Long perdayCost) {
		this.perdayCost = perdayCost;
	}

	public Long getApprover1() {
		return approver1;
	}

	public void setApprover1(Long approver1) {
		this.approver1 = approver1;
	}

	public Long getApprover1Status() {
		return approver1Status;
	}

	public void setApprover1Status(Long approver1Status) {
		this.approver1Status = approver1Status;
	}

	public Long getApprover2() {
		return approver2;
	}

	public void setApprover2(Long approver2) {
		this.approver2 = approver2;
	}

	public Long getApprover2Status() {
		return approver2Status;
	}

	public void setApprover2Status(Long approver2Status) {
		this.approver2Status = approver2Status;
	}

	
    
    

	
}

