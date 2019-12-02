package com.cognizant.eas.ipm.camunda.cc.app.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the "ACCOUNTS" database table.
 * 
 */
@Entity
@Table(name="\"ACCOUNTS\"")
public class CustomerAccount implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"accountnumber\"", nullable=false, length=50)
	private String accountNumber;

	@Column(name="\"customerid\"", nullable=false)
	private Long customerId;

	@Column(name="\"creditcardnumber\"", length=50)
	private String creditCardNumber;
	
	@Column(name="\"accounttype\"", nullable=false, length=50)
	private String accountType;
	
	public CustomerAccount(){
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
