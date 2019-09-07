package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_EXPENSE_COST_DETAILS")
public class TravelExpenseCostDetails extends TravelExpenseDocument implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "TRAVEL_EXPENSE_ID")
    private Long travelExpId; 
    
    @Column(name = "FOOD")
    private Long food; 
    
    @Column(name = "BILLNUMBER")
    private String billNumber; 
    
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

    @Column(name = "DAY")
    private Long day;
    
    @Column(name = "LOCALTRANSPORTBILL")
    private String localTransBill;
    
    @Column(name = "CLIENTENTERTAINMENTBILL")
    private String clientEntertainmentBill;
    
    @Column(name = "WATERBILL")
    private String waterBill;
    
    @Column(name = "FOODBILL")
    private String foodBill;
    
    @Column(name = "LAUNDRYBILL")
    private String laundryBill;
    
    @Column(name = "TELEPHONEBILL")
    private String telephoneBill;
    
    @Column(name = "DATACARDBILL")
    private String datacardBill;
    
    @Column(name = "PRINTOUTBILL")
    private String printOutBill;
    
    @Column(name = "SCANBILL")
    private String scanBill;
    
    @Column(name = "FOOD_DOC_NAME")
    private String foodDocumentName;
    
    @Column(name = "CLIENT_ENT_DOC_NAME")
    private String clientEntertainmentDocumentName;
   
    @Column(name = "WATER_DOC_NAME")
    private String waterDocumentName;
    
    @Column(name = "LAUNDRY_DOC_NAME")
    private String laundryDocumentName;
    
    @Column(name = "TELEPHONE_DOC_NAME")
    private String telephoneDocumentName;
    
    @Column(name = "DATA_CARD_DOC_NAME")
    private String datacardDocumentName;
    
    @Column(name = "PRINT_OUT_DOC_NAME")
    private String printOutDocumentName;
    
    @Column(name = "SCAN_DOC_NAME")
    private String scanDocumentName;
    
    @Column(name = "LOCAL_TRANS_DOC_NAME")
    private String localTransDocumentName;
    
    public String getLocalTransBill() {
		return localTransBill;
	}

	public void setLocalTransBill(String localTransBill) {
		this.localTransBill = localTransBill;
	}

	public String getClientEntertainmentBill() {
		return clientEntertainmentBill;
	}

	public void setClientEntertainmentBill(String clientEntertainmentBill) {
		this.clientEntertainmentBill = clientEntertainmentBill;
	}

	public String getWaterBill() {
		return waterBill;
	}

	public void setWaterBill(String waterBill) {
		this.waterBill = waterBill;
	}

	public String getFoodBill() {
		return foodBill;
	}

	public void setFoodBill(String foodBill) {
		this.foodBill = foodBill;
	}

	public String getLaundryBill() {
		return laundryBill;
	}

	public void setLaundryBill(String laundryBill) {
		this.laundryBill = laundryBill;
	}

	public String getTelephoneBill() {
		return telephoneBill;
	}

	public void setTelephoneBill(String telephoneBill) {
		this.telephoneBill = telephoneBill;
	}

	public String getDatacardBill() {
		return datacardBill;
	}

	public void setDatacardBill(String datacardBill) {
		this.datacardBill = datacardBill;
	}

	public String getPrintOutBill() {
		return printOutBill;
	}

	public void setPrintOutBill(String printOutBill) {
		this.printOutBill = printOutBill;
	}

	public String getScanBill() {
		return scanBill;
	}

	public void setScanBill(String scanBill) {
		this.scanBill = scanBill;
	}

	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

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

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
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

	public String getFoodDocumentName() {
		return foodDocumentName;
	}

	public String getClientEntertainmentDocumentName() {
		return clientEntertainmentDocumentName;
	}

	public String getWaterDocumentName() {
		return waterDocumentName;
	}

	public String getLaundryDocumentName() {
		return laundryDocumentName;
	}

	public String getTelephoneDocumentName() {
		return telephoneDocumentName;
	}

	public String getDatacardDocumentName() {
		return datacardDocumentName;
	}

	public String getPrintOutDocumentName() {
		return printOutDocumentName;
	}

	public String getScanDocumentName() {
		return scanDocumentName;
	}

	public String getLocalTransDocumentName() {
		return localTransDocumentName;
	}

	public void setFoodDocumentName(String foodDocumentName) {
		this.foodDocumentName = foodDocumentName;
	}

	public void setClientEntertainmentDocumentName(String clientEntertainmentDocumentName) {
		this.clientEntertainmentDocumentName = clientEntertainmentDocumentName;
	}

	public void setWaterDocumentName(String waterDocumentName) {
		this.waterDocumentName = waterDocumentName;
	}

	public void setLaundryDocumentName(String laundryDocumentName) {
		this.laundryDocumentName = laundryDocumentName;
	}

	public void setTelephoneDocumentName(String telephoneDocumentName) {
		this.telephoneDocumentName = telephoneDocumentName;
	}

	public void setDatacardDocumentName(String datacardDocumentName) {
		this.datacardDocumentName = datacardDocumentName;
	}

	public void setPrintOutDocumentName(String printOutDocumentName) {
		this.printOutDocumentName = printOutDocumentName;
	}

	public void setScanDocumentName(String scanDocumentName) {
		this.scanDocumentName = scanDocumentName;
	}

	public void setLocalTransDocumentName(String localTransDocumentName) {
		this.localTransDocumentName = localTransDocumentName;
	}

}

