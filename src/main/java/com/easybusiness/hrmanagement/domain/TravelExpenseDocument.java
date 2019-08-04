package com.easybusiness.hrmanagement.domain;

import java.io.Serializable;

public class TravelExpenseDocument implements Serializable {

	private static final long serialVersionUID = 1L;

	private FoodDocument foodDocument;

	private ClientEntertainmentDocument clientEntertainmentDocument;

	private WaterDocument waterDocument;

	private LaundryDocument laundryDocument;

	private TelephoneDocument telephoneDocument;

	private DatacardDocument datacardDocument;

	private PrintOutDocument printOutDocument;

	private ScanDocument scanDocument;

	private LocalTransDocument localTransDocument;

	public FoodDocument getFoodDocument() {
		return foodDocument;
	}

	public void setFoodDocument(FoodDocument foodDocument) {
		this.foodDocument = foodDocument;
	}

	public ClientEntertainmentDocument getClientEntertainmentDocument() {
		return clientEntertainmentDocument;
	}

	public void setClientEntertainmentDocument(ClientEntertainmentDocument clientEntertainmentDocument) {
		this.clientEntertainmentDocument = clientEntertainmentDocument;
	}

	public WaterDocument getWaterDocument() {
		return waterDocument;
	}

	public void setWaterDocument(WaterDocument waterDocument) {
		this.waterDocument = waterDocument;
	}

	public LaundryDocument getLaundryDocument() {
		return laundryDocument;
	}

	public void setLaundryDocument(LaundryDocument laundryDocument) {
		this.laundryDocument = laundryDocument;
	}

	public TelephoneDocument getTelephoneDocument() {
		return telephoneDocument;
	}

	public void setTelephoneDocument(TelephoneDocument telephoneDocument) {
		this.telephoneDocument = telephoneDocument;
	}

	public DatacardDocument getDatacardDocument() {
		return datacardDocument;
	}

	public void setDatacardDocument(DatacardDocument datacardDocument) {
		this.datacardDocument = datacardDocument;
	}

	public PrintOutDocument getPrintOutDocument() {
		return printOutDocument;
	}

	public void setPrintOutDocument(PrintOutDocument printOutDocument) {
		this.printOutDocument = printOutDocument;
	}

	public ScanDocument getScanDocument() {
		return scanDocument;
	}

	public void setScanDocument(ScanDocument scanDocument) {
		this.scanDocument = scanDocument;
	}

	public LocalTransDocument getLocalTransDocument() {
		return localTransDocument;
	}

	public void setLocalTransDocument(LocalTransDocument localTransDocument) {
		this.localTransDocument = localTransDocument;
	}
}
