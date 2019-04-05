package com.easybusiness.hrmanagement.domain;

import java.util.List;

public class TravelExpenseDetails {

	private TravelExpense travelExpense;
	private List<TravelExpenseCostDetails> travelExpenseCostDetailsList;
	
	public TravelExpense getTravelExpense() {
		return travelExpense;
	}
	public void setTravelExpense(TravelExpense travelExpense) {
		this.travelExpense = travelExpense;
	}
	public List<TravelExpenseCostDetails> getTravelExpenseCostDetailsList() {
		return travelExpenseCostDetailsList;
	}
	public void setTravelExpenseCostDetailsList(List<TravelExpenseCostDetails> travelExpenseCostDetailsList) {
		this.travelExpenseCostDetailsList = travelExpenseCostDetailsList;
	}
	
	

}
