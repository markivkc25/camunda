package com.cognizant.eas.ipm.camunda.cc.app.tasks.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service("eligibilityandfraudValidator")
public class EligibilityandFraudCheckTaskDelegate implements JavaDelegate {
	
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		execution.setVariable("fraudValidation", "Pass");

	}

}
