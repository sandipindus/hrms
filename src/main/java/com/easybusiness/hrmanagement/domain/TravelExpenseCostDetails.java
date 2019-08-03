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
public class TravelExpenseCostDetails implements Serializable {

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
    
    
    
    private FoodDocument foodDocument;
    @Column(name = "FOOD_DOC_NAME")
    private String foodDocumentName;
    
    private ClientEntertainmentDocument clientEntertainmentDocument;
    @Column(name = "CLIENT_ENT_DOC_NAME")
    private String clientEntertainmentDocumentName;
    
    private WaterDocument waterDocument;
    @Column(name = "WATER_DOC_NAME")
    private String waterDocumentName;
    
    private LaundryDocument laundryDocument;
    @Column(name = "LAUNDRY_DOC_NAME")
    private String laundryDocumentName;
    
    private TelephoneDocument telephoneDocument;
    @Column(name = "TELEPHONE_DOC_NAME")
    private String telephoneDocumentName;
    
    private DatacardDocument datacardDocument;
    @Column(name = "DATA_CARD_DOC_NAME")
    private String datacardDocumentName;
    
    private PrintOutDocument printOutDocument;
    @Column(name = "PRINT_OUT_DOC_NAME")
    private String printOutDocumentName;
    
    private ScanDocument scanDocument;
    @Column(name = "SCAN_DOC_NAME")
    private String scanDocumentName;
    
    private LocalTransDocument localTransDocument;
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

	public FoodDocument getFoodDocument() {
		return foodDocument;
	}

	public String getFoodDocumentName() {
		return foodDocumentName;
	}

	public ClientEntertainmentDocument getClientEntertainmentDocument() {
		return clientEntertainmentDocument;
	}

	public String getClientEntertainmentDocumentName() {
		return clientEntertainmentDocumentName;
	}

	public WaterDocument getWaterDocument() {
		return waterDocument;
	}

	public String getWaterDocumentName() {
		return waterDocumentName;
	}

	public LaundryDocument getLaundryDocument() {
		return laundryDocument;
	}

	public String getLaundryDocumentName() {
		return laundryDocumentName;
	}

	public TelephoneDocument getTelephoneDocument() {
		return telephoneDocument;
	}

	public String getTelephoneDocumentName() {
		return telephoneDocumentName;
	}

	public DatacardDocument getDatacardDocument() {
		return datacardDocument;
	}

	public String getDatacardDocumentName() {
		return datacardDocumentName;
	}

	public PrintOutDocument getPrintOutDocument() {
		return printOutDocument;
	}

	public String getPrintOutDocumentName() {
		return printOutDocumentName;
	}

	public ScanDocument getScanDocument() {
		return scanDocument;
	}

	public String getScanDocumentName() {
		return scanDocumentName;
	}

	public LocalTransDocument getLocalTransDocument() {
		return localTransDocument;
	}

	public String getLocalTransDocumentName() {
		return localTransDocumentName;
	}

	public void setFoodDocument(FoodDocument foodDocument) {
		this.foodDocument = foodDocument;
	}

	public void setFoodDocumentName(String foodDocumentName) {
		this.foodDocumentName = foodDocumentName;
	}

	public void setClientEntertainmentDocument(ClientEntertainmentDocument clientEntertainmentDocument) {
		this.clientEntertainmentDocument = clientEntertainmentDocument;
	}

	public void setClientEntertainmentDocumentName(String clientEntertainmentDocumentName) {
		this.clientEntertainmentDocumentName = clientEntertainmentDocumentName;
	}

	public void setWaterDocument(WaterDocument waterDocument) {
		this.waterDocument = waterDocument;
	}

	public void setWaterDocumentName(String waterDocumentName) {
		this.waterDocumentName = waterDocumentName;
	}

	public void setLaundryDocument(LaundryDocument laundryDocument) {
		this.laundryDocument = laundryDocument;
	}

	public void setLaundryDocumentName(String laundryDocumentName) {
		this.laundryDocumentName = laundryDocumentName;
	}

	public void setTelephoneDocument(TelephoneDocument telephoneDocument) {
		this.telephoneDocument = telephoneDocument;
	}

	public void setTelephoneDocumentName(String telephoneDocumentName) {
		this.telephoneDocumentName = telephoneDocumentName;
	}

	public void setDatacardDocument(DatacardDocument datacardDocument) {
		this.datacardDocument = datacardDocument;
	}

	public void setDatacardDocumentName(String datacardDocumentName) {
		this.datacardDocumentName = datacardDocumentName;
	}

	public void setPrintOutDocument(PrintOutDocument printOutDocument) {
		this.printOutDocument = printOutDocument;
	}

	public void setPrintOutDocumentName(String printOutDocumentName) {
		this.printOutDocumentName = printOutDocumentName;
	}

	public void setScanDocument(ScanDocument scanDocument) {
		this.scanDocument = scanDocument;
	}

	public void setScanDocumentName(String scanDocumentName) {
		this.scanDocumentName = scanDocumentName;
	}

	public void setLocalTransDocument(LocalTransDocument localTransDocument) {
		this.localTransDocument = localTransDocument;
	}

	public void setLocalTransDocumentName(String localTransDocumentName) {
		this.localTransDocumentName = localTransDocumentName;
	}

}

