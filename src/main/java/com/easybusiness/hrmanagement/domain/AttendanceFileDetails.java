package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATTENDENCE_FILE_DETAILS")
public class AttendanceFileDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name="ID")
    private Long id;
	
    @Column(name = "FILENAME")
    private String fileName;
    
    @Column(name = "MONTH")
    private String month;
    
    @Column(name = "YEAR")
    private String year;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;
    
    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;
    
    @Column(name = "MODIFIED_DATE")
    private Timestamp modifiedDate;

    @Column(name = "ISDELETED")
    private int isDeleted;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
    
    
}

