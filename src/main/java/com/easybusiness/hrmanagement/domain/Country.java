package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OMS_COUNTRY_MASTER")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "SR_NUM")
    private Long id;
    
    @Column(name = "COUNTRY")
    private String countryName;    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}

