package com.cognizant.eas.ipm.camunda.cc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.eas.ipm.camunda.cc.app.data.CustomerAccount;
import com.cognizant.eas.ipm.camunda.cc.app.data.CustomerData;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Address;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Applicant;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ContactInfo;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Customer;
import com.cognizant.eas.ipm.camunda.cc.app.repository.CustomerAccountRepository;
import com.cognizant.eas.ipm.camunda.cc.app.repository.CustomerDataRepository;

@Component("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDataRepository customerRepository;
	
	@Autowired
	private CustomerAccountRepository accountRepository;

	@Override
	public boolean validateCustomerCredentials(Customer customer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean validateAccountDetails(Customer customer) {
		boolean isValidCustomer = false;
		String accountNumber = customer.getAccountNumber();
		if(accountNumber != null && accountNumber != ""){
			CustomerAccount customerAccount = accountRepository.findByAccountNumber(accountNumber);
			if(customerAccount != null && customerAccount.getCustomerId() != null){
				isValidCustomer = true;
			}
		}
		
		return isValidCustomer;
	}

	@Override
	public boolean validateDebitCardDetails(Customer customer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void createCustomer(Applicant applicant, String cardNumber, String newAccountNumber) {
		Customer customer = applicant.getCustomer();
		Long customerId = null;
		CustomerAccount customerAccount = new CustomerAccount();
		if(customer!=null){
			String accountNumber = customer.getAccountNumber();
			customerAccount = accountRepository.findByAccountNumber(accountNumber);
			customerId = customerAccount != null ? customerAccount.getCustomerId() : null;
		}
		
		if(customerId != null) {
			customerAccount.setCreditCardNumber(cardNumber);
			accountRepository.save(customerAccount);
		}
		else{
			
			// Persist new customer into customers DB
			CustomerData newCustomerData = new CustomerData();
			newCustomerData.setFirstName(applicant.getFirstName());
			newCustomerData.setLastName(applicant.getLastName());
			newCustomerData.setSsn(applicant.getSsn());
			if(applicant.getAddress() != null){
				newCustomerData.setApt(applicant.getAddress().getApt());
				newCustomerData.setCity(applicant.getAddress().getCity());
				newCustomerData.setState(applicant.getAddress().getState());
				newCustomerData.setStreetAddress(applicant.getAddress().getStreetAddress());
				newCustomerData.setZipCode(applicant.getAddress().getZipCode());
				newCustomerData.setHomeType(applicant.getAddress().getHomeType());
			}
			if(applicant.getContactInfo() != null){
				newCustomerData.setEmail(applicant.getContactInfo().getEmail());
				newCustomerData.setPhoneNumber(applicant.getContactInfo().getPhoneNumber());
			}
			if(applicant.getEmploymentDetails().getIncome() != null){
				newCustomerData.setIncome(applicant.getEmploymentDetails().getIncome());
			}
			customerRepository.save(newCustomerData);
			
			// Persist New Customer's Account and Credit Card Number to Accounts DB
			CustomerAccount newCustomerAccount = new CustomerAccount();
			newCustomerAccount.setAccountNumber(newAccountNumber);
			newCustomerAccount.setCreditCardNumber(cardNumber);
			newCustomerAccount.setCustomerId(newCustomerData.getId());
			newCustomerAccount.setAccountType("CreditCard");
			accountRepository.save(newCustomerAccount);
		}
	}

	@Override
	public Applicant findCustomerById(Applicant applicant) {
		String accountNumber = applicant.getCustomer().getAccountNumber();
		CustomerAccount customerAccount = accountRepository.findByAccountNumber(accountNumber);
		Address address = new Address();
		ContactInfo contactInfo = new ContactInfo();
		if(customerAccount != null && customerAccount.getCustomerId() != null){
			CustomerData customerData = customerRepository.findByCustomerId(customerAccount.getCustomerId());
			applicant.setFirstName(customerData.getFirstName());
			applicant.setLastName(customerData.getLastName());
			applicant.setSsn(customerData.getSsn());
			contactInfo.setEmail(customerData.getEmail());
			contactInfo.setPhoneNumber(customerData.getPhoneNumber());
			address.setApt(customerData.getApt());
			address.setCity(customerData.getCity());
			address.setHomeType(customerData.getHomeType());
			address.setState(customerData.getState());
			address.setStreetAddress(customerData.getStreetAddress());
			address.setZipCode(customerData.getZipCode());
			
			applicant.setAddress(address);
			applicant.setContactInfo(contactInfo);
			
		}
		
		return applicant;
	}

	@Override
	public boolean findCustomerBySSN(String ssn) {
		// TODO Auto-generated method stub
		return false;
	}

}
