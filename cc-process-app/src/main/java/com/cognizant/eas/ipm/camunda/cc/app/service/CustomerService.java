package com.cognizant.eas.ipm.camunda.cc.app.service;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Applicant;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Customer;

public interface CustomerService {
	
	public boolean validateCustomerCredentials(Customer customer);
	
	public boolean validateAccountDetails(Customer customer);
	
	public boolean validateDebitCardDetails(Customer customer);
	
	public void createCustomer(Applicant applicant, String cardNumber, String newAccountNumber);
	
	public Applicant findCustomerById(Applicant applicant);
	
	public boolean findCustomerBySSN(String ssn);

}
