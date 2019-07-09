package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEEKEND_MASTER")
public class WeekendMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "WEEKEND_ID")
    private Long weekendId;
    
    @Column(name = "LOCATION_ID")
    private Long locationId;   
    
    @Column(name = "UNIT_ID")
    private Long unitId;  
    
    @Column(name = "WEEKEND1")
    private String weekend1;  
    
    @Column(name = "WEEKEND2")
    private String weekend2;  
    
    @Column(name = "ALTR_FOR_W1")
    private String altrForW1; 
    
    @Column(name = "MOD_BY")
    private Long modBy;
    
    @Column(name = "MOD_ON")
    private Date modOn;

	public Long getWeekendId() {
		return weekendId;
	}

	public void setWeekendId(Long weekendId) {
		this.weekendId = weekendId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getWeekend1() {
		return weekend1;
	}

	public void setWeekend1(String weekend1) {
		this.weekend1 = weekend1;
	}

	public String getWeekend2() {
		return weekend2;
	}

	public void setWeekend2(String weekend2) {
		this.weekend2 = weekend2;
	}

	public String getAltrForW1() {
		return altrForW1;
	}

	public void setAltrForW1(String altrForW1) {
		this.altrForW1 = altrForW1;
	}

	public Long getModBy() {
		return modBy;
	}

	public void setModBy(Long modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}
}

