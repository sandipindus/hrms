package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_TICKET_SUBCATEGORY")
public class TravelTicketSubCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "TRAVEL_CATEGORY")
    private String category;    
	
    @Column(name = "SUBCATEGORY_NAME")
    private String subCategory;
    
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

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	@Override
    public String toString() {
	return "TRAVEL_TICKET_SUBCATEGORY [id=" + id + ", travelCategory= " + category +  "subCategory= " + subCategory + "]";
    }
}

