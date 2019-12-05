package com.cognizant.eas.ipm.camunda.cc.app.tasks.service;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationFormResponse;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ApplicationForm.OverAllStatusEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.CurrentStageEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.NextStageEnum;
import com.cognizant.eas.ipm.camunda.cc.app.process.variables.ProcessingStatus.StageResultEnum;
import com.cognizant.eas.ipm.camunda.cc.app.service.FraudCheckService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("ssnValidator")
public class SSNValidatorDelegate implements JavaDelegate{
	
private static final String ACTIVE = "active";

private static final String STATUS = "status";

private static final String IS_CUSTOMER_ELIGIBLE = "isCustomerEligible";

private static final String CREDIT_HISTORY_IN_MONTHS = "creditHistoryInMonths";

private static final String CREDIT_SCORE = "creditScore";

private final Logger LOGGER = Logger.getLogger(PromoCodeValidationDelegate.class.getName());
	
	private static final String APPLICATION_FORM_RESPONSE = "applicationFormResponse";
	private static final String APPLICATION_FORM = "applicationForm";
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	@Autowired
	private FraudCheckService fraudCheckService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		LOGGER.info("Entered SSNValidatorDelegate.execute");
		// Retrieve the Original Form Request Object 
		ApplicationForm applicationForm = getRequestObject(execution);
		// Retrieve the Previous Response Object and Modify the response
		ApplicationFormResponse applicationFormResponse = getResponseObject(execution);		
		
		validateSSN(applicationForm, applicationFormResponse, execution);
		execution.setVariable("ValidationStatus", "Complete");
		getCreditScore(execution, applicationForm);
		execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);
		
	}

	private void getCreditScore(DelegateExecution execution, ApplicationForm applicationForm) {
		Map<String,Object> responseMap=fraudCheckService.getCreditHistoryDetails(applicationForm);
		execution.setVariable(CREDIT_SCORE, responseMap.get(CREDIT_SCORE));
		execution.setVariable(CREDIT_HISTORY_IN_MONTHS, responseMap.get(CREDIT_HISTORY_IN_MONTHS));
		execution.setVariable(IS_CUSTOMER_ELIGIBLE, responseMap.get(STATUS).equals(ACTIVE)?true:false);
	}
	
	/**
	 * 
	 * @param applicationForm
	 * @param applicationFormResponse
	 * @param execution
	 */
	private void validateSSN(ApplicationForm applicationForm, ApplicationFormResponse applicationFormResponse, DelegateExecution execution) {
		boolean isSSNValid = false;
		if(applicationForm.getApplicant().getSsn() != null && applicationForm.getApplicant().getSsn() != "") {
			LOGGER.info("SSN provided ");
			// Retrieve the Original Form Request Object 
			String code = (String)applicationForm.getReference().getPromoCode();
			isSSNValid=fraudCheckService.isSSNValid(applicationForm);
			if(!isSSNValid) {
				LOGGER.info("SSN is not valid.....");
				applicationFormResponse.getProcessingStatus().setMessage("SSN is not valid");
				applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.FAILED);
				applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERPERSONALDETAILS);
				applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERPERSONALDETAILS);
				execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);
				throw new BpmnError("CC-WF-009","InvalidSSN");
			}else {
				setProcessingStatus(applicationFormResponse,"SSN Validation Succesfull");				
			}			
		}else {
			LOGGER.info("SSN not provided.....");
			applicationFormResponse.getProcessingStatus().setMessage("SSN not provided");
			applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.FAILED);
			applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERPERSONALDETAILS);
			applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERPERSONALDETAILS);
			execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);
			throw new BpmnError("CC-WF-009","InvalidSSN");			
		}
			
	}
	
	/**
	 * 
	 * @param applicationFormResponse
	 * @param message
	 */
	private void setProcessingStatus(ApplicationFormResponse applicationFormResponse, String message) {
		applicationFormResponse.getApplicationForm().setOverAllStatus(OverAllStatusEnum.UNDERREVIEW);
		applicationFormResponse.getProcessingStatus().setMessage(message);
		applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.PASSED);
		applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERUSERPREFERENCES);
		applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERPERSONALDETAILS);
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

}
