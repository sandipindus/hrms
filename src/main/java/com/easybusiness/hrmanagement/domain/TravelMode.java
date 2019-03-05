package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_MODE")
public class TravelMode implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "MODE_OF_TRAVEL")
    private String modeOfTravel;    
	
    
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getModeOfTravel() {
		return modeOfTravel;
	}


	public void setModeOfTravel(String modeOfTravel) {
		this.modeOfTravel = modeOfTravel;
	}

	@Override
    public String toString() {
	return "TRAVEL_Mode [id=" + id + ", modeOfTravel=" + modeOfTravel +  "]";
    }
}

