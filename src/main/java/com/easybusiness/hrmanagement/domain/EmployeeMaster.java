package com.easybusiness.hrmanagement.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OMS_EMPLOYEE_MASTER")
public class EmployeeMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
    @Column(name = "EMPLOYEE_NUM")
	private Long employee_num;
	
	@Column(name = "FIRST_NAME")
	private String first_name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "ORG_NUM")
	private Long org_num;
	
	@Column(name = "DEPT_NUM")
	private Long dept_num;
	
	@Column(name = "DESIG_NUM")
	private Long desig_num;
	
	@Column(name = "PERSONAL_EMAIL")
	private String personal_email;
	
	@Column(name = "OFFICIAL_EMAIL")
	private String official_email;
	
	@Column(name = "MOBILE_NUM")
	private String mobile_num;
	
	@Column(name = "ALTR_PHONE_NUM")
	private String altr_phone_num;
	
	@Column(name = "TYPE_OF_EMP")
	private String type_of_emp;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "DOJ")
	private Date doj;
	
	@Column(name = "DOS")
	private Date dos;
	
	@Column(name = "EMPLOYEE_USER_NAME")
	private String employee_user_name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMPLOYEE_ATTDN_DEVICE_NUM")
	private String employee_attdn_device_num;
	
	@Column(name = "PRACTICE_MNGR_NUM")
	private String practice_mngr_num;
	
	@Column(name = "HR_MNGR_NUM")
	private String hr_mngr_num;
	
//	@Column(name = "EMPLOYEE_IMG")
//	private Clob employee_img;
	
	@Column(name = "PERMANENT_ADDR")
	private String permanent_addr;
	
	@Column(name = "COUNTRY_NUM_1")
	private Long country_num_1;
	
	@Column(name = "STATE_NUM_1")
	private Long state_num_1;
	
	@Column(name = "CITY_NUM_1")
	private Long city_num_1;
	
	@Column(name = "PINCODE_1")
	private Long pincode_1;
	
	@Column(name = "PRESENT_ADDR")
	private String present_addr;
	
	@Column(name = "COUNTRY_NUM_2")
	private Long country_num_2;
	
	@Column(name = "STATE_NUM_2")
	private Long state_num_2;
	
	@Column(name = "CITY_NUM_2")
	private Long city_num_2;
	
	@Column(name = "PINCODE_2")
	private Long pincode_2;
	
	@Column(name = "AADHAR_NUM")
	private String aadhar_num;
	
	@Column(name = "PASSPORT")
	private String passport;
	
	@Column(name = "PRIMARY_COMPETANCY")
	private String primary_competancy;
	
	@Column(name = "MOD_BY")
	private String mod_by;
	
	@Column(name = "MOD_ON")
	private Date mod_on;
	
	@Column(name = "PROJ_MNGR_NUM")
	private String proj_mngr_num;
	
	@Column(name = "PF_NO")
	private String pf_no;
	
	@Column(name = "ESI_NO")
	private String esi_no;
	
	@Column(name = "PH_NO_HOME")
	private String ph_no_home;
	
	@Column(name = "BIRTH_DAY")
	private Date birth_day;
	
	@Column(name = "SAFETY_CERT_NAME")
	private String safety_cert_name;
	
	@Column(name = "IS_POLICE_VERIFIED")
	private long is_police_verified;

	public Long getEmployee_num() {
		return employee_num;
	}

	public void setEmployee_num(Long employee_num) {
		this.employee_num = employee_num;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}

