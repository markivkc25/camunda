package com.cognizant.eas.ipm.camunda.cc.app.tasks.service;

import java.io.IOException;
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
import com.cognizant.eas.ipm.camunda.cc.app.service.CustomerService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("credentialsValidator")
public class OnlineBankingValidationDelegate implements JavaDelegate {
	
	private static final String APPLICATION_FORM_RESPONSE = "applicationFormResponse";
	private static final String APPLICATION_FORM = "applicationForm";
	private final Logger LOGGER = Logger.getLogger(OnlineBankingValidationDelegate.class.getName());
	
	@Autowired
	private CustomerService customerService;
	
	private ObjectMapper objectMapper=new ObjectMapper();

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Entered OnlineBankingValidationDelegate.execute");
		// Retrieve the Original Form Request Object 
		ApplicationForm applicationForm = getRequestObject(execution);
		// Retrieve the Previous Response Object and Modify the response
		ApplicationFormResponse applicationFormResponse = getResponseObject(execution);		
		validateCustomerCredentials(applicationForm, applicationFormResponse, execution);
		// Retrieve the Previous and Modify the response Response Object and Set in Context
		execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);

	}
	
	/**
	 * 
	 * @param applicationForm
	 * @param applicationFormResponse
	 * @param execution
	 */
	private void validateCustomerCredentials(ApplicationForm applicationForm, ApplicationFormResponse applicationFormResponse, DelegateExecution execution) {
		if(applicationForm.getApplicant().getCustomer()!=null) {
			boolean customerValid=false;
			LOGGER.info("Customer Info provided");
			// Retrieve the Original Form Request Object 
			customerValid=customerService.validateCustomerCredentials(applicationForm.getApplicant().getCustomer());
			if(!customerValid) {
				LOGGER.info("Customer is not present.....");
				applicationFormResponse.getProcessingStatus().setMessage("Credentials not Valid");
				applicationFormResponse.getProcessingStatus().setStageResult(StageResultEnum.FAILED);
				applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERCUSTOMERDETAILS);
				applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERCUSTOMERDETAILS);
				execution.setVariable(APPLICATION_FORM_RESPONSE, applicationFormResponse);
				throw new BpmnError("CC-WF-005","InvalidCredentials");
			}else {
				setProcessingStatus(applicationFormResponse,"Customer Credentials Validation Succesfull");
			}			
		}else {
			setProcessingStatus(applicationFormResponse,"Customer Credentials Not Provided");
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
		applicationFormResponse.getProcessingStatus().setCurrentStage(CurrentStageEnum.ENTERCUSTOMERDETAILS);
		applicationFormResponse.getProcessingStatus().setNextStage(NextStageEnum.ENTERPERSONALDETAILS);
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
