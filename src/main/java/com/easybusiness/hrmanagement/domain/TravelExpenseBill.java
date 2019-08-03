package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_EXPENSE_BILL")
public class TravelExpenseBill extends Base64String implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "BILL_ID")
    private Long billID;
    
	@Column(name = "EXPENSE_DAY_ID")
	private String expDayId;
    
    @Column(name = "BILL_TYPE")
    private String billType; 
    
    @Column(name = "BILLNUMBER")
    private Long billNumber; 
    
    @Column(name = "AMOUNT")
    private Double amount;

	public Long getBillID() {
		return billID;
	}

	public String getExpDayId() {
		return expDayId;
	}

	public String getBillType() {
		return billType;
	}

	public Long getBillNumber() {
		return billNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setBillID(Long billID) {
		this.billID = billID;
	}

	public void setExpDayId(String expDayId) {
		this.expDayId = expDayId;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	} 
    
    

}

