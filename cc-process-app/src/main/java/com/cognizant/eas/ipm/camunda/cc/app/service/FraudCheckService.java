package com.cognizant.eas.ipm.camunda.cc.app.service;

import java.util.Map;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;

public interface FraudCheckService {
	
	public boolean isSSNValid(ApplicationForm form);       //function used in SSN Validator delegate
	
	public boolean isCustomerFraud(ApplicationForm form);
	

	public Map<String,Object> getCreditHistoryDetails(ApplicationForm form);

}
