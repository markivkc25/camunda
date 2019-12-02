package com.cognizant.eas.ipm.camunda.cc.app.tasks.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationFormResponse;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm.OverAllStatusEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.StageResultEnum;
import com.cognizant.eas.ipm.camunda.cc.app.service.CustomerService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("applicationDecisionTask")
public class CreditCardDecisionServiceTaskDelegate implements JavaDelegate {
	
	private static final String APPLICATION_FORM_RESPONSE = "applicationFormResponse";
	private static final String APPLICATION_FORM = "applicationForm";
	private final Logger LOGGER = Logger.getLogger(CreditCardDecisionServiceTaskDelegate.class.getName());
	
	
	private ObjectMapper objectMapper=new ObjectMapper();
	private Random random = new Random(System.currentTimeMillis());
	
	@Autowired
	private CustomerService customerService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Entered CreditCardDecisionServiceTaskDelegate.execute");
		// Retrieve the Original Form Request Object 
		Map<String,Object> approvalDecisionMap = new HashMap<String,Object>();
		ApplicationForm applicationForm = getRequestObject(execution);
		approvalDecisionMap = (Map<String, Object>) execution.getVariable("approvalDecisionMap");
		String approvalDecision = (String) approvalDecisionMap.get("approvalDecision");
		// Retrieve the Previous Response Object and Modify the response
		ApplicationFormResponse applicationFormResponse = getResponseObject(execution);		
		updateCreditCardDetail(applicationForm, applicationFormResponse,approvalDecision);
		// Retrieve the Previous and Modify the response Response Object and Set in Context
		execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);

	}
	
	/**
	 * 
	 * @param applicationForm
	 * @param applicationFormResponse
	 * @param approvalDecision
	 */
	private void updateCreditCardDetail(ApplicationForm applicationForm, ApplicationFormResponse applicationFormResponse, String approvalDecision) {
		
		if(approvalDecision.equals("Approved") || approvalDecision.equals("ConditionallyApproved")) {
			LOGGER.info("Customer's Credit Card Application is Approved");
			setProcessingStatus(applicationFormResponse,OverAllStatusEnum.APPROVED);
			String cardNumber = generateCreditCardNumber("333", 16);
			String newAccountNumber = generateCreditCardNumber("123", 12);
			customerService.createCustomer(applicationForm.getApplicant(),cardNumber,newAccountNumber);
		}else if(approvalDecision.equals("OnHold")){
			LOGGER.info("Customer's Credit Card Application is OnHold");
			setProcessingStatus(applicationFormResponse,OverAllStatusEnum.ONHOLD);
		}
		else{
			LOGGER.info("Customer's Credit Card Application is Denied");
			setProcessingStatus(applicationFormResponse,OverAllStatusEnum.DENIED);
		}
	}
	
	/**
	 * 
	 * @param applicationFormResponse
	 * @param overAllStatus
	 */
	private void setProcessingStatus(ApplicationFormResponse applicationFormResponse, OverAllStatusEnum overAllStatus) {
		applicationFormResponse.getApplicationForm().setOverAllStatus(overAllStatus);
		applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.PASSED);
	}
	
	/**
	 * 
	 * @param execution
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	private com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationFormResponse getResponseObject(
			DelegateExecution execution) throws JsonParseException, JsonMappingException, IOException {
		ObjectValue applicationFormResponseValue = execution.getVariableTyped(APPLICATION_FORM_RESPONSE);
		ApplicationFormResponse applicationFormResponse = (ApplicationFormResponse)objectMapper.readValue(applicationFormResponseValue.getValueSerialized(),ApplicationFormResponse.class);
		return applicationFormResponse;
	}
	
	/**
	 * 
	 * @param execution
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	private com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm getRequestObject(
			DelegateExecution execution) throws JsonParseException, JsonMappingException, IOException {
		ObjectValue applicationFormValue = execution.getVariableTyped(APPLICATION_FORM);
		ApplicationForm applicationForm = (ApplicationForm)objectMapper.readValue(applicationFormValue.getValueSerialized(),ApplicationForm.class);
		return applicationForm;
	}
	
	public String generateCreditCardNumber(String bin, int length) {

		int randomNumberLength = length - (bin.length() + 1);

		StringBuilder builder = new StringBuilder(bin);
		for (int i = 0; i < randomNumberLength; i++) {
			int digit = this.random.nextInt(10);
			builder.append(digit);
		}
		int checkDigit = this.getCheckDigit(builder.toString());
		builder.append(checkDigit);
		return builder.toString();
	}

	private int getCheckDigit(String number) {

		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			int digit = Integer.parseInt(number.substring(i, (i + 1)));

			if ((i % 2) == 0) {
				digit = digit * 2;
				if (digit > 9) {
					digit = (digit / 10) + (digit % 10);
				}
			}
			sum += digit;
		}
		int mod = sum % 10;
		return ((mod == 0) ? 0 : 10 - mod);
	}

}
