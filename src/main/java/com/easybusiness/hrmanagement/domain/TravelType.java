package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_TYPE")
public class TravelType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "TYPE")
    private String type;    
	
    
    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
    public String toString() {
	return "TRAVEL_TYPE [id=" + id + ", travelType=" + type +  "]";
    }
}

