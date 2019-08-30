package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "TRAVEL_REQUEST")
public class TravelRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "TRAVEL_REQUEST_ID")
	private String travelRequestID;

	@Column(name = "TRAVEL_TYPE_ID")
	private Long travelTypeId;

	@Column(name = "TRAVEL_PURPOSE_ID")
	private Long travelPurposeId;

	@Column(name = "TRAVEL_FORM")
	private Long travelFrom;

	@Column(name = "TRAVEL_TO")
	private Long travelTo;

	@Column(name = "TRAVEL_DATE_OF_JOURNEY")
	private Date travelDateOfJourney;

	@Column(name = "TRAVEL_DATE_OF_RETURN")
	private Date travelDateOfReturn;

	@Column(name = "TRAVEL_TICKET_CATEGORY_ID")
	private Long travelTicketCategoryId;

	@Column(name = "TRAVEL_TICKET_SUB_CATEGORY_ID")
	private Long travelTicketSubCategoryId;

	@Column(name = "TRAVEL_TICKET_BOOKING_TPE_ID")
	private Long travelTicketBookingTypeId;

	@Column(name = "PROJECT_ID")
	private Long projectId;

	@Column(name = "TRAVEL_ACCOM_TYPE_ID")
	private Long travelAccomTypeId;

	@Column(name = "TRAVEL_ADVANCE")
	private Long travelAdvance;

	/**
	 * This is the employee id to whom request is pending.
	 */
	@Column(name = "PENDING_WITH")
	private Long pendingWith;

	@Column(name = "TRAVEL_REQEST_STATUS")
	private Long travelRequestStatus;

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

	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	// If settlement pending value is 0
	@Column(name = "IS_STLMNT_PENDING")
	private int isStlmntPending;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "DIRECTAPPROVER")
	private Long directApprover;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", referencedColumnName = "EMPLOYEE_NUM", insertable = false, updatable = false, nullable= true)
	@Fetch(FetchMode.JOIN)
	private EmployeeMaster createdByDetails;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODIFIED_BY", referencedColumnName = "EMPLOYEE_NUM", insertable = false, updatable = false, nullable= true)
	@Fetch(FetchMode.JOIN)
	private EmployeeMaster modifiedByDetails;

	public Long getTravelTypeId() {
		return travelTypeId;
	}

	public void setTravelTypeId(Long travelTypeId) {
		this.travelTypeId = travelTypeId;
	}

	public Long getTravelPurposeId() {
		return travelPurposeId;
	}

	public void setTravelPurposeId(Long travelPurposeId) {
		this.travelPurposeId = travelPurposeId;
	}

	public Long getTravelFrom() {
		return travelFrom;
	}

	public void setTravelFrom(Long travelFrom) {
		this.travelFrom = travelFrom;
	}

	public Long getTravelTo() {
		return travelTo;
	}

	public void setTravelTo(Long travelTo) {
		this.travelTo = travelTo;
	}

	public Date getTravelDateOfJourney() {
		return travelDateOfJourney;
	}

	public void setTravelDateOfJourney(Date travelDateOfJourney) {
		this.travelDateOfJourney = travelDateOfJourney;
	}

	public Date getTravelDateOfReturn() {
		return travelDateOfReturn;
	}

	public void setTravelDateOfReturn(Date travelDateOfReturn) {
		this.travelDateOfReturn = travelDateOfReturn;
	}

	public Long getTravelTicketCategoryId() {
		return travelTicketCategoryId;
	}

	public void setTravelTicketCategoryId(Long travelTicketCategoryId) {
		this.travelTicketCategoryId = travelTicketCategoryId;
	}

	public Long getTravelTicketSubCategoryId() {
		return travelTicketSubCategoryId;
	}

	public void setTravelTicketSubCategoryId(Long travelTicketSubCategoryId) {
		this.travelTicketSubCategoryId = travelTicketSubCategoryId;
	}

	public Long getTravelTicketBookingTypeId() {
		return travelTicketBookingTypeId;
	}

	public void setTravelTicketBookingTypeId(Long travelTicketBookingTypeId) {
		this.travelTicketBookingTypeId = travelTicketBookingTypeId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getTravelAccomTypeId() {
		return travelAccomTypeId;
	}

	public void setTravelAccomTypeId(Long travelAccomTypeId) {
		this.travelAccomTypeId = travelAccomTypeId;
	}

	public Long getTravelAdvance() {
		return travelAdvance;
	}

	public void setTravelAdvance(Long travelAdvance) {
		this.travelAdvance = travelAdvance;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public String getTravelRequestID() {
		return travelRequestID;
	}

	public void setTravelRequestID(String travelRequestID) {
		this.travelRequestID = travelRequestID;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
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

	public Long getTravelRequestStatus() {
		return travelRequestStatus;
	}

	public void setTravelRequestStatus(Long travelRequestStatus) {
		this.travelRequestStatus = travelRequestStatus;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public int getIsStlmntPending() {
		return isStlmntPending;
	}

	public void setIsStlmntPending(int isStlmntPending) {
		this.isStlmntPending = isStlmntPending;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getPendingWith() {
		return pendingWith;
	}

	public void setPendingWith(Long pendingWith) {
		this.pendingWith = pendingWith;
	}

	public Long getDirectApprover() {
		return directApprover;
	}

	public void setDirectApprover(Long directApprover) {
		this.directApprover = directApprover;
	}

	public EmployeeMaster getCreatedByDetails() {
		return createdByDetails;
	}

	public void setCreatedByDetails(EmployeeMaster createdByDetails) {
		this.createdByDetails = createdByDetails;
	}

	public EmployeeMaster getModifiedByDetails() {
		return modifiedByDetails;
	}

	public void setModifiedByDetails(EmployeeMaster modifiedByDetails) {
		this.modifiedByDetails = modifiedByDetails;
	}


	}

