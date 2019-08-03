package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

public class DatacardDocument implements Serializable {

	private static final long serialVersionUID = 1L;

    private CostDocument costDocument;

	public CostDocument getCostDocument() {
		return costDocument;
	}

	public void setCostDocument(CostDocument costDocument) {
		this.costDocument = costDocument;
	}
    
    
}

