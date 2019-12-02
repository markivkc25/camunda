package com.cognizant.eas.ipm.camunda.cc.app.service;

import org.springframework.stereotype.Component;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.UserOptions;

@Component("userPreferenceService")
public class UserPreferenceServiceImpl implements UserPreferenceService{

	@Override
	public boolean validateUserPreference(UserOptions userOption) {
		boolean validUserPreference = false;
		
		if(userOption.isTermsConditionsAccepted() != null && userOption.isTermsConditionsAccepted()){
			validUserPreference = true;
		}
		
		return validUserPreference;
	}

}
