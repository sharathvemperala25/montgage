package com.hcl.Mortgage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="applications")
@SequenceGenerator(name="application_number_seq", initialValue=21234351, allocationSize=100)
public class Applications {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_number_seq")	
	 private Long id;	
	 private String firstName;
	 private String lastName;
	 private String address;
	 private String creditStatus;
	 private Double applicantIncome;
	 private Double loanAmount;
	 private Date timeCreated= new Date();
	 
	public Date getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public Double getApplicantIncome() {
		return applicantIncome;
	}
	public void setApplicantIncome(Double applicantIncome) {
		this.applicantIncome = applicantIncome;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
 
}

