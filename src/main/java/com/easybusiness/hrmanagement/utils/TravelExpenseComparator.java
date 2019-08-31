package com.easybusiness.hrmanagement.utils;

import java.util.Comparator;

import com.easybusiness.hrmanagement.domain.TravelExpenseDetails;

public class TravelExpenseComparator implements Comparator<TravelExpenseDetails>{

	@Override
	public int compare(TravelExpenseDetails travelExpenseDetails1, TravelExpenseDetails travelExpenseDetails2) {
		
		if (null != travelExpenseDetails2.getTravelExpense().getModifiedDate() && null != travelExpenseDetails2.getTravelExpense().getModifiedDate()) {
			return travelExpenseDetails2.getTravelExpense().getModifiedDate().compareTo(travelExpenseDetails1.getTravelExpense().getModifiedDate());
		}
		return 0;
	}

}
