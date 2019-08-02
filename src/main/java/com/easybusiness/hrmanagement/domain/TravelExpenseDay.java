package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "TRAVEL_EXPENSE_DAY")
public class TravelExpenseDay implements Serializable {

	private static final long serialVersionUID = 1L;

	// Value should be <travelExpId>_<day>
	@Id()
    @Column(name = "EXPENSE_DAY_ID")
    private Long expDayId;
    
    @Column(name = "TRAVEL_EXPENSE_ID")
    private Long travelExpId; 
    
    @Column(name = "DAY")
    private Long day;
    
    @OneToMany(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name= "EXPENSE_DAY_ID", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private List<TravelExpenseBill> travelExpenseBill;

	public Long getExpDayId() {
		return expDayId;
	}

	public Long getTravelExpId() {
		return travelExpId;
	}

	public Long getDay() {
		return day;
	}

	public List<TravelExpenseBill> getTravelExpenseBill() {
		return travelExpenseBill;
	}

	public void setExpDayId(Long expDayId) {
		this.expDayId = expDayId;
	}

	public void setTravelExpId(Long travelExpId) {
		this.travelExpId = travelExpId;
	}

	public void setDay(Long day) {
		this.day = day;
	}

	public void setTravelExpenseBill(List<TravelExpenseBill> travelExpenseBill) {
		this.travelExpenseBill = travelExpenseBill;
	}
    
    
}

