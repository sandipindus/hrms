package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Table(name = "TRAVEL_EXPENSE_COST_DETAILS")
public class TravelExpenseCostDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "TRAVEL_EXPENSE_ID")
    private Long travelExpId; 
    
    @Column(name = "FOOD")
    private Long food; 
    
    @Column(name = "BILLNUMBER")
    private Long billNumber; 
    
    @Column(name = "LOCALTRANSPORTCOST")
    private Long LocalTransportCost; 
    
    @Column(name = "TIPS")
    private Long tips; 
    
    @Column(name = "CLIENTENTERTAINMENT")
    private Long clientEntertainment; 
    
    @Column(name = "WATER")
    private Long water; 
    
    @Column(name = "LAUNDRY")
    private Long laundry; 
    
    @Column(name = "TELEPHONE")
    private Long telephone; 
    
    @Column(name = "DATACARD")
    private Long datacard; 
    
    @Column(name = "PRINTOUT")
    private Long printOut; 
    
    @Column(name = "SCAN")
    private Long scan;
    
    @Column(name = "CONVRATE")
    private Long convrate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTravelExpId() {
		return travelExpId;
	}

	public void setTravelExpId(Long travelExpId) {
		this.travelExpId = travelExpId;
	}

	public Long getFood() {
		return food;
	}

	public void setFood(Long food) {
		this.food = food;
	}

	public Long getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}

	public Long getLocalTransportCost() {
		return LocalTransportCost;
	}

	public void setLocalTransportCost(Long localTransportCost) {
		LocalTransportCost = localTransportCost;
	}

	public Long getTips() {
		return tips;
	}

	public void setTips(Long tips) {
		this.tips = tips;
	}

	public Long getClientEntertainment() {
		return clientEntertainment;
	}

	public void setClientEntertainment(Long clientEntertainment) {
		this.clientEntertainment = clientEntertainment;
	}

	public Long getWater() {
		return water;
	}

	public void setWater(Long water) {
		this.water = water;
	}

	public Long getLaundry() {
		return laundry;
	}

	public void setLaundry(Long laundry) {
		this.laundry = laundry;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public Long getDatacard() {
		return datacard;
	}

	public void setDatacard(Long datacard) {
		this.datacard = datacard;
	}

	public Long getPrintOut() {
		return printOut;
	}

	public void setPrintOut(Long printOut) {
		this.printOut = printOut;
	}

	public Long getScan() {
		return scan;
	}

	public void setScan(Long scan) {
		this.scan = scan;
	}

	public Long getConvrate() {
		return convrate;
	}

	public void setConvrate(Long convrate) {
		this.convrate = convrate;
	}

}

