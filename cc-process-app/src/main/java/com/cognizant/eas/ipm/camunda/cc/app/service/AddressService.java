package com.cognizant.eas.ipm.camunda.cc.app.service;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Address;

public interface AddressService {
	
	public boolean validateAddress(Address address) throws Exception;
	
	public String getAddressValidationURL();

	public void setAddressValidationURL(String addressValidationURL);
}
