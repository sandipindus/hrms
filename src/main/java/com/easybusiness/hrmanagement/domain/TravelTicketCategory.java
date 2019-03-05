package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_TICKET_CATEGORY")
public class TravelTicketCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "CATEGORY")
    private String category;    
	
    
    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
    public String toString() {
	return "TRAVEL_TICKET_CATEGORY [id=" + id + ", travelCategory=" + category +  "]";
    }
}

