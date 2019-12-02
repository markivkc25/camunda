package com.cognizant.eas.ipm.camunda.cc.app.tasks.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service("eligibilityandfraudValidator")
public class EligibilityandFraudCheckTaskDelegate implements JavaDelegate {
	
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		
		//Dummy hard coded values
		
		execution.setVariable("creditScore", 650);
		execution.setVariable("isCustomerEligible", true);
		execution.setVariable("fraudValidation", "Pass");

	}

}
