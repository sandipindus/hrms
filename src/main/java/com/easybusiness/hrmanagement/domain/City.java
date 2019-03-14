package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITY_MASTER")
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "CITY_ID")
    private Long id;
    
    @Column(name = "CITY_NAME")
    private String city;    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	
}

