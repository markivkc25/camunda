package com.cognizant.eas.ipm.camunda.cc.app.service;

import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Address;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Applicant;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;

public class FraudCheckServiceImplTest {

	@Test
	public void testGetCreditHistoryDetails() {
		FraudCheckServiceImpl fraudCheckService=new FraudCheckServiceImpl();
		fraudCheckService.setCreditScoreURL("http://localhost:9091/credit-score");
		
		ApplicationForm form=new ApplicationForm();
		Applicant app=new Applicant();
		app.setFirstName("Rob");
		app.setLastName("Smith");
		app.setSsn("044975066");
		
		
		Address addr=new Address();
		addr.setApt("302");
		addr.setStreetAddress("42143 Grady Ter");
		addr.setCity("Aldie");
		addr.setState("VA");
		addr.setZipCode("20105");
		app.setAddress(addr);
		
		
		form.setApplicant(app);
		
		Map<String,Object> responsemap=fraudCheckService.getCreditHistoryDetails(form);
		System.out.println("responsemap"+responsemap.toString());
		fail("Not yet implemented");
	}

}
