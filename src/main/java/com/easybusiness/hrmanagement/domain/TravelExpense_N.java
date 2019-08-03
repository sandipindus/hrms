package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Table(name = "TRAVEL_EXPENSE_N")
public class TravelExpense_N implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "TRAVEL_EXPENSE_ID")
    private Long travelExpID;
    
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
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;
    
    public Long getTravelExpID() {
		return travelExpID;
	}

	public void setTravelExpID(Long travelExpID) {
		this.travelExpID = travelExpID;
	}

	public Long getCreatedBy() {
		return createdBy;
	}
    
    @OneToMany(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name= "TRAVEL_EXPENSE_ID", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private List<TravelExpenseDay> travelExpenseDay;
    
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

	public List<TravelExpenseDay> getTravelExpenseDay() {
		return travelExpenseDay;
	}

	public void setTravelExpenseDay(List<TravelExpenseDay> travelExpenseDay) {
		this.travelExpenseDay = travelExpenseDay;
	}
    
    

	
}

