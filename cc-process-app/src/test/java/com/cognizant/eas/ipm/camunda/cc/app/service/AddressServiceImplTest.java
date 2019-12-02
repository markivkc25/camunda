package com.cognizant.eas.ipm.camunda.cc.app.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Address;

public class AddressServiceImplTest {

	@Test
	public void testValidateAddress() throws Exception {
		AddressService addressService=new AddressServiceImpl();
		addressService.setAddressValidationURL("https://www.yaddress.net/api/Address ");
		
		Address address=new Address();
		address.setState("VA");
		address.setCity("Aldie");
		address.setStreetAddress("42143 grady ter");
		address.setZipCode("20105");
		//address.setHomeType(homeType);
		
		boolean addr=addressService.validateAddress(address);
		System.out.println("addr"+address.toString());
		fail("Not yet implemented");
	}

}
