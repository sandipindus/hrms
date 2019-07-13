package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OMS_HOLIDAY_MASTER")
public class HolidayMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "HOLIDAY_NUM")
    private Long holidayNum;
    
    @Column(name = "DATE_ON_CAL")
    private Date dateOnCal;   
    
    @Column(name = "HOLIDAY_DESC")
    private String holidayDesc;  
    
    @Column(name = "HOLIDAY_TYPE")
    private String holidayType;  
    
    @Column(name = "YEAR")
    private Long year;  
    
    @Column(name = "LOC_NUM")
    private Long locNum;  
    
    @Column(name = "MOD_BY")
    private String modBy;  
    
    @Column(name = "MOD_DATE")
    private Date modDate;

	public Long getHolidayNum() {
		return holidayNum;
	}

	public String getHolidayDesc() {
		return holidayDesc;
	}

	public String getHolidayType() {
		return holidayType;
	}

	public Long getYear() {
		return year;
	}

	public Long getLocNum() {
		return locNum;
	}

	public String getModBy() {
		return modBy;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setHolidayNum(Long holidayNum) {
		this.holidayNum = holidayNum;
	}

	public Date getDateOnCal() {
		return dateOnCal;
	}

	public void setDateOnCal(Date dateOnCal) {
		this.dateOnCal = dateOnCal;
	}

	public void setHolidayDesc(String holidayDesc) {
		this.holidayDesc = holidayDesc;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public void setLocNum(Long locNum) {
		this.locNum = locNum;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}  
    
}

