package com.cognizant.eas.ipm.camunda.cc.app.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cognizant.eas.ipm.camunda.cc.app.model.CreditScoreRequest;
import com.cognizant.eas.ipm.camunda.cc.app.model.CreditScoreResponse;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component("fraudCheckService")
public class FraudCheckServiceImpl implements FraudCheckService{
	
	private final Logger LOGGER = Logger.getLogger(AddressServiceImpl.class.getName());

	@Value("${st.cc.creditscore.validation.url}")
	private String creditScoreURL;


	public String getCreditScoreURL() {
		return creditScoreURL;
	}

	public void setCreditScoreURL(String creditScoreURL) {
		this.creditScoreURL = creditScoreURL;
	}

	public String getUrl() {
		return creditScoreURL;
	}

	public void setUrl(String url) {
		this.creditScoreURL = url;
	}

	@Override
	public boolean isSSNValid(ApplicationForm form) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCustomerFraud(ApplicationForm form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getCreditHistoryDetails(ApplicationForm form) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		LOGGER.info("creditScoreURL" + creditScoreURL);
		
		CreditScoreRequest creditScoreRequest=new CreditScoreRequest();
		creditScoreRequest.setFirstName(form.getApplicant().getFirstName());
		creditScoreRequest.setLastName(form.getApplicant().getLastName());
		creditScoreRequest.setSsn(form.getApplicant().getSsn());	
		creditScoreRequest.setAddress(form.getApplicant().getAddress().toString());
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<CreditScoreRequest> entity = new HttpEntity<CreditScoreRequest>(creditScoreRequest, headers);
		
	    Map<String, Object> responseMap=new HashMap<String, Object>();
		
		ResponseEntity<CreditScoreResponse> result = restTemplate.exchange(creditScoreURL, HttpMethod.POST,
				entity, CreditScoreResponse.class);
		LOGGER.info("getCreditHistoryDetails response from the Credit Card Score" + result.getBody());
		
		responseMap.put("creditScore", result.getBody().getEquifaxScore().intValue());
		responseMap.put("creditHistoryInMonths", result.getBody().getCreditHistoryInMonths());
		responseMap.put("status", result.getBody().getStatus().toString());
		
		return responseMap;
	}

}
