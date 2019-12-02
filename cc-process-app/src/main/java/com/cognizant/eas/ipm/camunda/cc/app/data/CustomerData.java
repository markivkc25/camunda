package com.cognizant.eas.ipm.camunda.cc.app.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the "CUSTOMER" database table.
 * 
 */

/*
 * CREATE TABLE 'customers' ( 'username' varchar(50) NOT NULL, 'email'
 * varchar(255) NOT NULL, 'phoneumber' varchar(50) NOT NULL, 'firstname'
 * varchar(50) NOT NULL, 'id' bigint(20) NOT NULL, 'lastname' varchar(50)
 * DEFAULT NULL, 'password' varchar(400) NOT NULL, 'ssn' varchar(50) NOT NULL,
 * 'income' varchar(50) DEFAULT NULL, PRIMARY KEY ('username') )
 */
@Entity
@Table(name = "\"CUSTOMERS\"")
public class CustomerData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "\"phonenumber\"", nullable = false, length = 50)
	private String phoneNumber;

	@Column(name = "\"email\"", nullable = false, length = 255)
	private String email;

	@Column(name = "\"income\"", length = 50)
	private String income;
	
	@Column(name = "\"hometype\"", length = 50)
	private String homeType = null;
	
	@Column(name = "\"streetaddress\"", length = 50)
	private String streetAddress = null;
	
	@Column(name = "\"apt\"", length = 50)
	private String apt = null;
	
	@Column(name = "\"city\"", length = 50)
	private String city = null;
	
	@Column(name = "\"state\"", length = 50)
	private String state = null;
	
	@Column(name = "\"zipcode\"", length = 50)
	private String zipCode = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"id\"", updatable = false, nullable = false)
	private Long customerId;

	@Column(name = "\"username\"", length = 50)
	private String username;

	@Column(name = "\"password\"", length = 400)
	private String password;

	@Column(name = "\"firstname\"", nullable = false, length = 50)
	private String firstName;

	@Column(name = "\"lastname\"", length = 50)
	private String lastName;

	@Column(name = "\"ssn\"", nullable = false, length = 50)
	private String ssn;

	public CustomerData() {
	}

	public Long getId() {
		return customerId;
	}

	public void setId(Long id) {
		this.customerId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

}
