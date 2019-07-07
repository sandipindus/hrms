package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OMS_LOCATION_MASTER")
public class LocationMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "LOC_NUM")
    private Long locNum;
    
    @Column(name = "COUNTRY_ID")
    private Long countryID;   
    
    @Column(name = "STATE_ID")
    private Long stateID;  
    
    @Column(name = "CITY_ID")
    private Long cityID;  
    
    @Column(name = "LOCATION")
    private String location;  
    
    @Column(name = "PINCODE")
    private Long pincode;  
    
    @Column(name = "MOD_BY")
    private String modBy;  
    
    @Column(name = "MOD_DATE")
    private Date modDate;

	public Long getLocNum() {
		return locNum;
	}

	public Long getCountryID() {
		return countryID;
	}

	public Long getStateID() {
		return stateID;
	}

	public Long getCityID() {
		return cityID;
	}

	public String getLocation() {
		return location;
	}

	public Long getPincode() {
		return pincode;
	}

	public String getModBy() {
		return modBy;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setLocNum(Long locNum) {
		this.locNum = locNum;
	}

	public void setCountryID(Long countryID) {
		this.countryID = countryID;
	}

	public void setStateID(Long stateID) {
		this.stateID = stateID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

}

