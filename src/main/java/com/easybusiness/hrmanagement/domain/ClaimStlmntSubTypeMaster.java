package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLAIM_STLMNT_SUB_TYPE")
public class ClaimStlmntSubTypeMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "ID")
    private Long id;
    
	@Column(name = "CLAIM_STLMNT_TYPE_ID")
	private Long claimStlmntTypeId;
	
    @Column(name = "NAME")
    private String name;    
    
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

	public Long getClaimStlmntTypeId() {
		return claimStlmntTypeId;
	}

	public void setClaimStlmntTypeId(Long claimStlmntTypeId) {
		this.claimStlmntTypeId = claimStlmntTypeId;
	}
	
	
}

