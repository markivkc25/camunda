package com.cognizant.eas.ipm.camunda.cc.app.service;

import java.util.Collections;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.Address;
import com.cognizant.eas.ipm.camunda.cc.app.utils.QueryString;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component("addressService")
public class AddressServiceImpl implements AddressService {

	private final Logger LOGGER = Logger.getLogger(AddressServiceImpl.class.getName());

	@Value("${st.cc.address.validation.url}")
	private String addressValidationURL;

	/*
	 * { "ErrorCode": 2, "ErrorMessage":
	 * "Invalid address: invalid City-State-Zip line", "AddressLine1": "",
	 * "AddressLine2": "", "Number": "", "PreDir": "", "Street": "", "Suffix": "",
	 * "PostDir": "", "Sec": "", "SecNumber": "", "City": "", "State": "", "Zip":
	 * "", "Zip4": "", "County": "", "StateFP": "", "CountyFP": "", "CensusTract":
	 * "", "CensusBlock": "", "Latitude": 0.0, "Longitude": 0.0, "GeoPrecision": 0 }
	 */

	public String getAddressValidationURL() {
		return addressValidationURL;
	}

	public void setAddressValidationURL(String addressValidationURL) {
		this.addressValidationURL = addressValidationURL;
	}

	@Override
	public boolean validateAddress(Address address) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		LOGGER.info("addressValidationURL" + addressValidationURL);
		boolean isValidAddress = false;
		String queryString = formQueryString(address);
		LOGGER.info("queryString --" + queryString);
		
		ResponseEntity<String> result = restTemplate.exchange(addressValidationURL+ "?" + queryString, HttpMethod.GET,
				null, String.class, 1);
		LOGGER.info("Get Address response fromt the Address Standardization" + result.getBody());
		JsonObject jsonObject = new JsonParser().parse(result.getBody()).getAsJsonObject();
		if(jsonObject.get("ErrorCode").getAsInt() != 0 && jsonObject.get("ErrorMessage").getAsString() != ""){
			isValidAddress = false;
		}
		else{
			isValidAddress = true;
			address.setStreetAddress(jsonObject.get("Number").getAsString()+" "+jsonObject.get("Street").getAsString()+ " "+jsonObject.get("Suffix").getAsString());
			address.setCity(jsonObject.get("City").getAsString());
			address.setState(jsonObject.get("State").getAsString());
			address.setZipCode(jsonObject.get("Zip").getAsString());
		}
		
		return true;
	}

	/**
	 * 
	 * @param applicationForm
	 * @param applicationFormResponse
	 */
	private String formQueryString(Address address) {
		String url = null;
		if (address != null) {
			boolean addressValid = false;
			LOGGER.info("Address provided ");
			QueryString qs = new QueryString("AddressLine1", (address.getApt()!=null?(address.getApt()+ ","):"" ) + address.getStreetAddress() + (address.getHomeType()!=null?address.getHomeType()+ ",":""));
			qs.add("AddressLine2", address.getZipCode());
			//qs.add("UserKey", "");
			url = qs.toString();
		}
		return url;
	}

	/**
	 * 
	 * @return
	 */
	private HttpHeaders populateHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}
