package com.easybusiness.hrmanagement.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAVEL_ALLOWANCE_LIMIT")
public class TravelAllowanceLimit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id()
    @Column(name = "ID")
    private Long id;

	@Column(name = "NAME")
    private String name;
	
	@Column(name = "AMOUNT")
    private Long amount;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	
}
